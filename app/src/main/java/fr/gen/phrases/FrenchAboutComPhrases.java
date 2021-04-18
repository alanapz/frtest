package fr.gen.phrases;
import fr.score.*;
import static apz.fr.utils.Utils.*;
import static fr.gen.MiscVocabulary.*;
import static fr.gen.MiscVocabulary.Preposition.*;

/* package */ final class FrenchAboutComPhrases extends AutoSentenceGenerator
{
    public FrenchAboutComPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    // http://french.about.com/library/weekly/aa030201t.htm
    // French Indefinite Relative Pronouns - Test
    public void aa030201t()
    {
        add("Avez-vous trouvé ce dont vous avez besoin ?", "(Have) you found that which you need?", DONT);
        add("C'est ce qui m'énerve", "It's that which irritates me");
        add("Ce à quoi elle joue, c'est le tennis", "That which she plays, is tennis");
        add("Ce à quoi je pense, c'est la publicité", "That which I'm thinking of, is the advert");
        add("Ce n'est pas ce à quoi j'ai consenti", "It's not that which I consented to");
        add("Ce n'est pas ce dont je me souviens", "It's not that which I remember", DONT);
        add("Ce dont j'ai envie, c'est l'amour", "That which I desire, is love", DONT);
        add("Ce dont elle joue, c'est le violon", "That which she plays, is the violin", DONT);
        add("Elle ne sait pas ce qui va se passer", "She doesn't know what's going to happen");
        add("Sais-tu ce dont il s'agit ?", "(Do) you(tu) know of what it consists of?", DONT);
        skip("Qu'est-ce qui va se passer ?", "What's going to happen?");
        //add("Voici ce que nous allons faire", "This is what we are going to do");
    }
    
    // http://french.about.com/od/grammar/a/advpasttenses.htm
    // Advanced French Past Tenses
    // French verbs that are usually in the imperfect
    private void advpasttenses()
    {
        add("J'aimais danser quand j'étais jeune", "I liked to dance when I was young");
        add("Je n'ai pas aimé le film", "I didn't like the movie");

        //add("Je croyais en Dieu", "I believed in God");
        //add("Je ne t'ai pas cru quand tu as dit", "I didn't believe you(tu) when you said");

        //add("J'espérais gagner", "I hoped (was hoping) to win");
        add("Hier, j'ai espéré que tu viendrais; aujourd'hui, ça m'est égal", "Yesterday, I hoped you(tu) would come; today, it's all the same to me");
        
        //add("J'étais heureux l'année passée", "I was happy last year");
        add("Quand je l'ai vu, j'ai été surpris", "When I saw him, I was surprised");

        add("Je pensais à mon frère", "I was thinking about my brother ....");
        add("J'ai pensé à une bonne histoire", "I thought of a good story");
        
        //add("Il semblait trop parfait", "It seemed too perfect");
        
        add("Je me sentais malade pendant toute la journée", "I felt sick (throughout) all day", TEMPORAL, PRONOMINAL);
        add("J'ai senti une goutte de pluie", "I felt a drop of rain");
        
        add("Je voulais rentrer après le film", "I wanted to go home after the movie");
        add("Tout d'un coup, j'ai voulu partir", "All of a sudden, I wanted to leave");



           
//           avoir - to have
//
//   imperfect - had
//   J'avais de l'argent. - I had some money
//   Je n'avais pas assez de temps. - I didn't have enough time
//   J'avais faim. - I was hungry
//
//   passé composé - had, got, received
//   J'ai eu un accident. - I had / got into an accident
//   J'ai eu une bonne surprise. - I got a nice surprise
//   J'ai eu faim. - I got hungry
//
//
//connaître - to know
//
//   imperfect - knew, was familiar with
//   Je la connaissais bien. - I knew her well
//
//   passé composé - met
//   J'ai connu Michel hier. - I met Michel (for the first time) yesterday
//
//
//devoir - to have to
//
//   imperfect - was supposed to (whether I did or not)
//   Je devais partir à midi. - I was supposed to leave at noon
//
//   passé composé - must have, had to
//   J'ai dû le perdre. - I must have lost it
//   J'ai dû partir à midi. - I had to leave at noon (and did)
//
//
//pouvoir - to be able to
//
//   imperfect - could, was able to (whether I did or not)
//   Je pouvais mentir. - I could lie / was capable of lying
//
//   passé composé - could, was able to, managed to; (negative) couldn't, was unable to
//   J'ai pu mentir. - I was able to lie
//   Je n'ai pas pu mentir. - I couldn't / was unable to lie
//
//
//savoir - to know
//
//   imperfect - knew
//   Je savais l'adresse. - I knew the address
//   Je savais nager. - I knew how to swim
//
//   passé composé - learned, found out
//   J'ai su la solution. - I found out / discovered the solution
//   J'ai su nager. - I learned how to swim
//
//
//vouloir - to want
//
//   imperfect - wanted
//   Je voulais partir. - I wanted to leave
//   Je voulais plus d'argent. - I wanted more money
//
//   passé composé - tried, decided to; (negative) refused
//   J'ai voulu partir. - I tried / decided to leave
//   Je n'ai pas voulu partir. - I refused to leave
//
//
//Verbal constructions
//
//Some verbs have particular constructions which, when referring to the past, are always in the imperfect:
//
//aller + infinitive (near future)
//   J'allais étudier. - I was going to study.
//
//avoir (with age)
//   J'avais 18 ans. - I was 18.
//
//être en train de
//   J'étais en train d'écrire une lettre. - I was writing a letter.
//
//venir de + infinitive (recent past)
//   Je venais d'arriver. - I had just arrived.
    }
    
    // http://french.about.com/od/grammar/a/arriver.htm
    // All about Arriver
    public void arriver()
    {
        add("à quelle heure vont-ils arriver ?", "What time (are) they going to arrive?");
        add("ça m'arrive souvent", "That often happens to me"); 
        add("Cela ne m'arrivera plus !", "*That* will never happen to me again!", CLITIC);
        add("Cela peut arriver à n'importe qui", "*That* can/could happen to anyone");
        add("David est arrivé à le faire tout seul", "David managed to do it by himself");
        add("Je n'arrive pas à trouver mes clés", "I can't (manage to) find my keys");
        add("Je suis arrivé à midi", "I arrived at noon");
        add("Je suis arrivée à faire mes devoirs", "I(f.) managed to do my homework");
        add("Il est arrivé un accident", "An accident has occurred");
        add("Il est vite arrivé à la conclusion évidente", "He quickly reached the obvious conclusion");
        add("L'eau m'arrive jusqu'aux chevilles", "The water reaches/comes up to my ankles", PRONOMINAL);
    }
    
    //http://french.about.com/od/grammar/a/preposition_par.htm
    
    //http://french.about.com/od/grammar/a/preposition_par2.htm

    // http://french.about.com/library/prepositions/bl_prep_verbs-test.htm
    // French Verbs with Prepositions
    private void bl_prep_verbs_testr()
    {
        add("Il a ri de notre chanson", "He laughed at our song");
        add("Il m'a donné une montre contre deux livres", "He gave me a watch in exchange for two books");
        add("J'écoute la radio chaque matin", "I listen to the radio each morning");
        add("Je pense que cette chemise conviendra à Alice", "I think that shirt will suit Alice");
        add("Je suis censé rencontrer des amis ce soir", "I am supposed to meet some friends this evening");
        add("Ne te moque pas de ton frère !", "Don't make fun of your(tu) brother!");
        add("Nous y serons vers midi", "We'll be there around noon");
        add("Peux-tu dire à Luc de mettre la table ?", "(Can) you tell Luc to set the table?");
        add("Nous voulons apprendre à faire du ski", "We want to learn to ski");
    }
    
    // http://french.about.com/od/grammar/a/conditionalperf.htm
    // French Conditional Perfect - Past Conditional
    private void FrenchConditionalPerfect()
    {
        push(CONDITIONAL, () ->
        {
            add("Si je l'avais vu, je l'aurais acheté", "If I had seen it, I would have bought it");
            add("Il serait venu si nous l'avions invité", "He would have come if we had invited him");
            add("à ta place, je l'aurais dit", "In your(tu) place, I would have said it");
            add("Elles auraient dû acheter un plan", "They(f.) should have bought a town-map");
            add("J'aurais aimé te voir, mais j'ai dû travailler", "I would have liked to see you(tu), but I had to work");
            add("Nous aurions voulu manger, mais il était trop tard", "We would have wanted to eat, but it was too late");

            // http://french.about.com/library/weekly/aa040800t.htm
            {
                add("Est-ce que tu aurais aimé venir avec moi ?", "Do would you(tu) have liked to come with me?");
                add("Elle aurait voulu assister à la conférence", "She would have wanted to attend the conference");
                add("Nous aurions dû faire la lessive",  "We should have done the laundry");
                add("Il aurait valu mieux faire nos devoirs", "It would have been better to do our homework");
                add("à sa place, je serais venu", "In his place, I would have come");
                add("Nous l'aurions fait si nous avions eu le temps", "We would have done it if we had had the time");
                add("Si vous m'aviez téléphoné, je vous aurais aidé", "If you had telephoned me, I would have helped you");
                ///add("Si j'avais eu sommeil, je (j') serais tombé");
            }
        });
    }
    
    // De vs Du, De la, Des
    // http://french.about.com/library/prepositions/bl-devsdest.htm
    private void bl_devsdestr()
    {
        push(DE, () ->
        {
            add("Avez-vous assez de temps ?", "(Do) you have enough time?");
            add("Ce ne sont pas des blagues", "These are not jokes");
            add("C'est la maison de mon frère", "It's my brother's house");
            add("En ce moment, il y a trop de difficultés", "At the moment, there are too many difficultues");
            add("Il a perdu les clés du directeur", "He lost the director's keys");
            add("Ils ont acheté des livres d'histoire", "They bought some history books");
            add("Ils n'ont pas de papier", "They don't have any paper");
            add("J'ai bu de la bière belge", "I drunk some Belgian beer");
            add("J'ai trouvé beaucoup des romans que nous aimions lire ensemble", "I found lots of novels that we loved to read together");
            add("J'ai vendu pas mal de cadeaux", "I sold (pas mal) of the presents");
            add("J'ai vendu pas mal des cadeaux qu'il m'avait offerts", "I sold (pas mal) of the presents that he had offered me");
            add("Je cherche des CD de musique de chambre", "I'm looking for CD's of chamber music");
            add("Je connais de bons écrivains", "I know some good writers");
            add("Je ne connais pas d'avocats", "I don't know any lawyers");
            add("Je ne veux pas d'eau", "I don't want any water");
            add("Le livre est plein de gribouillages", "The book is full of scribbles");
            add("Nous avons trouvé de jolis vêtements", "We found some pretty clothes");
            add("Où est la voiture de Valerie ?", "Where is Valerie's car?");
            add("Vas-tu manger de la salade ?", "(Are) you(tu) going to eat some salad?");
        });
    }
    
    public void comme_il_faut()
    {
        push(EXPR, () ->
        {
            add("Habille-toi comme il faut", "Dress(tu) properly(expr.)");
            add("Qui peut faire ce travail comme il faut ?", "Who can do this work correctly?(expr.)");
            add("Je ne sais pas répondre comme il faut", "I don't know how to respond correctly(expr.)");
            add("Mon ordinateur ne marche pas comme il faut", "My computer doesn't run as it correctly(expr.)"); 
        });
    }
    
    // http://french.about.com/od/grammar/a/de-vs-du-de-la-des_2.htm
    // Partitive Articles and Indefinite Articles
    // De vs Du, De la, Des
    private void de_vs_du_de_la_des_2()
    {
        push(DE, () ->
        {
            addCompound("Je veux du lait - Nous ne voudrions pas de lait", "I want some milk - We wouldn't want any milk");
            add("Nous avons mangé de la glace", "We ate some ice cream");
            add("Il a mangé des épinards", "He ate some spinach");
            add("Peux-tu me donner des conseils ?", "Can you(tu) give me some advice?");
            addCompound("Il a des livres intéressants - Il n'a pas de livres intéressants", "He has some interesting books - He doesn't have any interesting books");
            addCompound("J'ai acheté des chaussettes - Je n'ai pas acheté de chaussettes", "I bought some socks - I didn't buy any socks");
            add("Nous n'avons pas de voiture", "We don't have a car");
            add("C'est une poire, ce n'est pas une pomme", "It's a pear, it's not an apple");
            addCompound("C'est de la viande - Ce n'est pas de la viande", "It's meat - It's not meat");
            addCompound("J'ai des amis - J'ai de jeunes amis", "I have some friends - I have some young friends");
            addCompound("J'ai mangé des épinards - J'ai mangé de bons épinards", "I ate some spinach - I ate some good spinach");
            addCompound("J'ai besoin d'argent - J'ai besoin de l'argent que tu m'as promis", "I need some money - I need the money that you(tu) promised me");
        });
    }
        
    // http://french.about.com/od/grammar/a/de-vs-du-de-la-des_3.htm
    // Adverbs of Quantity, Containers, Adjectives, Prepositional Phrases
    // De vs Du, De la, Des
    private void de_vs_du_de_la_des_3()
    {
        push(DE, () ->
        {
            addCompound("Il y a beaucoup de problèmes - Beaucoup des problèmes sont graves", "There are a lot of problems - A lot of the problems are serious");
            addCompound("Peu d'étudiants sont ici - Peu des étudiants de Thierry sont ici", "Few students are here - Few of Thierry's students are here");
            addCompound("J'aimerais un verre de jus - J'aimerais un verre du jus que tu as apporté", "I'd like a glass of juice - I'd like a glass of the juice that you(tu) brought");
            addCompound("La chambre est pleine de vêtements - La chambre est pleine des vêtements de David", "The bedroom is full of clothes - The bedroom is full of David's clothes");
            add("Les tables sont couvertes de gâteaux", "The tables are covered in cakes", DONT);
            add("Les tables sont couvertes des gâteaux dont je t'ai parlé", "The tables are covered in the cakes which I told you(tu) about", DONT);
            add("J'ai acheté du jus au lieu de vin", "I bought juice instead of wine");
            add("J'ai acheté du jus au lieu du vin que tu as recommandé", "I bought juice instead of the wine you(tu) recommended");
        });
    }
        
    // http://french.about.com/od/grammar/a/de-vs-du-de-la-des_4.htm
    // Descriptive vs Possessive de
    // De vs Du, De la, Des
    private void de_vs_du_de_la_des_4()
    {
        push(DE, () ->
        {
            addCompound("Le livre de l'étudiant - Le livre des étudiants", "The student's book - The students' book");
            addCompound("Le panier du chien - Le panier de chien", "The dog's basket - The dog basket");
            addCompound("Le livre de Michel - La voiture du patron", "Michel's book - The boss's car");
        });
    }
    
    private void de_vs_du_de_la_des_5()
    {
        push(DE, () ->
        {
            add("Nous avons besoin d'argent", "We need money");
            add("J'ai besoin de nouvelles chaussures", "I need new shoes");
            add("Il se moque de mauvaises idées", "He makes fun of bad ideas", PRONOMINAL);
        });
    }
    
    // http://french.about.com/library/weekly/aa040100.htm
    // French Temporal Prepositions
    // Prépositions de temps
    private void aa040100()
    {
        push(TEMPORAL, () ->
        {
            add("Nous mangeons à huit heures", "We eat at eight o'clock");
            add("Il va parler à midi", "He is going to speak at noon");
            add("Nous avons mangé en une heure", "We ate in an hour (took an hour to eat)");
            add("Il va parler en hiver", "He is going to speak in the winter");
            add("Nous mangerons dans 20 minutes", "We'll eat in 20 minutes");
            add("Il va parler dans une heure", "He's going to speak in an hour");
            add("Nous mangeons depuis une heure", "We've been eating for an hour");
            add("Il parle depuis 5 minutes", "He's been speaking for 5 minutes");
            add("Il travaillait depuis 10 jours quand je l'ai vu", "He'd been working for 10 days when I saw him");
            add("Nous avons mangé pendant une heure", "We ate for an hour");
            add("Il peut parler pendant 15 minutes", "He can speak for 15 minutes");
            add("Il va parler pendant 15 minutes", "He's going to speak for 15 minutes");
            add("Louise travaille ici depuis cinq ans", "Louise worked here for five years");
            add("Serez-vous prêt dans une demie heure ?", "Will you be ready in half an hour?");
            add("J'ai fini mes devoirs en 45 minutes", "I finished my homework in 45 minutes");
            add("Elles ont joué pendant une heure et demie", "They(f) played for an hour and half");
            add("Qui a crié à minuit ?", "Who shouted at midnight?");
            add("Il fait froid en hiver", "It's cold in winter");
            add("On va partir à midi", "I/We're going to leave at midday");
            add("J'étudie le français depuis 5 ans", "I've studied French for 5 years [and still am]");
            add("Il fait chaud en juillet", "It's hot in July");
            add("Lisa a téléphoné à 15h", "Lisa telephoned at 3pm");
            add("Peut-on commencer dans quelques minutes ?", "(Can) I/we start in some minutes?");
            add("Paul va arriver dans 2 semaines", "Paul is going to arrive in 2 weeks");
            add("Nous avons fini le projet en deux ans", "We finished the project in two years");
            add("Il doit se lever à 6h30", "He must get up at 6:30");
            add("On peut commencer dans trois jours", "I/we can start in three days");
            add("Thierry va vivre en France pendant un an", "Thierry is going to live in France for a year");
            add("Je connais Michel depuis quelques mois", "I've known Michel for some months");
            add("Ils ont nagé pendant toute la journée", "They(m) swam all day(f)");
            add("Tu seras en Italie pendant un mois", "You'll(tu) be in Italy for a month");
            add("Nous regardons la télé depuis 2 heures", "We've been watching TV for 2 hours");
        });
    }
        
    // http://french.about.com/library/prepositions/bl_prep_en_vs_dans.htm
    // En vs Dans
    // French Prepositions
    private void bl_prep_en_vs_dans()
    {
        push(TEMPORAL, () ->
        {
            add("Je peux faire le lit en 5 minutes", "I can make the bed in 5 minutes (takes me 5 minutes to make the bed)");
            add("Il a lu le livre en une heure", "He read the book in an hour (took an hour to read)");
            add("J'ai appris à danser en un an", "I learned how to dance in a year");
            add("Nous voyageons en avril", "We travel in April");
            add("Il arrivera en hiver", "He will arrive in the winter");
            add("Nous voyageons au printemps", "We travel in the spring");
            add("Il arrivera au printemps", "He will arrive in the spring");
            add("Vous allez en prison !", "You're going to prison!");
            add("Il est en classe", "He's in school");
            add("J'habite en Californie", "I live in California");
            add("Je vais en France", "I'm going to France");
            add("Nous partons dans 10 minutes", "We're leaving in 10 minutes");
            add("Il reviendra dans une heure", "He'll come back in an hour");
            add("Elle va commencer dans une semaine", "She's going to start in a week");
            add("Qu'est-ce qui est dans la boite ?", "What's in the box?");
            add("Nous avons fini en une heure", "We finished in an hour");
            add("Il veut partir dans une demie heure", "He wants to leave in half an hour");
            add("J'ai écrit mon premier livre en six mois", "I wrote my first book in six months");
            add("Elle est née en 1956", "She was born in 1956");
            add("Je préfère voyager en été", "I prefere to travel in summer");
            //add("Grâce à ce cours que je suis maintenant, je vais apprendre à conduire en un mois", "Thanks to this course I'm following now, I'm going to learn to drive in(will take me) a month");
            add("Elle va partir pour l'université dans deux mois", "She's going to leave for university in two months");
            add("Nous arriverons dans une heure", "We will arrive in an hour");
            //add("Il a été inventé dans les années 50's", "It was invented in the 50's");
            add("Il peut manger un hamburger entier en une minute", "He can eat a whole hamburger in a minute");
            add("Venez me voir dans deux semaines", "Come see me in two weeks");
            add("Je vais commencer mes devoirs dans dix minutes", "I'm going to start my homework in ten minutes");
            add("Vas-tu partir en juin ?", "(Are) you(tu) going to leave in june?");
            add("Il s'est rasé en dix minutes", "He shaved in ten minutes", PRONOMINAL);
        });
    }
    
    // http://french.about.com/library/weekly/aa112599.htm
    // Definite, Indefinite, and Partitive Articles
    // Test on French Articles
    private void aa112599()
    {
        add("Est-ce que tu veux de l'eau ?", "Do you(tu) want some water?", DE);
        add("Est-ce qu'elle aime les fraises ?", "Does she like strawberries?");
        add("J'adore la mousse au chocolat", "I adore chocolate mousse");
        add("Ils cherchent une chambre à louer", "They're looking for a room to rent");
        add("Ils ont un jardin", "They have a garden");
        add("Y a-t-il du beurre sur la table ?", "(Is) there some butter on the table?", DE, Y);
    }
    
    // http://french.about.com/od/grammar/a/articles_3.htm
    // French Indefinite Articles
    // Articles indéfinis
    private void articles_3()
    {
          add2("J'ai une pomme - Je n'ai pas de pommes", "I have an apple - I don't have any apples", DE);
    }
    
    // http://french.about.com/od/grammar/a/articles_4.htm
    // French Partitive Articles
    // Articles partitifs
    private void articles_4()
    {
        push(DE, () ->
        {
            //
            add("Avez-vous bu du thé ?", "(Did) you drink some tea?");
            add("J'ai mangé de la salade hier", "I ate salad yesterday");
            add("Nous allons prendre de la glace", "We're going to have/take some ice cream");
            add("Il y a beaucoup de thé",  "There is a lot of tea");
            add("J'ai moins de glace que Thierry", "I have less ice cream than Thierry");
            addCompound("J'ai mangé de la soupe - Je n'ai pas mangé de soupe", "I ate some soup - I didn't eat any soup");
        });
    }

    // Agreement with French Compound Verbs
    // http://french.about.com/library/weekly/bl-agreement-cv.htm
    private void bl_agreement_cv()
    {
        push(AGREEMENT, () ->
        {
            add("Les voitures sont lavées par mon fils", "The cars are washed by my son");
            add("Ma mère est aimée par tous mes amis", "My mother is loved by all my friends");
            add("Les livres sont lus par les étudiants", "The books are read by the students");
            add("Il l'a vue", "He saw |Marie|");
            add("Elle les a achetés", "She bought |the books|");
            add("As-tu lu les livres que j'ai achetés ?", "(Did) you(tu) read the books I bought?");
            add("Tu les avais perdues", "You(tu) had lost |the keys|");
            add("J'ai trouvé les clés que tu avais perdues", "I found the keys you(tu) had lost");
            add("Voici les livres qu'il m'a donnés", "Here are the books he gave me");
            add("Il les a fait travailler", "He made them work");
            add("L'histoire que j'ai entendu lire", "The story that I heard read");
            add("Ils se sont arrêtés à la banque", "They stopped at the bank");
            add("Ana, tu t'es lavée", "Ana, you(tu) washed (yourself)");
            add("Ana, t'es-tu lavée ?", "Ana, you(tu) washed (yourself) ?");
        });
    }

    // http://french.about.com/od/grammar/a/sembler.htm
    // All about Sembler
    private void AllAboutSembler()
    {
        add("Tu me sembles bien fatigué", "You(tu) seem/look very tired to me");
        add("Il ne semble pas convaincu", "He doesn't seem convinced");
        add("Ton idée semble intéressante", "Your(tu) idea seems interesting");
        add("La maison semble secouer", "The house seems to be shaking");
        add("Il semble important d'essayer", "It seems important to try");
        add("Il ne semble pas qu'il soit prêt", "It doesn't seem like he's ready");
        add("Il me semble que tu as raison", "It seems to me that you're(tu) right");
        add("Il nous semble que Paul peut le faire", "It seems to us that Paul can do it");
    }
    
    // http://french.about.com/od/grammar/a/depuis-pendant-pour.htm
    // Depuis, Pendant, Pour
    // French prepositions
    private void depuis_pendant_pour()
    {
        push(TEMPORAL, () ->
        {
            add("Depuis quand étudiez-vous le français ?", "How long have you been studying French?");
            add("J'étudie le français depuis 3 ans", "I've been studying French for 3 years");
            add("J'étudie le français depuis 2009", "I've been studying French since 2009");
            add("Depuis combien de temps dormais-tu quand je suis arrivé ?", "How long had you(tu) been sleeping when I arrived?");
            add("Il vivait en France depuis deux ans quand je l'ai vu", "He'd been living(vivre) in France for two years when I saw him");
            add("Pendant combien de temps avez-vous étudié le français ?", "How long did you study French?");
            add("J'ai étudié le français pendant 3 ans", "I studied French for 3 years");
            add("Je vais habiter en France pendant 2 mois", "I'm going to 'habite' in France for 2 months");
            add("J'ai vu un film pendant mon séjour", "I saw a film during my stay");
            add("Pendant ce temps, il m'attendait", "During this time, he was waiting for me");
            add("Je vais y habiter pendant 2 mois", "I'm going to live there for 2 months");
            add("Il étudiera en Europe pendant 3 ans", "He'll study in Europe for 3 years");
            add("Le projet est suspendu pendant un an", "The project is suspended for a year");
            add("Le projet a été suspendu pendant un an", "The project was suspended for a year");
        });
    }

    // http://french.about.com/od/grammar/a/depuisilya.htm
    // Depuis vs Il y a
    // French temporal expressions
    private void depuisilya()
    {
        push(TEMPORAL, () ->
        {
            add("Nous attendons depuis une heure", "We've been waiting for an hour");
            add("Il parle depuis 5 minutes", "He's been speaking for 5 minutes");
            add("Il travaillait depuis 10 jours quand je l'ai vu", "He'd been working for 10 days when I saw him");
            add("Je suis malade depuis mon arrivée", "I've been sick since my arrival");
            add("Depuis hier, je suis déprimée", "Since yesterday, I've(f) been depressed");
            add("Il ne fume pas depuis un an", "He hasn't smoked for a year");
            add("Je suis arrivée il y a une heure", "I(f) arrived an hour ago");
            add("Il a parlé il y a 5 minutes", "He spoke 5 minutes ago");
            add("Il a travaillé il y a 10 jours", "He worked 10 days ago");
            add("J'étais malade il y a une semaine", "I was sick a week ago");
            add("Il y a deux jours, j'ai vu un chat noir", "Two days ago, I saw a black cat");
            add("J'ai déménagé ici il y a longtemps", "I moved here a long time ago");
            add("ça fait deux heures que nous attendons", "(informal) We've been waiting for two hours");
            add("J'attends depuis deux minutes - ça fait deux minutes que j'attends", "I've been waiting two minutes - (informal) I've been waiting two minutes");
        });
    }
    
    private void bl_depuis_v_ilyat()
    {
        push(TEMPORAL, () ->
        {
            add("Je cherche mes clés depuis lundi", "I've been looking for my keys since monday");
            add("Il est célèbre depuis la publication de son premier roman", "He is famous since the publication of his first novel");
            add("Le toit fuit depuis la tempête", "The roof has been leaking since the tempest");
            add("Je suis rentré il y a deux heures", "I arrived back home two hours ago");
            add("Je travaille en Espagne depuis six mois", "I've been working in Spain for six months");
            //// QUERY : add("Il y a des années que l'on ne s'est pas vu", "It's been years since I/we have seen each other");
            add("Elle a fini ses devoirs il y a cinq minutes", "she finished her homework five minutes ago");
            add("Il est malade depuis février", "He's been ill since February");
            add("Il y a trois mois que nous voyageons", "It's been three months since we travelled");
            add("Nous étudions depuis seulement une heure", "We've been studying for only one hour");
            add("J'ai vu ce film il y a longtemps", "I saw this film a long time ago");
            add("Nous nous connaissons depuis des années", "We've known each other for years", PRONOMINAL);
            add("Le bébé pleure depuis des heures !", "The baby has been crying for hours!");
            add("Depuis quand habites-tu ici ?", "Since when (have) you(tu) lived here?");
            add("Ils sont mal à l'aise depuis l'accident", "They've been uneasy since the accident");
            add("Il m'a téléphoné il y a trois jours", "He telephoned me three days ago");
        });
    }
    
    // http://french.about.com/od/grammar/a/indirectobjects.htm
    // French Indirect Objects and Indirect Object Pronouns
    // Complément d'objet indirect (COI)
    private void indirectobjects()
    {
        push(CLITIC, () ->
        {
            add("ça nous plait beaucoup", "That pleases us a lot");
            //add("Elle lui conseille", "Elle conseille |au professeur|");
            add("Elle lui rend visite", "She visits |Luc|");
            add("Elle m'a écrit", "She wrote to me");
            add("Elle nous écrit souvent", "She often writes |to us|");
            add("Je leur achète du pain", "I buy some bread for |the children|");
            add("Je leur donne quelque chose", "I give something to |them(f.)|");
            add("Je leur montre mon dessin", "I show my drawing to |them(f.)|");
            add("Je lui parle", "I'm talking to |my brother|");
            add("Je lui téléphone", "I'm telephoning |Alice|");
            add("Je vous donne le pain", "I'm giving the bread to you");
            add("Il faut y faire attention", "You(Il) have to pay attention to |details|");
            add("Il leur achète des livres", "He buys them some books");
            add("Il lui ressemble", "He resembles |his sister|");
            add("Ils te parlent", "They're speaking to you(tu)");
            add("Il pense à elle", "He is thinking |of Amy|");
            add("Ils m'envoient le livre", "They're sending the book to |me|");
            add("Nous leur demandons", "We ask |Lise and Agnès|");
            add("Nous leur écrivons", "We are writing to |our parents|");
            add("Tu peux me faire confiance", "You(tu) can trust me");
        });
    }
    
    // http://french.about.com/od/grammar/a/objectpronouns_4.htm
    // Double Object Pronouns
    // Pronoms objets - Position et ordre
    public void objectpronouns_4()
    {
        push(CLITIC, () ->
        {
            add("Ne me les donnez pas", "Don't give them to me");
            add("Il leur en a donné", "He gave them some", EN);
            add("Ils nous l'ont envoyé", "They sent it to us");
            add("Donnez-le-moi", "Give it to me");
            add("Vendez-nous-en", "Sell us some", EN);
            add("Trouvez-le-moi", "Find it for me");
            add("Parlez-nous-y", "Talk to us |there|", Y);
            add("Envoyez-le-lui", "Send it to him");
            add2("Je l'y mets - Je l'y mets", "I'm putting the |letter| on the |table| - I'm putting the |message| on the |tables|");
            add2("Je la lui montre - Je le leur montre", "I'm showing the |letter| to my |father| - I'm showing the |message| to my |parents|");
        });
    }
    
    // http://french.about.com/od/grammar/a/preposition_pour.htm
    public void preposition_pour()
    {
        add("Il l'a fait pour nous aider", "He did it to help us");
        add("Je vais y habiter pour un an", "I'm going to live there for a year", TEMPORAL);
        add("Il parlera pour une heure", "He will speak for an hour", TEMPORAL);
        add("J'ai été puni pour avoir volé", "I was punished for having stolen");
        add("Ce magasin est fermé pour réparations", "This store is closed for repairs");
        add("Je suis assez fatigué pour dormir par terre", "I'm tired enough to sleep on the floor");
        add("Il est trop avare pour nous aider", "He's too stingy(avare) to help us");
    }
    
    // http://french.about.com/od/grammar/a/pronouns_possessive.htm
    // French Possessive Pronouns - Pronoms possessifs
    // Introduction to French possessive pronouns
    public void pronouns_possessive()
    {
        add("Je vois ton frère, mais le mien n'est pas encore arrivé", "I see your(tu) brother, but mine hasn't arrived yet");
        add("Je déteste ma voiture ; la tienne est beaucoup plus jolie", "I hate my car; yours(tu) is much prettier");
        add("Mes parents sont en France. Où habitent les vôtres ?", "My parents are in France. Where do yours live?");
        add("Tu parles à ton frère ; je vais parler au mien", "You(tu) are talking to your brother; I'm going to talk to mine");
        add("Ils sont fiers de leurs enfants et nous sommes fiers des nôtres", "They are proud of their children and we are proud of ours");
        add2(
                "Ils sont fiers de leurs enfants - Ils sont fiers de leur enfant",
                "They are proud of their children - They are proud of their child");
    }
    
    // http://french.about.com/od/grammar/a/pastparticiple.htm
    // French Past Participle
    // Introduction to the French past participle
    public void pastparticiple()
    {
        push(AGREEMENT, () ->
        {
            add("Le ménage est fait tous les jours", "The housework is done every day");
            //      `add("Ce film sera suivi d'une discussion", "This film will be followed by a discussion");
            add("Fatigué, je suis rentré à minuit", "Tired, I went home at midnight");
            add("Le garçon déçu a pleuré", "The disappointed boy cried");
            // assis? add("Le chien assis sur le canapé est mignon", "The dog sitting on the couch is cute");
            add("Ce livre est écrit en espagnol", "This book is written in Spanish");
            add("La voiture est lavée par mon fils", "The car is being washed by my son");
            add("Les solutions proposées sont parfaites", "The proposed solutions are perfect");
            add("Elles sont allées à la banque", "They(f) went to the bank");
            add("Je l'ai vue ce matin", "I saw her this morning");
        });
    }

    // http://french.about.com/od/grammar/a/reflexivepronouns.htm
    // French Reflexive Pronouns - Pronoms réfléchis
    public void reflexivepronouns()
    {
        push(PRONOMINAL, () ->
        {
            add("Ils ne s'habillent pas", "They aren't getting dressed");
            skip("Aidons-nous", "Let's help each other");
            add("Nous nous sommes couchés", "We went to bed", AGREEMENT);
            add("Vas-tu te raser ?", "(Are) you(tu) going to shave?");
            add("En me levant, j'ai vu une voiture", "While getting up, I saw a car", PARTICIPLE);
        });
    }
    
    // http://french.about.com/od/grammar/a/reflexivepronouns_2.htm
    // Se - French Reflexive Pronoun
    public void reflexivepronouns_2()
    {
        push(PRONOMINAL, () ->
        {
            add("Cela ne se dit pas", "*That* isn't said");
            add("L'alcool ne se vend pas ici", "Alcohol isn't sold here");
            add("Il se lave le visage", "He's washing his face");
            add("Ils se lavent les jambes", "They're washing their legs");
            addCompound(CLITIC,
                    "Se lave-t-il le visage ? - Se le lave-t-il ?",
                    "(Is) he washing his face? - (Is) he washing |his face|?");
            addCompound(CLITIC,
                    "Il se le lave - Il se la lave",
                    "He's washing |his face| - He's washing |his leg|");
        });
    }
    
    // http://french.about.com/library/weekly/aa040601.htm
    // Inversion
    // French Word Order ~ Ordre des mots
    private void aa040601()
    {
        push(CLITIC, () ->
        {
            skip("Lis-tu ?", "(Are) you(tu) reading ?");
            add("Le lis-tu ?", "(Are) you(tu) reading it?");
            add("Ne lis-tu pas ?", "(Are) you(tu) not reading?");
            add("Ne le lis-tu pas ?", "(Are) you(tu) not reading it?");
            add("Ne me le lis-tu pas ?", "(Are) you(tu) not reading it to me?");
            skip("As-tu mangé ?", "(Did) you(tu) eat?");
            add("L'as-tu mangé ?", "(Did) you(tu) ate it?");
            add("N'as-tu pas mangé ?", "(Did) you(tu) not eat?");
            add("Ne l'as-tu pas mangé ?", "(Did) you(tu) not eat it?");
            add("T'es-tu habillé ?", "(Did) you(tu) get dressed?");
            add("Ne t'es-tu pas habillé ?", "(Did) you(tu) not get dressed?");
            add("Ne l'y as-tu pas mangé ?", "(Did) you(tu) not eat it there?");
            skip("Veux-tu manger ?", "(Do) you(tu) want to eat?");
            add("Veux-tu le manger ?", "(Do) you(tu) want to eat it?");
            add("Veux-tu te doucher ?", "(Do) you(tu) want to shower?");
            add("Ne veux-tu pas manger ?", "(Do) you(tu) not want to eat?");
            add("Ne veux-tu pas le manger ?", "(Do) you(tu) not want to eat it?");
            add("Ne veux-tu pas te doucher ?", "(Do) you(tu) not want to shower?");
            // add("Continuerons-nous à travailler ?", "(Will) we continue to work ?");
            // add("Continuerons-nous à y travailler ?", "(Will) we continue to work |there|?", Y);
            // add("Ne continuerons-nous pas à travailler ?", "(Will) we not continue to work?");
            // add("Ne continuerons-nous pas à y travailler ?", "(Will) we not continue to work |there|?", Y);
    //        add("Promets-tu d'étudier ?", "(Do) you(tu) promise to study?", CLITIC);
    //        add("Me promets-tu d'étudier ?", "(Do) you(tu) promise me to study?", CLITIC);
    //        add("Ne promets-tu pas d'étudier ?", "(Do) you not promise to study?
    //        add("Ne me promets-tu pas d'étudier ? 	Don't you promise me that you'll study?
    //        add("Ne me promets-tu pas de l'étudier ? 	Don't you promise me that you'll study it?
        });
    }

    // Vouloir, Pouvoir, Devoir
    private void aa041500tr()
    {
        add("Peut-elle voir l'écran ?", "Can she see the screen?");
        add("Veuillez m'excuser", "Kindly excuse me");
        add("Vous auriez pu perdre", "You might have lost");
        add("Je voudrais le faire", "I would like to do it");
        add("Je n'ai pas pu trouver les clés, Michel les avait prises", "I couldn't find the keys, Michel had taken them", AGREEMENT);
        add("Il se peut que tu aies raison", "It is possible(is a chance) that you're(tu) right", SUBJUNCTIVE);
        add("Il voudrait voir le film", "He would like to see the film");
        add("Tu aurais dû essayer", "You(tu) should have tried");
        add("Vous me devez beaucoup d'argent", "You owe me a lot of money", DE);
        add("Elles doivent étudier ce soir", "They(f.) must study this evening");
    }
    
    // En - French Pronoun
    // French adverbial pronoun ~ Pronom adverbial
    // http://french.about.com/od/grammar/a/pron_adverbial_2.htm
    private void pron_adverbial_2()
    {
        push(EN, () ->
        {
            add("Oui, j'en ai", "Yes, I have |some bread|");
            add("Il en a envie", "He desires |an apple|");
            add("Je n'en ai pas besoin", "I don't need |an assistant|");
            add("Il y en a beaucoup", "There are a lot |of rooms|");
            add("Je n'en ai pas assez", "I don't have enough |money|");
            add("J'en voudrais deux", "I'd want |two books|");
            add("Nous en avons acheté 10", "We bought 10 (of them)");
   
//
//En also replaces de + noun with verbs and expressions that need de. Again, in French, you must include either de + something or its replacement en, even though "about/of it" is usually optional in English.
//
//   What do you think about my idea? What do you think (about it)?
//   Que penses-tu de mon idée ? Qu'en penses-tu ?
   //Wrong: Que penses-tu ?
//
//   What are the consequences of this decision? What are the consequences (of it)?
//   Quelles sont les conséquences de cette décision ? Quelles en sont les conséquences ?
//   Wrong: Quelles sont les conséquences ?
//
//
//Note that en usually cannot replace de + verb.
//
//   I decided to accept his offer. I decided to accept it.
//   J'ai décidé d'accepter son offre. J'ai décidé de l'accepter.
//   Wrong: J'en ai décidé.
//
//   I forgot to wash the car. I forgot to wash it.
//   J'ai oublié de laver la voiture. J'ai oublié de la laver.
//   Wrong: J'en ai oublié. 

        });
    }
    
    private void PronominalVerbSeries()
    {
        // http://french.about.com/od/grammar/a/pronominalverbs.htm
        // French Pronominal Voice and Pronominal Verbs
        add("Elle se brosse les dents", "She's brushing her teeth", PRONOMINAL);
        addCompound(PRONOMINAL,
                "Elle se promène - Elle promène le chien",
                "She's taking a walk - She's taking the dog for a walk");

        // http://french.about.com/od/grammar/a/pronominalverbs_2.htm
        // French Reciprocal Verbs and Idiomatic Pronominal Verbs
        add("Elles se voient le lundi", "They(f) see each other on Mondays", PRONOMINAL);
        addCompound(PRONOMINAL,
                "Tu te trompes - Tu me trompes",
                "You(tu.f) are mistaken - You(tu.f) are cheating on me");
        addCompound(PRONOMINAL,
                "Tu t'es trompée - Tu m'as trompé",
                "You(tu.f) were mistaken - You(tu.f) cheated on me");
        addCompound(PRONOMINAL,
                "Vous vous êtes trompée - Vous m'avez trompé",
                "You(f) were mistaken - You(f) cheated on me");

        // http://french.about.com/od/grammar/a/pronominalverbs_3.htm
        // Word Order with Pronominal Verbs
        add("Tu te reposeras", "You(tu) will rest", PRONOMINAL);
        add("Je ne m'habille pas", "I'm not getting dressed", PRONOMINAL);
        add("Tu ne te reposes jamais", "You(tu) never rest", PRONOMINAL, CLITIC);
        add("Se rase-t-il ?", "(Is) he shaving?", PRONOMINAL, CLITIC);
        add("Te laves-tu les mains ?", "(Are) you(tu) washing your hands?", PRONOMINAL, CLITIC);
        add("Ne se rase-t-il pas ?", "(Is) he not shaving?", PRONOMINAL, CLITIC);
        add("Ne te laves-tu jamais les mains ?", "(Do) you(tu) never wash your hands?", PRONOMINAL, CLITIC);
        
        // http://french.about.com/od/grammar/a/pronominalverbs_4.htm
        // Pronominal Verbs in Compound Tenses
        push(of(AGREEMENT, PRONOMINAL), () ->
        {
            add("Elle s'est couchée à minuit", "She went to bed at midnight");
            add("Ils s'étaient vus à la banque", "They had seen each another at the bank");
            add("Après m'être habillé, j'ai allumé la télé", "After getting dressed, I turned on the TV");
            add("Nous nous sommes douchés", "We showered");
            add("Marianne s'est fâchée", "Marianne got mad");
            add("Elle s'est occupée du chien", "She took care of the dog");
            add("Ils se sont souvenus de la pièce", "They remembered the play");
            add("Nous nous sommes acheté une voiture", "We bought ourselves a car");
            add("Nous nous la sommes achetée", "We bought ourselves |a car|");
            add("Elle s'est dit la vérité", "She told herself the truth");
            add("Nous nous le sommes acheté", "We bought |the book| for ourselves");
            add("Nous nous la sommes achetée", "We bought |the car| for ourselves");
            add("Elle se l'est dit", "She told |the lie| to herself", CLITIC);
            add("Elle se l'est dite", "She told |the truth| to herself", CLITIC);
            add("Elles se sont parlé", "They(f) talked to each other");
        });
    }
    
    // Introduction to French Adverbs
    // http://french.about.com/od/grammar/a/adverbs.htm
    private void IntroductionToFrenchAdverbs()
    {
        skip("Nous avons bien mangé", "We ate well");
        add("Je regarde souvent la télé le soir", "I often watch TV in the evening");
        add("Je suis profondément ému", "I am deeply moved");
        ///s add("Je fais toujours mes devoirs", "I always do my homework");
        add("Parfois, Luc ne fait pas ses devoirs", "Sometimes, Luc doesn't do his homework");
        add("Aujourd'hui, je vais acheter une voiture", "Today, I'm going to buy a car");
        add("Généralement, nous mangeons avant 17h", "Generally, we eat before 5pm");
        add("Je ne l'ai pas trouvé, malheureusement", "I didn't find it, unfortunately");
        add("Il a immédiatement quitté Paris", "He left Paris immediately");
        add("Il a mis ton sac à dos là-bas", "He put your(tu) backpack over there");
        add("Je suis très heureuse", "I'm(f) very happy");
        add("Chantal fait assez souvent ses devoirs", "Chantal does her homework fairly often");
    }
    
    // http://french.about.com/od/grammar/a/possession_2.htm
    // French Possessive De
    // Learn how to express possession in French
    private void possession_2()
    {
        push(DE, () ->
        {
            add("Le livre de John", "John's book");
            add("Les rues de Rome", "The streets of Rome");
            add("Les idées d'un étudiant", "A student's ideas");
            add("C'est la voiture du patron", "It's the boss's car");
            addCompound("Les pages du livre - les pages des livres", "The book's pages - the books' pages");
        });
    }
    
    // http://french.about.com/od/grammar/a/presentparticiple_2.htm
    // French Present Participle - Le participe présent
    // Using the French present participle as a verb or gerund
    private void presentparticiple_2()
    {
        push(PARTICIPLE, () ->
        {
            add("En attendant", "While waiting...");
            add("En se sentant malade", "While feeling ill...", PRONOMINAL);
            add("Sachant le danger, je n'y suis pas allé", "Knowing the danger, I didn't go (there)");
            add("Ayant faim, il a mangé tout le gâteau", "Being hungry, he ate all of the cake");
            add("Une fille, lisant un livre, est venue au café", "A girl, reading a book, came to the café");
            add("Elle lisait en mangeant", "She read while eating");
            add("En voyant les fleurs, elle a pleuré", "Upon seeing the flowers, she cried (tears)  ");
            add("Il ne peut pas parler en travaillant", "He can't talk while working");
            add("C'est en pratiquant que vous le faites bien", "It's by practicing that you do it well");
            add("Elle a maigri en faisant beaucoup de sport", "She got thin by doing a lot of sport");
            add("En m'habillant vite, j'ai gagné 5 minutes", "By getting dressed quickly, I saved 5 minutes");
            add("La fille, chantant doucement, se promenait dans le parc", "The girl, singing softly, was strolling in the park");
            add("Se sentant malade, elle n'est pas venue", "Feeling ill, she didn't come");
            add("Il ne faut pas manger en courant", "(falloir) Do not eat while running");
            add("Les étudiants ayant leurs livres peuvent commencer", "The students having their books can start");
            add("En m'asseyant, je suis tombé", "While sitting, I fell");
            addCompound(
                    "J'ai vu Luc sortant de l'école - J'ai vu Luc en sortant de l'école",
                    "I saw Luc leaving the school - I saw Luc upon leaving the school");
            addCompound(
                    "Je l'ai vu achetant des livres - Je l'ai vu en achetant des livres",
                    "I saw him buying some books - I saw him while buying some books");
        });
    }
    
    // http://french.about.com/od/grammar/a/laisser.htm
    // All about Laisser
    public void laisser()
    {
        add("Peux-tu me laisser de l'argent ?", "Can you(tu) leave me some money?");
        add("Cela me laisse perplexe", "*That* leaves me perplexed");
        add("Il s'est laissé persuader", "He let himself be persuaded");
        add("Ne te laisse pas décourager !", "Don't let yourself(tu) get discouraged!");
    }
    
    // http://french.about.com/od/vocabulary/a/tomake.htm
    // Learn how to translate "to make" into French
    public void tomake()
    {
        push(FAIRE, () ->
        {
            add("Cela me fait mal", "*That* hurts (me)");
            add("Tu me fais honte !", "You(tu) make me feel ashamed!");
            add("Cela me rend heureux", "*That* makes me happy");
            add("Le poisson m'a rendu malade", "The fish made me sick");
            add("ça me donne soif", "that makes me thirsty");
            add("Cela m'a fait penser", "*That* made me think");
            add("Il me fait faire la vaisselle", "He's making me do the dishes");
        });
    }
    
    // http://french.about.com/od/grammar/a/verb_perception.htm
    // French Verbs of Perception
    // Les verbes de sensation
    private void verb_perception()
    {
        add("apercevoir", "(v.) to glimpse", "(v.) to catch sight of", PERCEPTION);
        add("J'aperçois tomber un arbre", "I glimpse a tree falling", PERCEPTION);
        add("J'écoute parler les enfants", "I'm listening to the children talking", PERCEPTION);
        add("J'entends arriver les étudiants", "I hear the students arriving", PERCEPTION);
        add("Je regarde jouer l'équipe", "I'm watching the team play", PERCEPTION);
        add("Je sens souffler le vent", "I feel the wind blowing", PERCEPTION);
        add("Je vois courir le chien", "I see the dog running", PERCEPTION);
    }

    // http://french.about.com/od/grammar/a/verb_perception_2.htm
    // Verbs of Perception
    // Word order with French verbs of perception
    private void verb_perception_2()
    {
        /// XXX: TODO
    }
    
    // http://french.about.com/library/weekly/aa072900.htm
    // The Many French Verbs that Mean To Return
    private void TheManyFrenchVerbsThatMeanToReturn()
    {
        // RENDRE
        add("Luc va rendre les livres à la bibliothèque", "Luc is going to return the books to the library");
        add("Je vais rendre la chemise de Chantal demain", "I'm going to return Chantal's shirt tomorrow"); 

        // REMBOURSER
        add("Luc va me rembourser demain", "Luc is going to pay me back tomorrow");
        add("Je veux rembourser l'argent que j'ai emprunté", "I want to return the money that I borrowed");
        add("Non, je les ai remboursés", "No, I paid them off");
   
        // RENVOYEZ
        add("Renvoyez cette lettre en France", "Send this letter back to France");

        // REVENIR
        add("Thomas va revenir en France", "Thomas is going to come back to France");
        add("Je viens de revenir au Canada", "I just returned to Canada");
        add("Je reviens de mes vacances", "I'm coming back from my holiday");
        add("Je n'ai pas l'intention de revenir à Paris", "I am not planning(expr.) on returning to Paris");
   
        // RETOURNER
        add("Thomas va retourner en France", "Thomas is going to return to France");
        add("Je veux retourner au Canada", "I want to go back to Canada");
   
        // RENTRER
        add("Thomas va rentrer en France", "Thomas is going to return to France");
        add("Je suis rentré au Canada", "I came back to Canada");
    }

    // http://french.about.com/od/grammar/a/adverb_negative.htm
    // French Negative Adverbs
    {
        add("N'êtes-vous pas fatigué ?", "Aren't you tired?", CLITIC);
        add("Nous n'aurions pas su", "We wouldn't have known", CLITIC);
        add("Il ne sera pas arrivé", "He will not have arrived");
        add("Tu n'avais pas parlé ?", "You(tu) hadn't talked?");
        add("Il ne veut pas skier", "He doesn't want to ski");
        add("Je ne peux pas y aller", "I can't go |there|");
    }
    
    // http://french.about.com/od/grammar/a/negation_inf.htm
    // Negation
    {
        add("Elle n'est pas encore arrivée", "She hasn't arrived yet", AGREEMENT);
        add("Il ne faut pas faire ça !", "You mustn't do that!");
        add("Je n'ai plus d'argent", "I don't have any more money", DE);
        add("Nous ne le voyons jamais", "We never see him");
        add("Je n'ai aucune idée", "I have no idea");
        add("Je n'en sais rien", "I don't know anything about it", CLITIC, EN);
    }

    private void TheSubjunctivator()
    {
        push(SUBJUNCTIVE, () ->
        {
            // http://french.about.com/od/grammar/qt/subjunctive_aimermieux.htm
            // Does aimer mieux need the subjunctive? - YES
            // add("J'aimerais mieux que tu le fasses", "I'd prefer that you(tu) do it");

            // http://french.about.com/od/grammar/qt/subjunctive_avoirbesoin.htm
            // Does avoir besoin que need the subjunctive?
            add("J'ai besoin qu'il vienne", "I need him to come");
            add("Je n'ai pas besoin qu'il vienne", "I don't need him to come");

            // http://french.about.com/od/grammar/qt/subjunctive_attendre.htm
            // Does attendre need the subjunctive? - YES
            add("J'attends qu'il vienne", "I'm waiting for him to come");

            // http://french.about.com/od/grammar/qt/subjunctive_amoinsque.htm
            // Does à moins que need the subjunctive?
            add("Je vais lui dire, à moins qu'il sache déjà", "I'm going to tell him, unless he already knows");
            
            // http://french.about.com/od/grammar/qt/subjunctive_cameplait.htm
            // Does ça me plaît que need the subjunctive? - YES
            add("ça me plait qu'il vienne", "It pleases me that he's coming");

            // http://french.about.com/od/grammar/qt/subjunctive_cestque.htm
            // Does c'est que need the subjunctive?
            {
                //add("C'est qu'il a de l'argent", "It's because he has money");
                //add("Ce n'est pas qu'il ait de l'argent", "It's not because he has money");
                //add("Est-ce qu'il ait de l'argent ?", "Is it because he has money?");
            }

            // http://french.about.com/od/grammar/qt/subjunctive_conseiller.htm
            // Does conseiller need the subjunctive? - YES
            add("Je conseille qu'il vienne", "I advise/recommend (that) he comes");

            // http://french.about.com/od/grammar/qt/subjunctive_desque.htm
            // Does dès que need the subjunctive?
            add("Je l'achèterai dès qu'il arrivera", "I'll buy it as soon as(inf.) he arrives");
            
            // http://french.about.com/od/grammar/qt/subjunctive_dire.htm
            // Does dire need the subjunctive?
            {
                add("Je dis qu'il le fait", "I say that he is doing it");
                add("Je ne dis pas qu'il le fasse", "I'm not saying that he is doing it");
                add("Dis-tu qu'il le fasse ?", "(Are) you(tu) saying that he is doing it?");
            }

            // http://french.about.com/od/grammar/qt/subjunctive_etresur.htm
            // Does être sûr que need the subjunctive?
            {
                add("Je suis sûr qu'il vient", "I'm sure he's coming");
                add("Je ne suis pas sûr qu'il vienne", "I'm not sure he's coming");
                add("Es-tu sûr qu'il vienne ?", "(Are) you(tu) sure he's coming?");
            }
            
            // http://french.about.com/od/grammar/qt/subjunctive_etrecertain.htm
            // Does être certain que need the subjunctive?
            {
                add("Je suis certain qu'il vient", "I'm certain he's coming");
                add("Je ne suis pas certain qu'il vienne", "I'm not certain he's coming");
                add("Es-tu certain qu'il vienne ?", "(Are) you(tu) certain he's coming?");
        }
            
            // http://french.about.com/od/grammar/qt/subjunctive_ilsemble.htm
            // Does il semble que need the subjunctive?
            {
                //add("fasse", "Il semble qu'il le *faire/fasse*");
                add("Il semble qu'il le fasse", "It seems that he does it");
                add("Il me semble qu'il le fait", "It seems to me that he does it");
                add("Il ne nous semble pas qu'il le fasse", "It doesn't seem to us that he does it");
                add("Te semble-t-il qu'il le fasse ?", "Seem to you(tu) that he does it?", CLITIC);
            }

            // http://french.about.com/od/grammar/qt/subjunctive_ilsepeut.htm
            // Does il se peut que need the subjunctive? - YES
            add("Il se peut qu'il le fasse", "It could be that he'll do it");

            // http://french.about.com/od/grammar/qt/subjunctive_savoir.htm
            // Does savoir need the subjunctive?
            {
                add("Je sais que vous avez raison", "I know you're right");
                add("Je ne sais pas si vous avez raison", "I don't know if you're right");
                add("Sais-tu s'il a raison ?", "(Do) you(tu) know if he's right?");         
            }
        });
    }
    
    private void VariousExpressions()
    {
        // http://french.about.com/od/vocabulary/a/a-cause-de.htm
        // A cause de
        {
            add("J'ai oublié mes clés à cause de l'appel de Philippe", "I forgot my keys because of Philippe's call");
            add("à cause de la mauvaise économie, j'ai perdu mon emploi", "Due to the bad economy, I lost my job");
            add("Je l'ai pardonné à cause de son âge", "I forgave him due to his age");
            add("Il va venir à la fête à cause de toi", "He's going to come to the party due to you(tu)");
            add("C'est à cause de cette décision que nous nous sommes disputés", "It's due to that decision that we argued", PRONOMINAL);
            add("J'ai paniqué à cause du bruit", "I panicked because of the noise", DE);
            add("Il est parti à cause des enfants", "He left because of the children", DE);
        }

        // http://french.about.com/od/vocabulary/a/grace-a.htm
        // Grâce à
        {
            add("Grâce à mon mari, j'ai une idée pour un livre", "Thanks to my husband, I have an idea for a book");
            add("Grâce à ton assistance, il a fini le travail", "Thanks to your(tu) assistance, he finished the work");
            add("S'il a réussi à l'examen, c'est grâce à toi", "If he passed the test, it's thanks to you(tu)");
            add("C'est grâce au centre de loisirs que je sais utiliser Facebook", "It's thanks to the leisure center that I know how to use Facebook");
            add("Grâce aux conseils de Pierre, nous avons trouvé la maison parfaite", "Thanks to Pierre's advice, we found the perfect house");
        }
        
        // http://french.about.com/od/vocabulary/a/jenysuispourien.htm
        // Je n'y suis pour rien
        {
            add("C'est Henri qui a pris ton CD - je n'y suis pour rien", "It's Henri who took your(tu) CD - I have nothing to do with it", Y);
            add("Marie est toujours à l'école - elle n'y est pour rien", "Marie is still at school - she's got nothing to do with this", CLITIC, Y);
            add("Je ne veux pas y aller avec eux - mon emploi n'y est pour rien", "I don't want to go there with them - my job/employment has nothing to do with it", CLITIC, Y);
            add("La dispute a commencé dans le couloir - je n'y étais pour rien", "The argument started in the hallway - I had nothing to do with it", CLITIC, Y);
        }
        
        // http://french.about.com/od/vocabulary/a/tumetonnes.htm
        // Tu m'étonnes
        {
            add("Tu m'étonnes", "You(tu) don't say (expr.)");
            add("L'économie globale ne va pas très bien - tu m'étonnes", "The global economy isn't going very well - you(tu) don't say");
        }
        
        // http://french.about.com/od/vocabulary/a/tiens.htm
        // Tiens
        {
            add("Tiens, j'ai besoin des deux mains pour conduire", "Take(tu) (this), I need both hands to drive");
            add("Tiens, je t'ai acheté des fleurs", "Here, I bought you(tu) some flowers");
            //add("Tiens, il faut que tu saches quelque chose", "Look, there's something you(tu) need to know");
        }
    }

    private void VariousMistakes()
    {
        // http://french.about.com/od/mistakes/a/demanderuneques.htm
        // Demander une question
        add("Puis-je te poser une question ?", "Can I ask you(tu) a question?");

        // http://french.about.com/od/mistakes/a/dentrevousetes.htm
        // Beaucoup d'entre vous êtes - French Mistake
        add("Beaucoup d'entre vous sont", "Many of you are ...", AGREEMENT);
        add("Certains d'entre nous ont", "Some of us have ...", AGREEMENT);
        
        // http://french.about.com/od/mistakes/a/ecoutera.htm
        // Écouter à la radio - French Mistake
        add("J'écoute la radio", "I'm listening to the radio");
        add("Il aime écouter les discours", "He likes listening to speeches");
        
        // http://french.about.com/od/mistakes/a/esperequetusois.htm
        // J'espère que tu sois
        add("J'espère que tu seras content", "I hope you(tu) will be satisfied", SUBJUNCTIVE);
        add("J'espère que tu y as réussi", "I hope that you(tu) succeeded (at it)");
        
        // http://french.about.com/od/mistakes/a/interessedans.htm
        // Je suis intéressé dans
        add("Je m'intéresse aux sports", "I'm interested in sports", PRONOMINAL);
        //  add("Savez-vous qui est intéressé dans ce scandale ?", "(Do) you know who is involved in this scandal?");

        // http://french.about.com/od/mistakes/a/jenaiditpas.htm
        // Je n'ai dit pas - French Mistake
         add("Je ne l'ai pas dit", "I didn't say that", CLITIC);
        
        // http://french.about.com/od/mistakes/a/jesuisfini.htm
        // Je suis fini - French Mistake
        add("J'ai fini", "I am finished");
        
        // http://french.about.com/od/mistakes/a/jeveuxquejaie.htm
        // Je veux que j'aie - French Mistake
        {
            addCompound(SUBJUNCTIVE,
                    "Je veux avoir assez de temps - Je veux que tu aies assez de temps",
                    "I want to have enough time - I want you(tu) to have enough time");
            addCompound(SUBJUNCTIVE,
                    "Je suis heureux qu'il soit là - Je suis heureux d'être là",
                    "I'm happy that he's here/there - I'm happy to be here/there");
        }

        // http://french.about.com/od/mistakes/a/jevousavezdit.htm
        // Je vous avez dit - French Mistake
        add("Je vous ai dit qu'il nous l'a donné", "I told you that he gave it to us", AGREEMENT, CLITIC);
        add("Est-ce que tu vois qu'elle vous aime ?", "Do you(tu) see that she loves you(pl?)", AGREEMENT, CLITIC);
        
        // http://french.about.com/od/mistakes/a/lemomentquand.htm
        // add(""c'était le moment quand je me suis rendu compte 
        // Tu peux manger quand tu arriveras.
        // The  French relative pronoun that means "when" is où (which also means "where"). So "that was the moment when I realized" and "the day when I left" are properly translated into French as c'était le moment où je me suis rendu compte and le jour où je suis parti.


        // http://french.about.com/od/mistakes/a/peutetreilafaim.htm
        // Peut-être il a faim - French Mistake
        //"maybe he's hungry," you can say either peut-être qu'il a faim or peut-être a-t-il faim, but you 
  //Certainly, he's hungry.
   //Sans doute qu'il a faim. or Sans doute a-t-il faim.                
                

        // http://french.about.com/od/mistakes/a/pourunan.htm
        // Pour un an - French Mistake
        add("J'étais en France pendant un an", "I was in France for a year", TEMPORAL);
        add("J'ai étudié le français pendant un semestre", "I studied French for one semester", TEMPORAL);
        add("Nous avons parlé pendant des heures", "We talked for hours", TEMPORAL);
        
        // http://french.about.com/od/mistakes/a/sestfaitpique.htm
        // Il s'est fait piqué 
        add("Il s'est fait piquer", "He got stung", "He got himself stung", FAIRE);
        add("J'ai fait remplir mon réservoir d'essence", "I had my gas tank filled", FAIRE);
        add("Je me suis fait couper les cheveux", "I had my hair cut", FAIRE);

        // http://french.about.com/od/mistakes/a/tunefaispasca.htm
        // Tu ne fais pas ça - French Mistake
        add("On ne fait pas ça", "You(general) don't do that");
        add("On ne sait jamais !", "You(general) never know !");

        // http://french.about.com/od/mistakes/a/what.htm
        // "What" in French
        add("Qu'est-ce que tu veux ?", "What do you(tu) want?");
        add("Qu'est-ce qu'ils regardent ?", "What are they watching?");
        add("Qu'est-ce qui se passe ?", "What's happening?");
        addCompound(
                "Qu'est-ce qui a fait ce bruit ? - Qui a fait ce bruit ?",
                "What made that noise? - Who made that noise?");
        add("Je me demande ce qui va se passer", "I wonder what's going to happen");
        add("Je ne sais pas ce qu'elle a dit", "I don't know what she said");
        add("Quel livre est-ce que tu veux ?", "What book do you(tu) want?");
        add("à quelle heure vas-tu partir ?", "What time (are) you(tu) going to leave?");
        add("Quelles sont les meilleures idées ?", "What are the best ideas?");
        add("Quel livre intéressant !", "What an interesting book!");
        add("Quelle bonne idée !", "What a good idea!");
//    De quoi parlez-vous ? De quoi est-ce que vous parlez ?
//    What are you talking about?
//
//    Sur quoi tire-t-il ? Sur quoi est-ce qu'il tire ?
//    What is he shooting at?
//     
//    In a question or statement with a relative clause, use quoi + subject + verb.
//
//    Sais-tu à quoi il pense ?
//    Do you know what he's thinking about?
//
//    Je me demande avec quoi c'est écrit.
//    I wonder what it's written with.
//
//    a) When a verb or expression requires de, use ce dont:
//
//        C'est ce dont j'ai besoin. (J'ai besoin de...)
//        That's what I need.
//
//        Je ne sais pas ce dont elle parle. (Elle parle de...)
//        I don't know what she's talking about.
//
//    b) When à is the preposition and it is placed either at the beginning of a clause or after c'est, use ce à quoi:
//
//        Ce à quoi je m'attends, c'est une invitation.
//        What I'm waiting for is an invitation.
//
//        C'est ce à quoi Chantal rêve.
//        That's what Chantal dreams about.
        
        // http://french.about.com/od/mistakes/a/nebougerpas.htm
        // Il m'a dit de ne bouger pas - French Mistake
        add("Il m'a dit de ne pas bouger", "He told me not to move", CLITIC);
    }
    
    // http://french.about.com/od/vocabulary/a/sur-et-certain.htm?nl=1
    // French expressions analyzed and explained
    public void sur_et_certain()
    {
        add("Il faut être sûr et certain avant de sauter !", "You have to absolutely sure(expr.) before you jump!");
        add("Ils sont sûrs et certains de son authenticité", "They're absolutely certain(expr.) of its authenticity");
        add("Hélène est sûre et certaine qu'il va pleuvoir", "Hélène is positive(expr.) it's going to rain");
        add("Sont-elles sûres et certaines que la maison soit prête ?", "(Are) they(f) absolutely certain(expr.) the house will be ready?");
    }
}