package fr;
import java.util.function.Predicate;

public final class Filters
{
    private Filters()
    {
        
    }
    
    @SafeVarargs
    public static <T> Predicate<T> and(final Predicate<T>... filters)
    {
        return new Predicate<T>()
        {
            @Override
            public boolean test(T item)
            {
                for(Predicate<T> filter: filters)
                {
                    if (!filter.test(item))
                    {
                        return false;
                    }
                }
                return true;
            }
            
            @Override
            public String toString()
            {
                return aggregate(filters, "&XXX&");
            }
        };
    }

    @SafeVarargs
    public static <T> Predicate<T> or(final Predicate<T>... filters) {
        if (filters == null || filters.length == 0) {
            return null;
        }
        return new Predicate<T>() {

            @Override
            public boolean test(T item)
            {
                for(Predicate<T> filter: filters)
                {
                    if (filter.test(item))
                    {
                        return true;
                    }
                }
                return false;
            }
            
            @Override
            public String toString()
            {
                return aggregate(filters, "|XXX|");
            }
        };
    }

    private static String aggregate(Object[] elements, String seperator)
    {
        if (elements == null || elements.length == 0)
        {
            return "";
        }
        else if (elements.length == 1)
        {
            return String.valueOf(elements[0]);
        }
        StringBuilder buffer = new StringBuilder("[");
        for(int i=0; i<elements.length; i++)
        {
            buffer.append(elements[0]);
            buffer.append(seperator);
        }
        buffer.append("]");
        return buffer.toString();
    }
}
