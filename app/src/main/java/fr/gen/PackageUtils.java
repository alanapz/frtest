package fr.gen;
import fr.*;
import java.util.*;

/* package */ final class PackageUtils
{
    private static final Map<VerbPerson, Possessive> possessives = new HashMap<>();

    private static final String vowels = "aàáâeèéêiou";
    
    private PackageUtils()
    {
        
    }
    
    public static Possessive lookupPossessive(VerbPerson person)
    {
        return possessives.get(person);
    }

    public static Voice toVoice(VerbPerson person, VerbGender gender)
    {
        return person.select(
                Voice.JE,
                Voice.TU,
                gender.select(Voice.IL, Voice.ELLE),
                Voice.NOUS,
                Voice.VOUS,
                gender.select(Voice.ILS, Voice.ELLES));
    }
    
    public static String nounDefiniteFr(Noun noun) {
        return noun.select(
                noun.isTag(NounTag.CONTRACTED) ? "l'" : "le ",
                noun.isTag(NounTag.CONTRACTED) ? "l'" : "la ",
                "les ") +
                noun.getName();
    }

    public static String elide(String left, String right) {
        if (vowelEnd(left) && vowelStart(right))
        {
            return left.substring(0, left.length() - 1) + "'" + right;
        }
        return left + " " + right;
    }

    public static boolean vowelStart(String word)
    {
        return vowels.indexOf(word.charAt(0)) >= 0;
    }

    private static boolean vowelEnd(String word)
    {
        return vowels.indexOf(word.charAt(word.length() - 1)) >= 0;
    }

    static
    {
        putPossessive(VerbPerson.JE, "My", "Mon", "Ma", "Mes");
        putPossessive(VerbPerson.TU, "Your (tu)", "Ton", "Ta", "Tes");
        putPossessive(VerbPerson.IL, "His", "Son", "Sa", "Ses");
        putPossessive(VerbPerson.NOUS, "Our", "Notre", "Notre", "Nos");
        putPossessive(VerbPerson.VOUS, "Your", "Votre", "Votre", "Vos");
        putPossessive(VerbPerson.ILS, "Their", "Leur", "Leur", "Leurs");
    }
    
    private static void putPossessive(VerbPerson person, String translation, String il, String elle, String ils)
    {
        possessives.put(person, new Possessive(translation, il, elle, ils));
    }
    
    public static final class Possessive
    {
        public final String translation;
        
        private final String il, elle, ils;
        
        private Possessive(String translation, String il, String elle, String ils)
        {
            this.translation = translation;
            this.il = il;
            this.elle = elle;
            this.ils = ils;
        }
        
        public String select(Noun noun)
        {
            return noun.select(il, elle, ils);
        }
    }
}
