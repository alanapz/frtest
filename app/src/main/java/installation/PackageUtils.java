package installation;
import java.io.*;
import java.net.*;

/* package */ final class PackageUtils
{
    private PackageUtils()
    {
        
    }
    
    public static String url_get_contents(String URL) throws IOException
    {
        HttpURLConnection conn = (HttpURLConnection) new URL(URL).openConnection();
        StringBuilder buffer = new StringBuilder();
        int i;
        while((i = conn.getInputStream().read()) != -1)
        {
            buffer.append((char) i);
        }
        conn.disconnect();    
        return buffer.toString();
    }
}
