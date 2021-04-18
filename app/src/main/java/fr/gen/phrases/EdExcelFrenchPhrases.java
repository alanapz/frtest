package fr.gen.phrases;
import fr.score.*;
import static fr.gen.MiscVocabulary.*;
import static fr.gen.MiscVocabulary.Preposition.*;

/* package */ final class EdExcelFrenchPhrases extends AutoSentenceGenerator
{
    public EdExcelFrenchPhrases(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy);
    }

    public void Page_3_Negative_Ne_Pas()
    {
        add("Nous ne prenons pas le petit déjeuner", "We don't take breakfast");
        add("Elle ne dine pas avec sa famille", "She doesn't lunch with her family");
        add("Tu ne vas pas au collège à pied", "You(tu) are not going to college by foot");
        add("Les garçons ne vont pas au club", "The boys are not going to the club");
        add("Les filles n'aiment pas les repas", "The girls don't like the meals");
        add("Paul ne mange pas tôt le dimanche", "Paul doesn't eat early on sundays");
        add("Je ne sors pas le week-end", "I don't go out on the weekends");
        add("Vous ne faites pas les devoirs", "You're not doing the homework");
        add("Nadia ne mange pas à la cantine", "Nadia doesn't eat at the canteen");
    }
    
    public void Page_4_Depuis_and_Present_Tense()
    {
        push(TEMPORAL, () ->
        {
            add("Ils apprennent le français depuis un an", "They have been learning French for a year");
            add("Nous faisons des exercices depuis une heure", "We have been doing some exercises for an hour");
            add("Tu vas au club de musique depuis " /* la */ + "1999", "You(tu) have been going to the music club since 1999");
            add("Je travaille avec M. Duval depuis la rentrée", "I have been working with M. Duval since the start of the new school year");
            add("Depuis quand es-tu membre du club de tennis ?", "How long (have) you(tu) been a member of the tennis club?");
            add("On porte un uniforme gris depuis mars", "I/We have been wearing a grey uniform since March");
            add("Mme Gauthier travaille ici depuis trente ans", "Mme Gauthier has been working here for thirty years");
            add("Vous êtes élève au collège depuis septembre", "You have been a pupil at the college since September");
            add("Elles portent des lunettes depuis la fin du trimestre", "They(f) have been wearing glasses since the end of the term");
        });
    }
    
    public void Page_10_En_and_Present_Participle()
    {
        push(PARTICIPLE, () ->
        {
            add("J'écoute mon iPod en allant chez mes amis", "I listen to my iPod while going round my friends");
            add("Nous bavardons en faisant du vélo dans le parc", "We chat while biking in the park");
            add("Elle parle à ses amis en jouant au tennis", "She talks to her friends while playing tennis");
            add("Tu prends ton petit déjeuner en lisant le magazine", "You(tu) have breakfast while reading the magazine");
            add("Vous écoutez la radio en vous douchant", "You listen to the radio while showering", PRONOMINAL);
            add("Ils dessinent en écoutant des histoires", "They draw while listening to some stories");
            add("Il mange du toast en s'habillant", "He eats some toast while getting dressed", PRONOMINAL);
            add("Elles réfléchissent à leur diner en se promenant", "They(f) reflect on their diner while strolling");
            add("On regarde la télé en préparant le diner", "I/we watch the TV while preparing dinner");
            add("Ils jouent au tennis en se disputant", "They play tennis while arguing", PRONOMINAL);
        });
    }
    
    public void Page_13_Irregular_Past_Participles()
    {
        add("Marc et Christophe n'ont pas pris trop de photos de nous", "Marc and Christophe haven't taken too many photos of us");
        add("Christine n'a pas mis sa jolie robe", "Christine hasn't put on her pretty dress");
        add("Moi, je n'ai pas eu de bonne surprise", "Me, I didn't have a nice suprise", DE);
        add("Pendant la visite, vous n'avez pas été déçu ?", "During the visit, weren't you disappointed?");
        add("Elles n'ont pas couru jusqu'à la gare", "They(f) didn't run upto the station");
        add("On n'a pas bu d'eau pendant la traversée", "I/We didn't drink water during the crossing");
        add("Je n'ai pas découvert la solution", "I didn't discover the solution");
    }
        
        private void Venir()
        {
            add("Ils viennent de partir", "They have just left");
            add("Vous venez de revenir", "You have just come back");
        }

        private void DirectObject()
        {
//        a	Tu prends le bus? Moi aussi je te/le prends!
//Are you taking the bus? I am taking it too!
//b	Vous avez des questions? Je m'/vous écoute.
//Do you have any questions? I am listening to you.
//c	Nous aimons les pays chauds, nous l'/les préférons aux pays froids.
//We like hot countries; we prefer them to cold countries.
//d	Ma voisine? Je le/la vois tous les jours.
//My neighbour? I see her every day.
//e	Notre ville et notre quartier? On les/nous trouve agréables.
//Our town and our district? We/People find them pleasant.
        }

        private void En()
        {
            push(EN, () ->
            {
                add("J'en ai deux", "I have two", EN);
                add("Il n'y en a pas", "There isn't any", EN);
                add("Nous en avons plusieurs", "We have several", EN);
                add("J'en ai mangé beaucoup", "I have eaten lots of it", EN);
                add("Je n'en veux pas", "I don't want any", EN);
            });
        }            
 
        private void NegativeQue()
        {
            add("Elle n'aime les montagnes que quand il neige", "She likes the mountains only when it snows");
            add("Nous ne voulons que des frites pour le déjeuner", "We want only chips for lunch", DE); 
            add("Alan ne va à l'école que six mois par an", "Alan goes to school only six months a year");
            add("Tu ne lis qu'un magazine de sport", "You(tu) read only a sports magazine");
            add("Amir n'écrit à sa mère que pour le nouvel an", "Amir writes to his mother only for the New Year");
            add("Nous n'avons que deux pommes", "We only have two apples");
            add("Je ne cuisine que le weekend", "I only cook at the weekend");
            add("Elle ne boit que du jus d'orange", "She drinks only orange juice", DE);
            add("Elle n'a mangé qu'un sandwich", "She has only eaten one sandwich");
            add("Nous n'allons prendre que des légumes", "We are going to take only vegetables", DE);
        }
        
        private void ReflexiveVerbs()
        {
            push(PRONOMINAL, () ->
            {
                add("Nous nous sommes rencontrés au café", "We met each other at the café", AGREEMENT);
                add("Vous vous êtes disputés tous les jours", "You argued with each other every day", AGREEMENT);
                //add("Ils se sont aimés toute leur vie", "They loved each other all their lives"); *** - toute leur vie / toutes leurs vies
                add("Nous nous sommes détestés depuis le début", "We hated each other from the beginning", AGREEMENT);
                add("Elles se parlent en classe", "They(f.) talk to each other in class", AGREEMENT);
                add("Elles ne se sont pas quittées", "They(f.) did not leave each other", AGREEMENT);
                add("Vous vous êtes regardés sans parler", "You looked at each other without speaking", AGREEMENT);
                add("On se retrouve au cinéma ?", "I/we find each other at the cinema?");
                add("Ils se téléphonent tous les jours", "They phone each other every day");
                add("Les stars s'embrassent à la fin du film", "The stars kiss each other at the end of the film");
            });
        }

