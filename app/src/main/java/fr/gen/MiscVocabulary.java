package fr.gen;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;
import fr.gen.phrases.*;
import static apz.fr.utils.Utils.*;
import static fr.gen.MiscVocabulary.Preposition.*;

public final class MiscVocabulary extends SentenceGenerator {

    public static final PhraseTag PERCEPTION = new PhraseTag();
    public static final PhraseTag AGREEMENT = new PhraseTag();
    public static final PhraseTag CONDITIONAL = new PhraseTag();
    public static final PhraseTag AUXILIARY = new PhraseTag();
    public static final PhraseTag ALLER = new PhraseTag(AUXILIARY);
    public static final PhraseTag CLITIC = new PhraseTag();
    public static final PhraseTag EXPR = new PhraseTag();
    public static final PhraseTag DE = new PhraseTag();
    public static final PhraseTag FAIRE = new PhraseTag();
    public static final PhraseTag LOCUTION = new PhraseTag();
    public static final PhraseTag NEGATION = new PhraseTag();
    public static final PhraseTag QUESTION = new PhraseTag();
    public static final PhraseTag PARTICIPLE = new PhraseTag();
    public static final PhraseTag PRONOMINAL = new PhraseTag();
    public static final PhraseTag SUBJUNCTIVE = new PhraseTag();
    public static final PhraseTag TRAPS = new PhraseTag();
    public static final PhraseTag DONT = new PhraseTag();
    public static final PhraseTag EN = new PhraseTag();
    public static final PhraseTag Y = new PhraseTag();

    public static final class Preposition
    {
        public static final PhraseTag PHYSICAL = new PhraseTag();
    
        public static final PhraseTag TEMPORAL = new PhraseTag();
        
        private Preposition()
        {
            
        }
    }

    public MiscVocabulary(ScoreFileBuilder scores, SortingPolicy sortPolicy, Predicate<SentenceQuestion> filter) {
        super(scores, sortPolicy, filter);
    }

    @Override
    public final String getResultsSource()
    {
        return "grammar";
    }
    
