package fr.gen;

public interface FixedQuestionGenerator extends QuestionGenerator {

    default String getResultsSource()
    {
        return null;
    }
}