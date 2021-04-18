package fr;
import fr.gen.*;
import java.util.*;

public interface Result extends java.io.Serializable
{
    public int getScore();
    
    public Set<Question> getCorrect();
    
    public Set<Question> getWrong();
}
