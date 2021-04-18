package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class PerfectParticiple extends VerbQuestionSupport
{
    public PerfectParticiple(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter, null, null);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                "While having " + verb.translation(wordlist).participle() + enPronoun(verb, person, gender) + ", " + en(person, gender, verb, null) + " ...",
                "En " + elide(frPronominal(person, gender, verb, auxillary.gerund()), verb.participle(person, gender)) + ", " + fr(person, gender, verb, null));
    }
}