package fr.gen;
import java.util.*;

public interface QuestionGenerator
{
    public List<Question> generate(int size, List<Question> out);
}