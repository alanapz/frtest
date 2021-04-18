package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;
import static fr.gen.MiscVocabulary.Preposition.*;

/* package */ final class RealFrenchGrammer extends AutoSentenceGenerator
{
    public RealFrenchGrammer(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }

    public void doSetup()
    {
        // UNIT 6 - Avoir
        {
            add("Tu as tort de dire cela", "You're (tu) wrong to say that-there");
        }
        
        // UNIT 12 - Devoir
        {
            add("Elles doivent aller à l'école", "They(f) must go to school");
            add("Tu devrais t'excuser", "You(tu) ought to apologise");
        }

        // UNIT 13 - Savoir/Connaitre
        {
            add("Elle ne sait pas la réponse", "She doesnt't know the answer");
            add("Il ne sait pas cuisiner", "He can't cook");
            add("Je connais bien Pierre", "I know Pierre well");
        }
        
        // UNIT 14 - Falloir
        {
            add("Il te faut un billet pour entrer", "You(tu) need/necessary a ticket to enter");
            add("Tu as besoin d'un billet", "You(tu) need a ticket");
            add("Il me faut un stylo", "I need/necessary a pen");
            add("Est-ce que vous avez besoin d'aide ?", "Do you need some help ?", DE);
        }
        
        // UNIT 15 - Pronominal verbs
        push(PRONOMINAL, () ->
        {
            add("Amusez-vous bien !", "Have (lots of) fun !");
            add("T'intéresses-tu au tennis ?", "(Are) You(tu) interested in tennis?");
            add("Elle se repose dans le jardin", "She rests in the garden");
            add("Elles se rencontrent souvent en ville", "They(f) meet each other often in town");
            add("Elle se souvient de leur adresse", "She remembers their address");
            add("Asseyez-vous !", "Sit down !");
            add("Tournez-vous !", "Turn around !");
            add("Il s'ennuie pendant les vacances", "He is bored during the holidays", TEMPORAL);
        });

        // UNIT 16 - Passive Voice
        push(AGREEMENT, () ->
        {
            add("On m'a conseillé de prendre quelques jours de repos", "I was advised to take some days rest"); 
            add("La voiture est lavée par mon père", "The car is being washed by my dad");
            add("Le paquet est livré par le facteur", "The packet is being delivered by the postman");
            add("Le livre est lu par l'étudiant", "The book is being read by the student");
            add("Le piano est joué par ma soeur", "The piano is being played by my sister");
            add("Le jouet est cassé par le garçon", "The toy is broken by the boy");
            add("Les voitures sont cassées par le garçon", "The cars are broken by the boy");
            add("Les voitures ont été cassées par le garçon", "The cars were broken by the boy");
            add("Michelle est aidée par Paul à faire ses devoirs", "Michelle is being helped by Paul to do her homework");
        });
  
        // UNIT 17/18 - Negation
        {
            add("Je ne veux pas de glace", "I don't want a ice-cream", DE, NEGATION);
            add("Nous n'avons pas de chat", "We don't have a cat", DE, NEGATION);
            add("Je ne prends plus le train", "I don't take the train any longer", NEGATION);
            add("Je ne veux plus jouer à ce jeu", "I don't want to play this game any more", NEGATION);
            add("Elle ne boit que de l'eau minérale", "She only drinks mineral water", DE, NEGATION);
        }
        
        // UNIT 19 - Questions
        {
            add("Tu aimes le cricket, n'est-ce pas ?", "You(tu) like cricket, don't you ?", QUESTION);
        }
        
        // UNIT 20/21 - Inversion
        {
            add("Aimes-tu le tennis ?", "(Do) you(tu) like tennis ?", CLITIC);
            add("Aime-t-il le tennis ?", "(Does) he likes tennis ?", CLITIC);
        }
        
        // UNIT 22 - More Questions
        {
            add("Quand rentrent-ils de leurs vacances ?", "When (do) they get back from their holidays?", QUESTION);
            add("Comment voyagent-ils en France ?", "How (are) they travelling to France ?", QUESTION);
        }
        
        // UNIT 24 - Pronominal Commands
        {
            add("Brosse-toi les cheveux", "Brush your(tu) hair", PRONOMINAL);
        }
        
        // UNIT 25-28 - Perfect
        {
            add("Le soldat a obéi aux ordres de son colonel", "The soldier obeyed his colonel's orders");
            add("Je lui ai rendu le livre", "I returned the book back |to her|", CLITIC);
            add("Hier soir nous avons eu des invités", "Last night we had some guests");
            add("Est-ce que Pierre vous a dit où il allait ?", "Did Pierre tell you where he was going ?", CLITIC);
        }

        // UNIT 29 - Etre
        {
            add("Je suis tombé par terre", "I fell on the ground");
            add("Quand est-ce que tu es né ?", "When were you(tu) you born ?", QUESTION);
            add("Ils sont venus passer une semaine chez nous", "They came to spend a week round ours");
        }
        
        // UNIT 30 - Pronominal Perfect
        {
            add("Je me suis trompé de numéro", "I got the wrong number", PRONOMINAL);
            add("Ils se sont rencontrés à une soirée", "They met at a (evening) party", PRONOMINAL, AGREEMENT);
            add("Je me suis assis dans le fauteuil", "I sat down on the arm-chair", PRONOMINAL);
            add("Je me suis décidé à vivre en France", "I decided (for myself) to live in France", PRONOMINAL);
            add("Il s'est demandé pourquoi elle était en retard", "He wondered why she was late", PRONOMINAL);
            add("Françoise s'est souvenue de l'histoire", "Françoise remembered the story", PRONOMINAL, AGREEMENT);
        }
        
        // UNIT 31 - Imperfect
        {
            add("Il jouait au badminton", "He used to play badminton");
        }
        
        // UNIT 32,33,34,35 - Future
        {
            add("Elle me rendra mon parapluie", "She will give me back my umbrella");
            add("Si tu suis mes conseils, tu réussiras", "If you(tu) follow my advice, you will succeed");
            add("Je viendrai te voir mercredi", "I will come and see you(tu) wednesday");
            add("Tu verras combien c'est facile", "You(tu) will see how easy it is");
        }
        
        // UNIT 36 - Conditional
        push(CONDITIONAL, () ->
        {
            add("Si tu arrêtais de parler tu finirais plus tôt", "If you(tu) stopped talking you'd finish earlier");
            add("Elle a dit qu'elle n'oublierait pas de lui en parler", "She said that she would not forget to talk to her about it", EN);
            add("Il a promis qu'il leur téléphonerait", "He promised that he would telephone them");
            add("Il m'a dit qu'il resterait jusqu'à dimanche", "He said to me that he would stay until sunday");
            add("Nous aimerions vous voir plus souvent", "We would love to see you more often");
            add("Si tu parlais plus fort elle t'entendrait", "If you(tu) spoke louder she would hear you(tu)");
        });
        
        // UNIT 37 - Irregular conditionals
        push(CONDITIONAL, () ->
        {
            add("Il faudrait te décider maintenant si tu veux y aller", "You(tu) would need(falloir) to make your mind up now if you want to go there");
        });

        // UNIT 39 - Subjunctive
        push(SUBJUNCTIVE, () ->
        {
            add("J'ai rangé ça pour qu'il y ait plus de place", "I put that away so that there's more room");
            add("Je veux que vous fassiez moins de bruit", "I want you to make less noise");
            add("Je suis désolé que nous ne puissions pas venir", "I'm sorry that we can't come");
            add("Il est possible qu'elle vienne mardi prochain", "It's possible she'll come next Tuesday");
            add("Il est important que tu ailles tout de suite", "It's important that you(tu) go straight away");
            add("Il est très heureux que son équipe ait gagné", "He is very happy that his team has won");
            add("Quel dommage qu'il fasse si mauvais aujourd'hui", "What a shame it's so bad(weather) today");
            add("Ils sont désolés que tu sois malade", "They are sorry that you(tu) are ill");
        });
        
        // UNIT 40 - Subjunctive Use
        push(SUBJUNCTIVE, () ->
        {
            add("bien que", "although ...");
            add("pourvu que", "provided that ...");
            add("pour que", "in order that ...");
            add("Je préférerais que nous y allions tout de suite", "I'd prefer it if we went there straightaway", Y);
            add("Il faut que nous partions tôt", "[It is necessary] that we leave early");
            add("Il est possible que nous arrivions en retard", "It's possible that we'll arrive late");
            add("Je doute qu'il dise la vérité", "I doubt he's telling the truth");
            add("Nous sommes très contents que tu aies réussi à ton examen", "We're very pleased you(tu) passed your exam");
            add("Il est dommage que vous ayez perdu", "It's a shame you lost");
            add("Bien qu'il soit malade, il continue à travailler", "Although he's unwell, he continues to work");
            add("Tu peux emprunter ce livre pourvu que tu me le rendes avant vendredi", "You can borrow this book provided you(tu) give it back to me by Friday");
            add("Bien que j'aie mis un pullover j'ai toujours froid", "Even though I put on a pullover I am still cold");
            add("Elle aimerait mieux que nous y allions un autre weekend", "She would like it better that we went there another weekend");
            add("Il est dommage que nous devions rentrer si tôt", "It's a shame that we have to return so early");
            add("Nous sommes ravis que tu aies trouvé un emploi", "We are delighted that you(tu) have found a job/employment");
            add("Je veux vous revoir avant que vous partiez", "I want to see you again before you leave");
            add("Il faut que vous veniez immédiatement", "It is necessary that you come immediately");
        });
        
        // UNIT 46 - Partative articles
        push(DE, () ->
        {
            add("Je veux de l'eau minérale", "I want some mineral water");
            add("Tu prends de la crème ?", "You(tu) take cream?");
            add("Je bois de l'eau minérale", "I'm drinking mineral water");
            add("Tu veux du chocolat ?", "You(tu) want some chocolate?");
            add("Elle ne boit que du jus d'orange", "She only drinks orange juice");
            add("J'ai du travail à faire", "I have work to do");
        });
        
        // UNIT 47 - To + Article
        {
            add("Veux-tu une glace à la vanille ?", "(Do) you(tu) want a vanilla ice-cream ?");
            add("Dans une heure nous partons à l'aéroport", "In an hour we leave for the airport");
            add("Céline et Anne sont au parc", "Céline and Anne are at the park");
        }
                
        // UNIT 48 - De + Article
        {
            add("Nous allons visiter les châteaux de la Loire cet été", "We're going to visit the castles of the Loire this summer", DE);
            add("Il a peur du chien", "He is scared of dogs", DE);
        }
 
        // UNIT 50 - Dates and routines
        {
            add("Lundi je vais au supermarché", "On Monday I'm going to the supermarket");
            add("Le lundi je vais au supermarché", "On Mondays I go to the supermarket");
            add("Nous avons français le mercredi", "We have French on wednesdays");
        }
        
        // UNIT 54 - Adjective Agreement
        {
            add("Il est sportif, elle est sportive", "He's sporty, she's sporty");
            add("Il est paresseux, elle est paresseuse", "He's lazy, she's lazy");
            add("Nous avons acheté un pull cher et une jupe chère", "We bought an expensive jumper and an expensive skirt");
            add("Nous avons vu un vieux film et une vieille histoire", "We saw an old film and an old story");
            add("Elle a de beaux cheveux", "She has beautiful hair");
            add("Cette tarte est délicieuse", "This tart is delicious");
        }
                        
        // UNIT 55 - Adjective Position
        {
            add("Un long voyage mais une courte distance", "A long journey but a short distance");
        }
        
        // UNIT 57 - Possessive Adjectives
        {
            add("Puis-je emprunter votre parapluie ?", "Can I borrow your umbrella?");  
            add("J'ai vu mon amie à ton école", "I saw my friend(f) at your(tu) school");
            add("Où est-ce que tu as passé tes vacances ?", "Where did you(tu) spend your holidays ?");
            add("Leurs rideaux sont fermés", "Their curtains are closed");
        }
        
        // UNIT 58 - Demonstrative Adjectives
        {
            add("Ces filles sont très bavardes", "These girls are very talkative");
            add("Cet arbre est très vieux", "This tree is very old");
            add("Cette fille est très douée", "That girl is very talented");
            add("Ces tickets étaient gratuits", "These tickets were free");
        }
        
        // UNIT 59: Comparative adjectives
        {
            add("Il est plus fort que moi en maths", "He's better than me in maths");
            add("Elle est moins timide que sa soeur", "She's less shy than her sister");
            add("Elle est aussi intelligente que son frère", "She's as clever as her brother");
            add("Mes notes étaient bonnes mais les notes de Martha étaient meilleures", "My marks were good but Martha's marks were better");
            add("Leur jardin est plus grand que le nôtre", "Their garden is bigger than ours");
            add("La France est plus chaude que l'Angleterre", "France is hotter than England");
            add("Ce fromage est bon mais celui-ci est meilleur", "That cheese is good but this one is better");
        }
        
        // UNIT 60: Superlative adjectives
        {                     
            add("La voiture rouge est la moins chère", "The red car is the cheapest");
            /// XXX: Ask Steph meilleures/meilleurs
            add("Mes notes étaient bonnes mais les notes de Martha étaient les meilleures", "My marks were good but Martha's marks were the best");
            add("C'est la pièce la plus froide de la maison", "It's the coldest room of the house");
            add("Le chocolat belge est le meilleur chocolat du monde", "Belgian chocolate is the best chocolate of the world");
            add("C'est la robe la plus belle du magasin", "It's the most beautiful dress of the store");
        }
        
        // UNIT 61 - Pronouns (I)
        {
             add("Je cherche mon stylo, il était sur mon bureau", "I'm looking for my pen, it was on my desk");
             add("Elle était très amusante, son histoire", "It was very funny, her story");
             add("Peux-tu ouvrir la fenêtre - elle est déjà ouverte", "Can you(tu) open the window - it is already open");
        }
        
        // UNIT 62 - Pronouns (II)
        {
            add("Taisez-vous, vous faites trop de bruit !", "Be quiet, you're making too much noise!");
            add("Est-ce que tu as un stylo que je peux emprunter ?", "Do you(tu) have a pen I can borrow?");    
        }
        
        // UNIT 63 - Pronouns (III)
        {
            add("On voudrait savoir où est la gare", "I/We'd like to know where the station is");
            add("Tes chaussettes ? Elles sont dans le tiroir", "Your(tu) socks? They're in the drawer");
            add("Regarde tes mains - elles sont pleines d'encre", "Look at your(tu) hands - they're covered in ink");
            add("Elles vont à la même école", "|Kate and Mia| go to the same school");
            add("Mes soeurs ? Elles ont toutes les deux les cheveux blonds", "My sisters ? They both have blond hair");
        }
        
        // UNIT 64 - ON
        {
            add("En France, on boit beaucoup de vin", "In France, we/they drink a lot of wine");
            add("On pourra venir à la fête", "I/We will be able to come to the party");
        }
        
        // UNIT 65 - Direct Pronouns
        {
            add("Elle la mange", "She eats |the pie|");
            add("Il les connait", "He knows |my parents|");
            add("Ils nous invitent", "They're inviting |Hannah and me|");
            add("Il nous connait", "He knows |me and my mum|");
            add("Je les aime beaucoup", "I like |John and Jane| a lot");
            add("Nous les invitons", "We're inviting |Céline and Anne|");
            add("Les enfants le regardent", "The children are watching |the computer|");
        }
        
        // UNIT 66 - Indirect Pronouns
        {
            add("Paul lui parle", "Paul talks to |Marie|");
            add("Je lui envoie un colis", "I am sending him a parcel");
            add("Elle leur écrit une lettre", "She's writing them a letter");
            add("Il lui donne des fleurs", "He gives her some flowers");
            add("Il me prête le livre", "He's lending |me| the book");
            add("Il nous dit la vérité", "He is telling |us| the truth");
            add("Il va lui parler", "He is going to talk to him");
            add("Il va lui parler", "He is going to talk to her");
            add("Elle leur demande de l'aider", "She asks them to help her");
            add("Je lui prête ma règle", "I lend her my ruler");
            add("Il me prête le livre", "He lends |me| the book");
            add("Elle lui apprend à danser", "She teaches her to dance");
            add("Je lui envoie un colis", "I send her a parcel");
        }   
        
        // UNIT 67 - EN
        push(EN, () ->
        {
            add("en", "|of it|");
            add("Tu en veux plus ? J'en ai beaucoup", "You(tu) want some more (of it)? I've got a lot (of it)");
            add("Est-ce que vous avez un chien ? Oui, nous en avons deux", "Do you have a dog? Yes, we've have two of them");
            add("J'en voudrais", "I would like |some chocolate|");
            add("Est-ce que vous avez de la limonade ?", "Do you have any lemonade?");
            add("Est-ce que vous en avez ?", "Do you have |any lemonade|?");  
            add("Je cherche des chemises blanches. En avez-vous ?", "I'm looking for some white shirts. You have any?");
            add("Ce jour-là, tu t'en souviens ?", "*That* day, you(tu) remember it?");
            add("Ma peinture, qu'est-ce que t'en penses ?", "My painting, what do you(tu) think of it?");
            add("Ce fait, il en est sûr", "This fact, he's sure of it");
            add("Mes cousins, je les vois souvent", "My cousins, I see them often");
            add("Cette affaire, nous en avons déjà parlé", "This matter, we've already talked about");
            add("Nous en avons besoin", "We need |some butter|");
            add("Est-ce que vous en voulez ?", "Do you want |any chocolate|?");
            add("Leur école, ils en sont fiers", "Their school, they're proud of it");
        });
        
        /// UNIT 68 - Y
        push(Y, () ->
        {
            add("Pierre y habite", "Pierre lives |in Paris|");
            add("Elle y va dans une heure", "She's going |to town| in an hour");
            add("Elle s'y habitue", "She's getting used to it", CLITIC);
            add("Le professeur y répond", "The teacher answers |my question|");
            add("Elle y habite depuis deux ans", "She lives(and still does) |in Paris| for two years");
            add("Pierre y pense souvent", "Pierre thinks of |the final| a lot");
            add("La salle de classe ? Je n'y ai pas trouvé mes gants", "The classroom? I didn't find my gloves there", CLITIC);
            add("Ta question ? Il y répondra demain", "Your(tu) question? He will reply to it tomorrow");
            add("Ma nouvelle école ? Je m'y habitue", "My new school? I'm getting used to it", CLITIC);
            add("Le cinéma ? Elle s'y intéresse beaucoup", "The cinema? She's very interested in it", CLITIC);
            add("Je vais y retourner samedi", "I'm going to go back to |Manchester| on saturday");
            add("Les échecs ? Je ne sais pas y jouer", "Chess? I don't know how to play it");
            add("Emma ? Je lui ai prêté mon stylo", "Emma? I lent her my pen", Y);
            add("Mes parents ? Je leur ai montré les photos", "My parents? I showed them the photos", Y);
            addCompound(
                    "Elle s'habitue à sa nouvelle école - elle s'y habitue",
                    "She's getting used to her new school - She's getting used to it");
            addCompound(
                    "Je m'intéresse à l'informatique - Je m'y intéresse",
                    "I'm interested in computing - I'm interested in |computing|");
        });
        
        // UNIT 69 - Possessive Pronouns
        {
            add("Ma voiture est en panne - prenons la tienne", "My car has broken down - let's take yours(tu)");
            add("Je lis mon livre et elle lit le sien", "I'm reading my book and she's reading hers");
            add("Stéphane a perdu ses gants, donc je lui ai prêté les miens", "Stéphane lost his gloves, so I lent him mine");
            add("Mes notes sont bonnes mais les siennes sont meilleures", "My marks are good but his are better");
            add("Marie a acheté une robe pareille à la mienne", "Marie bought a dress similar to mine");
            add("C'est la sienne ou la leur ?", "It's |his house| or |their house| ?");
            add("Ta montre était plus chère que la mienne", "Your(tu) watch was more expensive than mine");
        }
        
        // UNIT 70 - Demonstrative Pronouns
        {
            add("J'aime bien cette voiture-ci, mais je préfère celle d'à côté", "I like *this* car, but I prefer the one next to it");
            add("Dans quel magasin as-tu acheté cette écharpe ? Celui sur la rue Pasteur", "In which shop (did) you(tu) buy that scarf? The one on rue Pasteur");
            add("Quelle robe préfères-tu ? Celle aux manches courtes", "Which dress (do) you(tu) prefer? The one with the short sleeves");
            add("J'aime bien cette robe, mais je préfère celle-là", "I like this dress, but I prefer that one");
            add("Voici deux livres. Celui-ci est bon marché, celui-là est plus cher", "Here are two books. This one is cheap, that one is more expensive");
            add("Cette voiture-ci est la mienne et celle-là est la tienne", "*This* car is my one and that one is your(tu) one");
            add("J'ai trouvé ce livre-ci plus intéressant que celui-là", "I found *this* book more interesting than that one");
            add("J'ai confondu mon sac avec celui de Paul", "I mistook my bag for Paul's one");
            add("Il a pris la voiture de sa mère. Celle de son père est au garage", "He took his mother's car. His fathers is at the garage");
            add("Est-ce que tu préfères ces biscuits-ci ou ceux-là ?", "Do you(tu) prefer *these* biscuits or those ones?");
            add("David m'a montré sa moto, celle qu'il vient d'acheter", "David showed my his motorbike, the one he had just bought");
            add("Les chocolats belges sont ceux que je préfère", "Belgian chocolates are my preferred ones");
            add("Je n'aime pas cette robe-là. Je préfère celle-ci", "I don't like *that* dress. I prefer this one");
        }
        
        // UNIT 71 - Relative Pronouns
        {
            add("L'homme qui habite à côté", "The man who lives next door ...");
            add("L'homme que j'ai vu", "The man (who) I saw ...");
            add("Je n'ai pas trouvé le livre que je cherchais", "I didn't find the book I was looking for");
            add("C'est vous qui avez eu cette idée ?", "It's you who had this idea ?");
            add("La robe que tu portes est très jolie", "The dress you're(tu) wearing is very pretty");
            add("Elle a lavé la chemise qui était tachée", "She washed the shirt which was stained");
            add("C'est ton cousin que j'ai vu à la bibliothèque ?", "It's your(tu) cousin who I saw at the library?");
            add("Je connais quelqu'un qui peut nous aider", "I know someone who can help us");
        }
        
        // UNIT 72 - Relative Pronouns (dont)
        push(DONT, () ->
        {
            add("Paul, dont j'ai acheté la voiture", "Paul, whose car I bought ... ");
            add("Le livre dont j'ai besoin", "The book I need ...");
            add("La chose dont je me souviens le plus", "The thing I remember the most ...");
            add("Le chien dont les enfants ont peur", "The dog the children are afraid of ...");
            add("L'affaire dont nous parlons", "The matter we're talking about ...");
            add("Où se trouvent les ciseaux dont tu t'es servi ?", "Where (are to be found) the scissors you(tu) used?");
            add("Tu peux choisir ce dont tu as envie", "You(tu) can choose that which you desire");
            add("Nos voisins ont un chien dont nos enfants ont très peur", "Our neighbours have a dog which our children are very scared of");
            addCompound(
                    "Ses derniers livres sont ceux dont il est le plus fier - Son dernier livre est celui dont il est le plus fier",
                    "His latest books are the ones he's most proud of - His latest book is the one he's most proud of");
        });
        
        // UNIT 73 - Adverbs
        {
            add("Tu manges trop rapidement", "You're(tu) eating too quickly");
            //add("L'étudiant écoutait la prof attentivement", "The student was closely listening to the teacher");
            add("Elle a balancé le bébé doucement", "She rocked the baby gently");
            add("Jack est un enfant parfaitement sain", "Jack's a perfectly healthy child");
            add("Ils passent généralement la Journée de Noel chez les parents de sa femme", "They generally spend Christmas Day at his wifes parents'");
            add("Jules fait rapidement ses devoirs", "Jules quickly does his homework");
            add("Elle a répondu vivement à ces critiques", "She vigouresly replied to those criticisms");
        }

        // UNIT 74 - Prepositions
        {
            add("Le vase a été cassé par les enfants", "The vase was broken by the children", AGREEMENT);
            add("Qu'est-ce que tu penses de ce film ?", "What do you(tu) think of this film?");
            add("Ils se sont assis sous un arbre", "They sat down under a tree", PRONOMINAL);
            add("Ils s'intéressent beaucoup au sport", "They're very interested in sport", PRONOMINAL);
            add("En rentrant je passerai chez la boulangerie", "While coming back I'll pass into the bakers", PARTICIPLE);
        }
          
        // UNIT 75 - To/From
        {
            add("Je suis arrivé à 10 heures", "I arrived at 10 o'clock", AGREEMENT);
            add("Nous y allons au printemps", "We're going there in the spring");
            add("Je viens de Manchester", "I come from Manchester");
            add("Il a commencé à pleuvoir", "It started raining");
            add("Elle a promis de venir tout de suite", "She promised to come straightaway");
        }
        
        // UNIT 76 - Jouer/Jouer
        {
            add("Elle joue très bien du piano", "She plays the piano very well");
            add("J'aimerais bien apprendre à jouer de la guitare", "I'd really like to learn to play the guitar");
            add("Les enfants jouaient au badminton dans le jardin", "The children were playing badminton in the garden");
            add("Le piano ? Je ne sais pas en jouer", "The piano? I don't know how to play it", EN);
            add("Le badminton ? Nous aimons bien y jouer", "Badminton? We really like playing it", Y);
            add("J'aimerais bien apprendre à jouer de la harpe", "I would really like to learn to play the harp");
            add("Je ne sais pas jouer aux échecs", "I can't play chess");
        }
        
        // UNIT 77 - Depuis
        push(TEMPORAL, () ->
        {
            add("Je fais mes études à Manchester depuis septembre", "I have been doing my studies in Manchester since September");
            add("Nous habitons dans cette maison depuis avril", "We've lived in this house since april");
            add("Nous marchons dans cette forêt depuis deux heures", "We've been walking in this forest for two hours");
            add("Elle travaille sur ce livre depuis deux ans", "She's been working on this book for two years");
            add("Nous attendons ici depuis midi", "We've been waiting here since midday");
            add("Il est au régime depuis trois semaines", "He's been on a diet for three weeks");
            add("Nous cherchons une nouvelle maison depuis un an", "We've been looking for a new house for a year");
        });
        
        // UNIT 78 - Conjunctions
        {
            add("Il a réussi à l'examen bien qu'il n'ait pas étudié", "He passed the exam even though he didn't study");
            add("Tu peux emprunter mon sèche-cheveux pourvu que tu me le rendes tout de suite !", "You(tu) can borrow my hair-dryer provided you give it back to me straightaway!"); 
            add("Parlez fort pour que nous puissions vous entendre", "Speak loud so we can hear you", SUBJUNCTIVE);
            add("Il viendra à la soirée pourvu que Marie vienne aussi", "He will come to the soiree procided that Marie comes also");
            add("Il faut que je note votre adresse pendant que je m'en souviens", "It is necessary that I note your address while I remember it", TEMPORAL);
            add("Vu que je suis en forme maintenant, je peux reprendre le travail", "Seeing that I'm fit now, I can resume working");
            add("Bien qu'elle vive aux Etats-Unis, je la vois souvent", "Even though she lives in United-States, I see her often");
            add("Nous ne pourrons pas commencer avant que Pierre soit arrivé", "We will not be able to start before Pierre has arrived", AGREEMENT);
            add("Nous irons la voir avant qu'elle parte en Australie", "We'll go see her before she leaves for Australia");
            add("Bien qu'il ait étudié le français pendant deux ans, il ne comprenait pas un seul mot", "Even though he studied (the) French for two years, he wasn't understanding a single word", SUBJUNCTIVE, TEMPORAL);
        }
        
        // UNIT 82 - Expressions of quantity
        {
            add("Beaucoup de bruit, trop de travail", "A lot of noise, too much work", DE);
            add("Est-ce que nous avons assez de papier ?", "Do we have enough paper?", DE);
            add("J'ai acheté un tube de dentifrice", "I bought a tube of toothpaste", DE);
        }
    }
}