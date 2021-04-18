package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class FuturePerfectTense extends VerbQuestionSupport {

    public FuturePerfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                en(person, gender, verb, "will have " + verb.translation(wordlist).participle()),
                fr(person, gender, verb, elide(auxillary.future(person), verb.participle(person, gender))));
    }
}