////a	Ils n'envoient plus de textos.
////They do not send texts any more.
////b	Vous n'utilisez plus votre portable chaque jour.
////You no longer use your mobile phone each day.
////c	On n'écrit plus de méls.
////We no longer write e-mails.
////d	Il n'y a plus de séances à 6 heures.
////There isn't a performance at six o'clock any more.
////e	Vous ne faites plus la fête en août.
////You no longer celebrate in August.
////f	Ils n'ont plus célébré la fête nationale.
////They did not celebrate the national holiday any more.
////g	Je n'ai plus utilisé mon portable.
////I no longer used my mobile phone.
////h	Elle n'est plus sortie le dimanche.
////She no longer went out on Sundays.
////i	Tu n'as plus vu de films romantiques.
////You no longer saw romantic films.
////7

        
//        a	This town is neither old nor famous.
//Cette ville n'est ni vieille ni célèbre.
//b	Dublin is neither in France nor in Spain.
//Dublin n'est ni en France ni en Espagne.
//c	Abdel likes neither Madrid nor Berlin.
//Abdel n'aime ni Madrid ni Berlin.
//d	Alessia stayed neither in Greece nor in Italy.
//Alessia n'est restée ni en Grèce ni en Italie.
//e	This monument is neither a church nor a temple.
//Ce monument n'est ni une église ni un temple.
//f	Toby went neither to Africa nor to America.
//Toby n'est allé ni en Afrique ni en Amérique.
//4
        private void VariousNegatives()
        {
            add("Il n'est pas parti à 6 heures", "He did not leave at 6 o'clock");
            add("Elle n'a rien mangé pendant le matin", "She did not eat anything during the morning", TEMPORAL);
            add("Nous n'avons vu personne", "We did not see anybody");
            add("Il ne regardait rien", "He was not looking at anything");
            add("Elles ne sont allées nulle part", "They(f) did not go anywhere", AGREEMENT);
            add("Vous n'aimez plus les films", "You no longer like films");
            add("Tu ne joues jamais au tennis", "You(tu) never play tennis");
            add("Elle n'a rencontré personne", "She did not meet anybody");
            add("Ils n'ont pas d'idées", "They do not have any ideas", DE);
            add("Nous ne mangeons que des fruits", "We only eat fruits", DE);
            add("Il n'a vu que trois souris", "He saw only three mice");
            add("Je ne fumerai plus", "I will not smoke any more");
            add("Elle ne se promènera nulle part", "She will not go for a walk anywhere", PRONOMINAL);
            add("Vous n'avez que deux frères", "You only have two brothers");
            add("Tu ne finis pas tes devoirs", "You(tu) do not finish your homework");
        }

        
