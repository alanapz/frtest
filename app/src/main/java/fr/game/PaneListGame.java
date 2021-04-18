package fr.game;
import apz.fr.utils.*;
import fr.ListQuestion;
import javax.swing.*;

public final class PaneListGame
{
    private int score;
    
    private ListQuestion current;

    private final ListQuestion question;
    
    public PaneListGame(ListQuestion question)
    {
        this.question = question;
    }
    
    public ResultImpl go()
    {
        JOptionPane.showMessageDialog(null, "Press any key to start !");
        while(!current.advance())
        {
            String title = " (" + score + " points) "  + " remaining";
            String answer = JOptionPane.showInputDialog(null, current.getQuestion(), title, JOptionPane.INFORMATION_MESSAGE);
            if (!current.checkAnswer(answer))
            {
                JOptionPane.showMessageDialog(null, current.getQuestion() + " => " + "\n\nYou entered: " + answer, "Incorrect", JOptionPane.ERROR_MESSAGE);
                score--;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Correct !", title, JOptionPane.INFORMATION_MESSAGE);
            }
        }
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
            return question.size();
        }
    }
}
