package fr.gen;
import apz.fr.utils.*;
import apz.fr.utils.Filters;
import fr.*;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;

public final class DePartative implements FixedQuestionGenerator
{
    private final ScoreFileBuilder scores;
    
    private final Wordlist wordlist;
    
    private final Predicate<Noun> filter;
    
    private static final WeightedProducer<Subject> subjects = new WeightedProducer<>();

    public DePartative(ScoreFileBuilder scores, Wordlist wordlist, Predicate<Noun> filter)
    {
        if ((this.scores = scores) == null)
            throw new NullPointerException("scores");
        if ((this.wordlist = wordlist) == null)
            throw new NullPointerException("wordlist");
        this.filter = Filters.and(NounFilters.tag(NounTag.PARTATIVE), filter);
        //this.filter = Filter.and(Filter.and(NounFilters.tag(NounTag.PARTATIVE), filter), NounFilters.tag(NounTag.CONTRACTED));
    }
    
    @Override
    public List<Question> generate(int size, List<Question> out)
    {
        List<Noun> nouns = scores.open(this).map(wordlist.nouns(filter), null, size, Noun::getName);
        nouns.stream().forEach((noun) -> {
            Subject subject = subjects.next();
            out.add(new TextQuestion(this,
                    subject.name + "," + noun.getName(),
                    subject.english + " some " + noun.getTranslation(),
                    subject.french + " " + noun.select(
                            noun.isTag(NounTag.CONTRACTED) ? "de l'" : "du ",
                            noun.isTag(NounTag.CONTRACTED) ? "de l'" : "de la ",
                            "des ") + noun.getName()));
        });
        return out;
    }
    
    @Override
    public String toString()
    {
        return String.valueOf(filter);
    }    
    
    static
    {
        subjects.add(0, new WeightedProducer<>(
                new Subject("present#1", "J'ai", "I have"),
                new Subject("present#2", "Tu as", "You(tu) have"),
                new Subject("present#3f", "Elle a", "She has"),
                new Subject("present#4", "Nous avons", "We have"),
                new Subject("present#5", "Vous avez", "You have"),
                new Subject("present#6m", "Ils ont", "They have")));
        subjects.add(new WeightedProducer<>(
                new Subject("imperfect#1", "J'avais", "I was having"),
                new Subject("imperfect#2", "Tu avais", "You(tu) was having"),
                new Subject("imperfect#3f", "Elle avait", "She was having"),
                new Subject("imperfect#4", "Nous avions", "We were having"),
                new Subject("imperfect#5", "Vous aviez", "You were having"),
                new Subject("imperfect#6m", "Ils avaient", "They were having")));
        subjects.add(new WeightedProducer<>(
                new Subject("future#1", "J'aurai", "I will have"),
                new Subject("future#2", "Tu auras", "You(tu) will have"),
                new Subject("future#3f", "Elle aura", "She will have"),
                new Subject("future#4", "Nous aurons", "We will have"),
                new Subject("future#5", "Vous aurez", "You will have"),
                new Subject("future#6m", "Ils auront", "They will have")));
        subjects.add(new WeightedProducer<>(
                new Subject("futurePast#1", "J'aurai eu", "I will have had"),
                new Subject("futurePast#2", "Tu auras eu", "You(tu) will have had"),
                new Subject("futurePast#3f", "Elle aura eu", "She will have had"),
                new Subject("futurePast#4", "Nous aurons eu", "We will have had"),
                new Subject("futurePast#5", "Vous aurez eu", "You will have had"),
                new Subject("futurePast#6m", "Ils auront eu", "They will have had")));
        subjects.add(new WeightedProducer<>(
                new Subject("conditional#1", "J'aurais", "I would have"),
                new Subject("conditional#2", "Tu aurais", "You(tu) would have"),
                new Subject("conditional#3f", "Elle aurait", "She would have"),
                new Subject("conditional#4", "Nous aurions", "We would have"),
                new Subject("conditional#5", "Vous auriez", "You would have"),
                new Subject("conditional#6m", "Ils auraient", "They would have")));
        subjects.add(new WeightedProducer<>(
                new Subject("conditionalPast#1", "J'aurais eu", "I would have had"),
                new Subject("conditionalPast#2", "Tu aurais eu", "You(tu) would have had"),
                new Subject("conditionalPast#3f", "Elle aurait eu", "She would have had"),
                new Subject("conditionalPast#4", "Nous aurions eu", "We would have had"),
                new Subject("conditionalPast#5", "Vous auriez eu", "You would have had"),
                new Subject("conditionalPast#6m", "Ils auraient eu", "They would have had")));
        subjects.add(2, new WeightedProducer<>(
                new Subject("subjunctive#1", "Il faut que j'aie", "It is necessary that I have"),
                new Subject("subjunctive#2", "Il faut que tu aies", "It is necessary that you(tu) have"),
                new Subject("subjunctive#3m", "Il faut qu'il ait", "It is necessary that he has"),
                new Subject("subjunctive#3f", "Il faut qu'elle ait", "It is necessary that she has"),
                new Subject("subjunctive#4", "Il faut que nous ayons", "It is necessary that we have"),
                new Subject("subjunctive#5", "Il faut que vous ayez", "It is necessary that you have"),
                new Subject("subjunctive#6m", "Il faut qu'ils aient", "It is necessary that they have"),
                new Subject("subjunctive#6f", "Il faut qu'elles aient", "It is necessary that they(f) have")));
    }

    @Override
    public String getResultsSource()
    {
        return "partative";
    }
    
    private static final class Subject
    {
        public final String name, french, english;

        private Subject(String name, String french, String english)
        {
            if ((this.name = name) == null)
                throw new NullPointerException("name");
            if ((this.french = french) == null)
                throw new NullPointerException("french");
            if ((this.english = english) == null)
                throw new NullPointerException("english");
        }
    }
}