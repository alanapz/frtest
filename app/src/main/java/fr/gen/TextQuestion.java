package fr.gen;

/* package */ class TextQuestion implements Question
{
    private final String id;
    
    private final QuestionGenerator source;
    
    private final String question, answer;

    private static final long serialVersionUID = 1L;
    
    /* package */ TextQuestion(QuestionGenerator source, String question, String answer)
    {
        this(source, null, question, answer);
    }
    
    /* package */ TextQuestion(QuestionGenerator source, String id, String question, String answer)
    {
        if ((this.source = source) == null)
            throw new NullPointerException("source");
        if ((this.question = question) == null)
            throw new NullPointerException("question");
        if ((this.answer = answer) == null)
            throw new NullPointerException("answer");
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
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
    
    @Override
    public String toString()
    {
        return question + "=" + answer;
    }
}
