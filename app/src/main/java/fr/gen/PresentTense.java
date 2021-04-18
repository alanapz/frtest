package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class PresentTense extends VerbQuestionSupport
{
    public PresentTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }

    public PresentTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap) {
        super(wordlist, filter, personMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        return new TextQuestion(this,
                en(person, gender, verb, verb.translation(wordlist).present(person)),
                fr(person, gender, verb, verb.present(person)));
    }
}