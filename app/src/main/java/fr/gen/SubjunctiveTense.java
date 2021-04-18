package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class SubjunctiveTense extends VerbQuestionSupport
{
    public SubjunctiveTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }

    public SubjunctiveTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap) {
        super(wordlist, filter, personMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        return new TextQuestion(this,
                "It is necessary that " + en(person, gender, verb, verb.translation(wordlist).present(person)),
                elide("Il faut que", fr(person, gender, verb, verb.subjunctive(person))));
    }
}