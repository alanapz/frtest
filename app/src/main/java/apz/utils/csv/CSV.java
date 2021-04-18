package apz.utils.csv;
import apz.fr.utils.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.*;

public final class CSV
{
    private CSV()
    {
        
    }
    
    public static <T> List<T> importCSV(Class<T> target, CharacterSet charset, InputStream stream) throws IOException
    {
        final List<T> out = new ArrayList<>();
        try
        {
            final ReadDescriptor[] descriptors = buildReadDescriptors(target);
            for(String[] row: importCSV(new InputStreamReader(stream, charset.charset)))
            {
                T instance = target.newInstance();
                for(int i=0; i<Math.min(row.length, descriptors.length); i++)
                {
                    //System.out.println(Arrays.toString(row));
                    if (row[i] != null && !(row[i] = row[i].trim()).isEmpty() && !row[i].equals("-"))
                    {
                        descriptors[i].read(instance, row[i]);
                    }
                }
                out.add(instance);
            }
            return out;
        }
        catch(ReflectiveOperationException e)
        {
            throw new IOException("Couldn't parse: " + target.getName(), e);
        }
    }
    
    public static List<String[]> importCSV(CharacterSet charset, InputStream stream) throws IOException
    {
        return importCSV(new InputStreamReader(stream, charset.charset));
    }
    
    public static List<String[]> importCSV(Reader stream) throws IOException
    {
        final List<String[]> out = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(stream))
        {
            String current;
            while((current = reader.readLine()) != null)
            {
                out.add(processLine(current, new ArrayList<>()));
            }
        }
        return out;
    }
    
    private static String[] processLine(String line, List<String> out)
    {
        boolean inQuotes = false;
        final StringBuilder buffer = new StringBuilder();
        for(char c: line.toCharArray())
        {
            if (c == '"')
            {
                inQuotes = !inQuotes;
            }
            else if (!inQuotes && c == ',')
            {
                out.add(buffer.toString().trim());
                buffer.setLength(0);
            }
            else
            {
                buffer.append(c);
            }
        }
        if (buffer.length() > 0)
        {
            out.add(buffer.toString().trim());
        }
        return out.toArray(new String[out.size()]);
    }
    
    private interface ReadDescriptor
    {
        public void read(Object instance, String value) throws ReflectiveOperationException;
    }
    
    private static ReadDescriptor[] buildReadDescriptors(Class<?> target)
    {
        final List<ReadDescriptor> out = new ArrayList<>();
        for(final Field field: target.getFields())
        {
            final Class<?> type = field.getType();
            // Simplest is scalar string
            if (type == String.class)
            {
                out.add((ReadDescriptor) (instance, value) ->
                {
                    field.set(instance, value);
                });
            }
            // String array
            else if (type == String[].class)
            {
                // If no annotations are supplied, split on comma
                out.add((ReadDescriptor) (instance, value) ->
                {
                    field.set(instance, value.split(Utils.quote(",")));
                });
            }
            // Enum
            else if (type.isEnum())
            {
                final Map<String, Enum<?>> enumMappings = new HashMap<>();
                {
                    Map<String, Enum<?>> universe = parseEnumConstants(type.asSubclass(Enum.class));
                    for(EnumValue value: field.getAnnotation(EnumMapping.class).value())
                    {
                        enumMappings.put(value.name(), universe.get(value.value()));
                    }
                }
                out.add((ReadDescriptor) (Object instance, String valueName) ->
                {
                    Enum<?> value = enumMappings.get(valueName);
                    if (value == null)
                    {
                        throw new IllegalArgumentException("No enum mapping found for: " + valueName);
                    }
                    field.set(instance, value);
                });
            }
            // Custom field
            else if (CustomField.class.isAssignableFrom(type))
            {
                out.add((ReadDescriptor) (Object instance, String value) ->
                {
                    ((CustomField) field.get(instance)).read(value);
                });
            }
            else
            {
                throw new IllegalArgumentException("Couldn't build mapping for: " + field);
            }
        }
        return out.toArray(new ReadDescriptor[out.size()]);
    }
    
    private static <E extends Enum<?>> Map<String, Enum<?>> parseEnumConstants(Class<?> clazz)
    {
        Map<String, Enum<?>> values = new HashMap<>();
        for(Object value: clazz.getEnumConstants())
        {
            Enum<?> t;
            values.put((t = ((Enum<?>) value)).name(), t);
        }
        return values;
    }
}