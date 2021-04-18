package fr.dict;
import java.io.*;
import java.util.*;

/* package */ final class ItemContainer<T> implements Iterable<T>, java.io.Serializable
{
    public final String filename;
    
    public final long timestamp;
    
    public final List<T> items;
    
    private static final long serialVersionUID = 1L;
    
    public ItemContainer(File file, Collection<T> items)
    {
        this.filename = file.getName();
        this.timestamp = file.lastModified();
        this.items = new ArrayList<>(items);
    }

    @Override
    public Iterator<T> iterator()
    {
        return items.iterator();
    }
}
