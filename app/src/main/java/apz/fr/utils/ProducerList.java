package apz.fr.utils;
import java.util.*;
import java.util.function.Supplier;

/* package */ final class ProducerList<T> implements java.io.Serializable
{
    private final List<Supplier<T>> source = new ArrayList<>();
    
    private static final long serialVersionUID = 1L;

    public ProducerList()
    {

    }
    
    public int size()
    {
        return source.size();
    }
    
    public synchronized T get(int index)
    {
        return source.get(index).get();
    }

    public synchronized void add(int count, T entry)
    {
        add(count, Deferreds.fixed(entry));
    }
    
    public synchronized void add(int count, Producer<T> entry)
    {
        add(count, Deferreds.produced(entry));
    }

    private void add(int count, Supplier<T> entry)
    {
        for(int i=0; i<count; i++)
        {
            source.add(entry);
        }
    }

    public synchronized void addAll(Collection<? extends T> entries)
    {
        for(T item: entries)
        {
            add(1, item);
        }
    }

    public synchronized List<?> asList()
    {
        return source;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(source.size() == 1 ? source.get(0) : source);
    }
}