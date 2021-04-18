package fr.gen;
import fr.*;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;

/* package */ abstract class NounQuestionSupport implements FixedQuestionGenerator
{
    protected final ScoreFileBuilder scores;
    
    protected final SortingPolicy sortPolicy;

    protected final Wordlist wordlist;
    
    protected final Predicate<Noun> filter;
    
    public NounQuestionSupport(ScoreFileBuilder scores, SortingPolicy sortPolicy, Wordlist wordlist, Predicate<Noun> filter) {
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
        return "nouns";
    }
    
    @Override
    public final List<Question> generate(int size, List<Question> out)
    {
        List<Noun> nouns = scores.open(this).map(wordlist.nouns(filter), sortPolicy, size, new ScoreFile.Mapper<Noun>()
        {
            @Override
            public String key(Noun obj)
            {
                return obj.getName();
            }

            @Override
            public boolean weighted(Noun obj)
            {
                return obj.isTag(NounTag.STARRED);
            }
        });
        nouns.stream().forEach(noun -> out.add(generate(noun)));
        return out;
    }
    
    protected abstract Question generate(Noun noun);
    
    @Override
    public final String toString()
    {
        return String.valueOf(filter);
    }
}
