package fr.dict;
import apz.fr.utils.*;
import java.io.*;
import java.util.*;

/* package*/ abstract class CacheStore<T>
{
    private final File cacheFolder;
    
    private final File cacheFile;
    
    /* package */ CacheStore(String key)
    {
        this.cacheFile = new File("db/" + key + ".ser");
        this.cacheFolder = new File("db/" + key);
    }
    
    public abstract Set<T> parse(File file) throws IOException;
    
    public List<T> retrieve() throws IOException
    {
        if (!cacheFolder.exists())
        {
            return Collections.emptyList();
        }
        List<ItemContainer<T>> items = readCachedItems();
        if (items == null)
        {
            items = Parallelised.exec(
                    cacheFolder.listFiles((dir, name) -> name.endsWith(".xml")),
                    5,
                    (File file) -> file.isFile() ? new ItemContainer<>(file, parse(file)): null);
        }
        try(ObjectOutputStream file = new ObjectOutputStream(IO.openOutput(cacheFile)))
        {
            file.writeLong(cacheFolder.lastModified());
            file.writeObject(items);
        }
        List<T> results = new ArrayList<>();
        for(ItemContainer<T> itemContainer: items)
        {
            for(T item: itemContainer)
            {
                results.add(item);
            }
        }
        return results;
    }
    
    @SuppressWarnings("unchecked")
    private List<ItemContainer<T>> readCachedItems() throws IOException
    {
        if (!cacheFile.exists())
        {
            return null;
        }
        try(ObjectInputStream cacheStream = new ObjectInputStream(new FileInputStream(cacheFile)))
        {
            if (cacheStream.readLong() != cacheFolder.lastModified())
            {
                return null;
            }
            List<ItemContainer<T>> itemList = (List<ItemContainer<T>>) cacheStream.readObject();
            ListIterator<ItemContainer<T>> iterator = itemList.listIterator();
            while(iterator.hasNext())
            {
                ItemContainer<T> item = iterator.next();
                File itemFile = new File(cacheFolder + "/" + item.filename);
                if (!itemFile.exists())
                {
                    System.out.println(itemFile + " DELETED");
                    iterator.remove();
                    continue;
                }
                else if (itemFile.lastModified() != item.timestamp)
                {
                    System.out.println(itemFile + " UPDATED");
                    iterator.set(new ItemContainer<>(itemFile, parse(itemFile)));
                    continue;
                }
            }
            return itemList;
        }
        catch(ClassNotFoundException e)
        {
            throw new IOException("Couldn't parse: " + cacheFile, e);
        }
    }
}