    @Override
    protected void setup()
    {
        // MISC
        {
            add("Je ne me suis pas plainte tant que ??a du film", "I didn't complain about the film as much as that", PRONOMINAL, CLITIC);
            add("Il s'est rendu", "He turned himself in", PRONOMINAL);
            add("Je n'ai jamais vu une chose pareille", "I've never seen such a thing");
            add("Pour la diffusion fran??aise, il faudra attendre !", "For the French release, one will have to wait!");
            add("Je ne peux pas ne rien faire", "I can't do nothing", CLITIC);
            add("Il s'est bien pass?? - Il se passe bien", "It went well - It goes well", PRONOMINAL);
            add("Cela dit, il semble qu'elle ait eu l'effet d??sir??", "That said(expr), it seems |the action| had the desired effect", SUBJUNCTIVE);
            add("Il y a autre chose que vous ignorez probablement", "There is something else that you are probably unaware of");
            add("Il nous a tu??s", "He killed us", AGREEMENT);
            add("Ai-je l'air arrogant ?", "Do I look smug ?", CLITIC);
            add("Aie confiance !", "(tu)Have confidence !");                    // imperative
            add("Auriez-vous pu ??tre au rendez-vous ?", "Could you have made the rendez-vous?");
            // add("Je ne peux pas ne rien faire", "I can't do nothing", CLITIC);
            add("Autrefois, il ??tait com??dian", "In the past, he was a comedian");
            add("Avez-vous vu le caissier leur donner leur ch??que ?", "(Did) you see the cashier give them their cheque?");
            add("Avez-vous vu ma soeur descendre du train ?", "(Did) you see my sister get off the train?", DE);
            add("C'est de la folie pure", "It's pure madness");
            add("C'est de la part de qui ?", "Who is calling ? (Telephone)");
            add("C'est gentil de ta part", "It's kind of you(tu.f)");
            add("C'est ?? nous de les trouver", "It's upto us to find them");
            add("Cardassia ??tait au bord de l'abysse", "Cardassia was on the edge of the abyss");
            add("Ce n'est qu'une question de temps", "It's only a question of time");
            add("ce n'est pas facile de t'occuper de nous", "(tu) It's not easy to look after us", PRONOMINAL);
            add("Certains osent porter ce genre de chemise", "Certain people dare to wear that style of shirt");
            add("Ces armes fonctionnaient quand vous me les avez vendues", "These weapons were functioning when you sold them to me", AGREEMENT, CLITIC);
            add("Ces trois mois ont-ils ??t?? si terribles ?", "Those three months were(perfect) so terrible?");
            add("Cette eau est tr??s froide", "This water is very cold");
            add("Cette fois-ci, m??me leur Emissaire ne pourra pas les sauver !", "*This* time, not even their Emissary will be able to save them!");
            add("Combien en avez-vous tu?? ?", "How many of them have you killed?", EN);
            // add("Comme tu n'avais rien dit, j'avais peur que tu ne l'aies pas eu", "As you(tu) hadn't said anything, I was scared that you didn't have it", SUBJUNCTIVE);
            add2("J'avais peur que tu ne l'aies pas eu - J'avais peur que tu ne l'aies pas", "I was scared you(tu) didn't have it - I was scared you(tu) don't have it",  SUBJUNCTIVE);
            add("Damar a-t-il dit comment il allait proc??der ?", "(Did) Damar say how he was going to proceed?");
            add("Dans un exemple comme celui-ci", "In an example like this one");
            add("Je ne crois pas qu'il t'ait choisi plut??t que moi", "I don't believe that he chose you(tu) rather than me", SUBJUNCTIVE);
// add("Des gens se sont fait attaquer. Il en a qui ont peur", "Some people got attacked. Some (of them) are afraid", EN);
            add("Il reste 2 semaines avant ma grande d??mo", "There are 2 weeks before my big demo", TEMPORAL);
            add("Elle a suffisamment de probl??mes sans avoir ?? s'inqui??ter pour moi", "She has sufficient problems without having to worry for me");
            add("Elle a ??t?? rappel??e sur Bajor", "She has been recalled to Bajor", AGREEMENT);
            add("Elle est morte depuis 15 ans", "She is dead since 15 years ago", TEMPORAL);
            add("Elle m'a laiss?? le faire", "She let me do it");
            add("Elle ne sait pas chanter ni jouer", "She can't sing nor act");
            add("Elles allaient ??tre furieuses", "They (f) were going to be furious", ALLER);
            add("Elles chuchotent entre elles", "They(f) whisper among themselves(f)");
            add("Enl??ve tes coudes de la table", "(tu) Take your elbows off the table");
            add("Et pour ceux qui ne seraient pas au courant", "And for those who wouldn't be up-to date ...");
            add("Fais attention ?? eux", "(tu) Pay attention to them");
            add("Faites entendre votre voix !", "Make your voice heard !");     // faire
            add("I only eat organic", "Je ne mange que du bio", DE);
            add("Il a la flemme de faire la lessive", "He can't be bothered to do the laundry"); 
            add("Il allait ??tre furieux", "He was going to be furious", ALLER);
            add("Il commence ?? faire froid", "It's starting to get cold");
            add("Il doit lui jeter des becs de corbeaux", "He must throw some crow beaks at her");
            add("Il faut se parler !", "Gotta talk to each other!");
            add("Il ne sait pas lire le fran??ais", "He can't read French");
            add("Il se croit parfait", "He believes he's perfect");
            add("Il semblerait que nous", "It would seem that we ...");
            add("Ils lui ont enlev?? une tumeur", "They removed a tumour from her");
            add("Ils ont tous ??t?? tu??s apr??s m'avoir parl??", "They were all killed after having spoken to me");
            add("Ils se sont servi de moi pour tenter de commettre un g??nocide", "They used me to try commit a genocide", PRONOMINAL);
            add("Ils vont couper le g??teau", "They are going to cut the cake");
            add("Ils vous attendent dans une heure", "They're expecting you in an hour");
            add("J'ai besoin d'y r??fl??chir", "I need to reflect on it");
            add("J'ai besoin de savoir ce qu'on fait", "I need to know what I/we're doing");
            add("J'ai d?? lui mettre de l'arnica sur les jambes", "I had to put arnica on his legs", PRONOMINAL);
            add("J'ai envie de me souvenir de ??a", "I (desire) to remember that", DE, PRONOMINAL);
            add("J'aurais d?? rester ?? ma place", "I should have stayed in my place");
            add("J'y vais !", "I'm going!", EXPR);                                    // expr
            add("Je crains qu'il faille lui remettre ce qu'il souhaite", "I fear it'll be necessary to deliver/hand-over to him what he wishes");
            add("Je crois en toi et je m'ennuie", "I believe in you(tu) and I'm bored");
            add("Je croyais que tu ??tais partie", "I thought that you(tu.f) had left");
            add("Je dois encore nettoyer par terre", "I must clean the floor again");
            add("Je dois me pr??parer au pire", "I must prepare myself for the worst");
            add("Je lui ai laiss?? voir mon inqui??tude", "I (did) let her see my anxiety");
            add("Je lui ai laiss?? voir que j'??tais inquiet", "I (did) let her see that I was worried");
            add("Je m'en vais !", "I'm off!");                                  // expr
            add("Je me fiche qu'ils aient voulu me tuer", "I don't care that they wanted to kill me", SUBJUNCTIVE);
            add("Je me rappelle avoir ??t?? pris d'une envie d'arracher mes v??tements", "I remember being taken by a desire to rip-off my clothes");
            add("Je me suis d??j?? fait avoir", "I've already been had/tricked", FAIRE);
            add("Je n'ai plus envie d'en parler", "I don't desire to talk about it any more", EN);
            add("Je n'aurais besoin que de six volontaires", "I would only need six volunteers");
            add("Je n'aurais pas d?? le dire", "I shouldn't have said it");
            add("Je n'en suis pas convaincu", "I'm not convinced of it", EN);
            add("Je ne crois pas que vous soyez totalement franc", "I don't think you're being entirely frank");
            add("Je ne mange que du bio", "I only eat organic", DE);
            add("Je ne savais pas que tu allais venir", "I didn't know you(tu) were going to come", ALLER);
            add("Je ne vous aurais jamais vus ensemble", "I would have never seen you together");
            add("Je pr??f??rerais partir plut??t que rester", "I would prefer to leave rather than staying");
            add("Je savais ce que je faisais", "I knew what I was doing");
            add("Je suis tomb?? sur un site", "I fell on a site", AGREEMENT);
            add("Je suis vraiment heureux de te revoir", "I'm really happy to see you(tu) again");
            add("Je vois venir un taxi", "I see a taxi coming");
            add("Je voudrais parler ??", "I'd like to speak to ...");
            add("L'homme a ouvert la porte", "The man opened the door");
            add("L'organisation m'a offert des chances que je n'aurais jamais cru possible", "The organisation offered me chances that I would have never thought possible");
            add("La banane n'est pas m??re", "The banana isn't ripe");
            add("La cerise sur le g??teau", "The icing on the cake... (expr.)");
            add("La fille est presque aussi grande que son fr??re", "The girl is nearly as tall as her brother");
            add("La mauvaise direction", "The wrong direction");
            add("Le barman vous sert la mauvaise boisson", "The barman serves you the wrong drink");
            add("Le film raconte l'histoire d'un jeune animal", "The film tells the story of a young animal");
            add("Le salon est la plus belle pi??ce de la maison", "The living room is the most beautiful room of the house");
            add("Les armes me mettent mal ?? l'aise", "Guns make me uncomfortable");
            add("Les gens portent plainte au si??ge", "People complain to head office");
            add("Les poubelles viennent d'??tre vid??es", "The dustbins have just been empted", AGREEMENT);
            add("Les ??tudiants prennent l'avantage", "The students take the advantage");
            add("Ma montre s'est arr??t??e", "My watch stopped", PRONOMINAL, AGREEMENT);
            add("Mais il finira par nous rejoindre", "But he will finish by rejoining us");
            add("Mais pourquoi auriez-vous besoin d'une pomme ?", "But why would you need an apple?");
            add("Me croyez-vous coupable ?", "(Do) you believe me guilty?");
            add("Merci de m'avoir mis dans la merde !", "Thanks for putting me in the **** !");
            add("Merci de ne pas tirer sur le pianist", "Thank you for not shooting the messenger (expr.)");
            add("Mes amis se parlaient encore", "My friends were still speaking (to each other)");
            add("Mets un peu de sel dans la soupe", "Put(tu) a bit of salt in the soup");
            add("N'est-il pas curieux que vous l'ayez supprim?? ici ?", "Is it not curious that you took-him-out here?");
            add("Ne laissez pas partir vos amis", "Don't let your friends leave");
            add("Ne laissez pas voir votre inqui??tude ?? votre femme", "Don't let your wife see that you are worried", PERCEPTION);
            add("Ne le laissez pas s'en approcher", "Don't let him go near it");
            add("Ne m'envoie pas ces notes", "Don't(tu) send me those notes");
            add("Nous avons ??t?? attaqu??s par les Cardassians", "We were attacked by the Cardassians");
            add("Nous les mangerons bient??t - elles ne sont pas m??res", "We'll eat them(bananas) soon - they're not ripe");
            add("Nous lui avons entendu dire que vous aviez renonc?? ?? votre voyage", "We heard him say that you had given up (on your plans) for a trip");
            add("Nous lui avons entendu dire que vous aviez tort", "We heard her say that you were wrong");
            add("Nous nous sommes ?? peine vus !", "We barely saw each other!", PRONOMINAL, AGREEMENT);
            add("Nous sentions venir un orage", "We were feeling a storm coming");
            add("On devrait rentrer", "I/We should head back");
            add("On devrait vraiment y aller", "One really should go");
            add("On dit que l'homme est fou", "(Unspecified)People say that the man is crazy");
            add("On les a tous eus", "I/we got them all", AGREEMENT);
            add("On ne devrait pas te virer", "You(tu) shouldn't be fired");
            add("Oui, je l'ai vu le leur donner", "Yes, I saw him give it to them");
            add("Pendant qu'elle cuisinait, nous lisions le journal", "While she used to cook, we used to read the newspaper", TEMPORAL);
            add("Phyllis se r??veille, ??a me plait", "Phyllis waking up, that pleases me");
            add("Plus les choses changent, plus elles restent les m??mes", "The more things change, the more they stay the same");
            add("Pour votre sant??, bougez plus !", "For your health, move more!");
            add("Pourquoi le champ de mines n'a-t-il pas ??t?? neutralis?? ?", "Why has the mine field not been neutralised?");
            add("Pourquoi nous aurait-il donn?? les noms des agents infiltr??s ?", "Why would he have given us the names of undercover agents?", CLITIC);
            add("Qu'est-ce que je suis cens?? faire maintenant ?", "What am I supposed to do now ?");
            add("Quand est-ce qu'elle va le recevoir ?", "When is she going to receive it ?");
            add("Quel est le bon ?", "Which is the right one ?");
            add("Quel fil est le bon ?", "Which wire is the right one ?");
            add("Quelle est la bonne phrase ?", "Which is the right phrase ?");
            add("Sa famille a d??m??nag?? de Paris", "His family has moved from Paris");
            add("Ses chaussures ne rentrent pas dans son sac", "Her shoes don't fit in her bag");
            add("Si j'avais livr?? des armes inutilisables, il m'aurait tu??", "If I had delivered some unuseable weapons, he would have killed me", CONDITIONAL);
            add("Soit vous les tuez, soit ils vous tuent", "Either you kill them, or they kill you");
            add("Super dommage que tu ne sois pas all?? plus loin", "Super shame that you(tu) didn't go further", SUBJUNCTIVE);
            add("Their nicknames", "leurs surnoms");                            // fauxami
            add("Thomas est jaloux que tu ne sois pas all?? manger ?? sa table !", "Thomas is jealous that you(tu) didn't go eat at his table!", SUBJUNCTIVE);
            add("Tiens-moi au courant", "Keep(tu) me posted (expr.)");
            add("Tous les jours, il regarde la t??l?? le midi pour suivre les informations", "Every day, he watches the TV at midday to follow the news/info");
            add("Tout le monde est content", "Everyone is pleased", TRAPS);
            add("Toutes les r??unions qu'on a eues ensemble", "All the meetings I/we had together", AGREEMENT);
            add("Tu as dit que tu dirigais la soci??t??", "(tu) You said you were running the company");
            add("Tu as tort", "(tu) You're wrong");
            add("Tu aurais pu penser", "You(tu) could have thought ...");       // cond
            add("Tu aurais pu", "You(tu) could have ...");                      // cond
            add("Tu devrais probablement lui courir apr??s", "You(tu) should probably run after her");
            add("Tu lui as menti", "You(tu) lied to her");
            add("Tu n'oserais pas", "You(tu) wouldn't dare");
            add("Tu ne commences pas encore", "(tu) You don't start yet");
            add("Tu ne me dois aucune explication", "You(tu) owe me no explanation");
            add("Tu ne peux pas me corrompre", "You(tu) can't corrupt me");
            add("Tu ne sais pas vraiment comment on est cens?? porter un b??b??", "You(tu) don't really know how one is supposed to carry a baby");
            add("Tu pourras vendre ton id??e", "You(tu) will be able to sell your idea");
            add("Tuer est aussi facile que respirer", "Killing is as easy as breathing");
            add("Un peu de temps, c'est tout qu'elle a jamais eu", "A bit of time, that's all she ever had");
            add("Une part de pizza", "A slice of pizza");
            add("Veulent-ils de la cr??me et/ou du sucre ?", "They want cream and/or sugar ?", DE);
            add("Vous auriez pu faire mieux !", "You could have done better!");
            add("Vous iriez vous plaindre ?? Sisko", "You will be going to complain to Sisko", PRONOMINAL);
            add("Vous n'auriez eu aucune chance", "You would never have had any chance");
            add("Vous n'??tiez pas cens??s nous voir", "You(pl) were not supposed to see us");
            add("Vous ne m'avez toujours pas r??pondu", "You still haven't answered me", CLITIC);
            add("Vous ont-ils donn?? une raison ?", "(Did) they give you a reason?", CLITIC);
            add("Vous savez ce qu'on dit", "You know what people say");
            add("Vous vouliez me voir", "You wanted to see me (and still do)");
            add("Y a-t-il des livres dans le placard ? Oui, il y en a, en haut ?? droite", "(Are) there some books in the cupboard? Yes, there are some, top right", EN);
            add("avoir", "visiter auxilary");
            add("Je suis si heureux que tu aies voulu me revoir", "I am so happy that you(tu) wanted to see me again", SUBJUNCTIVE);
            add("jouer de la musique", "to play music");
            add("pour autant que je me souvienne", "for as far as i remember (expr.)");
            add("pour que les choses soient claires", "so that things are clear", SUBJUNCTIVE);
            add("que tu n'auras jamais", "...that you(tu) will ever have");
            add("??tes-vous s??r de vouloir supprimer cette page ?", "Are you sure you want to delete this page ?");
            add("?? l'h??pital", "to the hospital(m)");                           // ??
            add("?? trois heures du matin, je suis rentr?? chez moi", "At three in the morning, I went home");
            add("??a n'a pas d?? ??tre facile", "That mustn't have been easy", CLITIC);
            add("??a te dit ?", "Does that sound good to you(tu)? (expr.)");
            add2("J'ai besoin de l'ordinateur - J'ai besoin de sucre - J'ai besoin du t??l??phone", "I need the computer - I need some sugar - I need the telephone", DE);
            add2("J'ai lu trois livres - J'en ai lu trois", "I read three books - I read three |books|", EN);
            add("Je n'ai pas envie de me coucher en etant fach??e", "I(f) have no desire to go to bed while annoyed", PARTICIPLE);
            add("Elle a repouss?? la f??te de son anniversaire", "She put back/delayed the celebration of her birthday");
            //add("Si le president voulait qu'on s'en m??le, il nous le ferait savoir", "If the president was wanting us to meddle in it, he would make us know it");
            add("Je crois que tu aurais d?? attendre des preuves plus solides", "I believe you(tu) should have waited for more solid proof");
            add("C'est dommage que je me sois senti si fatigu??", "It's (c'est) a shame I felt so tired", SUBJUNCTIVE);
            add("Martine va apprendre ?? Karim ?? chanter", "Martine is going to teach Karim to sing", FAIRE);
            //addCompound(CONDITIONAL,
            //        "Pourquoi les Romulans voudraient-ils votre mort ? - Pourquoi les Romulans vous voulaient-ils morts ?",
            //        "(Why) would the Romulans want your death? - (Why) were the Romulans wanting you(pl) dead?");
            addCompound(CONDITIONAL,
                    "Pourquoi auraient-ils d??truit ce vaisseau ? - Pourquoi d??truiraient-ils ce vaisseau ?",
                    "(Why) would they have destroyed that ship? - (Why) would they destroy that ship?");
            addCompound(
                    "Tu aurais eu raison - Tu aurais raison",
                    "You(tu) would have been right - You(tu) would be right");
            addCompound(
                    "??a aurait ??t?? avec plaisir - ??a serait avec plaisir",
                    "That would have been with pleasure - That would be with pleasure");
            addCompound(CLITIC,
                    "??a t'a plu - ??a vous a plu",
                    "That pleased you(tu) - That pleased you");
            addCompound(DE,
                    "La moiti?? du g??teau - Le tiers du lait",
                    "Half of the cake - Third of the milk");
            addCompound(
                    "Il construit un mur en briques - Ils construisent un mur en briques",
                    "He builds a brick wall - They build a brick wall");
            addCompound(
                    "N'aie pas peur, sois heureux - N'ayez pas peur, soyez heureux",
                    "Don't be scared(tu), be happy - Don't be scared, be happy");
            addCompound(
                    "J'ai d??cid?? d'??crire - Je me suis d??cid?? ?? ??crire",
                    "I decided to write - I made up my mind to write");
            addCompound(
                    "Eux aussi veulent venir - Lui aussi veut venir",
                    "*They* also want to come - *He* also wants to come");
            addCompound(
                    "Ils choisissent un film - nous choisissons de la musique",
                    "They choose a film - we choose some music");
            addCompound(
                    "J'ai cru t'avoir vue - J'ai cru que je t'ai vue",
                    "I believed in having seen you(tu.f) - I believed that I saw you(tu.f)");
            addCompound(
                    "Les fleurs qui sont jolies - Les fleurs que j'ai achet??es",
                    "The flowers which are pretty - The flowers which I booughr");
        }
        
        // GRAMMAIRE EXPLIQU??E DU FEANCAIS
        {
            // p39
            add("Dans l'entreprise, c'est la s??cretaire du directeur qui s'occupe du courrier", "In the company, it's the director's secretary who deals with the post", DE);
            add("Ne reste pas trop longtemps au soleil", "Don't (tu) stay too long in the sun");
            
            // P40
            add("Elle a les cheveux longs", "She has long hair", DE);
            add("Les enfants, brossez-vous les dents !", "Children, brush your teeth !", PRONOMINAL);
            add("Lave-toi les mains", "Wash your(tu) hands");
            add("Avant de partir, il m'a serr?? la main", "Before leaving, he shook my hand");
            
            // P42
            add("Je suis au r??gime", "I am on a diet");
            add("J'ai besoin de sel", "I need some salt", DE);
            addCompound(DE,
                    "Fait-elle de la gymnastique ? - Elle ne fait pas de gymnastique",
                    "(Does) she do gymnastics? - She doesn't do gymnastics");
            addCompound(DE,
                    "Voulez-vous du sucre ? - Je ne prends pas de sucre",
                    "(Do) you want some sugar ? - I don't take sugar");
            addCompound(DE,
                    "De l'??nergie ? - Je n'ai plus d'??nergie",
                    "Motivation? - I have no more motivation");
        }
        
        // GENERIC ARTICLES
        {
            addCompound(
                    "J'aime bien la glace - J'aime bien de la glace",
                    "I like ice-cream - I like some ice-cream");
            addCompound(
                    "J'aime bien le lait - J'aime bien du lait",
                    "I like milk - I like some milk");
            addCompound(
                    "J'aime bien les fraises - J'aime bien des fraises",
                    "I like strawberries - I like some strawberries");
        }
        
        // MISC VERBS
        {
            add("tenir", "to retain", "to hold");
            add("parier", "to bet", "to wager");
            
            add("J'ai ??teint mon portable", "I've turned my phone off");
            add("??teignez vos portables", "Switch your phones off");
            
            add("Tu te trompes", "You(tu) are mistaken", PRONOMINAL);
            add("Tu t'es tromp??", "You(tu) were mistaken", PRONOMINAL);
            add("Vous vous trompez", "You are mistaken", PRONOMINAL);
            add("Vous vous ??tes tromp??", "You were mistaken", PRONOMINAL);
            
        }
        
        
        add("appartenir ??", "(v.) belongs to");
        {
            add("Ma vie m'appartient", "My life belongs to me/is mine");
            add("La d??cision t'appartient", "The decision belongs to you(tu)");
            //pour des raisons qui m'appartiennent   for my own reasons
//l'??ducation des enfants appartient aux deux parents   bringing up children is the responsibility of both parents
//(tournure impersonnelle)
//il appartient ?? chacun de faire attention   it's everyone's responsibility to be careful
            add("Il ne vous appartient pas d'en d??cider", "It's not for you to decide |it|");
        }
        
        // ADVERBS
        {
            add("Il marchait assur??ment vers le ring", "He was walking assuredly towards the (boxing) ring");
        }
        
        // A POSSESSION
        {
            add("Quel livre est ?? toi ?", "Which book is yours(tu) ?");
            add("Ce stylo est ?? moi", "This pen is mine");
            add("Ce stylo est le mien", "This pen is my one");
            add("Ce stylo est le tien", "This pen is your(tu) one");
        }
        
        // A QUEL POINT
        {
            add("?? quel point", "*just how* (eg: You see just how tired I am)");
            add("Tu ne sais pas ?? quel point il peut ??tre dangereux", "You(tu) don't know just how dangerous he can be");
            add("Je ne vous ai jamais dit ?? quel point je suis d??sol?? pour Ziyal", "I never said to you at just how sorry I am for Ziyal");
        
        }
        
        // ARRIVER
        {
            add("Beaucoup de choses peuvent arriver, comme on a vu", "A lot of things can happen, as I/we have seen");
            add("Comment ??a a pu arriver ?", "How could that happen ?");
            add("Il arrivera ?? midi", "He will arrive at noon");
            add("Il est arriv?? ?? la conclusion", "He arrived at the conclusion");
            add("Je continuerai d'ignorer ce qui lui arrive jusqu'?? la fin", "I will continue to ignore what's happening to him until the end");
            add("Je n'arrive pas ?? l'oublier", "I can't manage to forget it");
            add("Je n'arrive pas ?? me concentrer", "I can't manage to concentrate");
            add("Je ne suis pas arriv?? ?? le faire", "I couldn't manage to do it (expr.)");
            add("Je peux y arriver", "I can manage it (expr.)", Y);
            add("Je suis arriv?? ?? le faire", "I managed to do it (expr.)");
            add("Les stylos sont arriv??s !", "The pens happened!");
            add("Qu'allait-il lui arriver ?", "What was going to happen to her ?", ALLER, CLITIC);
            add("Qu'est-ce qui m'arrive ?", "What's happening to me ?", PRONOMINAL);
            add("Tout peut arriver", "Anything can happen ...");
            add("??a arrive parfois", "That happens occasionally");
            add("??a n'arrive presque jamais", "That hardly every happens");
            add("??a vient d'arriver", "It has just happened");
        }
        
        // ASSEZ
        {
            add("Je suis assez fatigu??", "I am rather tired");
            add("La situation est assez inqui??tante", "The situation is quite worrisome");
            add("As-tu mang?? assez de g??teau ?", "(Have) you(tu) eaten enough cake ?");
        }
        
        // ASSISTER
        add("assister ??", "(v.) to attend");
        {
            add("Nous assistons au match", "We're attending the match");
            add("We attend the match", "Nous assistons au match");
            add("J'assisterai ?? l'op??ration", "I will attend the operation");
        }
        
        // AUSSITOT
        {
            add("aussit??t que", "... as soon as ...");
            add("aussit??t dit, aussit??t fait", "No sooner said than done (expression)");
            add("Il est venu aussit??t apr??s mon appel t??l??phonique", "He came straight after my telephone call");
            add("Nous allons manger aussit??t qu'il arrivera", "We're going to eat as soon as he arrives");
            add("Aussit??t que j'aurai 21 ans, je prendrai ma retraite", "As soon as I'm 21, I will retire");  
            add("Nous allons manger aussit??t qu'il arrivera", "We're going to eat as soon as he arrives");
        }
        
        // AUTANT
        {
            add("J'ai autant de fr??res que lui", "I have as many brothers as he does");
            add("Mangez autant que vous voulez", "Eat as much as you want");
            add("Ce g??teau co??te autant que cette tarte", "This cake costs as much as this tart");
            add("Je veux autant de lait que toi", "I want as much milk as you(tu)");
            add("La pomme p??se presque autant que l'orange", "The apple weighs nearly as much as the orange");
            add("autant", "as much (+verb)", "as many (+verb)");
            add("Faites autant que vous pouvez", "Do as much as you can");
            add("Je travaille toujours autant", "I work as much as always");
            add("autant de", "as much (+noun)", "as many (+noun)");
            add("Il a autant d'amis que toi", "He has as many friends as you(tu)");
            add("Ma maison a autant d'espace", "My house has as-much space");
            add("Il a mang?? autant que toi", "He ate as much as you(tu))");
            add("C'est pour lui autant que pour toi", "It's for him as much as for you(tu))");
            add("Ils auront fini quand vous arriverez", "They will have finished when you arrive");
            // add("Il est sympathique autant qu'intelligent", "He is as nice as he is intelligent");
            add("J'ai mang?? autant que toi", "I ate as much as you(tu)");
            add("Pourquoi travaillez-vous autant ?", "Why (do) you work so much?");
            add("Elle mange autant que lui", "She eats as much as him");
            add("J'ai autant de puissance que lui", "I have as much (physical)power as him");
            add("Il ne l'aime pas tant que ??a", "He doesn't love it as much as that");
            add("??vitez de toucher, autant que possible", "Avoid touching, as much as possible");
            add("Pas autant que moi !", "Not as much as me !");
            add("Alors, ils ont autant de droits que les jeunes ?", "So, they have as much rights as the young?");
            add("J'ai fait autant d'effort que possible", "I made as much effort as possible");
            add("Si j'avais cr???? un site avec autant de probl??mes, je me suiciderais", "If I had created a site with as many problems, I would kill myself", CONDITIONAL);
            add("Honn??tement, si tu passais autant de temps ?? vendre", "Honestly, if you(tu) spent as much time selling ... (you would)", CONDITIONAL);
        }
        
        // CASSER
        {
            add("J'ai cass?? deux verres hier", "I broke two glasses yesterday");
            add("Je me suis cass?? la jambe", "I broke my leg", PRONOMINAL, AGREEMENT);
            add("Je me suis cass?? les jambes", "I(f) broke my legs", PRONOMINAL, AGREEMENT);
            add("Elle s'est cass?? la jambe", "She broke her leg", PRONOMINAL);
            add("Elle s'est coup?? le doigt", "She cut her finger", PRONOMINAL);
        }
        
        // CENSER
        {
            add("Il est cens?? ??tre mort", "He is supposed to be dead");
        }
        
        // CHOISIR
        {
            add("Je choisis de porter des sandales", "I choose to wear sandals");
        }
        
        // A versus DE
        {
            add("Une tasse ?? th??", "A teacup");
            add("Une tasse de th??", "A cup of tea");
            add("Un verre ?? vin", "A wine glass");
            add("Un verre de vin", "A glass of wine");
            add("Un sandwich au jambon", "A ham sandwich");
            add("Une tarte aux pommes", "An apple pie");
            add("La soupe de tomates", "The tomato soup", DE);
            add("Le jus d'orange", "The orange juice", DE);
            add("un pi??ge ?? fourmis", "an ant trap");
        }
        
        // CLITIC ORDER
        push(CLITIC, () ->
        {
            add("Il l'avait fait plusieurs fois", "He had done it multiple times");
            add("Il n'a jamais r??pondu ?? la lettre", "He never answered the letter");
            add("Il ne l'a pas r??par??", "He didn't fix it");
            add("Il nous a vus", "He saw us");
            add("J'en ai lu dix", "I did read ten of them", EN);
            add("Je l'ai fait", "I did it");
            add("Je l'ai vue", "I saw her");
            add("Je la lui ai donn??e", "I gave |the tart| to him");
            add("Je la lui ai donn??e", "I gave |the tart| to |Marie|");
            add("Je le lui ai donn??", "I gave |the cake| to him");
            add("Je les ai vues", "I saw them (f)", AGREEMENT);
            add("Je les ai vus", "I saw them", AGREEMENT);
            add("Je les leur ai donn??es", "I gave |the cars| to |Marie and Steve|", AGREEMENT);
            add("Je n'ai pas ??tudi??", "I didn't study");
            add("Je n'ai rien pr??par??", "I didn't prepare anything");
            add("Je n'ai vu personne", "I didn't see anyone");
            add("Je ne l'ai pas fait", "I didn't do it");
            add("Je ne l'ai trouv?? nulle part", "I didn't find it anywhere");
            add("Je ne les ai pas vus", "I didn't see them");
            add("Je ne te l'ai pas donn??", "I didn't give it to you(tu)");
            add("Je te l'ai donn??", "I gave it to you(tu)");
            add("L'avez-vous entendue parler fran??ais ?", "Did you hear her speaking French ?", AGREEMENT);
            add("Le gar??on n'a pas pu manger", "The boy wasn't able to eat");
            add("Les a-t-elle vus ?", "(Did) she see them ?");
            add("Les avez-vous entendus parler fran??ais ?", "Did you hear them speaking French ?", AGREEMENT);
            add("Nous a-t-elle parl?? ?", "(Did) she speak to us ?");
            add("Nous en avons choisi", "We chose some", EN);
            add("Nous n'aurions jamais su", "We would have never known");
            add("Nous n'avons pas fini le travail", "We didn't finish the work");
            add("Nous n'y serions jamais all??s", "We would never have gone there");
            add("Nous y serons all??s", "We will have gone |there|", Y);
            add("Vous a-t-il parl?? de cette affaire ?", "Has he spoken to you of this matter ?");
            addCompound("Je ne leur ai pas parl?? - Je ne lui ai pas parl??", "I didn't speak to them - I didn't speak to her");
            addCompound(AGREEMENT, "Je lui ai parl?? - Je leur ai parl??", "I spoke to her - I spoke to them");
            addCompound(EN,
                    "Vous en voulez ? - En voulez-vous ?",
                    "You want some? - (Do) you want some?");
            addCompound(EN,
                    "T'en veux ? - En veux-tu ?",
                    "You(tu) want some? - (Do) you(tu) want some?");
            add("Combien en voulez-vous ?", "How much of them do you want ?", EN);
            add("J'en voudrais un kilo", "I would like a kilo of them", EN);
            add("Je les ai d??j?? compt??s - j'en ai deux", "I already counted them - I have two", EN);
            add("N'as-tu rien mang?? ?", "Didn't you(tu) eat anything ?");
            addCompound(
                    "A-t-il attendu les autres ? - N'a-t-il pas attendu les autres ?",
                    "(Did) he wait for the others ? - Didn't he wait for the others ?");
            add("Quelles robes a-t-elle choisies ?", "Which dresses did she choose ?");
            add("Pourquoi n'??tes-vous pas venu ?? notre rendez-vous ?", "Why didn't you come to our appointment?");
            add("Je n'y suis jamais all??", "I've never been there");
            add("Tu devrais le savoir", "You(tu) should know that");
            add("Il l'a fait juste rire", "He just(only) made her laugh");
            add("Pourquoi il la fait autant rire ?", "Why is he making her laugh as much ?");
            add("Dis-le !", "(tu) Tell it!");
            add("Dis-lui !", "(tu) Tell him!");
            add("Dis-le-lui !", "(tu) Tell it to him!");
            addCompound("Tell it! - Tell him!", "Dis-le ! - Dis-lui !");
            addCompound("Show it! - Show him!", "Montre-le ! - Montre-lui !");
            addCompound("Oublie-moi - Ne m'oublie pas", "(tu)Forget me - (tu)Don't forget me");
            addCompound("Parlez-moi - Ne me parlez pas", "Speak to me - Don't speak to   me");
            // DUAL VERB CONSTRUCTIONS
            {
                add("Elle me dit de les lire", "She tells me to read them");
                add("Elle n'essaie jamais de me comprendre", "She never tries to understand me");
                add("Elles ne veulent jamais nous aider", "They(f) never want to help us");
                add("Je ne peux pas te dire de le voir", "I can't tell you(tu) to see him");
                add("Je ne vous demanderai pas de le faire", "I won't ask you to do it");
                add("Je vous aiderai ?? l'emballer", "I'll help you pack it");
                add("Il me dit de le trouver", "He tells me to find it");
                add("Il ne doit pas conduire", "He mustn't drive");
                add("Il ne va pas voyager", "He's not going to travel");
                add("Il veut nous en parler", "He wants to talk to us about it", EN);
                add("N'esp??rez-vous pas le voir ?", "Don't you hope to see him?");
                add("Ne voulez-vous pas les connaitre ?", "Don't you want to know them?");
                add("Nous ne pouvons rien faire", "We can't do anything");
                add("Nous ne voulons rien manger", "We don't want to eat anything");
                add("Tu ne vas pas sortir", "You're(tu) not going to go out");
                add("Tu peux m'aider ?? les laver", "You(tu) can help me wash them");
                add("Tu peux nous en parler", "You(tu) can tell us (about it)", EN);
                add("Paul d??teste leur ??crire", "Paul hates writing to them");
            }
            // IMPERATIVE
            {
                add("Ne finis pas !", "(tu) Don't finish !");
                add("Ne le finis pas !", "(tu) Don't finish it !");
                add("Ne lisez pas !", "Don't read !");
                add("Allons-y !", "Lets (us) go !");
                add("Mangez-les !", "Eat them !");
                add("Donne-lui-en !", "(tu) Give him some !");
                add("Envoie-le-nous !", "(tu) Send it to us !");
                add("Expliquons-le-leur !", "Let's explain it to them !");
                add("Donnez-nous-en !", "Give us some !", EN);
                add("Donne-le-moi !", "(tu) Give it to me !");
                add("Finis-le !", "(tu) Finish it!");
                add("L??ve-toi !", "(tu) Get up !", PRONOMINAL);
                add("Parlez-moi !", "Talk to me !");
                add("Dis-moi !", "(tu) Tell me !");
                add("Ne le mangez pas !", "Don't eat it!");
                add("Ne te d??peche pas !", "(tu) Don't you rush !");
            }
            add("Je n'y suis pas all??", "I didn't go there");
            add("Il ne le saura jamais", "He is never going to find (it) out");
            add("J'aurais pu l'arr??ter", "I could have stopped him");
            add("Combien d'animaux dessine-t-il ?", "How many animals is he drawing ?");
            add("Combien d'animaux a-t-il dessin??s ?", "How many animals did he draw ?");
            add("T'es-tu habill?? tout seul ?", "(Did) you(tu) got dressed alone?");
            add("Je ne t'en ai pas parl??", "I didn't tell you(tu) about it", EN);
            add("Pourquoi ont-ils dit oui ?? la vie monastique ?", "Why (did) they say yes to the monastique life ?");
            add("Dis-le-moi", "(tu) Tell me that");
            add("Dis-le-nous", "(tu) Tell us that");
            add("Dis-le-eux", "(tu) Tell them that");
            add("Je n'aime pas ta coupe, tu te l'es faite ?", "I don't like your(tu) cut, you did it (to you)?"); 
            add("Il va la lui pr??senter", "He is going to introduce his |friend(f)| to |his brother|");
            add("Elle les lui a expliqu??s", "She explained them to him", AGREEMENT);
            addCompound(
                    "Tu te l'es faite ? - Te l'es-tu faite ?",
                    "You(tu) did her (to you)? - (Did) you(tu) do her(to you)?");
            addCompound("A-t-il mang?? ? - N'a-t-il pas mang?? ? - Il n'a pas mang??", "(Did) he eat? - (Did)n't he eat? - He didn't eat");
            addCompound(
                    "A-t-elle nag?? ? - N'a-t-elle pas nag?? ? - Elle n'a pas nag??",
                    "(Did) she swam? - (Did)n't she swim? - She didn't swim");
            addCompound(
                    "Il va me la pr??senter - Il va me lui pr??senter",
                    "He is going to introduce his |friend(f)| to me - He is going to introduce me to his |friend(f)|");
            addCompound(
                    "Il va nous la pr??senter - Il va nous lui pr??senter",
                    "He is going to introduce his |friend(f)| to us - He is going to introduce us to his |friend(f)|");
            addCompound(
                    "Il va nous les pr??senter - Il va nous leur pr??senter",
                    "He is going to introduce his |friends(f)| to us - He is going to introduce us to his |friends(f)|");
            addCompound(
                    "Il va la leur pr??senter - Il va les lui pr??senter",
                    "He is going to introduce his |friend(f)| to his |parents| - He is going to introduce his |parents| to his |friend(f)|");
            addCompound(PRONOMINAL,
                    "Comment s'appelle-t-il ? - Comment s'appelle-t-elle ?",
                    "(What)'s he called? - (What)'s she called?");
            add("Vous n'y ??tes jamais arriv??", "You never arrived there");
            add("Le Dominion est-il f??ch?? ?", "(Is) the Dominion angry?");
            add("Comment l'ai-je contract??e ?", "(How) did I contract |the illness|?", AGREEMENT);
            add2(   "Tu ne la connais pas - La connais-tu ? - Ne la connais-tu pas ?",
                    "You(tu) don't know her - (Do) you(tu) know her? - (Don't) you(tu) know her ?");
            add2(   "Tu l'as connue - L'as-tu connue ? - Tu ne l'as pas connue - Ne l'as-tu pas connue ?",
                    "You(tu) knew her - (Did) you(tu) know her? - You(tu) didn't know her - (Didn't) you(tu) know her?");
        });
        
        // CONCENTRER
        {
            add("Je dois me concentrer", "I must concentrate", PRONOMINAL);
            add("Laissez-moi me concentrer", "Let me concentrate", PRONOMINAL);
            add("J'ai eu du mal ?? me concentrer", "I have been having trouble concentrating", PRONOMINAL);
            add("Concentre-toi !", "(tu) Concentrate!", PRONOMINAL);
        }
        
        // DAPRES
        {
            //add("d'apr??s les gens de ce site qui ont un cerveau", "based on people of this site who have a brain");
        }
        
        // DE
        push(DE, () ->
        {
            // Articles d??finis : DE + LE -> DU ; DE + LA -> DE LA ; DE + LES -> DES
            add("du", "de + le");
            add("de la", "de + la");
            add("des", "de + les");
            add("de l'", of("de + le + vowel", "de + la + vowel", "du + vowel", "de la + vowel"), DE);
            // Articles ind??finis : DE + UN -> D'UN ; DE + UNE -> D'UNE ; DE + DES -> DE
            add("d'un", "de + un");
            add("d'une", "de + une");
            add("de", "de + des");
            add("J'ai besoin de chaises", "I need some chairs"); // de + des (chaises) = DE
            // Articles partitifs : DE + DU -> DE ; DE + DE LA -> DE.
            add("d'", "de + vowel");
            add("de", "de + du");
            add("de", "de + de la");
            add("de", "de + des");
            //
            add("du", "... some + noun(m)");
            add("J'ai eu du beurre", "I had some butter");
            add("de la", "... some + noun(f)");
            add("J'ai eu de la chance", "I had some luck");
            add("de l'", "... some + vowel + noun(m)", "... some + vowel + noun(f)");
            add("J'ai eu de l'argent", "I had some money");
            add("J'ai eu de l'??lectricit??", "I had some electricity");
            add("des", "... some + noun(m.pl)", "... some + noun(f.pl)");
            add("J'ai eu des chemises", "I had some shirts");
            //
            add("d'", "of + vowel + noun(m)", "of + vowel + noun(f)");
            //
            
            add("Fais de beaux r??ves", "Have nice dreams (tu)");
            add("de la fen??tre", "from the window", DE);
            add("des objets de tous les jours", "some every-day objects");
            add("Nous ne voudrions pas de lait", "We wouldn't like any milk");
            add("Nous n'avons pas de voiture", "We don't have a car", DE);
            add("Tu as de la chance - tu as vachement de chance !", "You're(tu) lucky - you're bloody lucky !", DE);
            add("Paris est la capitale de la France", "Paris is the capital of France", DE);
            add("Le train va de Paris ?? Bordeaux", "The train goes from Paris to Bordeaux", DE);
            add("J'ai arr??t?? de fumer", "I stopped smoking", DE);
            add("Elle m'a dit de venir", "She told me to come", DE);
            add("Nous vous proposons de venir", "We suggest you to come", DE);
            add("Combien de voitures avez-vous ?", "How many cars (do) you have ?", DE);
            add("Combien d'enfants voulez-vous ?", "How many children (do) you want ?", DE);
            addCompound(
                    "Je n'ai pas de pommes - J'ai achet?? des pommes",
                    "I don't have any apples - I bought some apples");
            addCompound(
                    "J'ai besoin de pommes - J'ai besoin d'une pomme",
                    "I need apples - I need an apple");  // Partative
            addCompound(
                    "J'ai besoin de lait - J'ai besoin du lait qui est sur la table",
                    "I need milk - I need the milk that is on the table");
            add("J'ai besoin de la pomme qui est sur la table", "I need the apple that's on the table"); // Definite
            add("J'ai besoin d'une jolie robe noire", "I need a pretty black dress", DE);
            add("J'ai besoin de la jolie robe noire que j'ai vue dans une boutique hier", "I need the pretty black dress I saw in a (small)store yesterday", DE);
            // http://forum.wordreference.com/showthread.php?t=869396
            addCompound("Je veux le pain - Je veux du pain - J'ai besoin du pain - J'ai besoin de pain", "I want the bread - I want some bread - I need the bread - I need some bread");
            addCompound("Je veux la soupe - Je veux de la soupe - J'ai besoin de la soupe - J'ai besoin de soupe", "I want the soup - I want some soup - I need the soup - I need some soup");
            addCompound("Je veux les pommes - J'ai besoin des pommes", "I want the apples - I need the apples");
            addCompound("Je veux des pommes - J'ai besoin de pommes", "I want some apples - I need some apples");
            addCompound("Je veux des oranges - J'ai envie d'oranges", "I want some oranges - I wish for some oranges");
            addCompound("Je veux des vacances - J'ai envie de vacances", "I want some holidays - I wish for some holidays");
            // http://uk.answers.yahoo.com/question/index?qid=20100419110455AAsWNpl
            add("J'ai bu de l'eau", "I drank some water");
            add("J'ai bu du vin", "I drank some wine");
            add("J'ai bu de la bi??re", "I drank some beer");
            add("J'ai bu une bouteille d'eau", "I drank a bottle of water");
            add("J'ai bu une bouteille de vin", "I drank a bottle of wine");
            add("J'ai bu une bouteille de bi??re", "I drank a bottle of beer");
            //
            addCompound("J'ai du travail - J'ai d?? travailler", "I've got some work - I had to work");
            addCompound("Elle a de l'argent - Elle n'a pas d'argent", "She has some money - She has no money");
            addCompound("J'ai des g??teaux - J'ai de bons g??teaux", "I have some cakes - I have some good cakes");
       });
        
        // DEMANDER
        add("demander", "(v.) to ask");
        {
            add("se demander", "(v.) to wonder", "(v.) to ask oneself");
            add("demander ?? voir quelqu'un", "(v.) to ask to see someone");
            add("Il est facile de demander aux gens", "It is easy to ask people");
            add("Il m'a demand?? pourquoi", "He asked me why");
            add("Je vais demander un stylo ?? Michel", "I'm going to ask Michel for a pen");
            add("Puis-je te poser une question ?", "Can I ask you(tu) a question?");
            add("Marc s'est demand?? pourquoi", "Marc wondered why", PRONOMINAL);
            add("J'ai demand?? ?? la lune et le soleil ne le sait pas", "I asked the moon and the sun doesn't know about it");
        }
        
        // DEVOIR
        {
        }
        
        add("dresser", "(v.) to train (animal)", "(v.) to tame (animal)");
        
        // DONT
        {
            add("dont", "|of which|", "|of whom|", "whose", DONT);
            add("Voici le livre dont tu as besoin", "Here is the book you(tu) need", DONT);
            add("O?? est le re??u dont j'ai besoin ?", "Where is the receipt I need?", DONT);
            add("C'est la dame dont j'ai parl??", "That's the woman(dame) whom I talked about", DONT);
            add("Voici l'homme dont j'ai trouv?? la valise", "Here is the man whose suitcase I found", DONT);
            //TODO Je cherche le livre. Tu as arrach?? une page de ce livre.
            //TODO Je cherche le livre dont tu as arrach?? une page.
            //TODO I'm looking for the book out of which you tore a page, the book (that) you tore a page out of.
            add("J'ai lu plusieurs livres la semaine derni??re, dont le tien", "I read several books last week, including your's(tu)", DONT);
            add("Vous rappelez-vous ce dont je vous ai parl?? ?", "(Do) you recall that of which I spoke to you?", DONT, PRONOMINAL);
            //add("Quel est le pays dont provient cette marchandise suspecte ?", "What is the country from which comes the suspicious merchandise?");
            //add("La maladie dont il est mort porte un nom impronon??able", "The disease of which he died has an unpronounceable name");
            add("Il a ??crit trois livres, dont deux sont des best-sellers", "He has written three books, two of which are best sellers", DONT);
            add("Il a eu dix enfants, dont neuf filles", "He had ten children, nine of them girls", DONT);
            //add("Probablement plus avanc?? que ce dont vous avez l'habitude", "Probably more advanced than which you are used to");
            add("La v??tre est la seule signature dont j'ai besoin", "Your's is the only signature I need", DONT);
            add("En fait, il n'y a personne dont l'anniversaire soit proche", "Actually, there is nobody whose birthday is close", DONT);
            //add("Il y a quelque chose d'autre, dont je voudrais de te parler", "There is something else, that I would like to talk to you about");
            add("C'est un homme dont je n'attends rien de bon", "It's a man of whom I don't expect any good", DONT);
            add("Il y a une chose dont je ne me rends pas compte", "There is one thing I don't realise ...", DONT);
            add("Ma femme a un probl??me dont nous devons nous occuper", "My wife has a problem that we must handle", DONT);
        }
        
        // DU COUP
        {
            add("Il est arriv?? en retard hier. Du coup, il doit travailler jusqu'?? 19h ce soir", "He arrived late yesterday. As a result, he has to work until 7 this evening");
            add("J'ai oubli?? mon portefeuille et du coup j'ai emprunt?? 5 euros ?? Philippe", "I forgot my wallet and so[expression] I borrowed 5 euros from Philippe");
        }
        
        // EN versus A
        {
            add("J'ai fait une randonn??e ?? v??lo", "I did a bike trek");
            add("en voiture", "... by car");
            add("en train", "... by train");
            add("en a??roglisseur", "... by hovercraft");
            add("?? pied", "... by foot");
            add("?? v??lo", "... by bike");
        }
        
            add("en vie", "alive");
            add("en gros", "in a nutshell", "in summary");
            add("Je vais la chercher", "I am going to look for it (my mouse)", EN);
            add("Je vais la manger", "I am going to eat |the tart|", EN);
            add("Penses-y !", "(tu) Think about it!");
        push(EN, () ->
        {
            add("Combien en voulez-vous ?", "How much (do) you want ?", EN);
            add("Combien de lait est-ce que tu veux ?", "How much milk do you(tu) want?", EN);
            add("J'aimerais en avoir encore", "I would like to have more", EN);
            add("Je vais m'en souvenir", "I am going to remember that", EN);
            add("Je vais en manger", "I am going to eat |some ice-cream|", EN);
            add("Nous en avons choisi", "We chose some (tarts)");
            add("Nous en avons vu", "We saw some (tarts)");
            add("J'ai envie de refaire de l'escalade", "I wish to re-try some climbing", EN);
            add("J'ai envie d'en refaire", "I wish to re-try it (some climbing)");
            add("Avez-vous des enfants ? Oui, j'en ai deux", "Have you any children? Yes, I have two");
            add("Avez-vous des enfants ? Non, je n'en ai pas", "Have you any children? No, I don't");
            //add("Voulez-vous du sucre dans votre caf?? ? Oui, j'en veux bien");
            add("As-tu achet?? une voiture ? Oui, j'en ai achet?? une", "(Did) you(tu) buy a car? Yes, I bought one", EN);
            add("Laisses-en pour les autres", "(tu) Leave some for the others");
            add("Ach??tes-en !", "(tu) Buy some!");
            add("Je ne veux plus en reparler", "I don't want to re-talk about it any more");
            add("J'en ai identifi?? dix jusqu'?? maintenant", "I have identified ten of them as yet");
            add("Je ne sais pas m'en servir", "I don't know how to make use of it", PRONOMINAL);
            add("J'en parle", "I am talking about it");
            add("J'en viens", "I come |from France|");
            add("Non, je n'y travaille plus", "No, I do not work there anymore");
            add("J'en ai bu", "I drank some |apple juice|");
            add("Je n'en ai pas vu", "I did not see |any cows|");
            add("J'en ai mang?? une", "I ate one");
            //?? J'ai mang?? quelques pommes. ?? ??? J'en ai mang?? quelques-unes. ("I ate a number of apples." ??? "I ate a number of them.")
            add("J'en ai vendu beaucoup", "I sold a lot |of apple juice|", "I sold a lot");
            //?? J'ai achet?? trois kilogrammes de pommes. ?? ??? ?? J'en ai achet?? trois kilogrammes. ?? ("I bought three kilograms of apples." ??? "I bought three kilograms.")
            add2("Tu t'en sors - T'en sors-tu ?", "You(tu) are getting out of it (expr.) - (Are) you(tu) getting   out of it? (expr.)", CLITIC);
            add2("Tu t'en es sorti - T'en es-tu sorti ?", "You(tu) got out of it (expr.) - (Did) you(tu) got out of it? (expr.)", CLITIC);
            addCompound(EN,
                    "J'en ai quinze - Je n'en ai pas",
                    "I have fifteen of them - I don't have any of them");
        });
        
        // EMPRUNTER
        {
            add("J'ai d?? emprunter de l'argent", "I had to borrow some money", DE);
            add("Il a emprunt?? une voiture ?? son fr??re", "He borrowed a car from his brother");
        }

        // ENTENDRE
        push(PRONOMINAL, () ->
        {
            add("Nous nous entendons tr??s bien", "We get along very well with each other");
            add("Je m'entends bien avec elle", "I get along well with her");
            add("Elle s'entend bien avec moi", "She gets on well with me");
            add("Tu t'entends bien avec elle", "You (tu) get on well with her");
            add("Vous vous entendez bien avec elle", "You get on well with her");
            add("Je ne vous entends pas bien", "I can't hear you well");
            add("On va s'entendre", "I/We're going to get on with each other");
            add("Vous pourriez vraiment vous entendre", "You could really get along");
            add("J'??tais s??re que vous vous entendriez", "I(f) was sure you would get along");
        });
        
        // FAIRE CAUSATIVE
        push(FAIRE, () ->
        {
            add("J'ai fait cuisiner Andr??", "I made Andr?? cook");
            addCompound("J'ai fait un g??teau - J'ai fait faire un g??teau", "I made a cake - I had a cake made");
            add("Tu me fais vomir", "You(tu) are making me sick");
            add("Le trou fait la taille d'un doigt", "The hole is the size of a finger");
            add("Je t'ai fait un g??teau", "I made you(tu) a cake");
            add("Je vous ai fait une maison", "I made you a house");
            add("J'en ai fait", "I did |escalade|", EN);
            // Receiver only (The subject of the sentence makes something happen to the receiver)
            // subject + faire + infinitive + receiver
            addCompound("Je lave la voiture - Je fais laver la voiture", "I'm washing the car - I'm having the car washed");
            add("Il fait r??parer la machine", "He's having the machine repaired");
            add("Vas-tu faire d??sherber le jardin ?", "You(tu) going to have the garden weeded?");
            // Agent only (The subject makes the agent do something)
            // subject + faire + infinitive + agent
            add("Je fais ??crire David", "I'm making David write");
            add("Il fait manger sa soeur", "He makes his sister eat");
            add("Les orages font pleurer mes enfants", "Storms make my children cry");
            // Receiver + Agent (The subject has the agent do something to the receiver)
            // subject + faire + infinitive + receiver + par or ??* + agent
            add("Je fais laver la voiture ?? David", "I'm having David wash the car");
            add("Il fait r??parer la machine ?? sa soeur", "He's having his sister fix the machine");
            add("Je vais faire faire un g??teau ?? Andr??", "I'm going to have Andr?? make a cake");
            addCompound("Je vais faire un g??teau - Je vais faire faire un g??teau", "I'm going to make a cake - I'm going to have a cake made");
            add("Vas-tu faire examiner les enfants au m??decin ?", "You(tu) going to have the doctor examine the kids?");
            add("Je me fais coiffer deux fois par mois", "I get myself coiffed twice a month");
            // The reflexive causative can indicate something that happens to the subject (against wish)
            add("S'est-elle fait expulser ?", "(Did) she get herself expelled?", CLITIC, PRONOMINAL);
            add("Fais gaffe, tu vas te faire renvoyer", "(tu) Watch out, you're going to get yourself dismissed");
            add("Nous nous sommes fait faire un d??tour par Paris", "We were made to detour through Paris", PRONOMINAL);
            //
            add("Il fait manger les pommes ?? sa fille", "He's making his daughter eat the apples");
            add("Tex fait r??parer sa voiture au garage", "Tex is having his car fixed at the garage");
            add("Tex a fait r??parer sa voiture au garage", "Tex had his car fixed at the garage");
            add("Tex va faire r??parer sa voiture au garage", "Tex is going to have his car fixed at the garage");
            add("Tex fera r??parer sa voiture au garage", "Tex will have his car fixed at the garage");
            add("Tex fait chanter Tammy", "Tex makes Tammy sing");
            add("Tex fait chanter la chanson ?? Tammy", "Tex makes Tammy sing the song");
            add("Tex la fait r??parer", "Tex is having it(car) fixed");
            add("Tex la fait chanter", "Tex makes her sing");
            add("Fais-la chanter !", "Make her sing! (tu)", CLITIC);
            add("Ne la fais pas chanter !", "Make her not sing ! (tu)", CLITIC);
            add("Rita s'est fait faire une robe noire", "Rita had a black dress made for herself", PRONOMINAL);
            add("Mes parents se sont fait ??craser par un camion", "My parents (got themselves) run-over by a truck", PRONOMINAL);
            add("Mes parents font construire une maison ?? la campagne", "My parents are having a house build in the countryside");
            add("Rita a fait ranger la chambre aux enfants", "Rita made the children tidy the bedroom");
            add("Nous ferons envoyer des fleurs ?? Fiona", "We will have flowers sent to Fiona");
            add("Nous ferons envoyer des fleurs par Fiona", "We will have flowers sent by Fiona");
            add("Rita et ses enfants vont faire vendre leur maison", "Rita and her children are going to have their house sold");
            add("Bette et Tammy, faites descendre les valises !", "Bette and Tammy, make the suitcases be taken down !");
            add("Bob, est-ce que tu vas te faire couper les cheveux ?", "Bob, are you(tu) going to have your hair cut ?");
            add("Je fais faire une robe pour Tammy", "I'm getting a dress made for Tammy");
            add("Je vais faire faire une robe pour Tammy", "I'm going to get a dress made for Tammy");
            add("Pauvre Tex, il s'est fait arr??ter en France", "Poor Tex, he got himself arrested in France", PRONOMINAL);
            add("Il fait cuisiner sa soeur", "He makes his sister cook");
            add("He makes his sister cook", "Il fait cuisiner sa soeur");
            //
            add("Pourquoi il la fait rire ?", "Why is he making her laugh?");
            add("Pourquoi il la faisait rire ?", "Why was he making her laugh?");
            add("Tu dois faire venir le m??decin", "You(tu) must send for the doctor");
            add("Cela me fait plaisir", "*That* pleases me");
            add("Je te ferai arr??ter", "I will have you(tu) arrested");
            // infinitves.pdf
            add("Nous le ferons ??crire ?? sa famille", "We shall make him write to his family");
            add("Je lui ferai lire ce document", "I shall have him read this document");
            add("Je le lui ferai lire", "I'll have him read it", CLITIC);
            add("Les documents que je lui ai fait lire", "The documents I had him read");
            add("Faites-lui comprendre que je suis occup??", "Make him understand I am busy", CLITIC);
            add("Vous devriez faire lire ces documents ?? votre avocat", "You ought to make your lawyer read these documents");
            // faire.add("J'ai fait ??crire ?? Paul une lettre de remerciements ?? Suzanne", "I made Paul write a thank-you letter to Suzanne");        
            add("J'ai fait ??crire une lettre par Paul", "I made Paul write a letter");
            add("J'ai fait ??crire une lettre ?? Paul", "I had a letter written to Paul");
            add("J'ai fait r??parer mon v??lo par un bon m??canicien", "I had my bicycle repaired by a good mechanic");
            add("Faites r??veiller les enfants par la bonne", "Have the maid wake the children");  // - Why par instead of ?? ?
            add("Il lui a fait r??pondre par sa secr??taire", "He had his secretary answer him");
            add("Je ferai r??pondre ?? cette lettre par ma secr??taire", "I'll have my secretary respond to this letter");
            add("Je le lui ferai ??crire", "I shall have it written to him", "I shall have it written by him", CLITIC);
            add("Je leur en ferai donner", "I shall have some given to them", "I shall have some given by them", CLITIC);
            add("Je lui ferai faire une robe", "I shall have a dress made for |her|", "I shall have a dress made by her");
            add("Je vous en ferai faire une", "I shall have one of them made for you", "I shall have one of them made by you", CLITIC);
            add("Nous nous sommes fait b??tir une maison", "We had a new house built (for ourselves)");
            add("Je me ferai couper les cheveux", "I shall have my hair cut");
            add("Alors, j'ai fait porter le chapeau ?? Dwight", "So, I made Dwight take the fall(expr.)");
            add("Ils ont vu leurs camarades se faire tuer", "They've seen their comrades (get themselves) killed");
            add("Je vous le ferai regretter", "I will make you regret it");
            add("Ils se sont fait massacrer", "They got themselves massacred");
            add("Je veux me faire rembourser", "I want to get myself reimbursed");
            add("Et faire croire qu'il a ??t?? tu?? par une maison rivale ?", "And make-it-look-like he was killed by a rival house?");
            add("Vous voulez faire croire que Gowron a ordonn?? cet assassinat", "You want to make-it-look-like Gowron ordered this assassination");
            add("C'est ce qu'on a voulu me faire croire", "It's what he/they wanted to make-it-look-like to me");
            add("Alanis s'est fait guillotin??e", "Alanis got herself guillotined");
            add("Elle a fait avorter le b??b??", "She had the baby aborted");
            add("On se fait mordre souvent", "One gets bit often");
            add("Fais-lui croire que tu es sortie", "Make him believe you(f.tu) got out");
        });

        // FALLOIR
        {
            add("Dans ce cas, il faudra que Penny fasse le m??nage", "In that case, Penny will have to do the housework", SUBJUNCTIVE);
            add("Faites ce qu'il faudra", "Do what has to be done");
            add("Faut-il que tu sois si hostile ?", "(Is it necessary) for you(tu) to be so hostile ?");
            add("Il a fallu", "It has been necessary ...");
            add("Il faille", "(That) It is necessary ...");
            add("Il fallait", "It was necessary ...");
            add("Il faudra que je le fasse", "It will be necessary that I do it", SUBJUNCTIVE);
            add("Il faudra", "It will be necessary ...");
            add("Il faudrait que tu le rencontres", "You(tu) would need to meet him");
            add("Il faudrait", "It would be necessary ...");
            add("Il faut absolument que tu viennes !", "You(tu) absolutely have to come!", SUBJUNCTIVE);
            add("Il faut absolument que vous payiez cette dette", "It is absolutely necessary, that you pay this debt", SUBJUNCTIVE);
            add("Il faut l'emmener ?? l'h??pital", "He needs to be taken to the hospital");
            add("Il faut le faire", "It has to be done");
            add("Il faut le virer", "He needs to be fired");
            add("Il faut les arr??ter", "They need to be stopped");
            add("Il faut qu'on en discute", "It's necessary that I/we discuss it", EN);
            add("Il faut que ??a s'arr??te", "This has got to stop");
            add("Il faut", "It is necessary ...");
            add("Il me faudra le faire", "(falloir) I will have to do it");
            add("Il me faut du temps pour tout arranger", "I have to have time to arrange everything");
            add("Il te faut un verre de vin", "You(tu) need a glass of wine");
            add("Il va falloir que je la rappelle", "I'm going to have to to call her back (falloir)");
            add("Il va falloir", "It is going to be necessary ...");
            add("Il va nous falloir de l'argent", "We are going to have to need money");
            add("Il vous faut une femme d'abord", "It's necessary for you to have a wife first");
            add("Je veux qu'il faille", "I want it to be necessary ...", SUBJUNCTIVE);
            add("Tu sais ce qu'il te faut ?", "You(tu) know what you need?");
    }
        
        // FAILLIR
        add("faillir", "(v.) to almost do something");
        {
            add("J'ai failli tomber", "I almost fell");
            add("J'ai failli aller en Allemagne, mais j'ai annul?? au dernier moment", "I almost went to Germany, but cancelled at the last moment");
            add("Tu as failli ?? ta mission", "You(tu) failed your mission");
            //add("Il a failli ?? sa parole", "He failed to keep his word");
            add("Nous avons failli rater le train", "We very nearly missed the train");
            add("J'ai failli m'endormir quand il m'a montr?? les dossiers", "I nearly fell asleep when he showed me the files", PRONOMINAL);
            add("Ils ont failli commander", "They nearly ordered");
            add("Elle a failli ??tre la marraine de Cece", "She was nearly Cece's godmother");
            add("J'ai failli ne pas venir", "I nearly didn't come");
        }
        
        // FAIRE QUE
        push(of(FAIRE, LOCUTION), () ->
        {
            add("Ces gens ne font que chuchoter", "Those people only whisper");
            add("Ces gens chuchotent - Ces gens ne font que chuchoter", "Those people whisper - Those people only whisper");
            add("Il ne fait que dormir toute la journ??e", "He only sleeps all day");
            add("Ici, vous ne faites qu'ob??ir aux ordres", "Here, you only obey orders");
            //add("Pendant la r??union, il ne fit qu???entrer et sortir")
            add("Sa r??action n'a fait qu'empirer les choses", "His reaction only made things worse");
            //add("Cette nuit, je n???ai fait que me r??veiller sans cesse", "That night, I only");
        });
        
        // HABITER vs VIVRE
        {
            //add("Une vraie joie de vivre habite cette famille");
        }

        // PAST PARTICIPLE AGREEMENT
        push(of(AGREEMENT, PRONOMINAL), () ->
        {
            add("Il est rest?? cach??", "He remained hidden");
            add("Il reste cach??", "He remains hidden");
            add("La superbe danseuse qu'elle a ??t??", "The superb dancer that she has been");
            add("Les difficult??s que nous avons eues", "The difficulties we had");
            add("Quels verres as-tu remplis ?", "Which glasses did you(tu) fill ?");
            add("Elles se sont parl?? en classe", "They (f) talked (to each other) in class");
            add("Elles se sont battues en classe", "They (f) fought (to each other) in class");
            add("Elle est revenue du supermarch??", "She returned from the supermarket");
            add("Elle s'est bross?? les dents", "She brushed her teeth");
            add("Elle se les est bross??es", "She brushed |her teeth|", CLITIC);
            add("Elle s'est lav?? les mains", "She washed her hands");
            add("Elle se les est lav??es", "She washed |her hands|", CLITIC);
            add("Elle s'est lav??e", "She washed herself");
            add("Nous nous sommes bross?? les dents", "We brushed our teeth"); // bross?? - not bross??e - see http://forum.wordreference.com/showthread.php?t=184996
            add("Elles se sont bross?? les cheveux", "They(f) brushed their hair");
            add("Il s'est regard?? dans le miroir", "He looked at himself in the mirror");
            add("J'ai descendu les escaliers deux fois", "I went down the stairs twice");
            add("J'adore les photos que tu as prises !", "I adore the photos you(tu) took!");
            add("Quelqu'un te les a vol??es", "Someone stole |the (small)balls| from you(tu)");
            add("Non, je les ai vir??s, et tu es le suivant", "No, I fired them, and you're(tu) next");
            add("O?? es-tu all??e ?", "Where (did) you(tu.f) go?", CLITIC);
            add("Elle s'est assise ?? l'arri??re du car", "She sat down at the back of the coach", PRONOMINAL);
            add("Elle s'est suicid??e", "She killed herself", PRONOMINAL);
            add("Kira est-elle arriv??e ?", "(Did) Kira arrive?", QUESTION);
            add("Accus??e d'avoir menac?? le Pr??sident, elle", "Accused of having threatened the President, she ...");
            add("Quand il a sorti la poubelle", "When he took the dustbin out");
            add("Paul a retourn?? le paquet", "Paul returned the packet");
            // QUERY: Why tromp??e agreement? - add("Je t'ai tromp??e avec Dwight - Je te l'avais cach??", "I(f.) cheated on you(tu) with Dwight - I had hid it from you");
            add("La d??cision a d??j?? ??t?? prise", "The decision has already been made");
            addCompound(AGREEMENT,
                    "La voiture serait nettoy??e - La voiture aurait ??t?? nettoy??e",
                    "The car would be cleaned - The car would have been cleaned");
        });
        
        // IGNORER
        add("ignorer", "(v.) to be unaware of");
        {   
            add("Qui est, si vous l'ignorez", "Which is, if you are unaware of it");
            add("Mais ce que tu ignorais ?? ce moment-l??", "But what you(tu) was unaware of at that time");
            add("Kor ne peut pas l'ignorer", "Kor can't be unaware of it");
        }
        
        // IL Y A 
        push(Y, () ->
        {
            add("Il y a deux semaines", "Two weeks ago");
            add("Est-ce qu'il y a des enfants ?", "Are there any children ?");
            add("Y a-t-il un chat ?", "(Is) there a cat?", CLITIC);
            add("Y a-t-il des enfants ?", "(Are) there any children?", CLITIC);
            add("Il n'y a pas d'enfants l??-bas", "There aren't any kids over there", Y);
            add("Combien d'enfants y a-t-il ?", "How many kids are there?", CLITIC);
            add("Qu'est-ce qu'il y a ?", "Whats wrong (colloq)", Y);
            add("Il y a eu", "There has been...", Y);
            add("Il y avait", "There was/were ...", Y);
            add("Il y aura", "There will be ...", Y);
            add("Il y aurait", "There would be ...", Y);
            add("S'il y avait", "If there was ...", Y);
            add("N'y a-t-il pas de fromage ?", "Is there no cheese there?", CLITIC);
            addCompound(Y,
                    "Il y a eu un chat - Il y avait un chat",
                    "There has been a cat - There was a cat");
            addCompound(DE,
                    "Il y a un chat - Il n'y a pas de chat",
                    "There is a cat - There is no cat");
            addCompound(
                    "Il y avait un chat - Il n'y a pas eu de chat",
                    "There was a cat - There was no cat");
            addCompound(
                    "Il y aura des chats - Il y aura eu des chats",
                    "There will be some cats - There will have been some cats");
            addCompound(
                    "Il y aurait des chats - Il y aurait eu des chats",
                    "There would be some cats - There would have been some cats");
            addCompound(
                    "Il n'y aurait pas eu de chats - Il n'y aurait pas de chats",
                    "There would have been no cats - There would be no cats");
            addCompound(CLITIC,
                    "Il n'y aurait jamais de guerre - Il n'y aurait jamais eu de guerre",
                    "There would never be a war - There would never have been a war");
            addCompound(SUBJUNCTIVE,
                    "Il se peut qu'il y ait des complications - Il se peut qu'il y ait eu des complications",
                    "There could be complications - There could have been complications");
        });
        
        // INVERSION
        push(CLITIC, () ->
        {
            add("A-t-elle un stylo ?", "Does she have a pen?");
            add("A-t-il un ami ?? la banque ?", "He got a friend at the bank?");
            add("As-tu un stylo ?", "(Do) you(t) have a pen?");
            addCompound("Il s'amuse - S'amuse-t-il ?", "He is having fun - (Is) he having fun?");
            add("Mangeons-nous de la salade ?", "(Are) we eating salad?");
            add("Parle-t-on allemand ici ?", "(Does) (Any)one speak German here?");
            add("Peut-??tre a-t-il trouv?? mon sac ?? dos", "Maybe he found my backpack");
            addCompound("T'amuses-tu ? - Vous amusez-vous ?", "(Are) you(tu) having fun? - (Are) you having fun?"
            );
        });
        
        // LAISSER TOMBER
        {
            add("Laissez tomber", "Drop it (expr.)", "Forget it (expr.)", LOCUTION);
            add("Laisse tomber", "(tu) Drop it (expr.)", "(tu) Forget it (expr.)", LOCUTION);
            add("Imaginez si vous laissiez tomber votre t??l??phone", "Imagine if you drop your telephone", LOCUTION, SUBJUNCTIVE);
            add("Elle le laisse tomber comme une vieille chaussette", "She drops/forgets him like an old sock", LOCUTION); 
    }
        
        // MANQUER
        {
            add("Mon grand-p??re me manque", "I miss my grandfather");
            add("J'ai manqu?? le bus", "I missed(manquer) the bus");
            add2("Je manque le bus - Le bus me manque", "I miss(didn't catch) the bus - I miss(lack) the bus");
            add("Il va manquer le film", "He is going to miss the film");
            add("Vous manquez de patience", "You lack patience");
            add("Ce th?? manque de lait", "This tea needs some milk", DE);
            add("J'ai manqu?? de faire mes devoirs", "I failed to do my homework");
            add("Je manque ?? David", "David misses me");
            add("David me manque (David manque ?? moi)", "I miss David (+long)");
            add("Je lui manque (Je manque ?? elle)", "She misses me (+long)");
            add("Tu nous manques (Tu manques ?? nous)", "We miss you(tu) (+long)");
            add("Ils ont manqu?? de venir ?? ma f??te", "They missed coming to my party");
            add("Est-ce que je te manque ?", "Do you(tu) miss me?");
            add("Elle manque de gr??ce", "She lacks grace", DE);
            add("Ils ont manqu?? de faire le diner", "They missed making dinner");
            add("Leur ami leur manque", "They miss their friend");
            add2("Tu me manqueras - Je te manquerai", "I will miss you(tu) - You(tu) will miss me");
            add("Son fr??re lui manque", "She misses her brother");
            add("Je lui ai manqu?? et lui aussi m'a manqu??", "He missed me and I also missed *him*");
            add("Vous ne leur manquez pas", "They don't miss you");
            // add("Il me manque une vis", "I lack a screw");
        }
        
        // MERCI
        {
            add("Merci de m'avoir invit??", "Thank you for having invited me");
            add("Merci de m'avoir ouvert la porte", "Thank you for having opened the door for me");
            add("Merci de fermer la porte", "Thank you for closing the door");
            add("Merci d'avoir fermer la porte", "Thank you for having closed the door");
        }
        
        // MESURE
        add("mesure", "(v,) to measure");
        {
            add("??a mesure vingt m??tres de haut", "That is twenty metres high");
            add("Le mur mesure quatre m??tres de long", "The wall is four metres wide");
        }
        
        // NEUF VERSUS NOUVEAU
        {
            add("As-tu vu ma nouvelle voiture ?", "(Have) you(tu) seen my new car?");
            add("Il a mis une nouvelle chemise", "He put a new(different) shirt on");
            add("Nous avons un nouvel appartement", "We have a new apartment");
            add("J'ai vu le nouveau pont", "I saw the new bridge");
            add("Je n'ai jamais achet?? une voiture neuve", "I've never bought a (brand) new car");
            add("Il a achet?? une chemise neuve", "He bought a brand-new shirt");
            add("Comme neuf", "As good as new");
            add("Nous avons un appartement neuf", "We have a (brand)new apartment");
        }

        // PASSER
        {
            add("Elle passe de la cr??me sur son ventre", "She's rubbing cream on her belly");
            //add("J'ai l'impression que je passe la plupart de mes temps ici ?? faire des installations de mises ?? jour", "I get the impression that I spend most of my time here doing the installation of updates");
            add("J'ai pass?? les vacances en Espagne", "I spent the holidays in Spain");
            add("J'ai pass?? mon enfance ?? courir et ?? sauter", "I spent my infancy running and jumping");
            add("J'ai pass?? toute la journ??e ?? manger des g??teaux", "I spent all day eating cakes");
            add("J'ai pass?? toute ma vie ?? l'aimer", "I spent all my life loving her");
            add("J'ai pass?? une splendide soir??e chez toi", "I had/spent a splendid evening round yours(tu)");
            add("Je vais y passer demain pour mes affaires", "I'm going to stop there tomorrow for my things");
        }
        
        // INDEFINITE ADVERBS
        {
            add("Peu d'??tudiants aiment ce prof", "Few students like this teacher");
            add("Elle a peu de patience", "She has little patience");
            add("De toute fa??on, je l'aime bien", "I like him regardless");
            add("Cet h??tel ??tait autrefois un ch??teau", "This hotel was formerly a chateau");
            add("Je te suivrai n'importe o??", "I will follow you(tu) wherever");
            add("Je dois choisir un th??me, n'importe lequel", "I need to chose a theme, no matter which");
        }
        
        // PHRASAL VERBS
        {
            add("Nous voulons apprendre ?? faire du ski", "We want to learn to ski");
            add("Elle pleure la perte de son livre pr??f??r??", "She cries over the loss of her favourite book");
            add("J'??coute la radio chaque matin", "I listen to the radio each morning");
        }
        
        // PLUS
        {
            add("Je veux plus de beurre", "I want more butter");
            add("Il y aura plus de choix demain", "There will be more choices tomorrow");
            add("J'ai plus de 10 livres", "I have more than 10 books");
            add("Je ne le veux plus", "I don't want it any more");
            add("Je ne veux plus de beurre", "I don't want any more butter");
            add("Plus de beurre, merci", "No more butter, thank you");
            add("Je n'aime pas les pommes non plus", "I don't like apples either");
            add("En plus", "extra");
            add("J'ai une chaise en plus", "I have an extra chair");
            add("Il a trois ans de plus que moi", "He is three years older than I am");
            add("De plus, nous sommes en retard", "Furthermore, we're late");
            add("Allons-y une fois de plus", "Let's go there one more time");
            add("De plus en plus", "More and more");
            add("Je deviens de plus en plus fatigu??", "I'm getting more and more tired");
            add("aller de plus en plus vite", "to go faster and faster");
            add("au plus", "at the most");
            add("Tu as une heure au plus", "You(tu) have an hour at the most");
            add("Tout au plus", "at the very most");
            add("Il a 15 minutes tout au plus", "He has 15 minutes at the very most");
            add("Marchez plus vite", "Walk more quickly");
            add("Parle plus fort !", "Speak up! (tu)");
            add("Plus ou moins", "More-or-less");
            add("Il a plus ou moins 10 ordinateurs", "He has more-or-less 10 computers");
            add("Elle a fait plus ou moins tout", "She did more-or-less everything");
            add("Plus que jamais", "More than ever");
            add("Je t'aime plus que jamais", "I love you(tu) more than ever");
            add("Il ne travaille plus", "He works no longer", "He doesn't work any more");
            add("Je cherche quelque chose avec moins de graisse", "I'm looking for something with less fat");
            add("Il y a moins de touristes en hiver", "There are fewer tourists in the winter");
            add("Je la vois rarement", "I rarely see her");
            add("Elle s'habille n'importe comment", "She dresses however");
            add("Il n'y a pas plus de 3 m??decins", "There are no more than 3 doctors");
        }

        // PRESENT PARTICIPLES
        push(PARTICIPLE, () ->
        {
            add("Elle est tomb??e en faisant du ski", "She fell while skiing");
            add("Les enfants ??tant gard??s", "The children being looked-after ...");
            add("??tant fatigu??, il voulait rentrer chez lui", "Being tired, he was wanting to go back home");
            add("??tant proche de ma m??re, je d??cide de me confier ?? elle", "Being close to my mother, I decide to confide in her");
            add("En rentrant de l'??cole", "While coming back from school ...");
            add("Et on fait quoi en t'attendant ?", "And I/we do what while waiting for you(tu)?");
            add("Comment peux-tu montrer les fesses en conduisant ?", "(How) can you(tu) moon while driving?");
            add("Notre professeur ??tant malade, nous avons eu un rempla??ant", "Our teacher being ill, we had a replacement", PARTICIPLE);
            add2("J'ai vu Sherry en arrivant - J'ai vu Sherry arrivant", "I saw Sherry while arriving - I saw Sherry arriving", PARTICIPLE);
            add("Ayant fini mes devoirs, je suis sorti de la maison", "Having finished my homework, I came out from the house");
        });
        
        // MISC PRONOMINAL VERBS
        push(PRONOMINAL, () ->
        {
            add("Apr??s hier soir, je commen??ais ?? m'inqui??ter", "After last night, I was starting to worry");
            add("Arr??te de te moquer de moi", "Stop(tu) mocking me");           // http://forum.wordreference.com/showthread.php?t=489724
            add("Arr??tez de vous moquer de moi", "Stop mocking me");
            add("Comment vous sentez-vous ?", "(How) do you feel?");
            add("Elle se marie demain", "She's getting married tomorrow");
            add("Et puis je m'endors", "And then I go to sleep");
            add("Il faut du temps pour s'y habituer", "It (is necessary to) take time to get used to them");
            add("Il se d??brouille", "He gets by/manages");
            add("J'ai l'impression de me moquer d'eux", "I feel like I'm mocking them");
            add("Je les entends se disputer", "I hear them arguing");
            add("Je me souviens de m'??tre r??veill?? avec la t??te qui tournait", "I remember having woken up with a spinning head");
            add("Je me suis inscrit il y a deux semaines", "I signed up two weeks ago");
            add("Je me suis mordu la l??vre", "I bit my lip");
            add("Je me suis servie d'une r??gle pour la mesurer", "I(f) used a ruler to measure the |window|");
            add("Je ne m'occupe plus de ??a", "I don't handle that any more");
            add("Je ne vois aucune raison de vous inqui??ter", "I see no reason for you to worry");
            add("Je ne voulais pas vous tromper", "I was not wanting to deceive you");
            add("Je vais faire ??a jusqu'?? ce que tu te sentes un peu mieux", "I am going to do that up until you(tu) feel a little better", SUBJUNCTIVE);
            add("Je veux m'am??liorer, car je me marie", "I want to improve myself, as I'm getting married");
            add("La porte s'ouvre - viens me la fermer", "The door opens - come(tu) close it for me");
            add("La porte se ferme - viens me l'ouvrir", "The door closes - come(tu) open it for me");
            add("Le chef sait se d??brouiller tout seul", "The chief knows how to take care of himself alone");
            add("Les enfants se conduisent mal", "The children are behaving badly");
            add("Ne t'arr??te pas !", "Don't(tu) stop!");
            add("Nous nous sommes vus", "We saw ourselves", AGREEMENT);
            add("On s'est promis de ne jamais se le dire", "I/We promised (each other) to never say it (to each other)");
            add("On se comprend", "We(on) understand each other");
            add("Se d??brouiller", "To get by/to manage");
            add("Tu t'amuses - tout le monde s'amuse", "You're(tu) having fun - everyone is having fun");
            add("Vous devriez vous reposer", "You should rest");
            add("Vous m'avez demand?? de me rapprocher de lui", "You asked me to get close to him");
            add("Vous ne vous en souvenez pas ?", "You don't remember it?", CLITIC);
            add("et s'??chapper par les ??gouts", "... and (to)escape through the sewers");
            add("??a s'est bien pass??", "That went well (expr.)");
            add2("Je me suis dit - Je vous ai dit", "I said to myself - I said to you");
            add2("Je vois qu'on se comprend - Je vois on se comprendre", "I see that I/we understand each other - I see I/we understand each other");
            add("Assurez-vous qu'ils soient arm??s", "Make sure they are armed", SUBJUNCTIVE);
        });
        
        // QUE
        {
            add("Que faire ?", "What can you do?");
            add("Que dire ?", "What can you say?");
            add("Je n'ai qu'une chaussure", "I have only one shoe");
        }
        
        // RETOUR
        {
            add("Je serai de retour demain", "I will be back tomorrow");
            add("Je serai de retour pour le repas", "I'll be back for dinner");

        }
        
        // SUBJUNCTIVE
        push(SUBJUNCTIVE, () ->
        {
            add("J'esp??rais que tu le fasses", "I was hoping that you(tu) could do it");
            add("Le moins que tu puisses faire", "The least you(tu) could do ...");
            add("Ravie que tu aies trouv?? quelqu'un", "Delighted(f.) that you've(tu) found someone");
            add("Il est injuste qu'il ait ??t?? puni", "It's unfair that he was punished");
            add("Il est injuste qu'elles aient ??t?? punies", "It's unfair that they(f) were punished");
            add("Nous doutons qu'il fasse cela", "We doubt he will do *that*");
            add("Je suis heureux que vous soyez venu", "I am happy you came");
            add("Je suis heureux que ??a vous plaise", "I am happy that that pleases you");
            add("Mon voeu c'??tait que Jessica soit morte", "My wish was that Jessica was dead");
            add("Nous comprenons que vous soyez f??ch??", "We understand that you're angry");
            // AIMER
            {
                //add("J'aime qu'on soit ponctuel", "I like those who are punctual");
            }
            // AVOIR PEUR
            {
                add("J'ai peur qu'elle me prenne comme un ami", "I'm scared she'll take-me/treat-me as a friend");
            }
            // BIEN QUE
            {
                add("bien que", "even though ...");
                add("Bien que je n'aie pas fini", "Even though I haven't finished ...");
                add("Bien que je sois malade", "Even though I am ill ...");
            }
            // CRAINDRE
            {
                add("Il craint que vous n'ayez pas compris", "He fears you did not understand");
                add("Je crains que le lac soit froid", "I fear that the lake is cold");
            }
            // CROIRE
            {
                add("Je ne crois pas qu'il pleuve aujourd'hui", "I don't believe it will rain today");
            }
            // DOUTER
            addCompound(
                    "Je doute qu'ils aient fini - Je doute qu'ils finissent",
                    "I doubt they will have finished - I doubt they will finish");
            
            // PENSER
            {
                add("Je pense que c'est vrai", "I think it's true");
                add("Je ne pense pas que ce soit vrai", "I don't think it's true");
                add("Penses-tu que ce soit vrai ?", "(Do) you(tu) think it's true?");
                add("N'y pense m??me pas", "(tu)Don't even think about it", Y, CLITIC);
            }
            // POUR QUE
            {
                add("pour que", "in order to ...", "so that ...");
                add("pour qu'ils viennent me parler", "so that they'll come talk to me ...");
                add("pour qu'on puisse braquer une banque", "so that I/we can rob a bank ...");
                add("pour que tes dents soient plus propres", "... so that your(tu) teeth will be cleaner");
                add("pour que tu puisses aller dans une bonne universit??", "... so that you(tu) can go to a good university");
                //add("En fait, je l'y ai mis pour que tu choisisses un nouveau fauteuil", "Actually, I put it |there| so that you choose a new armchair", CLITIC);
                add("Je le ferai pour que nous puissions partir", "I'll do it so that we can leave");
                add("Je suis venu vous voir pour que nous parlions de nos affaires", "I came to see you in order to talk of our affairs");
                add("Je viens pour qu'il soit content", "I'm coming so that he'll be pleased");
                add("O?? y a-t-il une prise pour que je puisse recharger mon portable ?", "(Where) is there a plug so that I can recharge my mobile?");
                // add("Tu penses qu'il est trop tard pour que j'aie des enfants ?", "You(tu) think it is too late for me to have children?");
                add("J'esp??re que le Defiant arrivera ?? temps pour que Sisko voie ??a", "I hope the Defiant will arrive in time so that Sisko sees that");
            }
            
            // REGRETTER
            {
                add("Je regrette qu'il ait ??t?? puni", "I regret that he was punished");
                add("Il regrette aussi que tu n'aies pas pu venir", "He regrets also that you(tu) were not able to come");
            }
            // SEMBLER
            {
                add("sembler", "(v.) to seem");
                add("Il semble qu'elle soit malade", "It seems that she is sick");
                add("Il me semble impossible", "It seems impossible to me");
            }
            // SUFFIRE
            {
                add("suffire", "(v.) to suffice", "(v.) to be enough");
                add("Il te suffit de le faire demain", "It's enough if you(tu) do it tomorrow");
            }
            // VOIR
            {
                add("Je vois que vous avez raison", "I see that you're right");
                add("Je ne vois pas que vous ayez raison", "I don't see that you're right");
                add("Voyez-vous que j'aie raison ?", "(Do) you see that I'm right?");
            }
            // VOULOIR
            {
                add("Je veux qu'il le fasse", "I want him to do it");
                add("Que voulez-vous que je fasse ?", "What (do) you want (that) me to do ?");
                add("Je veux que tu prennes soin de toi", "I want you(tu) to take care of yourself");
                add("Je veux que vous preniez soin de vous", "I want you to take care of yourself");
                add("Vous voulez que je la reprenne ?", "You want me to take |the card| back?");
            }
            
            add("Sortez avant que je devienne m??chant", "Get out before I become mean");
            add("Admettons que vous ayez partag?? quelque chose", "Lets admit that you shared something ...");
            add("Je suis ravie que vous ayez appris quelque chose", "I(f) am delighed that you learnt something");
            add("C'est bizarre qu'il n'ait pas dit la v??rit??", "It's strange he didn't tell the truth");
            add("Il pr??f??re que personne ne sache", "He prefers that nobody knows");
            addCompound(
                    "Dommage que vous ne soyez pas venu - Dommage que vous ne veniez pas",
                    "Shame you didn't come - Shame you are not coming");
        });
        
        // SERVIR
        {
            add("se servir de", "(v.) to make use of ...");
            add("Je me sers d'une cl??",  "I am making use of a spanner", PRONOMINAL); 
            add("Il se sert d'une pince", "He is making use of a pliers", PRONOMINAL); 
            add("Ils se servent de marteaux", "They are making use of some hammers", PRONOMINAL); 
            add("??a ne sert ?? rien de pleurer, la vie continue", "No use crying, life goes on");
            add("??a ne sert ?? rien", "Thats no use");
            add("Je me suis servi de scotch pour r??parer mes lunettes", "I used some sellotape to repair my glasses", PRONOMINAL);
            add("Pourquoi le Dominion se servirait-il d'armes Bajoranes ?", "Why would the Dominion make use of bajoran weapons?", PRONOMINAL, CLITIC);
            add("Je ne te servirais jamais", "I would never serve you(tu)");
        }

        // SOUVENIR
        {
            add("Souvenez-vous du livre", "Remember the book ...", PRONOMINAL);
            add("Est-ce que tu te souviens de la nuit", "Do you(tu) remember the night", PRONOMINAL);
            add("Tu te souviens de moi", "You(tu) remember me", PRONOMINAL);
            add("Tu t'es souvenu de mon anniversaire !", "You(tu) remembered my birthday!", PRONOMINAL);
            add("Il s'est souvenu de fermer la porte", "He remembered to close the door", PRONOMINAL);
            add("Je me suis souvenu de", "I remembered to ...", PRONOMINAL);
            add("Tu t'es souvenu de", "You(tu) remembered to ...", PRONOMINAL);
            add("Vous vous ??tes souvenu de", "You remembered to ...", PRONOMINAL);
            add("Vous vous ??tes souvenus de", "You(pl) remembered to ...", PRONOMINAL, AGREEMENT);
            add("Elle s'est souvenue de", "She remembered to ...", PRONOMINAL, AGREEMENT);
            add("Elles se sont souvenues de", "They(f) remembered to ...", PRONOMINAL, AGREEMENT);
            add("Elles se sont souvenues de fermer la porte", "|Martha and Kerry| remembered to close the door", PRONOMINAL, AGREEMENT);
        }
        
        // TANT
        {
            add("Nous avons tant perdu", "We have lost so much");
            add("Il a d??j?? tant fait", "He has already done so much");
            add("Il travaille tant !", "He works so much!");
            add("tant de", "so much (+noun)", "so many (+noun)");
            add("Il a tant d'amis", "He has so many friends");
            add("Ta maison a tant d'espace !", "Your(tu) house has so much space!");
            add("tant que", "so much that", "as long as" /*, "while / since" */);
            add("Il a tant mang?? qu'il est malade", "He ate so much that he's sick.");
            add("J'ai tant lu que j'ai mal aux yeux", "I read(past) so much that my eyes hurt");
            add("J'ai d?? partir, tant j'??tais fatigu??", "I had to leave, since I was so tired");
            add("Tant que tu habiteras ici, tu m'ob??iras", "As long as you(tu) (will) live here, you will obey me");
            add("Tant que tu es l??, cherche mes lunettes", "As long as / since you're (tu) here, look for my glasses");
            add("J'ai tant besoin d'une copine", "I need a girlfriend so much");
        }   

        // TO TAKE
        {
            add("Savez-vous qui vous a tir?? votre sac ?? main ?", "(Do) you know who nabbed your handbag (from you?)");
            /// ADDME add("Prenez-le dans le placard");
            /// ADDME add("Quelqu'un m'a tir?? mon mobile !");
            add("Quand vas-tu passer l'examen ?", "When (are) you(tu) going to take the test ?");
            add("Vous devez enlever les chaussures avant d'y entrer", "You must take off the shoes before entering there");
        }
        
        // TRAPS
        {
            add("Un de ces enfants qui pleurent est ?? moi", "One of these crying children is mine", TRAPS);
            add("La plupart ne peuvent pas", "Most of them can't", TRAPS);
            add("Tout le monde est contre moi", "Everone is against me", TRAPS);
            // ADDME add("Mario ou Pierre fera/font..");
            add("Chacun a le sien", "Everyone has their |office|", TRAPS);
            add("Combien esp??rent partir ?", "How many hope to leave ?", TRAPS);
            add("C'est moi qui suis content", "It is me who is satisfied", TRAPS);
            add("C'est vous qui ??tes triste", "It is you who is sad", TRAPS);
        }
        
        // TOUT FAIT
        {
            add("C'est tout ?? fait normal", "It's totally/absolutely normal");
            add("Je suis tout ?? fait d'accord", "I agree completely");
        }
        
        // TRES
        {
            add("J'ai tr??s faim", "I am very hungry");
            add("Vous ??tes trop aimable", "You are too friendly");
        }

        // VENIR
        {
            add("Je sais qu'il vient de mourir", "I know that he just died");
            add("Je viens chercher ma voiture", "I pick up my car");
            add("Il vient ?? midi", "He's coming at noon");
            add("Je viens de Paris", "I'm from (I come from) Paris");
            add("Veux-tu venir avec nous ?", "(Do) you(tu) want to come with us?"); 
            add("Viens vite !", "Come(tu) quickly!");
            add("Elle ne vient jamais aux r??unions", "She never comes to meetings");
            add("Dans les ann??es ?? venir", "In the years to come");
            add("Je viens d'arriver", "I (have) just arrived");
            add("Ils viennent de manger", "They just ate");
            add("Nous venons de le faire", "We just did it");
            add("Je viens d'avoir une vision des Proph??tes", "I've just had a vision from the Prophets");
        }
        
        // VERS
        {
            add("Il est cruel envers les chiens", "He is cruel toward dogs");
            add("Son attitude envers les enfants", "His attitude toward children");
            add("Ses pens??es envers l'argent", "His thoughts on money");
            add("Arr??te d'??tre tr??s dur envers toi", "Stop(tu) being very hard on yourself");
            add("Tu es trop gentille envers moi !", "You(tu.f) are too kind to me!");
        }
        
        // PERSONAL PRONOUNS
        {
            add("Oui, ce sont les n??tres", "Yes, that's (pl) ours");
            add("Non, ce sont les leurs", "No, that's (pl) theirs");
            addCompound("Je recevrai ma voiture - Ils recevront leurs voitures", "I will receive my car - They will receive their cars");
        }
        
        add("ne t'en fais pas", "Don't worry bout it (informal)");
        add("je compatis", "I sympathise");
        add("Est-ce que ces lunettes sont en solde ?", "Are these glasses (sunglasses) on sale ?");
        // XX elle? or elles? ("Elle ne co??tent que cinq cent euros", "They (sunglasses) only cost five hundred euros");
            
        add("?? cause de", "due to (negative)");
        add("?? c??t?? de", "next to (location)");
        add("?? la rue", "lost (figuratively)");
        add("?? l'int??rieur", "inside (interior)");
        add("?? nouveau", "once again (expr.)", "once more (expr.)");
        add("?? partir de", "starting from (eg: train starting from)");
        add("?? temps - ?? l'heure", "In time - on time");
        add("autour", "around(area)");
        add("?? peine", "barely", "hardly");
        {
            add("Ce n'est pas la peine", "No need/no point... (expr)");
            add("J'ai ?? peine faim", "I'm barely hungry", "I'm hardly hungry");
            add("C'est ?? peine midi", "It's barely midday", "It's hardly midday");
            add("C'est ?? peine croyable", "It's barely believable");
            add("Nous avions fait ?? peine 10 kilom??tres", "We had barely did 10 kilometres");
        }
        
        add("?? propos de", "about (with respect to)");
        {
            add("J'ai entendu beaucoup de choses que tu as dites ?? propos de moi", "I heard a lot of things that you(tu) said about me");
        }

        add("s'accrocher", "(v.) to get addicted", "(v.) to collide");
        {
            add("s'accrocher ?? l'amour", "To get hooked on love");
            add("Deux voitures se sont accroch??es", "Two cars collided", AGREEMENT, PRONOMINAL);
        }

        add("actuellement", "currently");
        add("actualiser", "(v.) to update");
        
        // add("ainsi", "in this way", "thus (Thus I conclude that you must go)"); // APZ: EXAMPLES / CONTEXT
        // add("ainsi que", "just as (He didn't come, just as I told you)");       // // APZ: EXAMPLES / CONTEXT
        add("am??liorer", "(v.) to improve");
        
        add("appeler", "(v.) to call");
        {
            add("appel??", "(v.pp) to call");
            add("s'appeler", "(v.) to be called");
            add("il s'appelle", "he is called ...");
            add("nous nous appelons", "we are called ...");
            add("ils s'appellent", "they are called ...");
            add("J'ai appel?? son nom", "I called out her name");
            add("Appelle-moi ce soir", "(tu) Call me this evening");
            add("Nous devrions appeler un m??decin", "We should call a doctor");
        }
        
        add("aspirer", "(v.) to inhale", "(v.) to suck up");
        {
            add("Aspirer une grande quantit?? d'air", "Inhale a large amount of air", DE);
            add("Le tuyau de cette pompe aspire l'eau avec beaucoup de force", "The pipe of this pump sucks water with a lot of force", DE);
            add("aspirer ??", "(v.) to long for");
            add("Il aspirait au pouvoir", "He was longing for power");
            add("Il aspire ?? se distinguer dans son ??tat", "He aspires to distinguish himself in his state");
            add("Il n'aspire qu'?? vous plaire", "He only longs to please you");
            add("Je n'aspire qu'?? vivre tranquillement", "I only long for a tranquil life");
        }
        
        // AU CAS OU
        push(LOCUTION, () ->
        {
            add("au cas o??", "just in case");
            add("Apporte un parapluie, au cas o?? il pleuvrait", "(tu) Bring an umbrella, (just) in case it rains");
            add("Prends un imperm??able, au cas o?? il pleuvrait", "Take(tu) a raincoat, in case it would rain");
            add("Prends un imperm??able, au cas o??", "Take(tu) a raincoat, just in case");
            //add("Au cas o?? tu ne t'en souviennes pas, je d??fendais mon honneur", "Just in caee you(tu) don't remember it, I was defending my honour");
            //add("Vous devez toujours avoir un pull en cas de courant d'air", "You must always have a jumper in case of draughts");
            add("Au cas o?? il y aurait un intrus", "Just in case there would be an intruder");
            add("Pourquoi on aurait besoin d'un signal - au cas o?? l'un de nous aurait un probl??me", "Why would I/we need a signal - just in case one of us would have a problem");
            add("au cas o?? la police m'attraperait", "Just in case the police would catch me");
            add("Au cas o?? il rentrerait avant nous, je vais lui laisser un mot", "Just in case he gets home before us, I'm going to leave him a note");
            add("Apporte un blouson, au cas o??", "(tu) Bring a jacket, just in case");
        });
        
        // AU DELA
        push(LOCUTION, () ->
        {
            add("au-del??", "beyond");
            add("Vous pouvez vous promener jusqu'ici; au-del??, c'est interdit", "You can stroll upto here; beyond, is forbidden");
            add("vers l'infini et au-del?? !", "to infinity and beyond!");
        });
        
        // AU FAIT
        push(LOCUTION, () ->
        {
            add("au fait", "incidentally (expr.)");
            add("Salut Pierre ! Au fait, j'ai parl?? ?? ta soeur hier", "Hi Pierre! Incidentally, I talked to your(tu) sister yesterday");
            add("Je n'ai qu'une minute, donc je vais droit au fait", "I only have a minute, so I'll go straight to the point");
            add("Je ne suis pas au fait de sa situation", "I'm not familiar(fait) with his situation");
        });
        
        add("au sujet de", "regarding", "on the subject of");
        add("au moins", "at least");
        add("au plus", "at most");
        add("autant que", "as much as", "as far as");
        add("au bout d'un moment", "(expr.) after a while");
        
        add("est aussi...que", "is as...as");
        
        add("augmenter", "(v.) increase");
        add("?? moins que", "unless ...");
        {
            //add("Vous n'obtiendrez pas de travail ici ?? moins que vous n'ayez un doctorat", "You won't obtain work here here unless you have a doctorate");
            //add("N'??pousez jamais une veuve, ?? moins que son mari ait ??t?? pendu", "Never marry a widow, unless her husband has been hanged");
        }

        add("auparavant", "beforehand", "previously");
        {
            add("Il avait d??j?? fini le travail une semaine auparavant", "He had already finished the work a week before");
            add("Je veux bien ??couter l'histoire, mais cherchons une boisson auparavant", "I really want to hear the story, but let's find a drink beforehand");
        }
        
        add("autant", "so much (Why do you work so much?)");
        add("autant que", "as much as (She eats twice as much as him");
        add("autrefois", "in the past", "formerly");
        add("autrement dit", "in other words");
        add("autour de", "around (location)");
        add("avant", "before (time)");
        
        add("apparemment", "apparently", "seemingly");
        {
            add("Une puissance apparemment assur??e", "A power apparently assured");
            add("Le probl??me, c'est que je suis le chef, mais apparemment je ne peux rien dire !", "The problem, is that I'm the boss, but apparently I can't say anything!");
            add("Et apparemment, il esp??re pouvoir compter sur ta discr??tion", "And apparently, he hopes to be able to count on your(tu) discretion");
            add("Puis-je vous rappeler que c'est apparemment consenti", "Can I remind you that it's apparently consensual");
        }
        
        add("ailleurs", "elsewhere", "somewhere else");
        {
            add("nulle part ailleurs", "nowhere else");
            add("partout ailleurs", "everywhere else");
            add("d'ailleurs", "futhermore", "moreover", "by-the-way");
            add("D'ailleurs, je voulais vous dire", "By the way, I wanted to tell you ...");
            add("Ici, c'est aussi bien qu'ailleurs", "Here, is as good as spot as any");
            add("Restez debout ailleurs", "Stand somewhere else");
            add("Bravo, d'ailleurs", "Bravo, by-the-way");
            // STEPH: add("D'ailleurs, parlons des mensonges que tu m'as dit", "By the way, lets talk about some lies you told me"); - dit or dits?
            add("On prendra nos bagels ailleurs", "I/We'll be getting our bagels elsewhere");
        }
        
        add("J'ai besoin de", "I need ...");
        add("bas les pattes !", "(expr.) Hands off!");
        add("bien que", "although ( He left although I told him to stay here)");
        add("Ils veulent bien", "They really want");
        add("Nous esp??rons bien", "We really hope");
        add("bient??t", "soon");

        // CASSER
        {
            add("se casser", "(v.) to scram,clear-off");    
            add("Je pleure parce que je viens de casser avec mon mec", "I'm crying because I've just broken up with my guy");
            add("casse-toi !", "(tu) Clear-off!");
            add("Je me suis cass??", "I cleared-off");
        }
        
        add("??a m'est ??gal", "I don't care (all the same to me)");
        add("carr??ment", "definitely (slang)");
        add("cens??ment", "supposedly");

        add("cependant", "meanwhile");
        {
            add("Nous nous amusons, et cependant la nuit vient", "We are having fun, and meanwhile the night comes", PRONOMINAL);
        }
        
        // CE
        {
            add("ce mois-ci", "*this* month");
            add("ce mois-l??", "*that* month");
            add("C'est une bonne id??e !", "That's a good idea!");
            add("C'est difficile ?? faire", "It's hard to do");
            add("C'est triste de perdre un ami", "It's sad to lose a friend");
            add("ceci", "*this*");
            add("cela", "*that*");
            add("Ceci va ??tre facile", "*This* is going to be easy");
            add("Ceci peut nous aider", "*This* can help us");
            add("Cela doit aller dans la cuisine", "*That* has to go in the kitchen");
            //add("Donnez-lui cela de ma part", "Give him *this* from me");
            add("Qui a fait ceci ?", "Who did *this* ?");
            add("Je ne veux pas ceci, je veux cela", "I don't want *this*, I want *that*");
            add("Ce livre-ci est tr??s int??ressant", "*This* book is very interesting");
            add("Je pr??f??re ces rideaux-ci", "I prefer *these* curtains");
            add("Je dois travailler ce samedi", "I must to work this Saturday");
            add("Je dois travailler ce samedi-ci", "I must work *this* Saturday");
            add("Qui ??coute de la musique ?? cette heure-ci ?", "Who is listening to music at *this* hour?");
            add("Celui-ci est tr??s int??ressant", "This one is very interesting");
            add("Ce tableau est tr??s joli", "That painting is very pretty");
            add("Ce tableau-l?? est tr??s joli", "*That* painting is very pretty");
            add("Je pr??f??re ces chaises-l??", "I prefer *those* chairs");
            add("Je ne peux pas te voir ce dimanche", "I can't see you(tu) that Sunday");
            add("Je ne peux pas te voir ce dimanche-l??", "I can't see you(tu) *that* Sunday");
            add("Celui-l?? est tr??s joli", "That one is very pretty");
        }
        
        add("??a ne se fait pas", "(expr.) That isn't done", EXPR);
        add("??a ne se dit pas", "(expr.) That isn't said", EXPR);
        
        add("faire cuire", "(v.) to cook");
        {
            add("Je fais cuire le repas", "I'm cooking the meal");
        }
        
        add("C'est pas terrible", "It's not that great (expr.)", "It's nothing special (expr.)");
        {
            add("It's not that great", "C'est pas terrible (expr.)");
            add("Georges adore ce vin, mais ?? mon avis, c'est pas terrible", "Georges adores this wine, but in my opinion, it's not that great (expr.)");
            add("Qu'est-ce que tu as pens?? de ce film ? Pas terrible", "What did you think of that film? nothing special (expr.)");
            add("La premi??re fois c'??tait pas terrible", "The first time wasn't great");
            add("Mais personnellement, je le trouve pas terrible", "But personally, I don't find him great");
        }

        addCompound("comme ceci - comme cela", "like *this* - like *that*");
        add("Combien co??te cet attach??-case ?", "How much does this attache-case cost ?"); 
        {
//            Combien plus d'??nergie que j'ai ! Combien plus d'??nergie ai-je !
//   How much more energy I have! (I have so much more energy)

//            add("Combien d'argent que tu d??penses ! Combien d'argent d??penses-tu !
//   How much money you're spending! (You're spending so much money!
        }
        
        add("compatir", "(v.) to sympathise");
        add("compris", "comprendre past participle");
        add("contraindre", "(v.) to constrain");
        add("contre", "against");
        addCompound("celui-ci - celui-l??", "*This* one (bike) - *That* one (bike)");
        addCompound("ceux-ci - ceux-l??", "*These* ones (books) - *Those* ones (books)");
        addCompound("celle-l?? - celle-ci", "*That* one (jacket) - *This* one (jacket)");
        addCompound("celles-l?? - celles-ci", "*Those* ones (cars) - *These* ones (cars)");

        add("d'abord", "first (sequence)", "in the first place");
        {
            add("D'abord, mets-le dans le jardin", "(tu) First, put it in the garden");
        }
        
        add("dans", "in (+noun w/article)");
        add("Dans le bus", "On the bus");
        add("Dans le tram", "On the tram");
        //("davantage", "more/plus (Nous souhaitons fid??liser *** notre client??le)");

        add("d??s que", "once (eg: do that once you have finished)", "as soon as");
        {
            add("Je partirai d??s que tu seras pr??t", "I will leave once as you(tu) are ready", "I will leave as soon as(inf.) you(tu) are ready");
            add("Je suis venu d??s que j'ai pu", "I came as soon as(inf.) I could");
        }
        
        add("de toute fa??on", of("regardless", "anyway (regardless)", "all the same (regardless)"), LOCUTION);
        {
            add("De toute fa??on, dangereux ou pas, quelqu'un doit y aller", "All the same, dangerous or not, someone must go there");
        }
        
        add("de moins en moins", "less and less");
        add("de plus en plus", "more and more");
        add("de la boite", "from the box");
        add("du carton", "from the cardboard box");
        add("deux poids et deux mesures", "double standards");
        addCompound("d??cevoir - to disappoint", "(v.) to disappoint - (v.) d??cevoir");
        add("tromper", "(v.) to trick");
        add("d??chirer", "(v.) to rip up", "(v.) to tear up");
        add("d??caler", "(v.) to stagger/shift");
        add("d??m??nager", "(v.) to move home", "(v.) to move out (eg: apartment)");
        add("d??tends-toi du string", "don't get your knickers in a twist");
        add("d??tends-toi !", "(tu) relax!");
        add("disappointment", "dec??ption");
        add("dans un instant", "in a jiffy");
        add("d??finitivement", "definitely");

        add("d??cider", "(v.) to decide");
        {
            add("d??cider de", "(v.) to decide to ...");
            add("se d??cider", "(v.) to make one's mind up");
            add("J'ai d??cid?? d'aller ?? Paris pour l'??t??", "I decided to go to Paris for the summer");
            add("Une chose d??cid??e", "A thing decided");
            add("J'ai d??cid?? de d??m??nager", "I decided to move out");
            add("Je me suis d??cid?? ?? d??m??nager", "I made up my mind to move out");
        }
        
        add("dedans", "inside ('he is inside')");
        add("dehors", "outside ('he is outside')");
        
        add("depuis", "since", TEMPORAL);
        push(TEMPORAL, () ->
        {
            add("depuis que", "since+verb");
            add("Depuis que TF1 a ??t?? privatis??e", "Since TF1 has been privatised ...");
            add("Depuis la privatisation de TF1", "Since the privatisation of TF1 ...");
            add("Depuis quand fumez-vous ?", "How long have you been smoking for ?");
            add("Depuis quand mangent-ils ?", "How long have they been eating for ?");
            add("Je patine depuis toujours", "I've been skating forever");
            add("Je voulais faire ??a depuis tr??s longtemps", "I've been wanting to do that for a very long time");
            add("J'aurais d?? le faire depuis longtemps", "I should have done it (since) ages ago");
            add("Il ne m'a pas ??valu?? depuis des ann??es", "He hasn't evaluated me for years");
            add("Celle-ci est dingue - pourrais-tu me la redire depuis le d??but", "*This* |joke| is crazy - could you(tu) re-tell me it from the start");
            add("On se disputait depuis un moment", "I/We were arguing for a while");
            add("Je te suis depuis des semaines", "I've been following you(tu) for weeks");
            add("Je voulais venir depuis longtemps", "I've been wanting to come for a long time");
            add("Il en parlait depuis longtemps", "He was talking about it for a long time");
            add("Je sors avec Erin depuis cet ??t??", "I've been dating Erin since this summer");
            add("On l'attend depuis 9h", "I/We've been waiting for it since 9am");
            //add("Dwight a la paix depuis un moment, il est devenu incontr??lable", "Dwight has been left alone for a while, he has become uncontrollable");
            add("Depuis qu'il vit ici, il y a toujours des probl??mes", "Since he's lived(vivre) here, there has always been problems", DE);
            add("Je l'ai su depuis le d??but", "I knew it from the start");
            add("Je suis sur le honshu depuis deux jours, mais je ne lui ai toujours pas parl??", "I've been on the Honshu for two deux, but I still haven't spoken to him");
            add("Depuis quand Retaya ??tait-il recherch?? par le Tal Shiar ?", "How long was Retaya(m) searched-for by the Tal Shiar?");
            add("Je suis dans cette salle depuis une demi-heure", "I've been in this room for half an hour");
        });
        
        add("derri??re", "behind");
        
        add("d??sol??", "sorry");
        add("dessus", "on (+pronoun)", "on top of (+pronoun)", PHYSICAL);
        add("dessous", "under (+pronoun)", "beneath (+pronoun)", "below (+pronoun)", PHYSICAL);
        add("devant", "before (location)", PHYSICAL);
        add("diff??rent", "different");
        add("diff??remment", "differently");
        add("donc", "so");
        add("d'une mani??re ou d'une autre", "in one way or another");        
        add("??clairer", "(v.) to light up", "(v.) to brighten");
        add("de temps en temps", "from time to time");
        
        add("??garer", "(v.) to mislead", "(v.) to mislay");
        add("en effet", "indeed", LOCUTION);
        add("en face de", "opposite (location)");
        
        // EN FAIT
        push(LOCUTION, () ->
        {
            add("en fait", "(no) in fact", "(no) as a matter of fact");
            add("Non, en fait, j'ai d??j?? mang??", "No, actually, I've already eaten");
            add("J'avais pens?? que nous allions le faire ensemble, mais en fait j'??tais tout seul", "I'd thought we were going to do it together, but in fact I was alone");
        });
        
        add("en solde", "on sale");
        add("Soldes et bonnes affaires", "Sales and good deals");
        add("enchant??", "nice to meet you");
        
        add("effrayant", "scary");
        add("effray??", "frightened");
        add("emm??nager", "(v.) to move in (to a new home)");
        add("emprunter", "(v.) to borrow");
        //add("en haut", "upstairs");
        add("en moyenne", "on average");
        add("en aucun cas", "under no circumstances");
        add("en tout cas", "in any case", "anyway", "whatever happens", LOCUTION);
        add("en septembre", "in September");
        add("en novembre", "in November");
        add("en mai", "in May");
        add2("au printemps - en ??t?? - en hiver", "in the spring - in summer - in winter");
        add("endroit", "place (location)");
        add("enfin", "at last", "finally", "at least ('I am good, at least OK')");
        add("se entretenir", "(v.) to have a discussion (with someone)");
        add("ensuite", "then ('I ate and then I left')", "next ('I ate and next I left')");
        add("mon ??pouse", "my spouse(wife)");
        add("esp??rer", "(v.) to hope");
        add("essuyer", "(v.) to wipe down");
        add("??touffer", "(v.) to suffocate");
        add("et puis", "and then");
        add("??videmment", "obviously");
        
        add("??puiser", "(v.) to exhaust", "(v.) to wear out");
        
        add("s'excuser", "(v.) to apologise");
        {
            //add("Comment pourrait-il s'excuser d'une telle faute ?", "How could he be excused of such a fault ?");
        }
        
        add("apprendre ??", "(v.) to learn to ...");
        add("aider ??", "(v.) to help to ...");
        add("??couter", "(v.) to listen to ...");

        add("s'??clater", "(v.) to have a great time");
        {
            add("Je me suis ??clat??e ?? cette soir??e !", "I(f) had a great time a that soir??e!", PRONOMINAL, AGREEMENT);
            add("La bombe va ??clater ?? minuit", "The bomb is going to blow up at midnight");
            add("L'incendie a ??clat?? ?? cause des cigarettes", "The fire broke out because of some cigarettes");
            add("Quand je lui ai racont?? la blague, il a ??clat?? de rire", "When I told him the joke, he burst out laughing");
            add("Son talent ??clatera toujours", "Her talent will always shine through");
        }
        
        add("emp??cher", "(v.) to prevent");
	{
            add("Elle m'a emp??ch?? de fuir", "She stopped me from fleeing");
	} 
        
        
        add("faites-moi confiance", "Trust me");
        add("fais gaffe !", "Watch out ! (tu)");
        add("faute de frappe", "typo");
        add("ferm?? ?? cl??", "locked");
        add("fuir", "(v.) to flee");
        add("fui", "to flee past participle");
        
        add("garer", "(v.) to park");
        
        add("g??rer", "(v.) to manage", "(v.) to administer");
        {
            add("Cette entreprise est bien g??r??e", "This company is well managed");
            add("Ces fonds sont g??r??s par l'ONU", "These funds are administered by the UN");
        }
        
        add("gr??ce ??", "thanks to (positive)");

        add("h??ter", "(v.) to hasten");
        {
            add("Les pluies ont h??t?? la v??g??tation", "The rains hastened the vegetation");
            add("Ces ??v??nements ont h??t?? sa ruine", "These events hastened her ruin");
            // add("Faites h??ter le diner !", "Hurry up the dinner!");
            add("h??ter de", "(v.) can't wait for");
            add("J'ai h??te de voir ce qui Dwight a pr??vu", "I can't wait to see what Dwight has planned");
            add("J'ai h??te !", "I can't wait!");
            add("J'ai trop h??te !", "I can't wait at all!");
        }
        
        add("hier", "yesterday");
        
        add("Je t'en prie", "My pleasure (tu)");
        add("Je vous en prie", "My pleasure (expr).");
        
        // IL S'AGIT DE
        push(LOCUTION, () ->
        {
            add("Il s'agit de", "It consists of ...", "It is a question of ...");
            add("Il s'agit d'argent", "It has to do with money", DE);
            //add("Il s'agit de faire ce qu'on peut", "It's a question of doing what one can");
            add("Il s'agit de fuir en vie", "It is about fleeing alive");
            add("Il ne s'agirait que de quelques officiers", "It would only consist of some officers");
        });
        
        add("int??ressant", "interesting", "lucrative", "profitable");
        
        add("inqui??ter", "(v.) to worry");
        {
            add("s'inqui??ter", "(v.) to be worried");
            add("Ne t'inqui??te pas !", "Don't (tu) worry!");
            add("Il ne faut pas s'inqui??ter", "Not necessary to worry");
            add("Cette nouvelle m'inqui??te", "This new(s) worries me");
        }
        
        add("importer", "(v.) to matter", "(v.) to be important");
        add("impeccable", "faultless");
        add("inqui??ter", "(v.) to worry");

        add("il est s??r que", "it is certain that");
        {
//            add("Il est s??r / C'est s??r qu'il le fait.\n" +
//"It's sure/certain that he'll do it.")
//                    
//                    Il n'est pas s??r / Ce n'est pas s??r qu'il le fasse.
//It's not certain that he'll do it.
//
//Est-il s??r / Est-ce s??r qu'il le fasse ?
//Is it certain that he'll do it?
        }
        
        
        add("Je suis mal fichu", "I feel out-of-sorts (expr.)");
        add("Je me suis lav?? les mains", "I washed my hands");
        add("Je ne sais pas comment", "I don't know how");
        
        add("jusque", "until", "upto");
        {
            add("Je suis d??bord?? - j'ai du travail jusqu'aux oreilles", "I am swamped - I've got work upto my ears");
            add("Je ne veux pas rester jusqu'?? 19h cette ann??e", "I don't want to stay until 7 this year");
        }
        
        add("jusqu'?? ce que", "up until (time)");
        {
            add("Je vous aiderai jusqu'?? ce qu'il parte", "I'll help you up until he leaves", SUBJUNCTIVE);
            add("Je resterai ici jusqu'?? ce que vous reveniez", "I will stay here up until you return", SUBJUNCTIVE);
            add("Jusqu'?? ce que je gagne au loto", "Up until I win the lottery");
            add("jusqu'?? ce que le coupable se fasse connaitre", "... up until the guilty person makes himself known", SUBJUNCTIVE, PRONOMINAL);
            add("Vous me suivriez jusqu'au bout du monde en grognant", "You would follow me to the end of the earth while grumbling", PARTICIPLE);
            // add("J'ai d??cid?? qu'on ne fera rien jusqu'?? ce que tu aies les chips que tu demandes", "I've decided I/we are not going to do anything up until you(tu) get the crisps that you ask for", SUBJUNCTIVE);
        }
        
        add("jouer", "(v.) to play");
        {
            add("jouer ??", "(v.) to play a game or sport");
            add("jouer de", "(v.) to play an instrument");
            add("Arr??te de jouer !", "(tu) Stop playing/fooling around!");
            add("Il joue aux ??checs", "He's playing chess");
            add("Nous allons jouer au golf", "We're going to play golf");
            add("Elle ne joue pas ?? la poup??e", "She doesn't play with dolls");
            add("J'aimerais jouer du piano", "I'd like to play the piano");
            add("Depuis quand joue-t-elle de la fl??te ?", "How long has she played the flute?");
            add("Il ne sait pas jouer de la guitare", "He doesn't know how to play the guitar");
        }
                
        add("L??", "there");
        add("L??-bas", "over there");
        add("La plupart de", "most of ...");
        add("Le vendredi", "on fridays");
        add("Le cas ??ch??ant", "If applicable ...", LOCUTION);
        add("Loin de", "far from");
        add("Lors de", "at the time of...");

        add("malgr??", "despite", "in spite of");
        {
            add("Je ne comprends pas, malgr?? mes arguments, il est parti", "I don't understand, in spite of my arguments, he left");
        }
        
        add("Mangez-les tous", "Eat them all");

        // MENER
        add("mener", "(v.) to lead");
        {
            add("Le bus va nous mener au ch??teau", "The bus is going to lead us to the castle");
            add("Louis va mener ce cours", "Louis will lead this lesson");
            add("L'??quipe bleue m??ne 2 ?? 0", "The blue team is leading 2-0");
            add("amener", "(v.) to bring (a person)", "(v.) to give a lift");
            add("Je peux t'amener chez toi ?", "I can give you(tu) a lift home?");
            add("Elle m'a amen?? en voiture ?? la gare", "She gave me a lift by car to the station");
            add("emmener", "(v.) to take out/away");
            //add("Quand cet employ?? a quitt?? cette maison de commerce, il a emmen?? tous les clients, une partie de la client??le avec lui.
            add("??a ne m??ne ?? rien", "This is getting us nowhere (expr.)");
        }
        
        add("meanwhile", "cependant");
        add("mettre", "(v.) to put", "(v.) to place", "(v.) to set");
        add("moins", "less");
        add("mesure", "(v.) to measure");
        
        add("n'importe o??", "anywhere", LOCUTION);
        add("n'importe qui", "anybody", "whoever", LOCUTION);
        add("n'importe quand", "anytime", "whenever", LOCUTION);
        add("n'importe quoi", "whatever", LOCUTION);
        
        add("narguer", "(v.) to taunt");
        
        add("nulle part", "nowhere", LOCUTION);
        
        // OCCUPER
        {
            add("Vos valises occupent toute la chambre", "Your suitcases take up the whole bedroom");
            add("Il va occuper le nouveau poste", "He's going to fill the new position");
            add("s'occuper de", "(v.) to deal with", "(v.) to handle", "(v.) to care of");
            add("Tu peux t'en occuper ?", "(tu) You can take care/handle it ?", CLITIC, EN);
            add("Il ne s'occupe que de bagatelles", "He only deals with trifles");
            add("Je m'en occupe", "I'm handling it", EN);
            add("Je m'occupe de distribuer les copies", "I'm dealing with the distribution of copies");
            add("Moi, je m'occupe des clients", "Me, I'll take care of the clients");
            add("On doit s'occuper des enfants", "I/We must handle the children");
            add("s'occuper ??", "(v.) to keep busy");
            add("Il s'occupe ?? son jardin", "He keeps himself busy with his garden");
            add("Tout le jour il s'occupe ?? lire", "All day he keeps himself busy reading");
            add("Il ne sait pas ?? quoi s'occuper", "He doesn't know how to keep busy");
            add("Je peux m'occuper de lui", "I can handle/take care of him");
            add("Allez-vous vous occuper de lui ?", "(Are) you going to handle him?");
        }
        
        add("o?? vas-tu ?", "Where (are) you(tu) going?");
        
        add("ou bien", "or else", LOCUTION);
        add("Quelle odeur !", "What a smell !");
        
        add("par", "through (eg: left through the door)", "by (eg: left by the door)", "via");
        add("par contre", "on the other hand (expr.)");
        add("par-dessus", "over (over the fence)", PHYSICAL);
        add("par-dessous", "under (under the fence)", PHYSICAL);
        add("par exemple", "for example", "for instance", LOCUTION);
        
        add("par rapport ??", "in relation to", LOCUTION);
        {
            add("La terre est tr??s petite par rapport au soleil", "The earth is very small in relation to the sun", LOCUTION);
        }
        
        add("par terre", "on the ground");
        add("parler au t??l??phone", "Speak on the phone");
        add("parfois", "occasionally");
        add("parmi", "among");
        add("partout", "everywhere");
        {
            add("partout sauf chez moi", "Everywhere except round mine");
            add("Il y avait du monde partout, je ne pouvais pas bouger", "There were people everywhere, I couldn't move");
            add("Ils vont partout", "They're going everywhere");
        }

        add("pas de bol !", "unlucky! (expr.)");
        
        add("pas de quoi", "No big deal (expr.)", "Don't mention it (expr.)");
        add("pas du tout", "not at all");
        add("pas encore", "not yet");
        add("pas toujours", "not always");
        add("pendant", "during");
        add("pendant que", "while");
        add("permettre", "(v.) to permit");
        add("peu", "few");
        add("pire", "worse");
        add("plein", "full");

        add("par m??garde", "inadvertently", LOCUTION);
        {
            add("Il a bris?? ce vase par m??garde", "He inadvertently shattered that vase");
        }
        
        add("passer", "(v.) to go through", "(v.) to spend time");
        {
            add("se passer", "(v.) to take place", "(v.) to happen");
            //add("Le train va passer dans cinq minutes", "The train is going to pass in five minutes");
            add("Nous sommes pass??s devant la porte ?? midi", "We passed in front of the door at noon");
            add("Je vais passer te voir demain", "I'm going to pass (by to) see you(tu) tomorrow");
            //add("Pouvez-vous passer acheter du pain ?Can you go buy some bread?                    ");
            add("On doit passer la rivi??re", "I/We must cross the river");
            add("Il a d??j?? pass?? la porte", "He has already gone through the door");
            add("Nous allons passer deux semaines en France", "We're going to spend two weeks in France");
            add("J'ai pass?? trois mois sur ce livre", "I spent three months on that book");
            add("Je suis pass?? devant la porte", "I passed in front of the door");
            add("J'ai pass?? la porte", "I passed the door");
            add("Tout s'est bien pass??", "Everything went smoothly (expr.)");
            add("Deux jours se sont pass??s", "Two days went by");
            add("Qu'est-ce qui s'est pass?? ?", "What happened?");
            add("Qu'est-ce qui se passe ?", "What is happening?");
            add("Ma premi??re interview s'est pass??e comme pr??vue", "My first interview(f) went as expected", PRONOMINAL, AGREEMENT);
            add("Elle a pass?? la douane sans accroc", "She cleared customs without a hitch");
            add("Je passe souvent mes vacances en France", "I often spend my holidays in France");
        }
        
        add("Il n'y a plus de place dans la boite", "There's no more space in the box");
        add("Il y a assez de place", "There's enough space");
        
        add("pleurer", "(v.) cry");
        {
            add("pleur??", "(v.pp) cry");
        }
        add("pleuvoir", "(v.) rain");
        add("plut??t", "rather");
        add("plus", "no more", "no longer");
        add("pr??f??r??", "preferred");
        add("pr??s", "near");
        
        add("pr??voir", of("(v.) to anticipate", "(v.) to foresee", "(v.) to make provisions for", "(v.) to forecast"));
        add("pr??venir", "(v.) to warn");
        
        //  APZ CONTEXT EXAMPLES add("puisque", "You can leave ***since*** you're sick", "***Since*** it was his mistake, he helped me");
        
       add("promis", "(v.pp) to promise");
        
        add("poursuivre", "(v.) to continue (eg: meeting)");
        {
            add("On aimerait poursuivre cette r??union en priv??", "I/We would like to continue/persue this meeting in private");
            //add("L'enqu??te se poursuit", "The enquiry continues");
            add("reprendre", "(v.) to resume");
            //add("Nous reprendrons cette discussion demain ?? neuf heures", "We will resume this discussion tomorrow at nine");
            //add("Bien s??r, il y a certains d??fis qui vont se poursuivre", "Of course, there are some challenges that are going to continue");
        }
        
        add("pourtant", "however", "yet");
        {
            add("Et pourtant elle tourne", "And yet she turns");
        }
        
        add("prendre les devants", "take the lead (expr)");
        add("pr??ter", "(v.) to lend");
        
        add("qu'est-ce qui est", "What is ...");
        add("quand-m??me", "anyway (despite)", "all the same (despite)", "But still! (despite)");
        add("qu'elle", "That she");
        add("Je suis quasiment tomb??", "I almost fell (colloq.)");

        add("quelque", "some");
        {
            add("J'ai quelque envie de", "I kind of want ...");
            add("Il y a quelque 10 ans", "About 10 years ago ...");
            add("quelque chose", "something");
            add("quelquefois", "sometimes");
            add("quelque part", "somewhere");
            add("quelqu'un", "someone");
            add("en quelque sorte", "kind-of-like (expr.)", "of some sort (expr.)", "in a sense (expr.)");
            {
                add("Les Dundies sont, en quelque sorte, comme une f??te d'anniversaire", "The Dundies are, kind of, like a birthday party");
                add("Je suis d??j?? prise, en quelque sorte", "I(f.) am already taken, kind of");
            }
            
            //add("quelque chose d'int??ressant", "something interesting");
            //add("dans quelque temps", "before long");
            //add("depuis quelque temps", "for a while");
            add("Il y a quelque cinq ans, j'ai habit?? ici", "About (some) five years ago, I lived here");
            add("Je suis quelque peu d????u", "I am somewhat disappointed");
            add("J'ai laiss?? mes cl??s quelque part. Aidez-moi ?? les trouver", "I left my keys somewhere. Help me find them");
            add("Quelques gens aiment ses chansons", "Some people like his songs");
        }
        
        add("ralentir", "(v.) to slow down");
        {
            add("Il faut ralentir la voiture avant le carrefour", "It is necessary to slow the car down before the intersection");
            add("Nous avons ralenti nos efforts apr??s son annonce", "We slackened our efforts after his announcement");
        }
        
        add("rater", of("(v.) to misfire", "(v.) to miss (eg: a shot)", "(v.) to fail", "(v.) to mess up"));
        {
            add("Fais attention ! Le fusil peut rater", "(tu) Pay attention! The rifle could misfire");
            add("Elle a rat?? le train pour Paris", "She missed the train to Paris");
            //("Le project a rat?? parce que Paul n'y a pas contribu??", "The project failed because Paul didn't contribute to it");
            add("Tu as rat?? ta vie !", "You've (tu) failed your life!");
        }

        add("rappeler", "(v.) to call back");
        {
            add("se rappeler", "(v.) to remind", "(v.) to recall");
            add("Amelie me rappelle toi", "Amelie reminds me of you(tu)");
            add("Tu me rappelles mon fr??re", "You(tu) remind me of my brother");
            add("Vous me rappelez mon fr??re", "You remind me of my brother");
            add("rappelle-moi demain", "Remind me (tu) tomorrow");
            add("Rappelle-moi mon r??le", "(tu) Remind me of my role");
            add("Rappelle-le", "(tu) Call him back");
            add("Il s'est rappel?? qu'elle parle chinois", "He recalled that she speaks Chinese", PRONOMINAL);
        }
        
        add("r??cemment", "recently");
        
        add("recevoir - re??u", "(v.) to recieve - (v.pp) to recieve");
        
        add("remarquer", "(v.) to notice");
        {
            add("Je remarque qu'il le fait", "I notice that he is doing it");
        }
        
        //_("relou", "Irritating / annoying / frustrating (slang) ");
        add("remplir", "(v.) to fill", "(v.) to fill in", "(v.) to fulfill");
        
        add("rencontrer", "(v.) to meet", "(v.) to come across");
        {
            add("La plupart du temps, les v??hicules que vous rencontrez sur les routes sont des camions", "Most of the time, the vehicules that you come across on the roads are lorries");
            add("Nous nous sommes rencontr??s en voyage", "We met each other travelling", PRONOMINAL);
            add("J'ai rencontr?? ta soeur en ville", "I meet your(tu) sister in town");
            add("J'esp??re ne pas rencontrer mon ex ce soir", "I hope I don't meet my ex tonight");
        }
        
        add("rendre", "(v.) to return (item)");
        {
            add("se rendre", "(v.) to surrender", "(v.) makes oneself become (eg: feeling)");
            add("Apr??s trois longues heures d'attente, le voleur s'est finalement rendu", "After three long hours of waiting, the thief finally surrendered", PRONOMINAL);
            add("se rendre compte", "(v.) to realise", "(v.) to be aware");
            add("Rendez-vous compte !", "Just imagine! (expr.)");
            add("Je me suis rendu compte", "I realised/became aware");
            add("Je ne me suis pas rendu compte qu'il allait arriver ce soir", "I didn't realise/was unaware that he was going to arrive this evening");
            add("Tu te rends compte de la situation ?", "You(tu) aware of the situation?");
            add("Et il l'a fait, tu te rends compte !", "And he did it, can you(tu) imagine! (expr.)");
            add("Et Dwight s'en est rendu compte", "And Dwight figured |it| out/Became aware |of it|", EN);
            add("Je me suis rendu compte que certains ici", "It has come to my attention that some people here ...");
            add("Je me rends compte que vous savez", "I realise that you know ...");
            add("Je me suis rendu compte que certains d'entre vous ont oubli??", "It has come to my attention that some of you have forgotten ...");
            add("Je te le rends ce soir", "I (will) give it back to you(tu) this evening", CLITIC);
            add("Tu me rends malade", "You(tu) make me ill");
            add("L'amour vient rendre visite ?? mon ??me", "Love comes to pay a visit to my soul");
            add("Je vais rendre visite ?? mes grands-parents", "I am going to visit my grandparents");
            add("Il rend visite ?? ses grands-parents chaque ??t??", "He visits his grandparents every summer");
            add("Est-ce que tu as rendu visite ?? tes amis hier ?", "Did you (tu) visit your friends yesterday ?");
            add("Je rends visite ?? Anne", "I'm visiting Anne");
            add("Nous rendons visite ?? Luc", "We're visiting Luc");
        }
                
        add("r??pondre", "(v.) to reply", "(v.) to answer");
        
        // RETROUVER
        add("Ils ont retrouv?? le tr??sor qu'ils avaient enterr??", "They re-found the treasure they had buried");
        //Je ne retrouve plus son nom.
            //I no longer remember his name.
    //To meet; to meet up; to bump into

        //J'ai retrouv?? mon ancien ami au bord du lacI met up with my old friend by the lake.

        add("r??actualiser", "(v.)  to refresh (as in details)");
        add("Je reviens de mes vacances", "I'm coming back from my holiday");
        add("Je n'ai pas l'intention de revenir ?? Paris", "I've no intention of returning to Paris");

        
        add("se f??cher", "(v.) to get angry");
        add("selon", "according to");
        add("sensible", "sensitive");
        add("un peu", "a little");
        add("un peu sensible", "a little sensitive");
        
        add("sans doute", "probably");
        {
            add("probably", "sans doute");  
            add("probablement", "likely");
            add("Il viendra probablement", "He will likely come"); 
            add("Il viendra sans doute", "He will probably come");        
        }
        
        add("secouer", "(v.) to shake (off/up)");
        {
            add("Il faut bien secouer la vinaigrette", "You have to shake the vinaigrette well");
            add("Une crise a secou?? les n??gociations de la paix", "A crisis has shaken up the peace negotiations");
        }

        add("faire semblant de", "to pretend");
        {
            add("Il a fait semblant de dormir pour ne pas ??tre d??rang??", "He pretended to be asleep so as to not be disturbed");
            add("Pierre fait semblant d'??tre f??ch??", "Pierre pretends to be angry");
            add("Il a fait semblant d'??tre mort", "He pretended to be dead");
        }
        
        add("si seulement", "if only...");
        add("sinon", "otherwise");
        {
            // add("Pourquoi a-t-on pris cette d??cision, sinon pour nous aider ? - Why was this decision made, if not to help us?
            // Je n'en sais rien, sinon qu'il n'y va pas. - I don't know anything about it, other than that he's not going.
            add("Fais-le, sinon tu ne peux pas sortir ce soir", "(tu) Do it, otherwise you can't go out tonight");
        }
        
        add("soi-disant", "so-called");
        {
            add("La soi-disant libert?? d'expression", "So called freedom of expression");
        }
        
        add("sous", "under (+noun)", PHYSICAL);
        add("souvent", "often");
        add("sup??rieure", "greater than");
        add("sur", "on (+noun)", "on top of (+noun)");

        add("surtout", "above all", "most of all");
        {
            add("J'aime bien lire, surtout les romans", "I like to read, especially novels");
            add("Il est intelligent, cr??atif et surtout gentil", "He is smart, creative, and above all kind");
            add("Surtout ne fais pas ??a !", "Above all, don't(tu) do that!");
        }
        
        add("tant", "so much (+verb)", "so many (+verb)");
        add("tard", "late");
        
        add("tenter", "(v.) to tempt", "(v.) to attempt");
        {
            add("Il me tente avec du chocolat", "He is tempting me with chocolate");
            add("J'ai tent?? la planche ?? voile l'ann??e derni??re", "I attempted windsurfing last year");
        }
        
        add("Tu te fous de moi ?", "You(tu) sh*tting me ?");
        add("tout d'abord", "first of all");
        add("t??t", "early");
        add("toujours", "always", "still (still there)");
        add("tout de suite", "straight away", "at once");
        {
            add("Je reviens de suite !", "Back soon ! (expr.)");
        }
                
        add("tous les mercredis", "every wednesday");

        add("un nombre de", "a number of ...");
        add("un de ces jours", "one of these days ...");
        add("un mur en briques", "a brick wall");
        
        add("verser", "(v.) to pour", "(verb) to pay into (account etc)");
        add("v??rifier", "(v.) to verify");
        add("volontiers", "gladly", "willingly");
        {
            add("Il ??coutera volontiers cette proposition", "He will gladly listen to that proposition");
            add("Je le ferai volontiers, tr??s volontiers", "I will do it willingly, very willingly");
        }
        
        // VALOIR
        {
            add("valoir", "(v.) to be worth");
            add("Il vaut mieux", "(expr.) It would be better...", "(expr.) It would be preferable...");
            add("Il valait mieux", "(expr.) Probably a good thing");
            add("Il aurait valu mieux", "(expr.) It would have been better...", "(expr.) It would have been preferable...");
            add("Ma montre vaut mieux que la v??tre", "My watch is better/preferable than your one");
            add("Vous valez mieux que lui", "You are better/preferable than him");
            add("??a vaut mieux pour toi !", "That would be better/preferable for you(tu) !");
            add("Il vaut mieux qu'elle vienne", "It would be better/preferable that she comes", SUBJUNCTIVE);
            add("Vaut mieux que tu ne saches pas", "Better you(tu) not know", SUBJUNCTIVE);
            add("Il vaut mieux que tu le fasses", "It would be better/preferable that you(tu) do it");
            add("Il vaut mieux qu'il le fasse", "It would be better/preferable that he does it");
            add("J'ai cru qu'il valait mieux que vous ne sachiez rien", "I thought it would be better/preferable that you didn't know anything");
        }
        
        add("vu", "In view of ...");
        {
            add("Vu le nombre de personnes ici, il vaut mieux partir !", "In view of the number of people here, (we're) better off leaving!");
        }
        
        add("yet", "pourtant");
        
        // can =  pouvoir, savoir (in the present tense)
        {
            add("Je peux vous aider", "I can help you");
            add("Sais-tu nager ?", "Can you(tu) swim?");
        }
        
        // could (in the present) =  pouvoir (in the conditional)
        {
            add("Je pourrais danser pendant toute la nuit", "I could dance all night");
            add("Pourriez-vous m'aider ?", "Could you help me ?");
        }
        
        // could (in the past) =  pouvoir (in the imperfect)
        {
            add("Je pouvais", "I could(past)...");
            add("Ils pouvaient", "They could(past)...");
            add("Il pouvait manger beaucoup de bonbons quand il avait trois ans", "He could eat a lot of candy when he was three");
            add("L'ann??e derni??re, je pouvais dormir jusqu'?? midi tous les jours", "Last year, I could sleep until noon everyday");
        }
        
        // may/might =  peut-??tre, pouvoir (in the conditional), se pouvoir (in the present)
        {
            //add("Elle arrivera peut-??tre ?? midi, Elle pourrait arriver ?? midi, Il se peut qu'elle arrive ?? midi", "She may/might arrive at noon");
        }
   
        // must =  devoir (present tense)
        {
            add("Je dois partir", "I must leave");
            add("Vous devez m'aider", "You must help me");
        }

        // shall/will =  French future tense
        {
            add("Je vous aiderai", "I will help you");
        }
        
        // should/ought to =  devoir (in the conditional)
        {
            add("Je devrais partir bient??t", "I should leave soon"/*, "I ought to leave soon"*/);
            add("Vous devriez m'aider", "You should help me"/*, "You ought to help me"*/);
        }
        
        // would (in the present) =  French conditional mood
        {
            add("Ils voudraient", "They would want ...");
            add("Nous voudrions partir", "We would want to leave");
            add("Ils aimeraient", "They would like ...");
            add("Nous aimerions partir", "We would like to leave");
            add("Je vous aiderais si j'??tais pr??t", "I would help you if I were ready");
        }

        // would (in the past) =  French imperfect tense
        {
            add("Il lisait toujours quand il ??tait seul", "He would always read when he was alone");
            add("L'ann??e derni??re, je dormais jusqu'?? midi tous les jours", "Last year, I would sleep until noon every day");
        }
   
        // could have = pouvoir (in the conditional perfect)
        {
            add("J'aurais pu", "I could have ...");
            add("Elles auraient pu", "They(f) could have ...");
            add("Vous auriez pu", "You could have ...");
            add("J'aurais pu vous aider", "I could have helped you");
            add("Nous aurions pu manger", "We could have eaten");
        }

        // may/might have =  peut-??tre, se pouvoir (plus past subjunctive)
        {
   //I may/might have done it.
   //Je l'ai peut-??tre fait, Il se peut que je l'aie fait.
//_____ que tu aies raison. (it is possible)
			//a) Il peut ??tre
			//b) Il se peut*
        }

        // must have = devoir (in the pass?? compos??)
        {
            add("Nous avons d?? la voir", "We must have seen her");
            add("Vous avez d?? le voir", "You must have seen it");
            add("Il a d?? manger", "He must have eaten");
        }

        // shall/will have = French future perfect
        {
            add("J'aurai mang??", "I will have eaten");
            add("Il sera arriv?? avant midi", "He will have arrived by noon");
        }

        // should have = devoir (in the conditional perfect)
        {
            add("Ils auraient d??", "They should have ...");
            add("Vous auriez d?? aider", "You should have helped");
            add("Nous aurions d?? manger", "We should have eaten");
        }

        // would have = French conditional perfect
        {
            add("Je vous aurais aid??", "I would have helped you");
            add("Il l'aurait mang??", "He would have eaten it");
        }
   
        // DEVOIR
        {
            add("Je lui dois ??a", "I owe him that");
            add("J'aurais d??", "I should have ...");
            add("Vous auriez d??", "You should have ...");
            add("Ils auraient d??", "They should have ...");
            add("Tu aurais d?? essayer", "You(tu) should have tried");
        }
        
        // POUVOIR
        {
            add("La fille a pu manger", "The girl was able to eat");
            add("On aurait pu mourir", "One could have died");
            add("Vous auriez pu perdre", "You might have lost");
            add("Je n'ai pas pu trouver les cl??s", "I couldn't find the keys");
        }
        
        // VOULOIR
        {
            add("Je voudrais du th??", "I would like some tea");
            add("Voudriez-vous venir avec nous ?", "Would you like to come with us?");
            add("Veuillez m'excuser", "Kindly excuse me");
            add("Veuillez vous asseoir", "Kindly sit down");
        }
        
        add("J'aurais d?? ??tre plus pr??cis", "I should have been more precise");
        
        
        //items.addAll(new AnnoyingPhrases(scores).items);
        
        Phrases.go(scores, sortPolicy, items);
        
        new SubjunctiveExpressions(this).setup();
        SurSousVocabulary();
        FrenchLanguageDrills();
        TheOfficeAnAmericanWorkplace();
        PocketFrenchGrammar();

        setupConditional();
        
        System.out.println(items.size() + " phrases total");
    }
    
