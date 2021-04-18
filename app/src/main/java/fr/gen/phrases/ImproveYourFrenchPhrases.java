package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class ImproveYourFrenchPhrases extends AutoSentenceGenerator
{
    public ImproveYourFrenchPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }

    public void UnitThree()
    {
        add("Autrefois, nous avions un chien", "In the past, we had a dog");
        add("Nous devions faire nos devoirs", "We were having to do our homework");
        add2("J'ai coupé le pain - Tu t'es coupé", "I cut the bread - You(tu) cut yourself", PRONOMINAL);
        add2("Ils se sont rasés - J'ai rasé le client", "They shaved themselves - I shaved the customer", PRONOMINAL);
    }
    
    public void UnitFour()
    {
        add("Les voisins les ont avertis", "The neighbours warned them");
        add("Une vieille femme est venue vous voir", "An old lady came to see you");
        add("passer", "(v.) to sit for (exam/test)");
        add("Il va passer son bac", "He is going to sit his A levels");
        add("Ils passent des heures devant la télé", "They spend hours in front of the TV");
        add("Elle serait partie sans vous", "She would have left without you");
        add("Elles seront parties sans vous", "They(f.) will have left without you");
        add("Ils seront revenus à minuit", "They will have come back at midnight");
        add("Elle a apporté des fleurs à ses amis", "She brought her friends some flowers");
        add("La police lui a permis de partir", "The police allowed him to leave");
        //*** add("Ils se seront perdus dans la forêt", "They will be lost in the forest");
        add("On vous avait dit de faire attention !", "We(one) had told you to be careful!");
    }
    
    public void UnitFive()
    {
        // Activity 9 - Page 108
        {
            add("Ma femme m'a appelé au téléphone", "My wife called me on the telephone");
            add("Ils avaient vendu leur maison", "They had sold their house");
            add("Elles se sont endormies très vite", "They(f.) fell asleep very quickly", PRONOMINAL, AGREEMENT);
            add("Elle aurait été furieuse de me voir", "She would have been furious to see me");
            add("Les garçons se sont salis en jouant dans la vase", "The boys got dirty while playing in the mud", PARTICIPLE, PRONOMINAL, AGREEMENT);
        }

        // Activity 9 - Page 109
        {
            add("Ils se sont lavés dans la rivière", "They washed themselves in the river", PRONOMINAL, AGREEMENT);
            add("Elle a vu l'accident de sa fenêtre", "She saw the accident from her window");
            add("Nous avions oublié notre parapluie", "We had forgotton our umbrella");
            add("J'ai perdu ma montre, et je l'ai cherchée partout", "I lost my watch, and I looked for it everywhere", AGREEMENT);
        }
    }
    
    public void UnitSix()
    {
        // Activity 7 - Page 126
        {
            add("Tu iras jouer quand tu auras fini de manger", "You(tu) will go play when you have finished eating");
            add("Vous m'enverrez un email dès que vous aurez eu des nouvelles", "You will send me an email once you will have some news");
            add("Quand il sera rentré à la maison, je parlerai de cette affaire, avec lui", "When he has come back to the house, I will talk of this matter, with him");
        }

        // Comparatives and Superlatives - Page 139
        {
            add("Les pêches sont plus chères que les poires", "Peaches are more expensive than pears"); 
            add("Je suis aussi calme que vous", "I am as calm as you");
            add("La vie devient de plus en plus stressant", "Life becomes more and more stressful");
            add("Nous le voyons de moins en moins souvent", "We see him less and less often");
        }   
    }
    
    public void UnitSeven()
    {
        // Activity 4 - Page 149
        {
            add("J'aurais voulu te parler", "I would have wanted to talk to you(tu)");
            add("Elle serait venue nous voir", "She would have come seen us");
            add("On aurait dû prévenir la police", "I/we should have warned the police");
        }
        
        // The Three SI - Page 160
        {
            add("S'il te donne un cadeau, tu le remercieras", "If he gives you(tu) a present, you will thank him");
            add("S'il te donnait un cadeau, tu le remercierais", "If he gave you(tu) a present, you would thank him");
            add("S'il t'avait donné un cadeau, tu l'aurais remercié", "If he had given you(tu) a present, you would have thanked him");
        }
        
        // Activity 16 - Page 160
        {
            add("Si les invités arrivent, tu leur offriras l'apéritif", "If the guests arrive, you(tu) will offer them the apéritif");
            add("Si vous êtes d'accord, nous pouvons signer le contrat", "If you agree, we can sign the contract"); 
            add("Si elle avait réussi à son examen, je lui aurais acheté une voiture", "If she had passed her test, I would have bought her a car", CONDITIONAL);
        }
        
        // Activity 17 - Page 162
        {
            add("Il doit être arrivé", "He must have arrived", "It must have happened", AGREEMENT);
            add("Il nous laisse passer", "He is letting us through");
            add("Nous allons faire construire une piscine dans le jardin", "We are going to have a swimming pool built in the garden", FAIRE);
        }
    }
    
    public void Unit8()
    {
        // Activity 12 - Page 186
        {
            add("Quand je rentrerai, il sera en train de laver sa voiture", "When I get back, he will be washing his car");
            add("Quand je suis arrivé, elles étaient en train de finir leur déjeuner", "When I arrived, they(f) were in the process of finishing their lunch", AGREEMENT);
            add("Nous savions qu'il serait en train de décorer sa chambre", "We knew he would be in the process of decorating his room");
        }
    }
    
    public void Unit9()
    {
        // The Subjunctive - Page 188
        push(SUBJUNCTIVE, () ->
        {
            add("Je suis presque certain qu'elle acceptera", "I am almost certain she will accept");
            add("Nous sommes contents qu'ils soient revenus", "We are glad they have returned");
            add("Je ne suis pas sûr que vous ayez fini ce soir", "I am not sure you will have finished this evening");
            add("Je veux que tu aies signé le contrat quand je reviendrai", "I want you(tu) to have signed the contract when I return");
            add("Il faut que vous soyez partis avant son retour", "You(pl) have to have left before his return");
            add2("Il est possible qu'elle téléphone - Il est possible qu'elle ait téléphoné", "She might telephone - She might have telephoned");
            add2("Je crois qu'ils sont partis - Je ne crois pas qu'ils soient partis", "I believe they've left - I don't believe they've left");
            add2("Il est probable qu'ils abandonneront - Il est possible qu'ils abandonnent", "It is likely they will give up - They might give up");
        });
        
        // Activity 1 - Page 192
        push(SUBJUNCTIVE, () ->
        {
            add("Il faut que j'aie payé mes impôts avant demain", "I have to have paid my taxes before tomorrow");
            add("Il est possible qu'il soit rentré à 9 heures", "He might have come back (home) at 9 o'clock");
            add("Elle a peur que nous ayons eu un accident", "She is scared we will have had an accident");
            add2("Je ne crois pas que nous finissions ce soir - Je ne crois pas que nous ayons fini ce soir", "I don't believe we will finish this evening - I don't believe we will have finished this evening");
            add2("Nous doutons qu'ils réussissent à nous persuader - Nous doutons qu'ils aient réussi à nous persuader", "We doubt they will succeed at persuading us - We doubt they have succeeded at persuading us");
            add2("Il n'est pas certain que vous puissiez le convaincre - Il n'est pas certain que vous ayez pu le convaincre", "It's not certain you can convince him - It's not certain you have been able to convince him");
            add2("Nous aimerions qu'elle parte avant midi - Nous aimerions qu'elle soit partie avant midi", "We would like her to leave before midday - We would like her to have left before midday");
        });
        
        // Activity 11 - pagr 204
        {
            add("Ces produits peuvent s'acheter au supermarché", "(refl.) These products can be bought at the supermarket", PRONOMINAL);
            add("Ces produits peuvent être achetés au supermarché", "These products can be bought at the supermarket", AGREEMENT);
        }
        
        // Activity 12 - Page 205
        {
            add("Vous dormiez quand nous sommes rentrés", "You were sleeping when we got back", AGREEMENT);
            add("Nous n'avons pas fait du bruit pour que vous puissiez dormir", "We didn't make any noise so that you could sleep", SUBJUNCTIVE);
            add("Nous n'avons pas fait du bruit afin que vous puissiez dormir", "We didn't make any noise in order so you could sleep", SUBJUNCTIVE);
        }
        
        // Activity 14 - Page 210
        {
            add("J'en viens", "I'm coming from |the supermarket|", EN);
            add("Ils n'y vont pas", "They are not going |to the cinema|", Y);
            add("Nous n'y sommes pas allées", "We(f) didn't go |to Paris|", Y, CLITIC);
            add("J'en viens et j'y retourne", "I come |from Spain| and I'm going back |there|", EN, Y, CLITIC);
        }
    }
}