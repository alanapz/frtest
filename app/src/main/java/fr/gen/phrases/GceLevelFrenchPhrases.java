package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class GceLevelFrenchPhrases extends AutoSentenceGenerator
{
    public GceLevelFrenchPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    public void PresentSubjunctive()
    {
        push(SUBJUNCTIVE, () ->
        {
            // Page 87
            add("Bien qu'il soit riche, ses chaussures sont usées", "Although he is rich, his shoes are worn out", AGREEMENT);
            add("Je vais te l'expliquer, pour que tu comprennes mieux", "I'm going to explain it to you(tu), so you will understand better");
            add("Avant que je meure, racontez-moi votre vie", "Before I die, tell me your life-story");
            add("à moins que tu me dises la vérité, je ne te parlerai plus", "Unless you(tu) tell me truth, I will not speak to you any more");
            add("Nous voulons que vous ayez un véritable succés", "We want you to have a real success");
            add("Ils ont peur que vous perdiez tout votre argent", "They are scared you will lose all your money");
            add("Il est douteux que nous le sachions d'avance", "It is doubtful that we will know it in advance");
            // Page 88
            add("Il vaut mieux qu'il avoue tout de suite", "It would be better for him to confess straight away", LOCUTION);
            add("Il faut que tu prennes ces comprimés", "You(tu) have to take these tablets");
            add("Il est certain que le gâteau sera brûlé", "It is certain the cake will be burned");
            add("Il est possible que nous les voyions demain", "It is possible we shall see them tomorrow");
            add("Bien qu'ils aient déménagé, nous les rencontrons de temps en temps", "Although they've moved(out), we meet them from time-to-time");
            // Page 89
            add("Quelques jours avant sa morte, nous étions allés au théâtre", "A few days before he died, we had gone to the theatre");
            add("Nous avons couru pour ne pas arriver en retard", "We ran so as to not arrive late");
            add("Il avait peur de tomber dans le lac", "He was scared of falling in the lake");
            add("Il vaut mieux que nous rentrions demain", "It would be better if we went-back-home tomorrow");
            add("Il vaut mieux que tu aies tout préparé avant mon retour", "It would be better if you(tu) prepared everything before my return");
            add("Il vaut mieux qu'il finisse cela d'abord", "It would be better if he finished *that* first");
            add("Il vaut mieux que j'apprenne sérieusement", "It would be better if I learned seriously");
            add("Il vaut mieux que tu n'en boives plus", "It would be better if you(tu) don't drink any more of it", EN);
            //add("Il vaut mieux vous mettiez cet argent de côté", "It would be better if you put that money to the side");
            /// APZ: de cote vs a cote
            addCompound(
                    "Jusqu'à son départ nous avions joué aux cartes ensemble - Jusqu'à ce qu'il parte nous avions joué aux cartes ensemble",
                    "Until his leaving we had played cards together - Up until he leaves we had played cards together");
            // Page 90
            add("Il vaut mieux qu'ils écrivent cette lettre", "It would be better if they write that letter");
            add("Il vaut mieux que tu t'endormes vite", "It would be better if you(tu) quickly went to sleep");
            add("Il vaut mieux que nous partions tout de suite", "It would be better if we left straight away");
            add("Il vaut mieux que je poursuive le criminel", "It would be better if I persue the criminal");
            add("Il vaut mieux que vous soyez rentré avant minuit", "It would be better if you came back home before midnight");
            add("Il est possible qu'il vienne ce soir", "It is possible he'll come this evening");
            add("Ta mère a peur que tu sois malade", "You're(tu) mother is scared you're ill");
            add("J'ai defendu que Jean vous rende visite demain", "I forbade Jean to visit you tomorrow", LOCUTION);
            //add("Il faut que tous travaillent de leur mieux", "Everyone has to work to their best");
            add("Il est heureux qu'on l'ait reconnue à l'aéroport", "It is fortunate I/we recognised her at the airport");
        });
    }
    
    public void ThePassiveVoice()
    {
        push(AGREEMENT, () ->
        {
            // Page 99
            add("Si tu continues à faire cela, tu seras punie", "If you(tu.f) continue doing *that*, you will be punished");
            add("Il faut que les oeufs soient bien battus", "The eggs have to be well beaten");
            add("Ces ouvriers sont employés par son père", "These workers are employed by his father");
            add("Ils ont été attrapés", "They have been caught");
            add("Les jeunes filles seront récompensées par leur professeur", "The young girls will be rewarded by their teacher");
            add("Elle avait été élevée avec beaucoup de soin", "She was raised/brought-up with a lot of care");
            add("Ils ont peur d'être saisis par des agents ennemies", "They are afraid of being seized by enemy agents");
            // Page 100
            add("Nous avons essayé d'y entrer mais la porte était fermée", "We tried to get in (there) but the door was closed", Y);
            add("La porte a été fermée par le gardien il y a cinq minutes", "The door was closed by the guard five minutes ago");
            add("On lui a offert une montre pour noel", "He was offered a watch for christmas");
            // Page 101
            add("On m'a défendu d'y aller", "I was forbidden(défendre) to go there", Y);
            add2("On a coupé les arbres - Les arbres ont été coupés", "(d.) The trees were cut - The trees were cut");
            add2("On vend les timbres ici - Les timbres se vendent ici", "(d.) Stamps are sold here - (expr.) Stamps are sold here");
        });
    }
    
}