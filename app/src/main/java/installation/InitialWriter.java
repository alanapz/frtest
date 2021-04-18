package installation;
import java.io.*;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static installation.PackageUtils.*;

public class InitialWriter
{
    private static final Pattern pattern = Pattern.compile("(?si).*?<h2><a href=\"/od/verb_conjugations/a/(.*?)\\.htm\" zT=\".*?\">.*?</a></h2>.*?");
        
    public static void main(String[] args) throws IOException, InterruptedException, ExecutionException
    {
        List<String> urls = new Vector<>();
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<?>> results = new ArrayList<>();
        for(char i = 'a'; i <= 'z'; i++)
        {
            results.add(executor.submit(new VerbFinderTask("http://french.about.com/od/verbs-" + i + "/", urls)));
        }
        executor.shutdown();
        for(Future<?> result: results)
        {
            result.get();
        }
        try(FileWriter writer = new FileWriter("verbs.txt"))
        {
            for(String url: urls)
            {
                writer.write(url);
                writer.write("\r\n");
            }
        }
        System.out.println(urls.size() + " verbs discovered");
    }
    
    public static class VerbFinderTask implements Runnable
    {
        private final String target;
        
        private final List<String> urls;

        public VerbFinderTask(String target, List<String> urls)
        {
            this.target = target;
            this.urls = urls;
        }
        
        @Override
        public void run()
        {
            try
            {
                String targetData = url_get_contents(target);
                Matcher m;
                while ((m = pattern.matcher(targetData)).matches())
                {
                    urls.add(m.group(1));
                    targetData = targetData.substring(m.end(1));
                }
            }
            catch(FileNotFoundException e)
            {
                // Ignore ...
            }
            catch(IOException e)
            {
                throw new RuntimeException(e);
            }
        }
    }
}