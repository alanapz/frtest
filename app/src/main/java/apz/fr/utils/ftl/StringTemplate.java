package apz.fr.utils.ftl;
import java.io.*;

public final class StringTemplate implements java.io.Serializable
{
    private final String value;
    
    private static final long serialVersionUID = 1L;
    
    public StringTemplate(String value)
    {
        this.value = value;
    }
    
    public Reader reader()
    {
        return new StringReader(value);
    }
    
    @Override
    public String toString()
    {
        return value;
    }
    
    public static StringTemplate of(String value)
    {
        return new StringTemplate(value);
    }
}
