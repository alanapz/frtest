package fr;
import apz.fr.utils.*;
import java.util.*;
import java.util.function.Predicate;

public interface Wordlist
{
    void addNoun(Noun noun);
    
    NounList nouns();
    
    List<Noun> nouns(Predicate<Noun> filter);

    void addAdjective(Adjective adjective);

    List<Adjective> adjectives(Predicate<Adjective> filter);

    Producer<Adjective> adjectives();

    void addAdverb(Adverb adverb);
    
    Verb lookupVerb(String infinitive);

    List<Verb> takeVerbs(Producer<Predicate<Verb>> filter, int size);

    default Verb takeVerb(Producer<Predicate<Verb>> filter) {
        return takeVerbs(filter, 1).get(0);
    }

    VerbTranslation lookupVerbTranslation(String infinitive);
    
    void addVerbTranslation(VerbTranslation translation);
    
    interface NounList {

        Noun next(Predicate<Noun> filter);

        Noun[] next(Noun[] out, Predicate<Noun> filter);
    }
}