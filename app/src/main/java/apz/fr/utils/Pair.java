package apz.fr.utils;

public final class Pair<T> implements java.io.Serializable
{
    public final T first;
    
    public final T second;
    
    private static final long serialVersionUID = 1L;

    public Pair(T first, T second)
    {
        if ((this.first = first) == null)
            throw new NullPointerException("first");
        if ((this.second = second) == null)
            throw new NullPointerException("second");
    }
}