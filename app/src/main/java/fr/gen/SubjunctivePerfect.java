package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class SubjunctivePerfect extends VerbQuestionSupport
{
    public SubjunctivePerfect(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter, null, null);
    }

    public SubjunctivePerfect(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        return new TextQuestion(this,
                "It is necessary that " + en(person, gender, verb, "have " + verb.translation(wordlist).participle()),
                elide("Il faut que", fr(person, gender, verb, elide(auxillary.subjunctive(person), verb.participle(person, gender)))));
    }
}