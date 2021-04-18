package apz.fr.utils;

public final class StrPair implements java.io.Serializable
{
    public final String first;
    
    public final String second;
    
    private static final long serialVersionUID = 1L;

    public StrPair(String first, String second)
    {
        if ((this.first = first) == null)
            throw new NullPointerException("first");
        if ((this.second = second) == null)
            throw new NullPointerException("second");
    }
    
    public static String[] allFirst(StrPair[] in)
    {
        String[] out = new String[in.length];
        for(int i=0; i<in.length; i++)
        {
            out[i] = in[i].first;
        }
        return out;
    }
    
    public static String[] allSecond(StrPair[] in)
    {
        String[] out = new String[in.length];
        for(int i=0; i<in.length; i++)
        {
            out[i] = in[i].second;
        }
        return out;
    }
}