    private void SurSousVocabulary()
    {
        push(PHYSICAL, () ->
        {
            add("sous la table", "Under the table");
            add("au-dessus de la table", "Above the table");
            add("au-dessous de la table", "Below the table");
            add("sur le mur", "On the wall");
            add("sous le mur", "Under the wall");
            add("au-dessus du mur", "Above the wall");
            add("au-dessous du mur", "Below the wall");
            add("Son nom est marqu?? sur le papier", "Her name is marked on the paper");
            add("Prenez le papier, son nom est marqu?? dessus", "Take the paper, her name is marked on it");
            add("La valise est sous la table", "The suitcase is under the table");
            add("Jean se cache sous le si??ge", "Jean is hiding under the seat");
            add("Tu vois le si??ge ? Jean s'est cach?? dessous", "You (tu) see the seat? Jean hid underneath it");
            add("Personne ne vit au-dessus de mon appartement", "No one lives(vivre) above my apartment");
            add("J'aime bien mon appartement - personne ne vit au-dessus", "I like my apartment - no one lives(vivre) above");
            add("Il a saut?? par-dessus", "He jumped over (it)");
            add("Je suis pass?? par-dessous la barri??re", "I passed under the barrier");
            add2("L'horloge est au-dessus du tableau - L'horloge est au-dessous du tableau", "The clock is above the painting - The clock is below the painting");
            add2("L'horloge est sous le tableau - L'horloge est au-dessous du tableau", "The clock is under the painting - The clock is below the painting");
            add2("Les cl??s sont sous les tournevis - Les cl??s sont au-dessus des tournevis", "The spanners are below the screwdrivers - The spanners are above the screwdrivers");
            add2("en-dessous - au-dessus", "underneath - above");
            add("Un pain tout br??l?? en-dessous", "A bread completely burnt underneath");
            add("Il m'a crach?? dessus", "He spat on me");
        });
    }    
    
