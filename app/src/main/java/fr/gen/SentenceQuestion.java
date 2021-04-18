package fr.gen;
import java.util.*;

public final class SentenceQuestion implements Question
{
    private final QuestionGenerator source;

    private final String question;

    private final String answer;

    private final Set<PhraseTag> tags;

    private final StackTraceElement stack = Thread.currentThread().getStackTrace()[4];

    private static final long serialVersionUID = 1L;

    /* package */ SentenceQuestion(QuestionGenerator source, String question, String answer, Set<PhraseTag> tags)
    {
        if ((this.source = source) == null)
            throw new NullPointerException("source");
        if ((this.question = question) == null)
            throw new NullPointerException("question");
        if ((this.answer = answer) == null)
            throw new NullPointerException("answer");
        if ((this.tags = new HashSet<>(tags)) == null)
            throw new NullPointerException("tags");
    }

    @Override
    public String getId()
    {
        return question;
    }

    @Override
    public QuestionGenerator getSource()
    {
        return source;
    }
    
    @Override
    public String getQuestion()
    {
        return question;
    }

    @Override
    public String getAnswer()
    {
        return answer;
    }

    public boolean isTag(PhraseTag tag)
    {
        return tag != null && tag.matches(tags);
    }
    
    public Collection<PhraseTag> getTags()
    {
        return Collections.unmodifiableCollection(tags);
    }

    @Override
    public int hashCode()
    {
        return question.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        return o instanceof SentenceQuestion && question.equals(((SentenceQuestion) o).question) && answer.equals(((SentenceQuestion) o).answer);
    }

    @Override
    public String toString()
    {
        return stack.toString() + " " + question + ":" + answer + " (" + tags + ")";
    }
}