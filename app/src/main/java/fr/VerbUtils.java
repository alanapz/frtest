package fr;
import static apz.fr.utils.Utils.*;

public final class VerbUtils
{
    private static final String[][] fr = new String[][] {
        { "je", "je", "me"},
        { "tu", "tu", "te"},
        { "il", "elle", "se" },
        { "nous", "nous", "nous" },
        { "vous", "vous", "vous" },
        { "ils", "elles", "se" }};
    
    private static final String[][] en = new String[][] {
        { "I(m)", "I(f)" },
        { "you(m.tu)", "you(f.tu)" },
        { "he", "she" },
        { "we(m)", "we(f)" },
        { "you(m.pl)", "you(f.pl)" },
        { "they(m)", "they(f)" }};

    private static final String vowelsStart = "aàáâeèéêiouh";

    private static final String vowelsEnd = "ea";
    
    private VerbUtils()
    {
        
    }
    
    public static String enPronoun(Verb verb, VerbPerson person, VerbGender gender)
    {
        if (verb == null || !verb.isTag(VerbTag.TRANSITIVE))
        {
            return "";
        }
        else if (verb.isTag(VerbTag.PRONOMINAL))
        {
            return " " + person.select("myself",
                "yourself",
                gender.select("himself", "herself"),
                "ourselves",
                "yourselves",
                "themselves");
        }
        else
        {
            return " |object|";
        }
    }
    
    public static String en(VerbPerson person, VerbGender gender, Verb verb, String suffix)
    {
        String value = en[person.ordinal()][gender.ordinal()];
        if (suffix == null)
        {
            return value;
        }
        if (verb != null && verb.isTag(VerbTag.PRONOMINAL) && verb.isTag(VerbTag.TRANSITIVE))
        {
            suffix = suffix + " " + person.select("myself",
                "yourself",
                gender.select("himself", "herself"),
                "ourselves",
                "yourselves",
                "themselves");
        }
        return value + " " + suffix;
    }

    public static String fr(VerbPerson person, VerbGender gender, Verb pronominal, String suffix)
    {
        String value = fr[person.ordinal()][gender.ordinal()];
        if (suffix == null)
        {
            return value;
        }
        if (pronominal != null && pronominal.isTag(VerbTag.PRONOMINAL))
        {
            suffix = elide(fr[person.ordinal()][2], suffix);
        }
        return elide(value, suffix);
    }

    public static String frPronominal(VerbPerson person, VerbGender gender, Verb pronominal, String suffix)
    {
        if (pronominal != null && pronominal.isTag(VerbTag.PRONOMINAL))
        {
            suffix = elide(fr[person.ordinal()][2], suffix);
        }
        return suffix;
    }
    
    public static String elide(String left, String right)
    {
        if (right == null || (right = right.trim()).isEmpty())
        {
            return left;
        }
        if (Character.isUpperCase(right.charAt(0)))
        {
            right = Character.toLowerCase(right.charAt(0)) + right.substring(1);
        }
        if (split(left, " ", -1).length() <= 3
                && vowelsEnd.indexOf(left.charAt(left.length() - 1)) >= 0
                && vowelsStart.indexOf(Character.toLowerCase(right.charAt(0))) >= 0)
        {
            return left.substring(0, left.length() - 1) + '\'' + right;
        }
        return left + ' ' + right;
    }
}