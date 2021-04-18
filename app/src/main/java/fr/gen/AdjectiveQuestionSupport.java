package fr.gen;
import fr.*;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;

/* package */ abstract class AdjectiveQuestionSupport implements FixedQuestionGenerator
{
    protected final ScoreFileBuilder scores;
    
    protected final SortingPolicy sortPolicy;

    protected final Wordlist wordlist;
    
    protected final Predicate<Adjective> filter;
    
    public AdjectiveQuestionSupport(ScoreFileBuilder scores, SortingPolicy sortPolicy, Wordlist wordlist, Predicate<Adjective> filter) {
        if ((this.scores = scores) == null)
            throw new NullPointerException("scores");
        if ((this.wordlist = wordlist) == null)
            throw new NullPointerException("wordlist");
        this.sortPolicy = sortPolicy;
        this.filter = filter;
    }

    @Override
    public String getResultsSource()
    {
        return "adjectives";
    }
    
    @Override
    public final List<Question> generate(int size, List<Question> out)
    {
        return out;
    }
    
    protected abstract Question generate(Adjective noun);
    
    @Override
    public final String toString()
    {
        return String.valueOf(filter);
    }
}
