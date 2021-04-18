package apz.fr.utils;
import java.util.*;

public /* final */ class WeightedProducer<T> implements Producer<T>, java.io.Serializable
{
    private int current = -1;

    private final ProducerList<T> source = new ProducerList<>();
    
    private static final long serialVersionUID = 1L;

    public WeightedProducer() {

    }
    
    public WeightedProducer(T args) {
        source.add(1, args);
    }

    @SafeVarargs
    @SuppressWarnings({"varargs"})
    public WeightedProducer(T... args) {
        source.addAll(Arrays.asList(args));
    }

    public WeightedProducer(Collection<? extends T> args)
    {
        source.addAll(args);
    }
    
    public synchronized WeightedProducer<T> add(T entry)
    {
        source.add(1, entry);
        return this;
    }
    
    public synchronized WeightedProducer<T> add(int count, T entry)
    {
        source.add(count, entry);
        return this;
    }

    public synchronized WeightedProducer<T> add(Producer<T> entry)
    {
        source.add(1, entry);
        return this;
    }

    public synchronized WeightedProducer<T> add(int count, Producer<T> entry)
    {
        source.add(count, entry);
        return this;
    }

    @Override
    public synchronized T next() {
        if (current == -1 || current >= source.size()) {
            Utils.shuffle(source.asList());
            current = 0;
        }
        return source.get(current++);
    }

    @Override
    public String toString()
    {
        return String.valueOf(source.size() == 1 ? source.get(0) : source);
    }
    
    public static <T extends Enum<T>> WeightedProducer<T> fromEnum(Class<T> eClass) {
        return new WeightedProducer<T>(eClass.getEnumConstants()) {

            private static final long serialVersionUID = 1L;
            
            @Override
            public String toString() {
                return "ALL";
            }
        };
    }
}