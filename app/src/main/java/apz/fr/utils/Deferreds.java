package apz.fr.utils;

import java.util.function.Supplier;

public final class Deferreds
{
    private Deferreds()
    {
        
    }
    
    public static <T> Supplier<T> fixed(final T value)
    {
        return bind(() -> value, () -> String.valueOf(value));
    }
    
    public static <T> Supplier<T> produced(final Producer<T> producer)
    {
        return bind(producer::next, producer::toString);
    }
    
    private static <T> Supplier<T> bind(final Supplier<T> callback, final Supplier<String> message)
    {
        return new Supplier<T>()
        {
            @Override
            public T get()
            {
                return callback.get();
            }

            @Override
            public String toString()
            {
                return message.get();
            }
        };
    }
}