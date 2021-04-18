package apz.fr.utils;
import java.io.*;
import java.util.regex.*;

public final class IO
{
    private static final Pattern pattern = Pattern.compile(".*\\QThe process cannot access the file because it is being used by another process\\E.*");
    
    private IO()
    {
        
    }
    
    public static FileOutputStream openOutput(File file) throws IOException
    {
        return openFile(file, (lfile) -> new FileOutputStream(lfile));
    }
    
    public static FileWriter openWriter(File file) throws IOException
    {
        return openFile(file, (lfile) -> new FileWriter(lfile));
    }
    
    private static <T> T openFile(File file, FileHandler<T> handler) throws IOException
    {
        int delay = 0;
        for(;;)
        {
            try
            {
                return handler.go(file);
            }
            catch(IOException ioe)
            {
                if (!pattern.matcher(ioe.getMessage()).matches())
                {
                    throw ioe;
                }
                try
                {
                    System.out.println("*** " + file + " is open by another process ...");
                    //Thread.sleep(1 << ++delay);
                    Thread.sleep(++delay * 100);
                }
                catch(InterruptedException ie)
                {
                    // Not much we can do here !
                }
            }
        }
    }
    
    private interface FileHandler<T>
    {
        public T go(File file) throws IOException;
    }
}
