package fr.gen;
import fr.*;
import java.util.*;
import fr.lang.Pronoun;
import static apz.fr.utils.Utils.*;

public final class ObjectPronouns implements QuestionGenerator
{
    private final Wordlist wordlist;
    
    private static final Set<String> verbs = new HashSet<>();
    
    public ObjectPronouns(Wordlist wordlist)
    {
        this.wordlist = wordlist;
    }

    @Override
    public List<Question> generate(int size, List<Question> questions)
    {
        for(Noun noun: wordlist.nouns().next(new Noun[size], null))
        {
            questions.add(new QuestionImpl(noun, wordlist.lookupVerb(random(verbs))));
        }
        return questions;
    }

    private static final class QuestionImpl implements Question
    {
        private final Noun noun;

        private final Verb verb;

        private final Voice voice = random(Voice.class);
        
        private final Pronoun subject;
        
        private static final long serialVersionUID = 1L;
        
        public QuestionImpl(Noun noun, Verb verb)
        {
            this.noun = noun;
            this.verb = verb;
            this.subject = Pronoun.get(voice);
        }
        
        @Override
        public String getQuestion()
        {
            //return subject.enSubject + " " + verb.translation() + "(s) " + Utils.englishIndefiniteArticle(noun, verb.translation().infinitive()).toLowerCase() + " " + noun.getTranslation();
            return null;
        }
        
        @Override
        public String getAnswer()
        {
            return subject.frSubject + " " + PackageUtils.elide(noun.select("le", "la", "les"), verb.present(VerbPerson.values()[voice.person-1]));
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
    
    static
    {
        verbs.add("voir");
        verbs.add("entendre");
        verbs.add("acheter");
    }
}
