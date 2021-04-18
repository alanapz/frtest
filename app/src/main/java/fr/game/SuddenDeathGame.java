package fr.game;
import apz.fr.utils.*;
import fr.Result;
import fr.gen.*;
import java.util.*;

public final class SuddenDeathGame
{
    private int lives;

    private final List<Question> questions;

    public SuddenDeathGame(List<Question> questions, int lives)
    {
        if ((this.questions = questions) == null)
            throw new NullPointerException("questions");
        if ((this.lives = lives) == 0)
            throw new IllegalArgumentException("lives");
        Collections.shuffle(questions);
    }
    
    public Result go()
    {
        final SuddenDeathResult result = new SuddenDeathResult();
        Swing.message(Swing.Type.INFO, null, "Press any key to continue");
        while(!questions.isEmpty())
        {
            final String title = questions.size() + " remaining " + result.wrong.size() + " faults";
            Question current = Utils.popFirst(questions);
            String answer = Swing.input(Swing.Type.INFO, title, current.getQuestion());
            // Skip null
            if (answer == null || (answer = answer.trim()).isEmpty())
            {
                questions.add(current);
                continue;
            }
            if (current.checkAnswer(answer))
            {
                Swing.message(Swing.Type.INFO, "Correct", "Correct");
                result.correct.add(current);
            }
            else
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
                                result.wrong.add(current);
                            }

                            @Override
                            public void no()
                            {
                                System.out.println("FLAGGED: " + current);
                                while(questions.remove(current)){};
                            }

                            @Override
                            public void cancel()
                            {
                                questions.add(current);
                            }
                        });
                if (result.wrong.size() > lives)
                {
                    break;
                }
            }
        }
        return result;
    }
    
    public static final class SuddenDeathResult implements Result
    {
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
    }
}
