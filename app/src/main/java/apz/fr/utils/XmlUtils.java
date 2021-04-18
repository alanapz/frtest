package apz.fr.utils;
import java.util.*;
import org.jdom.*;

public final class XmlUtils
{
    private XmlUtils()
    {
        
    }
    
    public static String getChildText(Element xml, String child, String element)
    {
        if ((xml = xml.getChild(child)) == null)
        {
            return null;
        }
        return xml.getChildTextTrim(element);
    }
    
    @SuppressWarnings("unchecked")
    public static List<Element> children(Element element, String name)
    {
        return (List<Element>) element.getChildren(name);
    }
}