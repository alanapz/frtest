package apz.fr.utils;
import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public final class Parallelised
{
    private Parallelised()
    {
        
    
    }
    
    public interface IOFunction<T, R>
    {
        public R apply(T t) throws IOException;
    }
    
    public static <T, U> List<U> exec(T[] inputs, int poolSize, final IOFunction<T, U> function) throws IOException
    {
        final List<Future<U>> futures = new ArrayList<>();
        final ExecutorService executor = Executors.newFixedThreadPool(poolSize);
        
        for(final T input: inputs)
        {
            futures.add(executor.submit(() -> function.apply(input)));
        }
        
        executor.shutdown();
        List<U> results = new ArrayList<>();
        try
        {
            for(Future<U> future: futures)
            {
                U result = future.get();
                if (result != null)
                {
                    results.add(result);
                }
            }
            return results;
        }
        catch(InterruptedException | ExecutionException e)
        {
            throw new IOException(e);
        }
    }
}