//        a	For her, we bought flowers. 
//Pour elle, nous avons acheté des fleurs.
//b	She will be next to me. 
//Elle sera à côté de moi.
//c	The car was in front of him. 
//La voiture était devant lui.
//d	We are leaving without them (m). 
//Nous partons sans eux.
//e	Léa and I will go to Nice with you (s). 
//Léa et moi irons à Nice avec toi.
//f	They chose a table near us. 
//Ils ont choisi une table près de nous.
//g	We are going to arrive after them (f). 
//Nous allons arriver après elles.
//h	Who loved Paris? You (s) or him? 
//Qui a aimé Paris? Toi ou lui?
//7

//a	Je n'ai aucune ceinture.
//I haven't any belts at all.
//b	Ils n'ont aucun short.
//They haven't a single pair of shorts.
//c	Elle ne lit aucun livre.
//She doesn't read a single book.
//d	Il n'y a aucun café.
//There isn't a single café.
//e	Vous n'avez aucun supermarché dans le village.
//You don't have any supermarkets in the village at all.
//f	On n'a vendu aucun gilet.
//We haven't sold a single waistcoat.
//g	Nous n'avons acheté aucun cadeau.
//We haven't sold a single present.
//h	Vous n'avez choisi aucune jupe.
//You haven't chosen a single skirt.
//i	Elles n'ont offert aucun chocolat.
//They haven't offered a single chocolate.
//3
//
//a	Léna leur achète un livre à la librairie.
//Léna is buying a book for them at the bookshop.
//b	Marie ne lui envoie pas de cartes.
//Marie does not send cards to him/to her.
//c	Louise lui donnait des bonbons pour son anniversaire.
//Louise used to give him/her sweets for his/her birthday.
//d	Je ne lui demande pas une boisson.
//I am not asking him for a drink.
//e	Ils ne vont pas leur téléphoner ce soir.
//They are not going to telephone them this evening.
//f	Vous ne leur avez pas montré les photos.
//You did not show the photographs to them.
//7
//
//a	La table est réservée par le client.
//The table is reserved by the customer.
//b	Le repas est préparé par le chef.
//The meal is prepared by the chef.
//c	Les rideaux sont déchirés par le petit chien.
//The curtains are torn by the little dog.
//d	La leçon est comprise par les élèves.
//The lesson is understood by the pupils.
//e	La maison est abîmée par la tempête.
//The house is damaged by the storm.
//f	Les réparations sont faites par le maçon.
//The repairs are done by the builder.
//g	Les camions sont conduits par les employés.
//The lorries are driven by the employees.
//h	Le sac est pris par le voleur.
//The bag is taken by the thief.
//i	Les enfants sont attendus par leurs parents.
//The children are expected by their parents.
//j	Les patients sont reçus par le médecin.
//The patients are (received) seen by the doctor.
//5
//
//
//a	She had just eaten. Elle venait de manger.
//b	They (f) had just finished. Elles venaient de finir.
//c	We had just done the work. Nous venions de faire le travail.
//d	He had just got up. Il venait de se lever.
//e	Tom and I had just seen the car. Tom et moi venions de voir la voiture.
//f	You (pl) had just lost the match. Vous veniez de perdre le match.
//g	They (m) had just phoned. Ils venaient de téléphoner.
//h	Myriam had just cancelled. Myriam venait d'annuler.
//i	I had just injured myself. Je venais de me blesser.
//j	Luc and Marco had just written. Luc et Marco venaient d'écrire.
//U
//
//a	J'ai mangé un sandwich parce que j'avais faim.
//b	Elle veut de la limonade parce qu'elle a soif.
//c	Elle a l'air contente parce qu'elle sourit.
//d	Tu auras froid si tu ne mets pas ton manteau.
//e	Elles ont sommeil; elles vont se coucher.
//f	Il a horreur de faire le ménage; il préfère sortir.
//g	Le festival a eu lieu à Toulouse.
//h	Ils en ont marre; ils ont trop de devoirs.
//i	Nous avons peur des araignées.
//j	Elle a raison/tort; la Belgique est un pays francophone.
//
//
//
//
//a	Il y a deux postes disponibles.
//There are two jobs available.
//b	Il reste beaucoup de monnaie marocaine.
//There is a lot of Moroccan change left.
//c	Il manque des numéros dans l'annuaire tunisien.
//Some numbers are missing in the Tunisian telephone directory.
//d	Il s'agit de mon stage au Sénégal.
//It is about my work experience in Senegal.
//e	Il paraît que tout le monde aime travailler aux Seychelles.
//It appears that everyone likes working in the Seychelles.
//f	Il suffit d'une heure pour cette tâche.
//An hour is enough for this task.
//g	Il pleut tous les jours chez nous.
//It rains every day where we live.
//h	Il y avait des dollars dans son porte-monnaie.
//There were some dollars in his/her purse
//i	Il vaut mieux voyager avec son passeport.
//It is better to travel with one's passport.

    // Page 48 - Après avoir/être + past participle
    public void P48_PerfectInfinitive()
    {
        push(AGREEMENT, () ->
        {
            add("Après avoir nettoyé la chambre, elle a regardé la télé", "After having cleaned the bedroom. she watched the TV");
            add("Après avoir vu le film, nous sommes rentrés", "After having seen the film, we returned home");
            add("Après avoir joué au foot, ils ont fait du vélo", "After having played football, they did some biking");
            add("Après être sorties, vous avez rencontré vos amis", "After having gone out, you(f.pl) met your friends");
            add("Après être allée au parc, j'ai fait du patinage", "After going to the park, I(f) went skating");
            add("Après être rentré, on a surfé le net", "After coming back home, I/we surfed the net");
            add("Après m'être levée, j'ai pris mon petit déjeuner", "After getting up, I(f) had my breakfast", PRONOMINAL);
            add("Après t'être réveillée, tu t'es habillée", "After waking up, you(tu.f) got dressed", PRONOMINAL);
            add("Après s'être douchés, ils sont partis", "After showering, they left", PRONOMINAL);
            add("Après avoir ouvert le cadeau, tu m'as envoyé un mél", "After opening the present, you(tu) sent me an e-mail(mél)");
            add("Après avoir visité le musée, elle a travaillé à la bibliothèque", "After having visited the museum, she worked in the library");
            add("Après avoir fait les courses, j'ai pris le train", "After having done the shopping, I took the train");
            add("Après avoir joué de la batterie, il a fait de l'escalade", "After having played the drums, he went climbing");
            add("Après avoir diné, elle s'est couchée", "After having dined, she went to bed", PRONOMINAL);
            add("Après avoir voyagé en avion, ils sont allés à un concert", "After having travelled by plane, they went to a concert");
            add("Après être arrivée à l'hôtel, tu as pris un bain", "After having arrived at the hotel, you(tu.f) took a bath");
        });
    }
        
    // Page 51 - Using two pronons together
    public void P51_UsingTwoPronounsTogether()
    {
        push(CLITIC, () ->
        {
            add("Elles le leur ont offert", "They(f) offered it to them");
            add("Je vais vous y rencontrer", "I am going to meet you |there|", Y);
            add("Nous pouvons les y voir", "We can see them |there|");
            add("Nous t'en avons acheté", "We bought some for |you(tu)|", EN);
            add("Voulez-vous les leur offrir ?", "(Do) You want to offer them to them?");
            add("Tu me l'as pris", "You(tu) took it for me");
            add("Tu me l'as prise", "You(tu) took |the car| for me");
            add("Il va nous les ouvrir", "He is going to open them for us");
            add("Ils doivent m'en parler", "They must talk to me about it", EN);
            add("On le lui a trouvé", "I/We found it for her");
            add("Elle peut nous le préparer", "She can prepare it for us");
        });
    }

    private void Page56()
    {
        // Page 56 - Verbs requiring à or de before an infinitive
        {
            add("J'ai oublié de téléphoner à Paul", "I have forgotten to telephone Paul");
            add("Elle invite ses amis à jouer au tennis", "She is inviting her friends to play tennis");
            add("Tu réussis toujours à finir avant moi", "You(tu) always succeed in finishing before me");
            add("Ils vont essayer d'avoir de bons résultats", "They are going to try to have good results");
            add("Nous avions décidé de finir plus tôt", "We had decided to finish earlier");
            add("Il allait commencer à jouer de la flute", "He was going to begin playing the flute");
            add("Vous avez appris à parler français", "You have learnt to speak French");
            add("On a arrêté de regarder le film", "I/We stopped watching the film");
            add("Veux-tu aider à débarrasser la table ?", "(Do) you(tu) want to help to clear the table?");
            add("Je suis obligé de faire un stage", "I am obliged to do work experience");
        }
    }

    private void Page58()
    {
        // Verbs requiring à + person + de + infinitive
        {
            add("Vous avez proposé à Martin de jouer au tennis", "You suggested to Martin that you play tennis");
            add("Elle va promettre à ses parents de travailler dur", "She is going to promise her parents to work hard");
            add("Nous conseillons aux garçons de voyager par le train", "We are advising the boys to travel by train");
            add("As-tu dit à Marie de faire le repassage ?", "(Did) you(tu) tell Marie to do the ironing?");
            add("Je défendrai à mes enfants de partir", "I will forbid my children to leave");
            add("Il a demandé à Marc de réparer la voiture", "He asked Marc to repair the car");
            add("Ils ont permis à Juliette d'aller au concert", "They allowed Juliette to go to the concert");
            add("Je promets à Sylvia de manger au restaurant", "I am promising Sylvia to eat at the restaurant");
            add("Elle n'a jamais défendu à sa fille de jouer au concert de rock", "She never forbade her daughter to play at the rock concert");
            add("Je vais promettre à mes cousins de partir en vacances", "I am going to promise my cousins to leave on holiday");
        }
    }

    private void Page59()
    {
        // Page 59 - Pronouns with verbs requiring à + person + de + infinitive
        {
            add("Tu me promettras de revenir", "You(tu) will promise me to come back");
            add("Ils vous avaient commandé de sortir", "They had ordered you to come out");
            add("Je vais vous défendre de faire la cuisine", "I am going to forbid you to do the cooking");
            add("Elle ne va pas nous ordonner de jouer", "She is not going to order us to play");
            add("Il m'a proposé de passer les vacances en France", "He suggested to me to spend the holidays in France");
            add("Il me conseille d'écouter le nouveau CD", "He is advising me to listen to the new CD");
            add("Nous vous demanderons de nous accompagner", "We will ask you to accompany us");
            add("Elles vont leur dire d'aider", "They(f) are going to tell them to help");
            add("Vous lui avez permis d'aller au parc", "You allowed her to go to the park");
            add("On t'a promis de revenir samedi", "I/We promised you(tu) to come back on Saturday");
        }
    }

    private void Page60()
    {
        // Page 60 - Converting to subjunctive
        push(SUBJUNCTIVE, () ->
        {
            add("Il faut que vous travailliez", "(falloir) Vous devez travailler");
            add("Il faut que nous écoutions les jeunes", "(falloir) Nous devons écouter les jeunes");
            add("Il faut que tu écrives la lettre", "(falloir) Tu dois écrire la lettre");
            add("Il faut qu'ils suivent les traditions", "(falloir) Ils doivent suivre les traditions");
            add("Il faut que j'attende", "(falloir) Je dois attendre");
            add("Il faut que nous nous rencontrions", "(falloir) Nous devons nous rencontrer", PRONOMINAL);
            add("Il faut que je paraisse calme", "(falloir) Je dois paraitre calme");
        });

        // Page 60 - Subjunctive Use
        push(SUBJUNCTIVE, () ->
        {
            add("Je souhaite que les enfants puissent réussir", "I wish the children can succeed");
            add("Je ne crois pas qu'il sache où j'habite", "I don't believe he knows where I live");
            add("Ils s'étonnent que je veuille étudier les maths", "They are astonished that I want to study maths", PRONOMINAL);
            add("Elle regrette que tu n'ailles pas à l'université", "She is sorry that you(tu) are not going to university");
            add("Je crains qu'elle soit en retard", "I fear she may be late");
            add("Elle a peur que vous vous fassiez mal", "She is scared that you will hurt yourself", PRONOMINAL);
            //add("Nos amis attendent que nous puissions sortir", "Our friends are waiting for {us to go out}");
            add("Ma mère voudrait que je sois médecin", "My mother would want for me to be a doctor");
            add("Je veux que tu fasses tes devoirs", "I want you(tu) to do your homework");
            add("Ils souhaitent que je réussisse dans ma carrière", "They wish that I succeed in my career");
            add("Elle s'étonne que je n'aie pas beaucoup de livres", "She is astonished that I haven't many books");
            add("Je crains qu'il ne puisse pas voyager", "I fear that he may not be able to travel");
            add("Ma correspondante attend que j'aille en France", "My pen-friend(f) is waiting for me to go to France");
            add("Je ne pense pas qu'il veuille aller à l'étranger", "I don't think he wants to go abroad");
        });
    }
}