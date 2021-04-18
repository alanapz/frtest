package fr.gen;
import apz.fr.utils.*;
import fr.*;
import static fr.VerbUtils.*;

import java.util.function.Predicate;

public final class ImperfectTense extends VerbQuestionSupport
{
    public ImperfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter)
    {
        super(wordlist, filter);
    }

    public ImperfectTense(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        super(wordlist, filter, personMap, genderMap);
    }

    @Override
    protected TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender)
    {
        final VerbTranslation auxiliaryEn = wordlist.lookupVerbTranslation("be");
        return new TextQuestion(this,
                en(person, gender, verb, auxiliaryEn.past(person) + " " + verb.translation(wordlist).gerund()),
                fr(person, gender, verb, verb.imperfect(person)));
    }
}