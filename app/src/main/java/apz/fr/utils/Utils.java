package apz.fr.utils;
import fr.Noun;
import fr.Voice;
import java.lang.reflect.*;
import java.security.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;

public final class Utils
{
    private static final Random random = initialiseRNG();

    private static final String vowels = "aàáâeèéêiouh";

    private static final Map<String, String> quoteMap = new ConcurrentHashMap<>();
    
    private Utils()
    {
        
    }
    
    public static long parseLong(String s)
    {
        return (s == null) || (s = s.trim()).isEmpty() ? 0 : Long.parseLong(s);
    }
    
    
    public static int parseInt(String s)
    {
        return (s == null) || (s = s.trim()).isEmpty() ? 0 : Integer.parseInt(s);
    }

    public static String removeUnprintable(String in)
    {
        return in.replace("î", "").replace("ï", "");
    }

    public static Random random()
    {
        return new Random(random.nextLong());
    }
    
    public static String quote(String value)
    {
        String quoted = quoteMap.get(value);
        if (quoted == null)
        {
            quoteMap.put(value, (quoted = Pattern.quote(value)));
        }
        return quoted;
    }
    
    @SuppressWarnings({"varargs", "unchecked"})
    public static <T> boolean is(T left, T... right)
    {
        return Arrays.asList(right).contains(left);
    }
    
    @SuppressWarnings({"unchecked", "varargs"})
    public static <T> T[] of(T... values)
    {
        return values;
    }
    
    public static StrPair pair(String left, String right)
    {
        return new StrPair(left, right);
    }

    public static <T> Pair<T> pair(T left, T right)
    {
        return new Pair<>(left, right);
    }

    public static <T> T select(boolean condition, T left, T right)
    {
        return condition ? left : right;
    }

    public static <T> T select(T left, Supplier<T> right)
    {
        return left != null ? left : right.get();
    }

    public static <T> T add(T item, Collection<T> collection)
    {
        collection.add(item);
        return item;
    }
    
    public static <T, C extends Collection<T>> C add(C collection, T item)
    {
        collection.add(item);
        return collection;
    }
    
    public static <R, T> R apply(T in, R out, Function<T, R> func)
    {
        return in != null ? func.apply(in) : out;
    }

    public static String implode(String[] values, String seperator)
    {
        final StringBuilder buffer = new StringBuilder();
        for(int i=0; i<values.length; i++)
        {
            buffer.append(String.valueOf(values[i]));
            if (i != values.length - 1)
            {
                buffer.append(seperator);
            }
        }
        return buffer.toString();
    }
    
    public static String split(String input, String pattern, int index)
    {
        final String[] values = input.split(quote(pattern));
        return index >= 0 ? values[index] : values[values.length + index];
    }

    public static <T, C extends Collection<T>> C addAll(C collection, Collection<T> items)
    {
        collection.addAll(items);
        return collection;
    }

    public static <E extends Enum<E>> String toString(Collection<E> values)
    {
        if (values == null || values.isEmpty())
        {
            return "";
        }
        final StringBuilder buffer = new StringBuilder("[");
        for(E value: values)
        {
            buffer.append(value);
        }
        return buffer.append("]").toString();
    }
    
    public static <T extends Comparable<T>> int compare(T o1, T o2)
    {
        if (o1 == null && o2 == null)
        {
            return 0;
        }
        else if (o1 == null)
        {
            return -1;
        }
        else if (o2 == null)
        {
            return +1;
        }
        else
        {
            return o1.compareTo(o2);
        }
    }

    public static <T> int compare(T o1, T o2, Comparator<T> comparator)
    {
        if (o1 == null && o2 == null)
        {
            return 0;
        }
        else if (o1 == null)
        {
            return -1;
        }
        else if (o2 == null)
        {
            return +1;
        }
        else
        {
            return comparator.compare(o1, o2);
        }
    }
    
    public static String strcmp(String left, String right)
    {
        StringBuilder buffer = new StringBuilder();
        for(int i=0; i<Math.max((left = left.toLowerCase()).length(), (right = right.toLowerCase()).length()); i++)
        {
            if (i >= left.length() || i >= right.length() || left.charAt(i) != right.charAt(i))
            {
                buffer.append("***");
                break;
            }
            buffer.append(left.charAt(i));
        }
        return buffer.toString();
    }
    
    /* package */ static boolean nextBoolean()
    {
        return random.nextBoolean();
    }

    public static int nextInt(int n)
    {
        return random.nextInt(n);
    }

    public static <T extends List<?>> T shuffle(T list)
    {
        Collections.shuffle(list, random);
        return list;
    }
    
    public static <T> T random(T[] array)
    {
        return array[random.nextInt(array.length)];
    }

    /* package */ static <T> T nextElement(T[] array)
    {
        return array[random.nextInt(array.length)];
    }

    public static <E extends Enum<E>> E random(Class<E> type)
    {
        return random(type.getEnumConstants());
    }

    public static <T> T popFirst(List<T> list)
    {
        return list.isEmpty() ? null : list.remove(0);
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T random(Collection<T> collection)
    {
        return (T) random(collection.toArray());
    }

    /* package */ static <T> T nextElement(Class<T> klazz, Collection<T> collection)
    {
        return klazz.cast(collection.toArray()[random.nextInt(collection.size())]);
    }

    public static long lookupSerialNumber(Class<?> clazz)
    {
        try
        {
            Field field = clazz.getDeclaredField("serialVersionUID");
            field.setAccessible(true);
            return field.getLong(clazz);
        }
        catch(NoSuchFieldException e)
        {
            return 0;
        }
        catch(IllegalAccessException e)
        {
            throw new RuntimeException("Couldn't lookup serialVersionUID for " + clazz, e);
        }
    }
    
    @SuppressWarnings("unchecked")
    /* package */ static <K, V> Map.Entry<K, V> random(Map<K, V> map)
    {
        return (Map.Entry<K, V>) random(map.entrySet().toArray());
    }

    public static boolean startsWithVowel(String word)
    {
        return vowels.indexOf(word.charAt(0)) >= 0;
    }

    public static Set<Character> str2chars(String input)
    {
        if (input == null || (input = input.trim()).isEmpty())
        {
            return Collections.emptySet();
        }
        Set<Character> charset = new HashSet<>();
        for(char c: input.toCharArray())
        {
            charset.add(c);
        }
        return charset;
    }
    
    public static String englishIndefiniteArticle(Noun noun, String translation)
    {
        if (noun.isPlural())
        {
            return "Some ";
        }
        char firstLetter = translation.toLowerCase().charAt(0);
        if (vowels.indexOf(firstLetter) == (-1))
        {
            return "A ";
        }
        else
        {
            return "An ";
        }
    }

    public static WeightedProducer<Voice> defaultVoiceMap()
    {
        WeightedProducer<Voice> list = new WeightedProducer<>();
        list.add(1, Voice.JE);
        list.add(1, Voice.TU);
        list.add(2, Voice.IL);
        list.add(2, Voice.ELLE);
        list.add(2, Voice.ON);
        list.add(1, Voice.NOUS);
        list.add(1, Voice.VOUS);
        list.add(2, Voice.ILS);
        list.add(3, Voice.ELLES);
        return list;
    }
    
    private static Random initialiseRNG()
    {
        try
        {
            return SecureRandom.getInstance("SHA1PRNG");
        }
        catch(NoSuchAlgorithmException e)
        {
            throw new RuntimeException("Couldn't obtain RNG", e);
        }
    }
}