package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class ConditionalTense extends VerbQuestionSupport
{
    public ConditionalTense(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        super(wordlist, filter);
    }

    public ConditionalTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender) {
        return new TextQuestion(this,
                en(person, gender, verb, "would " + verb.translation(wordlist).infinitive()),
                fr(person, gender, verb, verb.conditional(person)));
    }
}