    // http://www.columbia.edu/~fms5/fpro.html
    public void FrenchLanguageDrills()
    {
        push(CLITIC, () ->
        {
            add("Il les a lus", "He read |the books|", AGREEMENT);
            add2(   "Elle les lui donne - Elle les lui a donn??es",
                    "She gives |the flowers| to |her mother| - She gave |the flowers| to |her mother|");
            add("N'oublie pas de lui t??l??phoner !", "(tu) Dont't forget to phone |Jill|!");
            add("Paul n'aime pas l'attendre", "Paul doesn't like waiting for |the bus|");
            add2(   "J'ai oubli?? de remercier mon amie - J'ai oubli?? de la remercier",
                    "I forgot to thank my friend(f.) - I forgot to thank my |friend(f.)|");
            add("Il la leur a pos??e", "He asked |his students| |the question|", AGREEMENT);
            //add("Il faut lui r??pondre le plus vite possible", "One has to answer |Chantal| as quickly as possible");
            add("Est-ce que tu les as toutes termin??es ?", "Have you(tu) completed/terminated all |the questions|?", AGREEMENT);
        });
    }
    
    private void TheOfficeAnAmericanWorkplace()
    {
        add("J'ai toujours voulu l'??tre", "I always wanted to be it");
        add("La nudit?? me met mal ?? l'aise - j'aimerais qu'ils l'interdisent", "Nudity makes me uncomfortable - I would like that they forbade it");
        add("Je n'ai jamais tromp??, ??t?? tromp??e, ou aid?? ?? tromper", "I've(f) never cheated, been cheated on, or helped to cheat", AGREEMENT);
        add("Il se l??ve t??t, il se couche t??t - j'ai d?? lui dire !", "He gets up early, he goes to bed early - I had to tell him!", PRONOMINAL);
        add("J'en ai vraiment envie", "I've got a real desire |for it|", EN);
        //add("Ils ont d'autant plus besoin de notre argent", "They need our money more than ever")
        add("Tu pourrais lui donner ta ligne directe", "You(tu) could give her your(tu) direct line");
        add("Je me suis br??l?? le pied !", "I burnt my foot!");
        add("Il sera sans doute au bureau demain", "He will probably be in the office tomorrow");
        add("En fait, j'en ai besoin", "Actually, I need it");
        //add("Tu lui racontes quoi ?", "What (are) you retelling (to) her?");
        add("Ne lui dis pas n'importe quoi", "(tu)Don't tell her nonsense");
        add("Vous ne lui avez pas dit au revoir", "You didn't say goodbye to her");
        //add("Mais on peut se rattraper en ??tant m??chant avec elle", "But I/we can recover-by being mean with her");
        add("On en a parl??, ??a semblait ce que tu voulais", "I/We talked about it, that seemed what you(tu) wanted");
        add("C'est pour ??a que tu as autant de virus", "It's because of that that you(tu) have so many viruses");
        add("Je m'en occupe", "I'm on it (expr.)");
        add("Je n'en serais pas si s??r", "I wouldn't be so sure of it");
        add("Rien ne lui ??chappe", "Nothing escapes her");
        add("J'en ai plus que ??a", "I've got more of them than that", EN);
        add("Je t'appelle en arrivant", "I (will) call you(tu) on arriving");
        add("Tu te fous de moi ?", "You(tu) sh*ttin me?");
        add("C'est compliqu?? - tu ne comprendrais pas", "It's complicated - you(tu) wouldn't understand");
        add("Mike ne va nulle part", "Mike's not going anywhere");
        add("Et j'aurais aim?? que Jim soit l??", "And I would have liked Jim to be there", SUBJUNCTIVE);
        //add("Une bonne chose que je sois de retour", "A good thing I'm back", SUBJ);
        add("Aucune femme ne voudrait un homme qui ignore ??a", "No woman would want a man who didn't know that");
        add("Je ne pourrai plus me regarder dans un miroir", "I will not be able to look at myself in a mirror any longer");
        add("Tu veux quitter pour devenir acteur", "You(tu) want to leave to become an actor");
        add("Merci, mais je n'en aurai pas besoin", "Thanks, but I will not need it");
        add("Je viendrai te voir", "I will come visit you(tu)");
        add("Laissez-moi imaginer que je n'aie pas cette place r??serv??e", "Let me imagine that I didn't have that place reserved");
        add("On a enqu??t?? et Dwight n'avait pas tort", "I/We invesigated and Dwight was not wrong");
        add("Je lui ai dit que je le laisserais, mais je ne le ferai pas", "I said to him that I would leave him, but I will not do it");
        //add("Tu devrais demander ?? Toby qu'il t'apprenne ?? jouer ?? Dunderball", "You(tu) should ask Toby (that) to teach you to play Dunderball");
        //add("Je me disais qu'il valait mieux que tu l'apprennes par moi", "I figured it would be better that you learn it from me");
        add("Tu pourrais l'??tre", "You(tu) could be it");
        add("Comment pourrais-je ??tre vierge ?", "How could I be a virgin?");
        //add("??a semble s'??tre tr??s bien pass??", "It appears it")
        add("Puis, Mike a dit que ceux qui viendraient auraient cong?? le vendredi", "Then, Mike said that those who would come would have friday off", CONDITIONAL);
        add("Ne d??cide rien avant qu'on ait parl??", "Don't(tu) decide anything before I/we have talked");
}   

