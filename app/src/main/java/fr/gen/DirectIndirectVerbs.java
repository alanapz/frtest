package fr.gen;
import apz.fr.utils.*;
import fr.*;
import fr.lang.*;
import java.util.*;

public final class DirectIndirectVerbs implements QuestionGenerator
{
    private static final CircularProducer<Phrase> phrases = new CircularProducer<>(); 
    
    private static final WeightedProducer<Voice> voiceMap = new WeightedProducer<Voice>().add(Voice.IL).add(Voice.ILS).add(Voice.ELLE).add(Voice.ELLES);
    
    public DirectIndirectVerbs()
    {
    }

    @Override
    public List<Question> generate(int size, List<Question> questions) {
        for (Phrase phrase: phrases.next(new Phrase[size])) {
            final Pronoun pronoun = Pronoun.get(voiceMap.next());
            questions.add(new TextQuestion(this,
                    phrase.translation + " - " + pronoun.enObject,
                    (phrase.preposition == Preposition.NONE)
                    ? phrase.infinitive + " - " + pronoun.frDirect
                    : phrase.infinitive + " " + phrase.preposition.value + " - " + pronoun.frIndirect));
        }
        return questions;
    }
    
    @Override
    public String toString()
    {
        return "[voice=" + voiceMap + "]";
    }
        
    static
    {
        // assister
        
        direct("aller", "to be going to do something");
        direct("attendre", "to wait for something");
        direct("chercher", "to look for something");
        direct("demander", "to ask for something");
        direct("devoir", "to have to do something");
        direct("dire", "to tell something");
        direct("écouter", "to listen to something");
        direct("essayer", "to try something on");
        direct("espérer", "to hope for something");
        direct("faire", "to do something");
        direct("habiter", "to live in");
        direct("ignorer", "to be unaware of something");
        direct("laisser", "to leave something");
        direct("manquer", "to miss someoneXXX");
        direct("payer", "to pay for something");
        direct("regarder", "to look at something");
         
        to("aider", "to help to do ...");
        to("àrriver", "to manage to ...");
        to("chercher", "to attempt to do ...");
        to("donner", "to give someone something");
        to("écrire", "to write to ...");
        to("dire", "to tell someone");
        to("envoyer", "to send something to someone");
        to("montrer", "to show someone/something");
        to("téléphoner", "to telephone someone");
        to("emprunter", "to borrow from");
        
        of("avoir besoin de", "need ...");
        of("avoir envie de", "desire ...");
        of("avoir peur de", "fear ...");
        of("se souvenir", "to remember someone");
        of("venir", "to have just done something");

        // permettre
        // conseiller
        // aimer
        
    }
    
    private static void direct(String infinitive, String translation)
    {
        phrases.add(new Phrase(Preposition.NONE, infinitive, translation));
    }
    
    private static void to(String infinitive, String translation)
    {
        phrases.add(new Phrase(Preposition.A, infinitive, translation));
    }

     private static void of(String infinitive, String translation)
    {
        phrases.add(new Phrase(Preposition.DE, infinitive, translation));
    }

    private enum Preposition
    {
        NONE(""),
        A("à"),
        DE("de");
        
        private final String value;
        
        Preposition(String value)
        {
            this.value = value;
        }
    }
    
    private static final class Phrase
    {
        private final Preposition preposition;

        private final String infinitive;

        private final String translation;
        
        private Phrase(Preposition preposition, String infinitive, String translation)
        {
            this.preposition = preposition;
            this.infinitive = infinitive;
            this.translation = translation;
        }
    }
}