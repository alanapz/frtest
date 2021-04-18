package fr.gen;
import fr.*;
import java.util.*;
import static apz.fr.utils.Utils.*;

public final class PossessiveAdjectives implements QuestionGenerator
{
    private final Wordlist wordlist;
    
    public PossessiveAdjectives(Wordlist wordlist)
    {
        this.wordlist = wordlist;
    }

    @Override
    public List<Question> generate(int size, List<Question> questions)
    {
        for(Noun noun: wordlist.nouns().next(new Noun[size], null))
        {
            questions.add(new QuestionImpl(noun));
        }
        return questions;
    }

    private static final class QuestionImpl implements Question
    {
        private final Noun noun;
        
        private final PackageUtils.Possessive possessive;

        private static final long serialVersionUID = 1L;
        
        public QuestionImpl(Noun noun)
        {
            this.noun = noun;
            this.possessive = PackageUtils.lookupPossessive(random(VerbPerson.class));
            // Contracted, feminine singular words change to masculine
            if (noun.isTag(NounTag.CONTRACTED) && noun.getGender() == WordGender.ELLE)
            {
                //this.allVoices = il;
            }
        }
        
        @Override
        public String getQuestion()
        {
            return possessive.translation + " " + noun.getTranslation();
        }
        
        @Override
        public String getAnswer()
        {
            return possessive.select(noun) + " " + noun.getName();
        }

        @Override
        public QuestionGenerator getSource() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
