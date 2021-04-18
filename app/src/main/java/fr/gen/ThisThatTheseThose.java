package fr.gen;
import apz.fr.utils.Utils;
import fr.Noun;
import fr.Wordlist;
import java.util.*;

public final class ThisThatTheseThose implements QuestionGenerator
{
    private final Wordlist wordlist;
    
    private static final Map<Type, Definition> definitions = new HashMap<>();
    
    private enum Type { THIS, THAT };
    
    public ThisThatTheseThose(Wordlist wordlist)
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
        
        private final Definition definition = definitions.get(Utils.random(Type.class));
        
        private static final long serialVersionUID = 1L;
        
        private QuestionImpl(Noun noun)
        {
            this.noun = noun;
        }
        
        @Override
        public String getQuestion()
        {
            return definition.english(noun) + " (" + noun.getTranslation() + ")";
        }

        @Override
        public String getAnswer()
        {
            return definition.french(noun);
        }

        @Override
        public QuestionGenerator getSource()
        {
            return null;
        }

        @Override
        public String getId() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }

    private static final class Definition
    {
        private final String enSingle, enPlural, frMascSingle, frMascPlural, frFemSingle, frFemPlural;
        
        private Definition(String enSingle, String enPlural, String frMascSingle, String frMascPlural, String frFemSingle, String frFemPlural)
        {
            this.enSingle = enSingle;
            this.enPlural = enPlural;
            this.frMascSingle = frMascSingle;
            this.frMascPlural = frMascPlural;
            this.frFemSingle = frFemSingle;
            this.frFemPlural = frFemPlural;
        }
        
        public String english(Noun noun)
        {
            return noun.isPlural() ? enPlural : enSingle;
        }

        public String french(Noun noun)
        {
            return noun.getGender().select(frMascSingle, frFemSingle, frMascPlural, frFemPlural);
        }
    }
    
    static
    {
        definitions.put(Type.THIS, new Definition("This one", "These ones", "Celui-ci", "Ceux-ci", "Celle-ci", "Celles-ci"));
        definitions.put(Type.THAT, new Definition("That one", "Those ones", "Celui-là", "Ceux-là", "Celle-là", "Celles-là"));
    }
}
