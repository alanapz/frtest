package fr.gen;
import apz.fr.utils.*;
import apz.fr.utils.ftl.*;
import fr.*;
import fr.lang.*;
import java.util.*;
import java.util.function.Predicate;

public final class PhrasalVerbs implements QuestionGenerator {

    private final Wordlist wordlist;

    private final Producer<VerbPerson> personMap;

    private final Producer<VerbGender> genderMap;

    private static final CircularProducer<Phrase> phrases = new CircularProducer<>();
    
    public PhrasalVerbs(Wordlist wordlist, WeightedProducer<VerbPerson> personMap, WeightedProducer<VerbGender> genderMap) {
        this.wordlist = wordlist;
        this.personMap = (personMap != null ? personMap : WeightedProducer.fromEnum(VerbPerson.class));
        this.genderMap = (genderMap != null ? genderMap : WeightedProducer.fromEnum(VerbGender.class));
    }

    @Override
    public List<Question> generate(int size, List<Question> questions) {
        for (Phrase phrase: phrases.next(new Phrase[size])) {
            final Verb principal = wordlist.lookupVerb(phrase.infinitive);
            final VerbPerson person = personMap.next();
            final VerbGender gender = genderMap.next();
            final Pronoun subject = Pronoun.get(PackageUtils.toVoice(person, gender));
            
            final Verb secondary = wordlist.takeVerb(new WeightedProducer<Predicate<Verb>>().add(VerbFilters.tag(VerbTag.TEMPLATE)));
            
            final StringTemplateLoader frTemplate = new StringTemplateLoader(phrase.phrase);
            frTemplate.put("func", new Functions(person));
            frTemplate.put("subject", subject.frSubject);
            frTemplate.put("verb", principal.present(person));
            frTemplate.put("secondary", secondary.infinitive());

            final StringTemplateLoader enTemplate = new StringTemplateLoader(phrase.translation);
            enTemplate.put("fx", new Functions(person));
            enTemplate.put("subject", subject.enSubject);

            questions.add(new TextQuestion(this, enTemplate.render(), frTemplate.render()));
        }
        return questions;
    }
    
    public static final class Functions
    {
        private final VerbPerson person;
        
        private Functions(VerbPerson person)
        {
            this.person = person;
        }
        
        public String elide(String left, String right)
        {
            return person == VerbPerson.JE && PackageUtils.vowelStart(right) ? "J'" + right : left + " " + right;
        }

        public String s()
        {
            return person == VerbPerson.IL ? "s" : "";
        }
    }
    
    @Override
    public String toString()
    {
        return "[person=" + personMap + ",gender=" + genderMap + "]";
    }
    
    static {
        add("accepter", "${func.elide(subject, verb)} de ${secondary}", "${subject} agree${fx.s()} to ${secondary}");
        add("avoir", "${func.elide(subject, verb)} besoin d'un stylo", "${subject} need${fx.s()} a pen");
        add("avoir", "${func.elide(subject, verb)} envie d'un stylo", "${subject} wants${fx.s()} a pen");
        add("aider", "${func.elide(subject, verb)} ?? ${secondary}", "${subject} help${fx.s()} to ${secondary}");
        add("arriver", "${func.elide(subject, verb)} ?? ${secondary}", "${subject} manage${fx.s()} to ${secondary}");
        //_("assister", "${func.elide(subject, verb)} ?? ${noun}", "${subject} attends ${noun}");
        add("chercher", "${subject} ${verb} ?? ${secondary}", "${subject} attempt${fx.s()} to ${secondary}");
        add("choisir", "${subject} ${verb}} de ${secondary}", "${subject} choose${fx.s()} to ${secondary}");
        add("conseiller", "${subject} ${verb} ?? mon ami", "${subject} advise${fx.s()} my friend");
        add("demander", "${subject} ${verb} ?? mon p??re", "${subject} ask${fx.s()} my dad");
        add("dire", "${subject} ${verb} ?? mes grands-parents", "${subject} tell${fx.s()} my grand-parents");
        add("faire", "${subject} ${verb} attention ?? la rue", "${subject} pay${fx.s()} attention to the road");
        add("plaire", "${subject} ${verb} ?? mon fr??re", "${subject} please${fx.s()} my brother");
        add("r??fl??chir", "${subject} ${verb} ?? un truc", "${subject} think${fx.s()} about a thingymabob");
        add("renoncer", "${subject} ${verb} ?? ${secondary}", "${subject} give${fx.s()} up ${secondary}");
        add("r??sister", "${subject} ${verb} ?? ${secondary}", "${subject} resist${fx.s()} ${secondary}");
        add("r??ussir", "${subject} ${verb} ?? ${secondary}", "${subject} succeed${fx.s()} in ${secondary}");
        add("t??l??phoner", "${subject} ${verb} ?? ma soeur", "${subject} call${fx.s()} my sister");
        add("voler", "${subject} ${verb} ?? Luc", "${subject} steal${fx.s()} from Luc");
    }
    
    private static void add(String infinitive, String value, String translation) {
        phrases.add(new Phrase(infinitive, StringTemplate.of(value), StringTemplate.of(translation)));
    }
    
    private static final class Phrase
    {
        private final String infinitive;
        
        private final StringTemplate phrase;

        private final StringTemplate translation;

        private Phrase(String infinitive, StringTemplate phrase, StringTemplate translation)
        {
            this.infinitive = infinitive;
            this.phrase = phrase;
            this.translation = translation;
        }
    }
}