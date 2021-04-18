package apz.utils.csv;
import java.nio.charset.*;

public enum CharacterSet
{
    LATIN_1("ISO-8859-1");
    
    public final Charset charset;
    
    private CharacterSet(String name)
    {
        this.charset = Charset.forName(name);
    }
}