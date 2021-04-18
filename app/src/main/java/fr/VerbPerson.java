package fr;
import java.util.*;

public enum VerbPerson
{
    JE,
    TU,
    IL,
    NOUS,
    VOUS,
    ILS;
    
    public <T> T select(T singular, T plural)
    {
        return select(singular, singular, singular, plural, plural, plural);
    }
    
    public <T> T select(T je, T tu, T il, T nous, T vous, T ils)
    {
        if (this == JE)
        {
            return je;
        }
        else if (this == TU)
        {
            return tu;
        }
        else if (this == IL)
        {
            return il;
        }
        else if (this == NOUS)
        {
            return nous;
        }
        else if (this == VOUS)
        {
            return vous;
        }
        else if (this == ILS)
        {
            return ils;
        }
        else
        {
            return null;
        }
    }
    
    public static <T, M extends Map<VerbPerson, T>> M populate(M map, T je, T tu, T il, T nous, T vous, T ils)
    {
        map.put(VerbPerson.JE, je);
        map.put(VerbPerson.TU, tu);
        map.put(VerbPerson.IL, il);
        map.put(VerbPerson.NOUS, nous);
        map.put(VerbPerson.VOUS, vous);
        map.put(VerbPerson.ILS, ils);
        return map;
    }
}