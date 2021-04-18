package fr.game;
import apz.fr.utils.*;
import fr.gen.*;
import java.util.*;
import javax.swing.*;

public final class PaneGame
{
    private final CountedIterator<Question> questions;

    private final List<Question> corrections = new ArrayList<>();

    private int score;
    
    private Question current;

    public PaneGame(List<Question> questions)
    {
        this.questions = new CountedIterator<>(questions);
    }
    
    public ResultImpl go()
    {
        JOptionPane.showMessageDialog(null, "Press any key to start !");
        while((current = questions.next()) != null)
        {
            long startTime = System.currentTimeMillis();
            String title = questions.index() + "/" + questions.size() + " (" + score + " points) ";
            String answer = JOptionPane.showInputDialog(null, current.getQuestion(), title, JOptionPane.INFORMATION_MESSAGE);
            if (!current.checkAnswer(answer))
            {
                JOptionPane.showMessageDialog(null, current.getQuestion() + " => " + current.getAnswer() + "\n\nYou entered: " + answer, "Incorrect", JOptionPane.ERROR_MESSAGE);
                corrections.add(current);
                corrections.add(current);
                corrections.add(current);
            }
            else if (System.currentTimeMillis() - startTime > 5000)
            {
                JOptionPane.showMessageDialog(null, "Too slow !!", "Incorrect", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correct !", title, JOptionPane.INFORMATION_MESSAGE);
                this.score++;
            }
        }
        Collections.shuffle(corrections);
        return new ResultImpl();
    }

    public class ResultImpl
    {
        public int getScore()
        {
            return score;
        }
        
        public int getMaximum()
        {
            return questions.size();
        }
    }
}
