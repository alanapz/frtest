package fr.gen;
import java.util.*;

public final class PhraseTag
{
    private final PhraseTag parent;
    
    public PhraseTag()
    {
        this.parent = null;
    }
    
    public PhraseTag(PhraseTag parent)
    {
        if((this.parent = parent) == null)
            throw new NullPointerException("parent");
    }
    
    public boolean matches(Collection<?> source)
    {
        return source.contains(this) || (parent != null && parent.matches(source));
    }
}