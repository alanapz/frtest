package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class BertrandBoutinPhrases extends AutoSentenceGenerator
{
    public BertrandBoutinPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    // http://www.bertrandboutin.ca/Exercices_grammaire/Voix_active_passive_pronominale.htm
    // Voix active, passive et pronominale
    public void Voix_active_passive_pronominale()
    {
        add("Le lait a été bu par le chat - Le chat a bu le lait",  "(passive) The cat drank the milk - (active) The cat drank the milk");
        add("On n'a pas répondu à ma question", "My question has not been answered");
        add("On lui a donné une récompense", "She was given a reward");
        add("On m'a défendu de manger", "I was forbidden to eat");
        add("On m'a demandé de boire", "I was asked to drink");
        add("Un nouveau gouvernement sera élu ce soir", "A new government will be elected tonight");
        add("La photocopieuse a été endommagée", "The photocopier has been damaged", AGREEMENT);
    }
    
    // http://www.bertrandboutin.ca/Exercices_grammaire/Participe_present_02.htm
    // Répondez à ces questions concernant les formes verbales en –ant.
    public void Participe_present_02()
    {
        push(PARTICIPLE, () ->
        {
            add2("Marie a rencontré Paul en allant au bureau - Marie a rencontré Paul revenant de la ville",
                 "Marie met Paul while going to the office - Marie met Paul coming back from town");
            add("Robert chantait tout en prenant sa douche", "Robert was singing while (simultaneously) taking his shower");
        });
    }
}