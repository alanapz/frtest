package fr.gen;

public interface Question extends java.io.Serializable
{
    public String getId();
    
    public QuestionGenerator getSource();
    
    public String getQuestion();
    
    public String getAnswer();
    
    static final long serialVersionUID = 1L;
    
    public default boolean checkAnswer(String answer)
    {
        return answer != null ? answer.trim().equalsIgnoreCase(getAnswer()) : false;
    }
}