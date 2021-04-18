package fr.game;
import apz.fr.utils.*;
import fr.Result;
import fr.gen.*;
import java.util.*;

public final class PaneGame2
{
    private final int threshold;

    private final List<Entry> questions;

    private Entry current;
    
    private long startTime;
    
    private final ResultImpl results = new ResultImpl();
    
    public PaneGame2(List<Question> questions, int threshold)
    {
        this.questions = buildEntries(questions);
        this.threshold = threshold;
    }
    
    public Result go()
    {
        Swing.message(Swing.Type.INFO, null, "Press any key to continue");
        while((current = Utils.popFirst(questions)) != null)
        {
            this.startTime = System.currentTimeMillis();
            final String title = (questions.size() + 1) + " remaining " + results.faults + " faults";
            String answer = Swing.input(Swing.Type.INFO, title, current.getQuestion());
            // Skip null
            if (answer == null || (answer = answer.trim()).isEmpty())
            {
                questions.add(current);
                continue;
            }
            Boolean status = current.calculate(answer);
            if (status == null)
            {
                Swing.message(Swing.Type.WARN, title, "Too Slow !");
                questions.add(current);
            }
            else if (status == Boolean.FALSE)
            {
                Swing.yesNoCancel(Swing.Type.ERROR,
                        current.getQuestion()
                        + " => |" + current.getAnswer()
                        + "|\n\n" + answer.toLowerCase() + "\n"
                        + Utils.strcmp(current.getAnswer(), answer), new Swing.YesNoCancel()
                        {
                            @Override
                            public void yes()
                            {
                                results.wrong(current);
                            }

                            @Override
                            public void no()
                            {
                                System.out.println("FLAGGED: " + current.question);
                                while(questions.remove(current)){};
                            }

                            @Override
                            public void cancel()
                            {
                                questions.add(current);
                            }
                        });
            }
            else
            {
                results.correct(current);
                Swing.message(Swing.Type.INFO, "Correct", "Correct");
            }
        }
        return results;
    }
    
    private List<Entry> buildEntries(List<Question> questions)
    {
        List<Entry> list = new ArrayList<>();
        for(Question question: questions)
        {
            list.add(new Entry(question));
        }
        return Utils.shuffle(list);
    }
    
    private final class Entry
    {
        private final Question question;
        
        private Entry(Question question)
        {
            this.question = question;
        }
        
        public String getQuestion()
        {
            return question.getQuestion();
        }
        
        public String getAnswer()
        {
            return question.getAnswer();
        }

        public Boolean calculate(String answer)
        {
            boolean correct = checkAnswer(answer);
            if (!correct)
            {
                return false;
            }
            if (threshold == 0 || System.currentTimeMillis() - startTime <= threshold * 1000)
            {
                return true;
            }
            else
            {
                return null;
            }
        }
        
        private boolean checkAnswer(String answer)
        {
            return question.checkAnswer(answer);
        }
        
        @Override
        public String toString()
        {
            return question.toString();
        }
    }
    
    private final class ResultImpl implements Result
    {
        private int faults;
        
        private final Set<Question> correct = new HashSet<>();
        
        private final Set<Question> wrong = new HashSet<>();

        private static final long serialVersionUID = 1L;
        
        @Override
        public int getScore()
        {
            return correct.size();
        }
        
        @Override
        public Set<Question> getCorrect()
        {
            return correct;
        }

        @Override
        public Set<Question> getWrong()
        {
            return wrong;
        }
        
        private void correct(Entry entry)
        {
            if (!wrong.contains(entry.question))
            {
                correct.add(entry.question);
            }
        }

        private void wrong(Entry entry)
        {
            this.faults++;
            wrong.add(entry.question);
            questions.add(current);
        }
    }
}
