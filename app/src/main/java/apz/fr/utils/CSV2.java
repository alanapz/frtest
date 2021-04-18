package apz.fr.utils;
import java.io.*;
import java.util.*;

public final class CSV2
{
    private CSV2()
    {
        
    }
    
    public interface Importer<T>
    {
        T read(String[] input) throws IOException;
    }
    
    public interface Exporter<T>
    {
        Object[] write(T row);
    }
    
    public static <T> List<T> importFromFile(File file, Importer<T> importer)
    {
        try
        {
            return importCSV(new FileReader(file), importer);
        }
        catch(IOException e)
        {
            throw new RuntimeException("Couldn't open file: " + file, e);
        }
    }
    
    private static <T> List<T> importCSV(Reader stream, Importer<T> importer) throws IOException
    {
        final List<T> out = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(stream))
        {
            String current;
            while((current = reader.readLine()) != null)
            {
                String[] components = current.split(",");
                for(int i=0; i<components.length; i++)
                {
                    components[i] = components[i].replace("\\'", "\"").replace("\\;", ",");
                }
                out.add(importer.read(components));
            }
        }
        return out;
    }

    public static <T> void write(File file, Collection<T> rows, Exporter<T> exporter)
    {
        if (rows.isEmpty())
        {
            return;
        }
        try(Writer writer = IO.openWriter(file))
        {
            for(T row: rows)
            {
                for(Object value: exporter.write(row))
                {
                    writer.write(String.valueOf(value).replace("\"", "\\'").replace(",", "\\;"));
                    writer.write(',');
                }
                writer.write("\r\n");
            }
        }
        catch(IOException e)
        {
            throw new RuntimeException("Couldn't CSV write: " + file, e);
        }
    }
}
