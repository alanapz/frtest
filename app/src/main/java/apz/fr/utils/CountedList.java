package apz.fr.utils;
import java.util.*;

public final class CountedList<T> implements java.io.Serializable
{
    private final Map<T, Integer> map = new LinkedHashMap<>();
    
    private static final long serialVersionUID = 1L;
    
    public void increment(T value)
    {
        Integer current = map.get(value);
        if (current == null)
        {
            current = 0;
        }
        map.put(value, current + 1);
    }
    
    public Set<Map.Entry<T, Integer>> entries()
    {
        return new LinkedHashMap<>(map).entrySet();
    }
}
