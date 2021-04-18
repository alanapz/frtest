package apz.fr.utils.ftl;
import freemarker.cache.*;
import freemarker.template.*;
import java.io.*;
import java.util.*;

public final class StringTemplateLoader implements TemplateLoader {

    private final StringTemplate source;
    
    private final Map<String, Object> context = new HashMap<>();

    public StringTemplateLoader(StringTemplate source)
    {
        this.source = source;
    }

    public void put(String name, Object value)
    {
        context.put(name, value);
    }

    public String render() {
        final CharArrayWriter buffer = new CharArrayWriter();
        try {
            Configuration config = new Configuration();
            config.setTemplateLoader(this);
            config.getTemplate("").process(context, buffer);
            return buffer.toString();
        }
        catch( IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }
   
    @Override
    public StringTemplate findTemplateSource(String string) {
        return source;
    }

    @Override
    public long getLastModified(Object o)
    {
        return 0;
    }

    @Override
    public Reader getReader(Object o, String string) {
        return ((StringTemplate) o).reader();
    }

    @Override
    public void closeTemplateSource(Object o) {
        // Nothing to do here
    }
}
