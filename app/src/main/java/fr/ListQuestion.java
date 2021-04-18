package fr;
import java.util.*;

public final class ListQuestion implements java.io.Serializable
{
    private final String question;
    
    private final String answers[];
    
    private int index = -1;
    
    private static final long serialVersionUID = 1L;

    public ListQuestion(String question, List<String> answers)
    {
        this.question = question;
        this.answers = answers.toArray(new String[answers.size()]);
    }

    public synchronized String getQuestion()
    {
        return question;
    }
    
    public synchronized boolean advance()
    {
        return ++index == answers.length;
    }
    
    public synchronized boolean checkAnswer(String answer)
    {
        return answer != null ? answer.trim().equalsIgnoreCase(answers[index]) : false;
    }

    public synchronized String getAnswer()
    {
        return answers[index];
    }
    
    public synchronized int size()
    {
        return answers.length;
    }
}
