package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class FrancaisFacilePhrases extends AutoSentenceGenerator
{
    public FrancaisFacilePhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }

    public void ArticlesIndefinis()
    {
    	addCompound(
                "Sophie mange des légumes - Je ne veux pas de légumes car je ne les aime pas",
                "Sophie eats vegetables - I don't wany any vegetables as I don't like them");
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-48991.php?guide=1
    // test de français n°48991: FLE - De ou Du ? (articles partitifs) - cours
    public void De_ou_Du_Articles_Partatifs()
    {
        push(DE, () ->
        {
            add("Je mange de la pizza", "I'm eating some pizza");
            add("J'aimerais une tasse de café", "I would like a cup of coffee");
            add("Je mangerais du chocolat", "I would eat some chocolate");
            add("Où est ma boite de chocolats ?", "(Where) is my box of chocolates?");
            add("J'écris sur une feuille de papier", "I'm writing on a sheet of paper");
            add("Je voudrais un peu de silence !", "I would want a bit of silence!");
        });
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-47037.php?guide=1
    // Apprendre le français > Cours & exercices de français > test de français n°47037
    public void La_Phrase_Simple_Interrogative()
    {
        add("Parles-tu avec ta maman ?", "(Are) you speaking with your(tu) mum?");
        add("Mangent-ils des fraises ?", "(Are) they eating some strawberries?");
    }

    // http://www.francaisfacile.com/cgi2/myexam/voir2r.php?id=4570
    // test de français n°4570: Passé composé - bases - cours
    public void Passé_Composé_Bases()
    {
        add("J'ai été en forme tout le matin", "I [has been] on form all morning");
        add("Je cherche Mathilde, il parait qu'elle est montée dans sa chambre", "I'm looking for Mathilde, it appears she went up into her bedroom");
        add("Ils ont repeint leur maison en jaune", "They repainted their house in yellow");
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-33328.php?guide=1
    // test de français n°33328: Dialogue : BD : Pronoms personnels sujets - cour
    public void Pronoms_Personnels_Sujets()
    {
        add("Dis-moi, veux-tu encore de la soupe ?", "Tell(tu) me, (do) you want more soup?");
        add("Paul et Lucie, vous devez apprendre à vous taire !", "Paul and Lucie, you must learn to keep quiet!", PRONOMINAL);
        add("Regarde cette photo ! Ils ont l'air tellement heureux !", "Look(tu) at this photo! They have a very happy appearance!");
        add("Avec mes amis, ce soir nous allons au cinéma", "With my friends, this evening we are going to the cinema");
        add("Si tu me dis pourquoi tu as menti, je te pardonnerai", "If you(tu) tell me why you lied, I will forgive you");
        add("Dépêche-toi ! Nous allons être en retard", "(tu) Hurry up! We are going to be late");
        add("Mes frères m'agacent ! Ils cassent tous mes jouets !", "My brothers irritate me! They break all my toys!");
        add("Magalie boude, elle ne veut pas aller chez sa grand-mère", "Magalie sulks, she doesn't want to go to her grand-mothers");
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-3978.php
    // test de français n°3978: Subjonctif passé et expressions courantes
    public void Subjonctif_Passé_et_Expressions_Courantes()
    {
        push(SUBJUNCTIVE, () ->
        {
            add("Il est très content que j'aie corrigé ses erreurs", "He is very satisfied that I corrected his errors");
            add("C'est drôle qu'ils aient dit ça", "It's(ça) funny that they said that");
            add("C'est bien que vous ayez pensé à téléphoner", "It's(ça) good that you thought of telephoning");
            add("Marie, c'est bête que tu ne sois pas allée voir ce film", "Marie, it's silly that you(tu) didn't go see that film");
            add("C'est bizarre qu'il n'ait pas répondu à mon message", "It's(ça) bizarre that he didn't reply to my message");
            add("Je suis très content que vous ayez trouvé un appartement", "I am very satisfied that you found an apartment");
            add("Je regrette qu'elle n'ait pas eu un peu plus de temps", "I regret that she didn't have a little more time");
            add("Les filles, ça me fait plaisir que vous soyez passées nous voir !", "Girls, that makes me pleased that you passed by to see us!");
            add("Dommage que tu aies perdu tes clés", "Shame you(tu) lost your keys");
            add("ça m'ennuie que vous ayez pu penser une chose pareille", "It's(ça) boring to me that you could have thought such a thing");
            add("ça m'énerve que les gens aient cru cette histoire", "It(ça) annoys me that people believed this story");
            add("C'est dommage qu'ils ne soient pas venus hier", "It's(ça) a shame that they didn't come yesterday");
            add("C'est bête qu'elle n'ait pas su répondre à toutes les questions", "It's(ça) silly that she didn't know how to reply to all the questions");
            add("C'est bien qu'elle soit venue", "It's(ça) good/as-well that she came");
            add("Il ne comprend pas que nous ayons pris le train au lieu de prendre l'avion", "It doesn't understand that we took the train instead of taking the plane");
        });
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-48720.php?guide=1
    // FLE - Ma journée d'hier (Imparfait) - cours
    public void Verbes_Actions_à_Imparfait()
    {
        add("Nous nous habillions chaudement - Ils mangeaient des pommes", "We were dressing warmly - They were eating apples");
        add("Tu te couchais trop tard - Il dormait dans sa chambre", "You(tu) were getting to bed too late - He was sleeping in his room");
    }
    
    // http://www.francaisfacile.com/exercices/exercice-francais-2/exercice-francais-48741.php?guide=1
    // test de français n°48741: FLE - Être et Avoir à l'impératif - cours
    public void Être_et_Avoir_à_Impératif()
    {
        add("Sois courageux", "Be brave(tu)");
        add("Ayons la fierté de notre travail", "Let's have pride in our work");
        add("Ayez de la patience avec votre chien", "Have patience with your dog");
//        add("Soyez forts pour faire cet exercice.
        add("Aie de bons résultats à l'école", "Have(tu) good results at school");
        add("Soyons gentils avec le chien", "Let's be gentle with the dog");
  //  Aie de la patience avec ton chat.	Ayons  de bons résultats.	Ayez  confiance en vos parents
    }
}