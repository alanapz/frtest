package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class PresentParticiple extends VerbQuestionSupport
{
    public PresentParticiple(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter, null, null);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        return new TextQuestion(this,
                "While " + verb.translation(wordlist).gerund() + ", " + en(person, gender, verb, null) + " ...",
                "En " + verb.gerund() + ", " + fr(person, gender, verb, null));
    }
}