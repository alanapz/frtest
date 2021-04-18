package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class PluperfectTense extends VerbQuestionSupport
{
    public PluperfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter, null, null);
    }

    public PluperfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                en(person, gender, verb, "had " + verb.translation(wordlist).participle()),
                fr(person, gender, verb, elide(auxillary.imperfect(person), verb.participle(person, gender))));
    }
}