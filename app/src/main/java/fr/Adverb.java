package fr;
import java.util.*;

public interface Adverb extends java.io.Serializable {

    String name();
    
    Set<? extends Translation> translations();
    
    interface Translation {

        Adverb adverb();
        
        String translation();
    }
}