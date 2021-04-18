package fr.lang;
import fr.*;
import java.util.*;

public final class Pronoun implements java.io.Serializable
{
    public final Voice voice;

    public final String enSubject, enObject;

    public final String frSubject, frReflexive, frDirect, frIndirect, frDisjunctive;

    private static final Map<Voice, Pronoun> values = new HashMap<>();
    
    private static final long serialVersionUID = 1L;

    private Pronoun(Voice voice, String enSubject, String enObject, String frSubject, String frReflexive, String frDirect, String frIndirect, String frDisjunctive) {
        this.voice = voice;
        this.enSubject = enSubject;
        this.enObject = enObject;
        this.frSubject = frSubject;
        this.frReflexive = frReflexive;
        this.frDirect = frDirect;
        this.frIndirect = frIndirect;
        this.frDisjunctive = frDisjunctive;
    }

    public <T> T plural(T singlular, T plural) {
        return voice.select(singlular, singlular, singlular, singlular, singlular, plural, plural, plural, plural);
    }
    
    public static Pronoun get(Voice voice)
    {
        return values.get(voice);
    }

    static {
        add(Voice.JE, "I", "me", "Je", "me", "me", "me", "moi");
        add(Voice.TU, "You (tu)", "you (tu)", "Tu", "te", "te", "te", "toi");
        add(Voice.IL, "He", "him", "Il", "se", "le", "lui", "lui");
        add(Voice.ELLE, "She", "her", "Elle", "se", "la", "lui", "elle");
        add(Voice.ON, "One", "one", "On", "se", null, null, "soi");
        add(Voice.NOUS, "We", "us", "Nous", "nous", "nous", "nous", "nous");
        add(Voice.VOUS, "You", "you", "Vous", "vous", "vous", "vous", "vous");
        add(Voice.ILS, "They (m.)", "them (m.)", "Ils", "se", "les", "leur", "eux");
        add(Voice.ELLES, "They (f.)", "them (f.)", "Elles", "se", "les", "leur", "elles");
    }

    private static void add(Voice voice, String enSubject, String enObject, String frSubject, String reflexive, String direct, String indirect, String frDisjunctive)
    {
        values.put(voice, new Pronoun(voice, enSubject, enObject, frSubject, reflexive, direct, indirect, frDisjunctive));
    }
}