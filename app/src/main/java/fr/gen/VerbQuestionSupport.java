package fr.gen;
import apz.fr.utils.*;
import fr.*;
import java.util.*;
import java.util.function.Predicate;

/* package */ abstract class VerbQuestionSupport implements QuestionGenerator
{
    protected final Wordlist wordlist;
    
    protected final Producer<Predicate<Verb>> filter;

    protected final Producer<VerbPerson> personMap;

    protected final Producer<VerbGender> genderMap;

    public VerbQuestionSupport(Wordlist wordlist, Producer<Predicate<Verb>> filter) {
        this(wordlist, filter, null, null);
    }

    public VerbQuestionSupport(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap) {
        this(wordlist, filter, personMap, null);
    }

    public VerbQuestionSupport(Wordlist wordlist, Producer<Predicate<Verb>> filter, Producer<VerbPerson> personMap, Producer<VerbGender> genderMap) {
        if ((this.wordlist = wordlist) == null)
            throw new NullPointerException("filter");
        this.filter = (filter != null ? filter : defaultFilter());
        this.personMap = (personMap != null ? personMap : defaultPersonMap());
        this.genderMap = (genderMap != null ? genderMap : defaultGenderMap());
    }

    protected abstract TextQuestion generate(Verb verb, VerbPerson person, VerbGender gender);
    
    @Override
    public final List<Question> generate(int size, List<Question> questions)
    {
        Question question;
        for (Verb verb: wordlist.takeVerbs(filter, size)) {
            while(true) {
                if ((question = generate(verb, personMap.next(), genderMap.next())) != null) {
                    questions.add(question);
                    break;
                }
            }
        }
        return questions;
    }
    
    @Override
    public final String toString()
    {
        return "[filter=" + filter + ",person=" + personMap + ",gender=" + genderMap + "]";
    }
    
    // Convenience methods
    protected WeightedProducer<Predicate<Verb>> defaultFilter() {
        return null;
    }
    
    // Convenience methods
    protected static Producer<VerbPerson> defaultPersonMap()
    {
        CircularProducer<VerbPerson> list = new CircularProducer<>();
        list.add(VerbPerson.JE);
        list.add(VerbPerson.TU);
        list.add(VerbPerson.IL);
        list.add(VerbPerson.NOUS);
        list.add(VerbPerson.VOUS);
        list.add(VerbPerson.VOUS);
        list.add(VerbPerson.ILS);
        list.add(VerbPerson.ILS);
        list.add(VerbPerson.ILS);
        return list;
    }

    // Convenience methods
    protected static Producer<VerbGender> defaultGenderMap()
    {
        return WeightedProducer.fromEnum(VerbGender.class);
    }
}