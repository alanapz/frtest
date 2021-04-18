package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class LeNouvelObservateurPhrases extends AutoSentenceGenerator
{
    public LeNouvelObservateurPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    // http://la-conjugaison.nouvelobs.com/regles/conjugaison/gerondif-present-49.php
    // Règles de français > Conjugaison > Mode gérondif > Gérondif présent
    public void Gérondif_présent()
    {
        push(PARTICIPLE, () ->
        {
            add("Il rêve en marchant", "He dreams while walking");
            add("C'est en travaillant qu'il a réussi", "It's by working that he succeeded");
            //add("C'est en marchant que me viennent mes idées", "It's while walking that ideas come to me");
        });
    }
    
    // http://la-conjugaison.nouvelobs.com/regles/conjugaison/gerondif-passe-50.php
    // Règles de français > Conjugaison > Mode gérondif > Gérondif passé
    public void Gérondif_passé()
    {
        push(PARTICIPLE, () ->
        {
            add("Étant arrivés, nous avons téléphoné à nos amis", "Having arrived, we telephoned our friends");
            add("Ayant vendu notre voiture, nous ne pourrons pas venir", "Having sold our car, we won't be able to come");
        });
    }
}