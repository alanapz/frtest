package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;
import static fr.gen.MiscVocabulary.Preposition.*;

/* package */ final class RosettaStonePhrases extends AutoSentenceGenerator
{
    public RosettaStonePhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }
    
    private void rosetta()
    {
        add("Elle a déjà bu le tiers du lait", "She has already drank a third of the milk");
        add("Quelqu'un a mangé la moitié du gâteau !", "Somebody ate half the cake!", DE);
        add("Combien pèsent les pommes de terre ?", "How much do the potatoes weigh?");
        add("De combien d'assiettes avons-nous besoin ?", "How many plates (do) we need?", DE);
        add("Nous avons besoin d'au moins dix assiettes", "We need at least ten plates");
    }

    public void M3_U4_L1()
    {
        add("Elles regardent les informations à la télévision", "They(f) watch the news on the television");
        add("Est-ce qu'ils ont dit qui avait gagné le match de football ?", "Did they say who had won the football match?");
        add("Ils s'envoient des emails par Internet", "They send each other emails by Internet");
        add("Les enfants regardent un film intéressant à la télévision", "The children are watching an interesting film on the television");
        add("Nous écoutons les informations à la radio", "We listen to the info/news on the radio");
        add("Qu'est-ce qu'il y a aux informations aujourd'hui ?", "What's in the news today?");
        add("Qu'est-ce qu'il y a à la télévision ?", "Whats's on television?");
    }

    private void M3_U4_L2()
    {
        add("Ces statues ont été découvertes sur une ile", "These statues were discovered on an island", AGREEMENT);
        add("Cette maison a été construite l'année dernière", "This house was built last year", AGREEMENT);
        add("Cette photo a été prise en 1923", "This photo was taken in 1923", AGREEMENT);
        add("Ma grand-mère l'a prise", "My grand-mother took |tbe photo|", AGREEMENT);
        add("Cette statue a été faite à Rome il y a longtemps", "This statue was did in Rome a long time ago", AGREEMENT);
        add("Comment " + /*est-ce que*/ "ça s'appelle en français ?", "What is that called in French?");
    }  
    
    private void M3_U4_L3()
    {
        add("Elle s'est souvenue de prendre son café", "She remembered to take her coffee", PRONOMINAL, AGREEMENT);
        add("Est-ce que tu as apporté ton livre ?", "Did you(tu) bring your book?");
        add("Est-ce que tu as compris ce que j'ai dit ?", "Did you(tu) understand what I said?");
        add("Est-ce que tu te souviens de quand nous habitions là ?", "Do you(tu) remember when we were living here/there?", PRONOMINAL);
        add("Est-ce que vous saviez que la Pierre de Rosetta a été découverte en 1799", "Did you knew the Rosetta Stone was discovered in 1799");
        add("Est-ce que vous vous êtes entrainés ce matin ? Nous nous entrainons cet après-midi", "Did you(pl.) practice this morning? We practice this afternoon", PRONOMINAL);
        add("J'y suis allé l'année dernière et j'y retourne le mois prochain", "I went there last year and I (will) return there next month");
        add("Je croyais qu'elle commençait à 20h", "I thought |the party| was starting at 8pm");
        add("Je devrais l'appeler maintenant", "I should call her now");
        add("Je l'ai encore oublié", "I forgot |my book| again");
        add("Je m'entraine depuis trois heures", "I've been practising for three hours", PRONOMINAL, TEMPORAL);
        add("Je ne suis jamais allée en Russie, mais j'aimerais visiter le pays un jour", "I've(f) never been to Russia, but I would love to visit the country one day");
        add("Je vis au Japon depuis que je suis bébé", "I've lived(vivre) in Japan since I was a baby", TEMPORAL);
        add("Il s'est souvenu de prendre ses clés", "He remembered to take this keys", PRONOMINAL);
        add("Il veut que tu l'appelles ce soir - je l'appellerai", "He wants you(tu) to call him this evening - I'll call him");
        add("Il y a trop de monde dans ce bus", "There's too many people on that bus");
        add("La fille apprend à faire un gâteau", "The girl learns to make a cake");
        add("Ma femme et moi sommes mariés depuis trente-cinq ans", "My wife and I have been married for thirty-five years", TEMPORAL);
        add("Mon mari s'est servi d'une clé et d'une pince pour le réparer", "My husband used a spanner and some pliers to repair it", PRONOMINAL);
        add("N'oublie pas de l'apporter demain", "Don't forget to bring your(tu) |book| tomorrow");
        add("Sa grand-mère apprend à se servir de l'ordinateur", "His grand-mother learns to use the computer", PRONOMINAL, DE);
        add("Tu ne t'en souviens pas ?", "You(tu) don't remember it?", PRONOMINAL, EN);
        add("Où veux-tu que je m'asseye ?", "Where do you(tu) want me to sit?", SUBJUNCTIVE);
        add2("J'ai assez mangé - Je n'ai plus faim", "I've eaten enough - I'm no longer hungry");
        add2("Combien coûte-t-il ? - Combien coûte-t-elle ?", "How much does it cost? - How much does |the shirt| cost?", CLITIC);
    }
    
    private void M3_U4_L4()
    {
        add("Allons en Russie le mois prochain", "Let's go to Russia next month");
        add("C'est un homme qui n'est jamais prêt", "It's a man who is never ready");
        add("Ce sont", "These are ...");
        add("Elle dort pendant le film parce qu'elle est fatiguée", "She sleeps during the film because she's tired", TEMPORAL);
        add("J'ai rencontré beaucoup de gens intéressants - J'ai bien aimé la cuisine indienne epicée", "I met many interesting people - I liked spicy indian cooking");
        add("Je suis prêt à faire tout ce qu'il vous plaira", "I'm ready to do all that will please you");
        add("Je suis prêt à vous entendre", "I'm ready to hear you");
        add("Ils font la fête parce qu'ils sont mariés depuis quarante ans", "They are partying because they have been married for forty years", TEMPORAL);
        add("L'année dernière, je suis allé en vacances pendant un mois", "Last year, I went on holidays for a month", TEMPORAL);
        add("L'homme est presque prêt à partir pour son travail, mais pas sa femme", "The man is nearly ready to leave for his work, but not his wife");
        add("Là-bas, les taxis sont très différents que ceux d'ici", "Over there, the taxis are very different from those here");
        add("La chanteuse n'est pas prête à chanter", "The singer(f) is not ready to sing");
        add("Pendant cette fête, les gens célèbrent le nouvel an", "During this festival, people celebrate the new year");
        add("Personne ne fait la fête au bureau", "Nobody is partying in the office");
        //add("Pendant les quatres jours où j'y suis restée, j'ai rencontré beaucoup de gens", "");
        add("êtes-vous allée en Australie pour affaires - Non, j'y suis allée en vacances", "(Did) you(f) go to Australia for business - No, I(f) went there on holiday");
    }
    
    private void M4_U3_L1()
    {
        add("As-tu mis les boites dans le placard ?", "(Did) you(tu) put the boxes in the cupboard ?");
        add("Il a ouvert les portes du balcon", "He opened the balcony doors");
        add("Il a souri en ouvrant la boite", "He smiled while opening the box", PARTICIPLE);
        add("Il cherche un dictionnaire sur les étagères", "He looks for a dictionary on the shelves");
        add("Il emménage dans la maison de sa mère", "He moves into his mothers house");
        add("Les tiroirs sont pleins de serviettes", "The drawers are full of towels");
        push(PHYSICAL, () ->
        {
            add("Elle boit du café près de la cheminée", "She drinks coffee near the chimney");
            add("J'ai suspendu la télévision au-dessous du tableau", "I hung the television below the painting");
            add("J'ai suspendu le tableau au-dessus de la télévision", "I hung the painting above the television");
            add("Le tableau est suspendu au-dessus de la cheminée", "The painting is hanging above the chimney");
            add("Les clés sont suspendues au mur", "The spanners are hanging on the wall");
        });
    }
    
    public void M4_U3_L2()
    {
        add("As-tu oublié de payer l'électricité ce mois-ci ?", "(Did) you(tu) forget to pay this electricity *this* month?");
        add("Bien que je n'aie pas fini de lire ce livre, je vais quand-même le rendre à la bibliothèque", "Even though I haven't finished reading this book, I am going to all-the-same return it to the library", SUBJUNCTIVE);
        add("Ce robinet fuit - il a été rémplacé", "This tap leaks - it has been replaced");
        add("Ceci était cassé jusqu'à ce que je le répare", "This was broken up until I repaired it");
        add("Elle a regardé un film jusqu'à ce qu'elle soit fatiguée", "She watched a film up until she was tired", SUBJUNCTIVE);
        add("Elle est assise sur la moquette blanche", "She is sitting on the white carpet");
        add("Elle ne sait pas quel fil est le bon", "She doesn't know which wire is correct");
        add("Elle passe la serpillière dans la cuisine pour nettoyer par terre", "She mops in the kitchen to clean the floor");
        add("Ils mangeaient dehors jusqu'à ce qu'il commence à pleuvoir", "They were eating outside up until it started to rain");
        add("Ils regardent la télévision depuis qu'ils sont rentrés de l'école", "They've been watching the television since they came back from school", TEMPORAL);
        add("Ils veulent tous utiliser la prise de courant", "They all want to use the electric plug");
        add("Je dois attendre jusqu'à ce qu'il rentre de l'école", "I must wait up until he comes back from school");
        add("Je ne peux pas allumer la lampe parce qu'il n'y a pas d'électricité", "I can't turn on the lamp because there is no electricity", DE);
        add("Je travaille depuis cinq heures ce matin", "I've been working since five this morning", TEMPORAL);
        add("L'homme remplace une vieille prise de courant", "The man replaces an old power switch");
        add("La maison est endommagée - le robinet fuit", "The house is damaged - the tap leaks");
        add("La voiture n'est pas fermée à clé", "The car is not locked", AGREEMENT);
        add("Quelqu'un utilisait ce bateau, mais maintenant il est endommagé", "Somebody was using this boat, but now it's damaged");
    }
    
    private void M4_U3_L3()
    {
        //add("Je ne m'étais jamais rien cassée jusqu'à aujourd-hui"
        add("Elle dort chez sa grand-mère pendant une semaine", "She is sleeping at her grand-mothers for a week", TEMPORAL);
        add("Elle est gênée parce qu'elle ne porte pas le bon costume", "She is embarrased because she's not wearing the right outfit");
        add("Elle est surprise d'avoir dormi jusqu'à midi", "She is surprised to have slept upto midday");
        add("Il avait perdu sa peluche, mais il l'a retrouvée", "He had lost his stuffed-toy, but he (re)found it", AGREEMENT);
        add("Il est sur le point d'envoyer ce colis", "He is just about to send this parcel");
        add("Il est sur le point de lui offrir des fleurs", "He is just about to offer her some flowers", CLITIC);
        add("Il vient de s'acheter un livre et il en a déjà lu la moitié", "He has just bought himself a book and he has already read half of it", PRONOMINAL, CLITIC, EN);
        add("Ils portent toujours leur casque quand ils font du vélo", "They always wear their helmet when they cycle");
        add("Ils viennent de grimper la montagne", "They have just climbed the mountain");
        add("Je n'ai pas pu réparer mon skateboard, alors j'en ai acheté un autre", "I couldn't repair my skateboard, so I bought another one of them");
        add("Je préfère la nouvelle maison à l'ancienne", "I prefer the new house to the former");
        add("Je préfère la vieille voiture à la nouvelle", "I prefer the old car to the new");
        add("Je suis inquiet parce que mes parents ne vont pas être contents", "I am worried because my parents are not going to be pleased");
        add("Je suis inquiète que personne ne vienne à ma fête", "I(f) am worried that nobody will come to my party", SUBJUNCTIVE);
        add("Je suis sur le point de nettoyer par terre", "I am just about to clean the floor");
        add("Je venais d'acheter cette voiture", "I had just bought this car");
        add("Je viens de me réveiller et vous avez déjà préparé le petit déjeuner", "I have just woken up and you have already prepared breakfast");
        add("L'enfant est surprise parce que son père lui a offert un chien", "The child is surprised because his dad offered him a dog");
        add("L'oeuf s'est cassé quand il est tombé par terre", "The egg broke when it fell on the floor", PRONOMINAL);
        add("Le frère et sa soeur se disputent pour un jeu vidéo", "The brother and his sister argue over a video game");
        add("Le garçon a cassé son jouet, mais son grand-père l'aide à le réparer", "The boy broke his toy, but his grand-father helps him to repair it", CLITIC);
        add("Leur enfant vient de naitre", "Their child has just been born");
        add("Nous sommes sur le point d'aller voir une pièce de théâtre", "We are just about to go see a theatre play");
        add("Son père l'a embrassée avant qu'elle parte à l'école", "Her dad kissed her before she leaves for school", AGREEMENT, SUBJUNCTIVE);
        add("Son skateboard vient de se casser", "Her skateboard has just broken", PRONOMINAL);
        add("Tu as couru pendant trente minutes !", "You(tu) ran for thirty minutes!", TEMPORAL);
    }
    
    public void M5_U1_L1()
    {
        // add("J'aimerais aussi avoir un bateau qui puisse le transporter dans d'autres pays", "I would also like to have a boat which can transpot it to other countries", SUBJUNCTIVE);
        //je cherche quelqu'un qui puisse jouer de la     guitare
        add("Beaucoup de grands bâtiments sont construits avec de l'acier", "Many big buildings are constructed with steel", DE);
        add("Brûler du bois produit de l'énergie", "Burning wood produces energy", DE, PARTICIPLE);
        add("Ce type de voiture brûle de l'essence pour produire de l'énergie", "This type of car burns petrol to produce energy", DE);
        add("Ces fils électriques transportent de l'énergie électrique", "These electric cables transport electical energy");
        add("Cette centrale électrique produit de l'électricité avec de l'eau", "This power station produces electricty with water", DE);
        add("Cette voiture n'a été conduite qu'une fois", "This car has been driven only one time", AGREEMENT);
        add("Elles travaillent dans l'industrie de la mode", "They(f.) work in the fashion indistry", DE);
        add("Est-ce que je pourrai m'asseoir dans son bulldozer ?", "Will I be able to sit in her bulldozer?", PRONOMINAL);
        add("Il soulève sa fille au-dessus de sa tête", "He raises his daughter above his head", PHYSICAL);
        add("J'ai besoin d'un bulldozer qui puisse pousser toute cette terre", "I need a bulldozer that can push all this earth", SUBJUNCTIVE);
        add("J'aimerais un blouson qui ait plus de poches", "I would like a blouson which has more pockets", SUBJUNCTIVE, DE);
        add("Je suis inquiète que personne ne vienne à ma fête", "I(f) am worried that nobody will come to my party", SUBJUNCTIVE);
        add("Je travaille dans l'industrie du bâtiment", "I work in the building industry", DE);
        add("Je vais visiter une des usines de ma société", "I am going to visit one of the factories of my company/society", DE);
        add("L'homme d'affaires l'aide à soulever le colis", "The businessman helps him raise the parcel");
        add("L'énergie de cette voiture provient de l'électricité plutôt que de l'essence", "The energy of this car originates from electrity rather than petrol", DE);
        add("La jeune femme et son petit ami tirent la voiture", "The young lady and her boyfriend pull the car");
        add("Nous aimerions aller dans une grotte que personne n'ait exploré", "We would like to go in a cave that no-one has explored", SUBJUNCTIVE);
        add("Nous avons pu charger beaucoup de bois sur notre voiture", "We were able to load lots of wood on our car", DE);
        add("Nous essayons de concevoir un moteur qui produise de l'énergie avec de l'eau", "We are trying to design an engine that produces energy with water", DE, SUBJUNCTIVE);
        add("Quelqu'un s'entraine à la guitare", "Somebody is practicing the guitar", PRONOMINAL);
    }
    
    public void M5_U1_L2()
    {
        // add("Est-ce que le manteau vous va ? je doute qu'elle m'aille
        //add("Bien que je sois adulte, j'aime encore jouer à des jeux vidéo", "Even though I am adult, I still like playing video games");
        //add("nous n'avons plus de tee-shirts bleus - est-ce que vous en voudiez en jaune ?", "We don't have any more blue 'tee-shirts' - do you want"
        add("Qu'est-ce que vous en pensez ?", "What do you think of it?", EN);
        add("Elle veut des bijoux mais elle n'en a pas besoin", "She wants some jewellery but she doesn't need some", EN, DE, CLITIC);
        add("Il a besoin de médicaments mais il n'en veut pas", "He needs medecine but he doesn't want any", EN, DE);
        add("Il vient de s'acheter un livre et il en a déjà lu la moitié", "He has just bought himself a book and he has already read half of it", EN);
        add("J'ai peur que nous soyons perdus", "I'm scared we are lost", AGREEMENT, SUBJUNCTIVE);
        add("J'aimerais qu'un jour elle soit médecin", "I would like that one day she will be a doctor", SUBJUNCTIVE);      
        add("J'en doute - Je dois travailler ce soir", "I doubt it - I must work this evening", EN);
        add("Je doute qu'elle m'aille", "I doubt |the robe| fits me", SUBJUNCTIVE);
        add("Je doute que ce soit la bonne quantité de sucre pour préparer le gâteau", "I doubt that's the right amount of sugar to prepare the cake", SUBJUNCTIVE);
        add("Je doute que ce vêtement m'aille", "I doubt this item-of-clothing fits me", SUBJUNCTIVE);
        add("Je doute que je puisse arriver à l'heure", "I doubt I can arrive on time", SUBJUNCTIVE);
        add("Je doute que nous ayons assez d'argent pour payer le diner", "I doubt we have enough money to pay for the dinner", SUBJUNCTIVE);
        add("L'année dernière les français ont diminué la quantité d'électricité qu'ils ont utilisée", "Last year the French reduced the quantity of electricity they used", DE);
        add("Le nombre d'ordinateurs que cette usine a fabriqués a augmenté cette année", "The number of computers that this factory has built has increased this year", AGREEMENT);
        add("Le nombre de livres que cette usine a fabriqués a diminué depuis l'année dernière", "The number of books that this factory has produced has reduced since last year", AGREEMENT);
        add("Nos clients en veulent plus", "Our customers want more |bread|", EN);
        add("Nous avons la bonne quantité de farine mais nous n'avons pas la bonne quantité de salade", "We have the right amount of flour but we don't have the right amount of salad", DE);
        add("On n'a plus de lait - tu pourrais en acheter au supermarché", "I/we have no more milk - you(tu) could buy some at the supermarket", EN);
        add("Si je conduis moins, je vais diminuer la quantité d'essence que j'achète", "If I drive less, I am going to reduce the amount of petrol that I buy", DE);
        add2("Ce vêtement me va - Je doute que ce vêtement m'aille", "This clothe(s) fits me - I doubt this clothe(s) fits me", SUBJUNCTIVE);
        add2("Elle a besoin d'un manteau - Elle en a besoin", "She needs a coat - She needs |a coat|", EN);
        add2("La femme boit de l'eau - La femme en boit", "The lady drinks some water - The lady drinks |some water|", EN, DE);
    }
    
    public void M5_U4_L2()
    {
        add("Le père et la tante du garçon lui montrent comment utiliser un ordinateur", "The dad and the aunt of the boy shows him how to use a computer");
    }
    
    public void M5_U1_L3()
    {
        add("Au lever de soleil, le photographe prenait déjà des photos", "At sunrise, the photograper was already taking photos");
        add("J'ai déjà quatre poules, mais je viens d'en acheter quatre autres", "I already have four hens, but I have just bought four others", EN);
        add("Vous ne vendiez pas du fromage de chèvre avant ?", "You were not selling goat cheese before?", DE);
        add("J'en vendais, mais je me suis cassé la jambe", "I was selling |some of them|, but I broke my leg", EN, PRONOMINAL);
    }
}