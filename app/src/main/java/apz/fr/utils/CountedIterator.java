package apz.fr.utils;
import java.util.*;

public final class CountedIterator<T> implements Iterator<T>
{
    private final List<T> source;
    
    private int index;
    
    public CountedIterator(List<T> source)
    {
        this.source = source;
    }
    
    @Override
    public boolean hasNext()
    {
        return index < source.size();
    }

    @Override
    public synchronized T next()
    {
        return (index >= source.size()) ? null : source.get(index++);
    }
    
    public synchronized int index()
    {
        return index;
    }
    
    public synchronized int size()
    {
        return source.size();
    }

    @Override
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
