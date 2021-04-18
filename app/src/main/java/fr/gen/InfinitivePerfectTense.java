package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class InfinitivePerfectTense extends VerbQuestionSupport
{
    public InfinitivePerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter)
    {
        super(wordlist, filter);
    }

    public InfinitivePerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                "After having " + verb.translation(wordlist).participle() + enPronoun(verb, person, gender) + ", " + en(person, gender, verb, null) + " ...",
                "Après " + elide(frPronominal(person, gender, verb, auxillary.infinitive()), verb.participle(person, gender)) + ", " + fr(person, gender, verb, null));
    }
}