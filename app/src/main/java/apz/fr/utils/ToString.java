package apz.fr.utils;

public final class ToString<T> implements java.io.Serializable {

    public final String label;
    
    public final T value;
    
    private static final long serialVersionUID = 1L;
    
    private ToString(String label, T value) {
        this.label = label;
        this.value = value;
    }
    
    @Override
    public String toString()
    {
        return label;
    }

    public static <T> ToString<T> of(T obj)
    {
        return new ToString<>(obj != null ? obj.toString() : null, obj);
    }

    public static <T> ToString<T> of(String label, T obj)
    {
        return new ToString<>(label, obj);
    }
    
    public static <T> T value(ToString<T> inst)
    {
        return inst != null ? inst.value : null;
    }
}
