package fr.gen;
import apz.fr.utils.*;
import fr.*;
import java.util.*;
import java.util.function.Predicate;

public final class ImperativeTense extends VerbQuestionSupport
{
    public ImperativeTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }

    public ImperativeTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson verbPerson, VerbGender gender)
    {
        final ImperativePerson person = verbPerson.select(null /* je */, ImperativePerson.TU, null /* il */, ImperativePerson.NOUS, ImperativePerson.VOUS, null /* ils */);
        if (person == null)
        {
            return null;
        }
        return new TextQuestion(this, 
                mappings.get(person) + ' ' + verb.translation(wordlist).infinitive() + "!",
                verb.imperative(person) + (verb.isTag(VerbTag.PRONOMINAL) ? '-' + person.select("toi", "nous", "vous") : "") + " !");
    }

    private static final Map<ImperativePerson, String> mappings = new HashMap<ImperativePerson, String>()
    {
        private static final long serialVersionUID = 1L;
        {
            put(ImperativePerson.TU, "You (t) must");
            put(ImperativePerson.NOUS, "Let's");
            put(ImperativePerson.VOUS, "You (v) must");
        }
    };
}