    private void PocketFrenchGrammar()
    {
        // Page 145 - The Partative Article
        push(DE, () ->
        {
            add("J'ai achet?? de la farine et de la margarine", "I bought some flour and margarine");
            add("Il me doit de l'argent", "He owes me money");
            add("Il a fait de gros efforts pour nous aider", "He made great efforts to help us");
            add("Cette region a de belles ??glises", "This region has some beautiful churches");
            add("Je n'ai pas de nourriture ni d'argent", "I don't have any food nor money");
            add("Vous n'avez pas de timbres ni d'oeufs ?", "You have no stamps nor eggs ?");
            add("Je ne mange jamais de viande ni d'omelettes", "I never eat meat nor omelettes");
            add("Il ne veut plus de visiteurs ni d'eau", "He doesn't want any more visitors nor water");
            add("Il ne boit que du th??, de la bi??re et de l'eau", "He only drinks tea, beer and water");
            add("Je n'ai que des probl??mes avec cette machine", "I only have problems with this machine");
        });
    }
    
    protected void setupConditional()
    {
        push(CONDITIONAL, () ->
        {
        add("Pourriez-vous m'aider ?", "Could you help me?");
        add("Je le rappellerais", "I would call him back");
        add("Je ne d??fendrais pas cet homme", "I wouldn't defend that man");
        add("Il ne ferait jamais ce travail", "He would never do that work");
        add("Si nous avions des billets, nous pourrions aller voir le match", "If we had some tickets, we could go see the match");
        add("Si j'avais un sandwich, je n'aurais plus faim", "If I had a sandwich, I wouldn't be hungry any more");
        addCompound(CLITIC,
                "Elle ne le verrait plus - Elle ne le verra plus",
                "She would never see him again - She will never see him again");
        addCompound(CLITIC,
                "Nous n'y serions jamais all??s - Nous n'y serons jamais all??s",
                "We would never have gone there - We will never have gone there");
        addCompound(CLITIC,
                "Nous n'aurions jamais su - Nous n'aurons jamais su",
                "We would have never known - We will have never known");
        
        // SI (factual)
        {
            add("Si tu conduis, je paierai", "If you (tu) drive, I'll pay");
            add("Je paierai si tu conduis", "I'll pay if you (tu) drive");
            add("S'il pleut, nous ne sortons pas", "If it rains, we don't go out");
            add("Nous ne sortons pas s'il pleut", "We don't go out if it rains");
            add("Si j'ai soif, je bois de l'eau", "If I'm thirsty, I drink some water", DE);
            add("Si je ne veux pas lire, je regarde la t??l??", "If I don't want to read, I watch TV");
            add("Si tu peux, viens me voir", "If you (tu) can, come see me.");
            add("Si vous avez de l'argent, payez la facture", "If you have money, pay the bill");
            add("Si tu n'as pas fini, tu me le diras", "If you (tu) haven't finished, you will tell me (that)");
            add("Si tu n'as pas fini, dis-le-moi", "If you (tu) haven't finished, tell me (that))", CLITIC);
            add("Il sera heureux s'il se marie", "He'll be happy if he gets married");
        }
        
        // WOULD
        {
            add("Si j'??tais riche, j'ach??terais une maison", "If I was rich, I would buy a house");
            add("Nous aurions mang?? s'ils avaient ??t?? pr??ts", "We would have eaten if they had been ready");
            add("Je serais venue si elles avaient ??t?? contentes", "I(f.) would have come if they(f.) had been satisfied");
            add("Nous serions partis s'ils ??taient morts", "We would have left if they had died");
            add("Si elle te donne de l'argent, ach??teras-tu une voiture ?", "If she gives you (tu) some money, will you buy a car ?");
            add("Tes fr??res pleureraient si tu tombais", "Your brothers would cry if you (tu) fell");
        }
        
        add("Si j'ai le temps, je le ferai", "If I have time, I will do it");
        //add("Imperfect+Conditional", "Counterfactual present");
        //add("Pluperfect+Conditional Past", "Counterfactual past");
        add("Si j'avais le temps, je le ferais", "If I had time, I would do it");
        add("Si j'avais eu le temps, je l'aurais fait", "If I had had time, I would have done it");
        add("If I have the time, I will do it", "Si j'ai le temps, je le ferai");
        add("If I had the time, I would do it", "Si j'avais le temps, je le ferais");
        add("If I had had the time, I would have done it", "Si j'avais eu le temps, je l'aurais fait");

        add("Si tu ??tudies, tu r??ussiras ?? l'examen", "If you (tu) study, you will pass the test");
        add("Tu r??ussiras ?? l'examen si tu ??tudies", "You (tu) will pass the test if you study");
        add("Si tu ??tudiais, tu r??ussirais ?? l'examen", "If you (tu) studied, you would pass the test");
        add("Tu r??ussirais ?? l'examen si tu ??tudiais", "You (tu) would pass the test if you studied");
        add("Si tu avais ??tudi??, tu aurais r??ussi ?? l'examen", "If you (tu) had studied, you would have passed the test");
        add("Tu aurais r??ussi ?? l'examen si tu avais ??tudi??", "You (tu) would have passed the test if you (tu) had studied");

        add("If you study, you will pass the test", "Si tu ??tudies, tu r??ussiras ?? l'examen");
        add("If you studied, you would pass the test", "Si tu ??tudiais, tu r??ussirais ?? l'examen");
        add("If you had studied, you would have passed the test", "Si tu avais ??tudi??, tu aurais r??ussi ?? l'examen");

        add("Si elle vous voit, elle vous aidera", "If she sees you, she will help you");
        add("Elle vous aidera si elle vous voit", "She will help you if she sees you");
        add("Si elle vous voyait, elle vous aiderait", "If she saw you, she would help you");
        add("Elle vous aiderait si elle vous voyait", "She would help you if she saw you");
        add("Si elle vous avait vu, elle vous aurait aid??", "If she had seen you, she would have helped you");
        add("Elle vous aurait aid?? si elle vous avait vu", "She would have helped you if she had seen you");

        add("If she sees you, she will help you", "Si elle vous voit, elle vous aidera");
        add("If she saw you, she would help you", "Si elle vous voyait, elle vous aiderait");
        add("If she had seen you, she would have helped you", "Si elle vous avait vu, elle vous aurait aid??");
        
        add("Il l'aurait fait si j'avais demand??", "He would have done it if I had asked");
        
        add("S'il avait une voiture, il n'aurait pas besoin de marcher", "If he had a car, he wouldn't need to walk");
        
        add("Je nagerai s'il fait beau", "I will swim if it's nice weather");
        add("Je nagerais s'il faisait beau", "I would swim if it was nice weather");
        add("J'aurais nag?? s'il avait fait beau", "I would have swam if it had been nice weather");
        });
    }

    /* package */ static abstract class PhraseSource
    {
        private final SentenceGenerator source;
        
        public PhraseSource(SentenceGenerator source)
        {
            this.source = source;
        }

        protected abstract void setup();

        public final void add(String translation, String... phrases)
        {
            if (phrases == null || phrases.length == 0)
            {
                throw new IllegalArgumentException("phrase required for: " + translation);
            }
            for(String phrase: phrases)
            {
                source.items.add(new SentenceQuestion(source, phrase, translation, new HashSet<>()));
            }
        }
    }
}        