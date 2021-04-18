package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class AmeliorerSonFrancaisPhrases extends AutoSentenceGenerator
{
    public AmeliorerSonFrancaisPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    // http://ameliorersonfrancais.com/grammaire/verbes/accords-participes-passes-base/
    // Accorder les participes passés, règles de base
    public void accords_participes_passes_base()
    {
        push(AGREEMENT, () ->
        {
            //add("Les culottes du roi Dagobert ont été lavées par le bon saint Eloi", "The breeches of King Dagobert were being washed by the good saint Eloi");
            add("Les assiettes que j'ai rangées ont appartenu à ma grand-mère", "The plates that I tidied belonged to my grand-mother");
        });
    }
    
    // http://ameliorersonfrancais.com/grammaire/verbes/accord-participes-passes-cas-particuliers/
    // Accorder les participes passés, cas particuliers
    public void accord_participes_passes_cas_particuliers()
    {
        push(AGREEMENT, () ->
        {
            add("Les enfants que j'ai vus patiner sont allés se réchauffer", "The children that I saw skating went to warm-up");
            // J'ai acheté des couches et j'en ai rangé dans l'armoire.
            // add("Passer ma vie sans vous, je ne l'ai pas cru possible", "Spending my life without you, I didn't believe it was possible");
            // J'ai acheté des couches et j'en ai rangé dans l'armoire.
            add("Elle s'est coiffée avant de sortir", "She did her hair before exiting", PRONOMINAL);
            add("à l'arrivée du recteur, les étudiantes se sont assises", "At the arrival of the rector, the students(f) sat down");
            //    Soudainement, il a |plu (pleuvoir) d'énormes gouttes glacées.
            add("Les maisons que nous avons fait construire sont presque toutes vendues", "The houses that we have made constructed are nearly all sold", FAIRE);
            //    Les deux félins se sont jaugées (jauger) avant de s'élancer.
            //    J'ai récolté des belles pommes et j'en ai ________ (faire) de succulentes tartes.
            //    La multitude d'oiseaux que j'ai ________(voir) s'envoler l'automne dernier.
        });
    }
    
    // http://ameliorersonfrancais.com/grammaire/verbes/trouver-cd-ci/
    // Complément (d'objet) direct et indirect, comment les trouver?
    public void trouver_cd_ci()
    {
        add("Le félin a croqué la souris qui le narguait depuis longtemps", "The feline crunched the mouse that was taunting him for ages");
        add("Paul a épousé Julie la semaine dernière", "Paul married Julie last week");
        add("Ce jus de pommes, je l'ai bu avidement", "This apple juice, I eagerly drank it");
        add("Ce jeune homme aspire à une vie rangée", "This young man longs for a tidy life");
        // add("Paul a demandé à Julie de l'épouser", "Paul asked Julie to marry him");
        // Julien a commandé une nouvelle toile à un artiste renommé.
        add("Pierre a aidé Solange à construire une remise", "Pierre helped Solange build a shed");
        add("Ils ont perdu malgré de grands sacrifices", "They lost despite some big sacrifices", DE);
        add("Le vieux mage a révélé ses secrets dans un livre crypté", "The old mage revealed his secrets in a encrypted book");
        add("Chaque printemps, je rêve de retourner en Europe", "Each spring, I dream of returning to Europe");
    }
}