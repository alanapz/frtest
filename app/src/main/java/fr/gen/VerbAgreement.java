package fr.gen;
import apz.fr.utils.*;
import fr.*;
import java.util.*;
import static fr.VerbUtils.*;

public final class VerbAgreement implements QuestionGenerator
{
    private final Wordlist wordlist;
    
    private final Producer<VerbPerson> personMap;

    private final Producer<VerbGender> genderMap;

    public VerbAgreement(Wordlist wordlist)
    {
        this(wordlist, defaultPersonMap(), defaultGenderMap());
    }

    public VerbAgreement(Wordlist wordlist, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap)
    {
        this.wordlist = wordlist;
        this.personMap = personMap;
        this.genderMap = genderMap;
    }

    @Override
    public final List<Question> generate(int size, List<Question> questions)
    {
        final Verb verb = wordlist.lookupVerb("prendre");
        final Verb auxillary = wordlist.lookupVerb(verb.auxiliary());
        final Wordlist.NounList nouns = wordlist.nouns();
        while(questions.size() != size) {
            final VerbPerson sbjPerson = personMap.next();
            final VerbGender sbjGender = genderMap.next();
            final VerbPerson objPerson = personMap.next();
            final VerbGender objGender = genderMap.next();
            final WordGender wordGender = parseGender(objPerson, objGender);
            final Noun noun = nouns.next(item -> item.isTag(NounTag.STARRED) && item.getGender() == wordGender);
            questions.add(new TextQuestion(this,
                en(sbjPerson, sbjGender, verb, verb.translation(wordlist).past(sbjPerson) + " |the " + noun.getTranslation() + "|"),
                fr(sbjPerson, sbjGender, verb, elide(noun.select("le", "la", "les"), auxillary.present(sbjPerson)) + " " + verb.participle(wordGender))));
        }
        return questions;
    }
    
    @Override
    public final String toString()
    {
        return "[person=" + personMap + ",gender=" + genderMap + "]";
    }

    private static WordGender parseGender(VerbPerson person, VerbGender gender)
    {
        return person.select(
                gender.select(WordGender.IL, WordGender.ELLE),
                gender.select(WordGender.ILS, WordGender.ELLES));
    }
    
    private static WeightedProducer<VerbPerson> defaultPersonMap()
    {
        // Prefer ILS
        WeightedProducer<VerbPerson> list = new WeightedProducer<>();
        list.add(1, VerbPerson.JE);
        list.add(1, VerbPerson.TU);
        list.add(1, VerbPerson.IL);                                                
        list.add(1, VerbPerson.NOUS);
        list.add(1, VerbPerson.VOUS);
        list.add(2, VerbPerson.ILS);
        return list;
    }

    private static WeightedProducer<VerbGender> defaultGenderMap()
    {
        // Prefer ELLE
        WeightedProducer<VerbGender> list = new WeightedProducer<>();
        list.add(2, VerbGender.IL);
        list.add(3, VerbGender.ELLE);
        return list;
    }
}