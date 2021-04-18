package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class PerfectTense extends VerbQuestionSupport
{
    public PerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter)
    {
        super(wordlist, filter);
    }

    public PerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                en(person, gender, verb, verb.translation(wordlist).past(person)),
                fr(person, gender, verb, elide(auxillary.present(person), verb.participle(person, gender))));
    }
}