package apz.fr.utils;
import java.util.*;
import java.util.function.*;

public final class Filters
{
    private Filters()
    {
        
    }
    
    public static <T> List<T> filter(Collection<T> in, Predicate<T> filter) {
        return filter(in, filter, new ArrayList<>());
    }
    
    public static <T, C extends Collection<T>> C filter(Collection<T> in, Predicate<T> filter, C out)
    {
        if (filter == null)
        {
            out.addAll(in);
            return out;
        }
        for(T value: in) {
            if (filter.test(value)) {
                out.add(value);
            }
        }
        return out;
    }

    public static <T> Predicate<T> not(final Predicate<T> filter) {
        if (filter == null) {
            return null;
        }
        return bind((item) -> !filter.test(item), () -> "!" + filter);
    }

    public static <T> Predicate<T> and(final Predicate<T> filter1, final Predicate<T> filter2)
    {
        if (filter1 == null)
        {
            return filter2;
        }
        if (filter2 == null)
        {
            return filter1;
        }
        return bind((item) -> filter1.test(item) && filter2.test(item), () -> "[" + filter1 + "&&" + filter2 + "]");
    }

    public static <T> Predicate<T> or(final Predicate<T> filter1, final Predicate<T> filter2) {
        if (filter1 == null) {
            return filter2;
        }
        if (filter2 == null) {
            return filter1;
        }
        return bind((item) -> filter1.test(item) || filter2.test(item), () -> "[" + filter1 + "||" + filter2 + "]");
    }
    
    private static <T> Predicate<T> bind(final Function<T, Boolean> callback, final Supplier<String> message) {
        return new Predicate<T>()
        {
            @Override
            public boolean test(T item)
            {
                return callback.apply(item);
            }

            @Override
            public String toString()
            {
                return message.get();
            }
        };
    }
}