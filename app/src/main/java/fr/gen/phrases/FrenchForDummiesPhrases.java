package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;

/* package */ final class FrenchForDummiesPhrases extends AutoSentenceGenerator
{
    public FrenchForDummiesPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }

    
    // CHAPTER 5 - Questions
    public void Questions()
    {
        add("Marie est-t-elle prête ?", "Is Marie ready ?", CLITIC);
        add("A-t-on de l'argent ?", "(Do) I/We have any money ?", CLITIC, DE);
        add("Travaille-t-elle ici ?", "(Does) she work here ?", CLITIC);
    }
    
    // CHAPTER 6 - Negatives
    public void Negatives()
    {
        add("Ne viennent-ils pas ?", "(Are) they not coming?", CLITIC);
        add("N'as-tu pas faim ?", "(Are) you(tu) you not hungry?", CLITIC);
        add("Tu as faim, n'est-ce pas ?", "You're(tu) hungry, right?");
        add("Tu ne me l'as pas donné", "You(tu) didn't give |the bike| to me", CLITIC);
        add("Tu ne me l'as pas donnée", "You(tu) didn't give |the television| to me", CLITIC);
        add("Je ne suis pas encore prêt", "I am not ready yet");
        add("Elle ne parle pas français", "She doesn't speak French");
        add("Je ne peux plus travailler", "I can't work any more");
        add("Ne veux-tu pas partir ?", "(Don't) you(tu) want to leave?", CLITIC);
        add("Elle ne le veut pas du tout", "She doesn't want it at all");
        add("Je n'ai qu'un frère", "I only have one brother");
        add("Il n'est pas toujours en retard", "He is not always late");
        add("Vont-ils voyager ensemble ?", "(Are) they going to travel together?");
        add("N'a-t-elle pas une suggestion ?", "(Has) she not a suggestion?", CLITIC);
        add("Ne peut-il pas travailler ?", "Can he not work?", CLITIC);
        add("Je n'aime pas du tout danser", "I don't like dancing at all");
        add("Il ne va jamais arriver !", "He is never going to arrive!");
    }
    
    // CHAPTER 7 - To Be
    public void ToBe()
    {
        push(PARTICIPLE, () ->
        {
            add("écrire est difficile", "Writing is difficult");
            add("Vous pouvez demander au directeur", "You can ask the manager");
            add("Nous mangions en nous habillant", "We were eating while getting dressed");
            add("Je l'ai fait en rêvant de mes vacances", "I did it while dreaming of my holidays");
            add("En me levant, j'ai vu les fleurs", "Upon getting up, I saw the flowers");
            add("En me brossant les dents, j'ai avalé du dentifrice", "While brushing my teeth, I swallowed some toothpaste");
            add("J'ai vu une fille, lisant le journal", "I saw a girl, reading the paper");
            add("I saw a girl, reading the paper", "J'ai vu une fille, lisant le journal");
            add("J'ai vu une fille, en lisant le journal", "I saw a girl, while reading the paper");
            add("I saw a girl, while reading the paper", "J'ai vu une fille, en lisant le journal");
            add("En quittant le bâtiment, j'ai vu mon frère", "As I left the building, I saw my brother");
            add("En utilisant l'ordinateur, on peut gagner du temps", "By using the computer, I/we can save time");
        });
    }
    
    // CHAPTER 8 - The Subjunctive
    public void TheSubjunctive()
    {
        // CHAPTER 8 - The 
        push(SUBJUNCTIVE, () ->
        {
            add("Il veut que nous parlions en français", "He wants us to speak in French");
            add("Il faut que tu finisses avant midi", "You(tu) have to (that) finish before midday");
            add("Penses-tu qu'il vende les fraises ?", "(Do) you(tu) think he sells strawberries?");
            add("Il est bon que vous envoyiez le chèque", "It's good that you're sending the cheque");
            add("Il ne faut pas que vous leviez la main", "(It is not necessary) that you raise your hand");
            add("Penses-tu que je doive partir ?", "(Do) you(tu) think I must leave?");
            add("Elle ne croit pas que je puisse nager", "She doesn't believe that I can swim");
            add("Il faut que tu manges immédiatement", "You(tu) have to(falloir) eat immediately");
            add2("Il est bon que tu le fasses - Il est bon que tu l'aies fait", "It's good that you're(tu) doing it - It is good that you've(tu) done it");
        });
    }
}