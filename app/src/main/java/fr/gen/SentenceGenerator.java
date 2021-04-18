package fr.gen;
import apz.fr.utils.*;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;

import static apz.fr.utils.Utils.*;

public abstract class SentenceGenerator implements FixedQuestionGenerator
{
    protected final ScoreFileBuilder scores;
    
    protected final SortingPolicy sortPolicy;
    
    protected final Predicate<SentenceQuestion> filter;
    
    protected final List<SentenceQuestion> items = new ArrayList<>();

    protected final Set<PhraseTag> stack = new HashSet<>();
    
    public SentenceGenerator(ScoreFileBuilder scores, SortingPolicy sortPolicy, Predicate<SentenceQuestion> filter) {
        if ((this.scores = scores) == null)
            throw new NullPointerException("scores");
        this.sortPolicy = sortPolicy;
        this.filter = filter;
        this.setup();
    }
    
    protected abstract void setup();
    
    @Override
    public final synchronized List<Question> generate(int size, List<Question> out)
    {
        out.addAll(scores.open(this).map(Filters.filter(items, filter), sortPolicy, size));
        return out;
    }
    
    @Override
    public final String toString()
    { 
        StringBuilder buffer = new StringBuilder();
        toString(buffer);
        return buffer.toString();
    }
    
    protected void toString(StringBuilder buffer)
    {
        buffer.append(getClass().getName());
        buffer.append(",policy=").append(sortPolicy);
    }

    protected final void add(String answer, String question, PhraseTag... tags)
    {
        add(answer, of(question), merge(tags));
    }

    protected final void add(String answer, String question1, String question2, PhraseTag... tags)
    {
        add(answer, of(question1, question2), merge(tags));
    }

    protected final void add(String answer, String question1, String question2, String question3, PhraseTag... tags)
    {
        add(answer, of(question1, question2, question3), merge(tags));
    }

    protected final void add(String answer, String[] questions, PhraseTag... tags)
    {
        add(answer, questions, merge(tags));
    }
    
    private void add(String answer, String[] questions, Set<PhraseTag> tags)
    {
        for(String question: questions)
        {
            items.add(new SentenceQuestion(this, question, answer, tags));
        }
    }
    
    protected final void add2(String answer, String question, PhraseTag... tags)
    {
        addCompound(answer, question, tags);
    }

    protected final void addCompound(String answer, String question)
    {
        addCompound(answer, question, new PhraseTag[0]);
    }

    protected final void addCompound(PhraseTag tag, String answer, String question)
    {
        addCompound(answer, question, tag);
    }
    
    private void addCompound(String answer, String question, PhraseTag... tags)
    {
        final String[] arrayA = answer.split(quote(" - "));
        final String[] arrayQ = question.split(quote(" - "));
        if (arrayA.length <= 1 || arrayA.length != arrayQ.length)
        {
            throw new IllegalArgumentException("mismatch between [" + answer + "] and [" + question + "]");
        }
        final Set<PhraseTag> mergedTags = merge(tags);
        items.add(new SentenceQuestion(this, question, answer, mergedTags));
        for(int i=0; i<arrayA.length; i++)
        {
            items.add(new SentenceQuestion(this, arrayQ[i], arrayA[i], mergedTags));
        }
    }
    
    protected final void skip(Object... args) {
        // Do nothing
    }

    protected final void push(final PhraseTag tag, Runnable block)
    {
        stack.add(tag);
        try
        {
            block.run();
        }
        finally
        {
            stack.remove(tag);
        }
    }
    
    protected final void push(final PhraseTag[] tags, Runnable block)
    {
        final Collection<PhraseTag> tagList = Arrays.asList(tags);
        stack.addAll(tagList);
        try
        {
            block.run();
        }
        finally
        {
            stack.removeAll(tagList);
        }
    }
    
    private Set<PhraseTag> merge(PhraseTag[] tags)
    {
        Set<PhraseTag> out = new HashSet<>(stack);
        if (tags != null && tags.length > 0)
        {
            out.addAll(Arrays.asList(tags));
        }
        return out;
    }
}