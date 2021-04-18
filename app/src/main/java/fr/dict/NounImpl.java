package fr.dict;
import fr.*;
import java.util.*;

/* package */ final class NounImpl implements Noun
{
    private final String name;

    private final String translation;

    private final WordGender gender;

    private final Set<NounTag> tags;
    
    public NounImpl(String name, String translation, WordGender gender, Set<NounTag> tags)
    {
        if ((this.name = name) == null)
            throw new NullPointerException("name");
        if ((this.translation = translation) == null)
            throw new NullPointerException("translation for: " + name);
        if ((this.gender = gender) == null)
            throw new NullPointerException("gender for: " + name);
        if ((this.tags = tags) == null)
            throw new NullPointerException("tags for: " + name);
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public String getTranslation()
    {
        return translation;
    }
    
    @Override
    public boolean isTag(NounTag tag)
    {
        return tag != null && tags.contains(tag);
    }
    
    @Override
    public WordGender getGender()
    {
        return gender;
    }
    
    @Override
    public boolean isPlural()
    {
        return gender.select(false, false, true, true);
    }

    @Override
    public <T> T select(T MS, T FS, T plural)
    {
        return gender.select(MS, FS, plural, plural);
    }

    @Override
    public <T> T select(T MS, T FS, T MP, T FP)
    {
        return gender.select(MS, FS, MP, FP);
    }
    
    @Override
    public String toString()
    {
        return name + "(" + gender.select("le", "la", "les", "las") + ")=" + translation + tags;
    }
}