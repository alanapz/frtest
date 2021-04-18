package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;
import static fr.gen.MiscVocabulary.Preposition.PHYSICAL;

/* package */ final class AdditionalPhrases extends AutoSentenceGenerator
{
    private static final long serialVersionUID = 3L;
    
    public AdditionalPhrases(ScoreFileBuilder scoreFile, SortingPolicy sortPolicy)
    { 
        super(scoreFile, sortPolicy);
    }

    protected void setupX()
    {
        // abimer
        add("Le muscle s'abime en trop travaillant", "The muscle deteriorates by working too much", PARTICIPLE);
        
        // confier
        add("Il confie son secret à son ami", "He confides his secret to his friend");


 
////
////        Il y a eu un changement.
////
////            There has been a change.
//
//
//                    //J'attends l'échéance de mon bon - I'm waiting for my bond's maturity date.
////
////Quelle est l'échéance de cette facture ? - What is this bill's due date?
        
    }
    
    public void Accabler()
    {
        add("accabler", "(v.) to overwhelm");
    }
    
    public void Accéder()
    {
        add("accéder", "(v.) to grant (permission)", "(v.) to gain access");
        // add("Ce programme de construction permettra à de nombreuses familles d'accéder à la propriété", "This construction program will allow numerou fama")
    }
    
    public void Affligeant()
    {
        add("J'ai dû prendre une décision affligeante", "I had to make a distressing decision");
        // add("Nous avons été bouleversés par la nouvelle affligeante de sa mort", "We were shattered by the overwhelming news of his death");
    }

    public void Affoler()
    {
        add("affoler", "(v.) to drive crazy");
        add("Cette femme l'a affolé", "That lady drove-him-crazy");
        add("Il est affolé de sa femme", "He is mad-about his wife");
    }
    
    public void Anéantir()
    {
        //add("anéantir", "(v.) to wipe out", "(v.) to annihilate");
        //add("L'armée a anéanti trois villes en quinze jours - The army wiped out three towns in two weeks
        //add("Trop de chaleur m'anéantit - Too much heat overwhelms me
        //add("Il a été anéanti par le chagrin", "He was overcome/wiped-out with grief");
    }
    
    public void Attendre()
    {
        add("attendre", "(v.) to wait for", "(v.) to await");
        add("s'attendre", "(v.) to expect");
        add("Je ne m'attendais pas à autant de monde", "I wasn't expecting so many people");
        add("J'attends mon cousin à la gare", "I am waiting for my cousin at the station");
        add("On s'attendait mieux de toi", "I/we were expecting better from you(tu)");
        add("Parce que les gens s'attendent ça de moi", "Because people expect that of me");
        add("Je ne m'attendais pas à un cadeau", "I wasn't expecting a present");
        add("Attendez, il me vient une idée", "Wait, an idea is coming to me");
        // à ou not ? add("Je m'attendais à mieux venant de toi");
    }
    
    public void Atteindre()
    {
        add("atteindre", "(v.) to attain", "(v.) to reach (goal)", "(v.) to catch up to (target)");
        add("atteint", "(v.pp) atteindre");
        // Il a manqué d'adresse, il n'a pas atteint le but.
        add("Cet arbre n'a pas atteint la même hauteur que l'autre", "This tree did not reach the same height as the other one");
        add("L'incendie avait déjà atteint les étages supérieurs", "The fire had already reached the upper floors");
        add("Ce chien n'a pas pu atteindre le lièvre", "That dog couldn't catch up to the hare");
        // Il atteindra bientôt sa douzième année.
        // Atteindre l'âge de raison.
        add("Avec ces provisions, ils peuvent atteindre la fin du mois", "With those provisions, they can reach the end of the month");
        add("Tôt ou tard la peine atteint les coupables", "Sooner or later the punishment catches up to the guilt(ies)");
    }

    public void Balancer()
    {
        add("balancer", "(v.) to swing", "(v.) to toss away/discard");
        add("Il l'a balancé à la police", "He denounced her to the police");
    }

    public void CaAlors()
    {
        //  add("ça alors ! Je n'aurais jamais imaginé un produit pareil", "My goodness! I'd never have imagined such a product");
        //      add("J'ai invité Thomas à déjeuner, mais il prétend être débordé de travail", "I invited Thomas to lunch, but he claims to be snowed under with work");
    }
    
    public void Craindre()
    {
        add("craindre", "(v.) to fear");
        add("Les autorités craignent plus de 10 morts", "The authorities fear more than 10 deaths");
    }        
    
    public void Conduire()
    {
        add("Il conduit la voiture", "He is driving the car");
        add("Les enfants se conduisent mal", "The children are behaving badly", PRONOMINAL);
    }

    public void Dérouler()
    {
        add("dérouler", "(v.) to unroll");
        add("se dérouler", "(v.) to unfold (events)");
        add("Leur procession par les rues se déroule avec la lenteur habituelle", "Their procession though the roads unfolds with the habitual slowness");
    }
    
    public void Désormais()
    {
        add("désormais", "from now on", "henceforth");
        add("Désormais, c'est pour la vie", "From now on, it's for life");
    }
    
    public void Détournement()
    {
        add("détourner", "(v.) to divert", "(v.) reroute", "(v.) to hijack");
        add("Le détournement des profits doit être arrêté", "The diversion of profits must be stopped");
        add("Il y a eu un détournement d'avion hier", "There has been a plane hijacking yesterday");
    }
    
    public void FaireLaTete()
    {
        add("Pourquoi est-ce que tu fais la tête ?", "Why [is it that] are you(tu) sulking?");
        add("Ne fais pas la tête !", "(tu) Don't sulk!");
        add("Frank fait toujours la tête à propos de ta décision", "Frank is still sulking about your(tu) decision");
    }
    
    public void Foutre()
    {
        add("Qu'est-ce qu'elles foutent ?", "What the f*ck are they(f) doing?");
        add("Fous-moi la paix !", "Give me a f*cking break !");
        add("Fous-le dans ton sac", "Bung it in your(tu) bag");
        add("Est-ce que vous vous foutez de ma soeur ?", "Are you taking the p*ss out of my sister?");
        //add("Se foutraient-ils de sa gueule ?", "Would they take the piss out of him ?");
        add("Nous nous en foutons", "We don't give a f*ck about it");
        add("Il m'a foutue toute la nuit", "He f*cked me all night long");
        add("Va te faire foutre !", "F*ck off!");
    }
    
    public void Forcement()
    {
        add("forcément", "inevitably", "necessarily");
        add("Tu n'as pas forcément raison", "You(tu) aren't necessarily correct");
        add("Cela devait forcément arriver", "*That* was bound to happen (expr.)");
    }

    public void Intéresser()
    {
        // add("Je ne sais pas quoi faire pour l'intéresser", "I don't know what to do to interest him");
        add("Tu pourrais t'intéresser à autre chose qu'aux voitures !", "You(tu) could be interested in other things than cars!");
    }
    
    public void Mal()
    {
        add("J'ai du mal à m'imaginer cela", "I have trouble imagining *that*");
        // add("J'ai mal à la tête", "I've got a headache"); -- CHECK: 
        add("Nous devons réagir contre les maux du tabac", "We must react against the evils of tobacco");
    }

    public void Moment()
    {
        // add("Ça fait un moment que je l'attends", "I've been waiting for him for a while");
    }

    public void Néanmoins()
    {
        add("néanmoins", "nevertheless");
        add("J'ai peur, mais je vais néanmoins le faire", "I'm afraid, but I am nevertheless going to do it");
        add("Il est impatient mais néanmoins gentil", "He is impatient but nevertheless kind");
        add("Il n'est qu'un enfant et néanmoins il est déjà très raisonnable", "He is only a child and nevertheless he is already very reasonable");
        add("Il lui avait promis fermement de l'aider, néanmoins il ne l'a pas fait", "He had promised her firmly to help her, nevertheless he didn't do it");
    }

    public void Parages()
    {
        add("Habitez-vous dans les parages ?", "(Do) you live in the area?");
        add("Je cherche une épicerie dans les parages", "I'm looking for a grocery store in the area"); 
    }
    
    public void Peu()
    {
        add("Peu de gens sont d'accord", "Few people agree");
        add("Je te donne le peu d'argent que j'ai", "I give you(tu) the little money I have", DE);
        add("Je n'aime pas beaucoup ce café mais j'en ai bu un peu", "I don't like this coffee very much but I drank a little of it");
    }
    
    public void Poser()
    {
        add("poser", "(v.) to stop carrying", "(v.) to put down", "(v.) to ask a question");
        add("Il a posé son livre sur la table", "He put his book down on the table");
        add("Vous pouvez poser des questions après la présentation", "You can ask questions after the presentation");
    }
    
    public void Prochain()
    {
        add2("la prochaine semaine - la semaine prochaine", "the following week - next week");
    }
    
    public void Redouter()
    {
        add("redouter", "(v.) to dread");
        //add("Je redoute de le faire", "I dread doing it");
        add("Je redoute qu'il le fasse", "I dread his doing it", SUBJUNCTIVE);
    }

    public void Repère()
    {
        add("repèrer", "(v.) to scout out/survey");
    }
    
    public void Résoudre()
    {
        add2("résoudre - résolu", "(v.) to solve - (v.pp) to solve");
    }
    
    public void Sens()
    {
        add("sens devant derrière", "back-to-front", PHYSICAL);
        add("sens dessus dessous", "upside-down", PHYSICAL);
    }
    
    public void Taquiner()
    {
        add("taquiner", "(v.) to tease");
        add("Marie me taquine constamment", "Marie teases me constantly");
    }
    
    public void Tiquer()
    {
        add("tiquer", "(v.) to bat an eyelid", "(v.) to pull a face");
        //Les résultats m'ont presque fait tiquer. - The results almost made me make a face.
        add("Il n'a pas tiqué quand j'ai mentionné notre rendez-vous", "He didn't bat an eyelid when I mentioned our appointment");
    }
    
    public void Vieux()
    {
        add("La grand-mère est tellement vieille", "The grand-mother is really old");
        add("Je suis le plus vieux de ma classe", "I'm the oldest in my class");
        add("Un vieil homme, une vieille femme", "An old man, an old lady");
        add("Ce mot est vieux : Il a cessé d'être en usage", "This word is old: It is has ceased being in usage");
        add("Il n'a que vingt ans, vous êtes plus vieux que lui", "He's only twenty, you are older than him");
        addCompound(
                "Il n'est pas si vieux que vous - Il n'est pas aussi vieux que vous",
                "He's not so old as you - He's not as old as you");
    }

    public void Violence()
    {
        //add("la violence au volant", "road-rage");
    }
}