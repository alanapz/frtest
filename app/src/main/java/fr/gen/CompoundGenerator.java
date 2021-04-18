package fr.gen;
import apz.fr.utils.*;
import java.util.*;

public final class CompoundGenerator implements QuestionGenerator
{
    private final WeightedProducer<QuestionGenerator> generators = new WeightedProducer<>();

    public CompoundGenerator add(QuestionGenerator generator) {
        generators.add(generator);
        return this;
    }

    @Override
    public List<Question> generate(int size, List<Question> out)
    {
        CountedList<QuestionGenerator> entries = new CountedList<>();
        while (--size >= 0) {
            entries.increment(generators.next());
        }
        for (Map.Entry<QuestionGenerator, Integer> entry: entries.entries()) {
            for(Question question: entry.getKey().generate(entry.getValue(), new ArrayList<>())) {
                out.add(new QuestionImpl(question));
            }
        }
        return out;
    }
    
    @Override
    public String toString()
    {
        return generators.toString();
    }
    
    private static final class QuestionImpl implements Question
    {
        private final Question question;
        
        private final String tag;

        private static final long serialVersionUID = 1L;
        
        private QuestionImpl(Question question)
        {
            if ((this.question = question) == null)
                throw new NullPointerException("question");
            this.tag = (question.getSource() instanceof TaggedQuestionGenerator)
                        ? ((TaggedQuestionGenerator)question).getTag() : null;
        }
        
        @Override
        public String getId()
        {
            return question.getId();
        }

        @Override
        public QuestionGenerator getSource()
        {
            return question.getSource();
        }
        
        @Override
        public String getQuestion()
        {
            return (tag != null ? "(" + tag + ") " : "") + question.getQuestion();
        }

        @Override
        public String getAnswer()
        {
            return question.getAnswer();
        }
        
        @Override
        public String toString()
        {
            return question.toString();
        }
    }
}