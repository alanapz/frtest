package fr;
import java.util.*;

public interface Adjective extends java.io.Serializable
{
    public String name();
    
    public boolean isTag(AdjectiveTag tag);
    
    public String lookup(Noun noun);

    public Set<? extends Translation> translations();

    public interface Translation extends java.io.Serializable
    {
        public Adjective adjective();

        public String translation();
    }
}