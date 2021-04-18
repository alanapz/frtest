package apz.fr.utils;
import java.util.*;

public final class CircularProducer<T> implements Producer<T>, java.io.Serializable
{
    private int current = -1;

    private final ProducerList<T> source = new ProducerList<>();
    
    private static final long serialVersionUID = 1L;

    public CircularProducer() {
    }

    public CircularProducer(Collection<? extends T> args) {
        source.addAll(args);
    }
    
    public synchronized CircularProducer<T> add(T entry)
    {
        source.add(1, entry);
        return this;
    }
    
    public synchronized CircularProducer<T> add(Producer<T> entry)
    {
        source.add(1, entry);
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
    public synchronized String toString()
    {
        return source.toString();
    }
}