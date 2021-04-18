package fr.gen;
import fr.*;
import apz.fr.utils.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class ConditionalPerfectTense extends VerbQuestionSupport
{
    public ConditionalPerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }
    
    public ConditionalPerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender)
    {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                en(person, gender, verb, "would have " + verb.translation(wordlist).participle()),
                fr(person, gender, verb, elide(auxillary.conditional(person), verb.participle(person, gender))));
    }
}