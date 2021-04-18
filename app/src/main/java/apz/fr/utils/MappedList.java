package apz.fr.utils;
import java.util.*;

public final class MappedList<K, V>
{
    private final List<V> list = new ArrayList<>();
    
    private final Map<K, Set<V>> map = new HashMap<>();
    
    public synchronized int size()
    {
        return list.size();
    }
    
    public synchronized void add(K key, V value)
    {
        list.add(value);
        Set<V> values = map.get(key);
        if (values == null)
        {
            values = new HashSet<>();
            map.put(key, values);
        }
        values.add(value);
    }
    
    public synchronized V get(K key)
    {
        return map.containsKey(key) ? Utils.random(map.get(key)) : null;
    }
    
    public synchronized Collection<V> getAll(K key)
    {
        return map.containsKey(key) ? Collections.unmodifiableCollection(map.get(key)) : null;
    }

    public synchronized List<V> values()
    {
        return new ArrayList<>(list);
    }
}
