package fr;
import apz.fr.utils.*;
import static fr.VerbPerson.*;
import fr.dict.*;
import fr.game.*;   
import fr.gen.*;
import fr.score.*;
import java.io.*;
import java.util.*;
import java.util.function.*;
import javax.swing.*;

public final class Launcher
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            new Launcher().go();
        }
        catch(TerminateException e)
        {
            // Nothing to do here
        }
    }
    
    @SuppressWarnings({"unchecked"})
    private void go() throws IOException
    {
        GameSelector<LevelBuilder> selector = new GameSelector<>();
        
        try(ScoreFileBuilder scores = new ScoreFileBuilder())
        {
            Launcher.buildSelector(scores, selector);

            final class PolicyCallbackImpl implements PolicyCallback
            {
                private ToString<SortingPolicy> policy;
                
                @Override
                public synchronized SortingPolicy policy()
                {
                    if (policy != null)
                    {
                        return policy.value;
                    }
                    this.policy = (ToString<SortingPolicy>) JOptionPane.showInputDialog(null, "Select sorting policy", "APZ FR", JOptionPane.INFORMATION_MESSAGE, null,
                            new ToString<?>[]
                            {
                                ToString.of("Score", SortingPolicy.byScore()),
                                ToString.of("Score X", SortingPolicy.byAttemptTimeAdjust()),
                                ToString.of("Date (Attempt)", SortingPolicy.byAttemptTime()),
                                ToString.of("Date (Correct)", SortingPolicy.byCorrectTime()),
                                ToString.of("(Random)", null)
                            }, null);
                    if (policy == null)
                    {
                        throw new TerminateException();
                    }
                    return policy.value;
                }
            }
            
            QuestionGenerator generator = buildGenerator(selector.go(), new PolicyCallbackImpl());
            if (generator == null)
            {
                return; 
            }
            
            System.out.println(generator);

            final Integer numQuestions = (Integer) JOptionPane.showInputDialog(null, "Select number of questions", "APZ FR", JOptionPane.INFORMATION_MESSAGE, null, new Integer[] { 10, 20, 50, 100}, null);
            if (numQuestions == null)
            {
                return;
            }

//            final Integer difficulty = (Integer) JOptionPane.showInputDialog(null, "Select difficulty", "APZ FR", JOptionPane.INFORMATION_MESSAGE, null, new Integer[] { 0, 5, 10}, null);
//            if (difficulty == null)
//            {
//                return;
//            }

            final List<Question> questions = new ArrayList<>(generator.generate(numQuestions, new ArrayList<>()));

            FileWriter qw = new FileWriter(System.getProperty("user.home") + "\\Desktop\\e.txt");
            FileWriter aw = new FileWriter(System.getProperty("user.home") + "\\Desktop\\f.txt");
            int i = 1;
            for(Question question: questions)
            {
                i++;
                qw.write(i + " " + question.getQuestion() + "\r\n");
                aw.write(i + " " + question.getAnswer() + "\r\n");
            }
            qw.close();
            aw.close();
            
            
            //Result result = new SuddenDeathGame(questions, 3).go();
            Result result = new PaneGame2(questions, 0).go();
            System.out.println("CORRECT: " + result.getCorrect().size());
            System.out.println("WRONG: " + result.getWrong().size());
            if (generator instanceof FixedQuestionGenerator)
            {
                scores.open((FixedQuestionGenerator) generator).update(result);
            }
        }
    }
    
    private interface PolicyCallback
    {
        SortingPolicy policy();
    }
    
    private static QuestionGenerator buildGenerator(List<LevelBuilder> builders, PolicyCallback policy) throws IOException
    {
        if (builders.isEmpty())
        {
            return null;
        }
        Wordlist wordlist = DictionaryBuilder.buildWordlist();
        if (builders.size() == 1)
        {
            return buildGenerator(builders.get(0), wordlist, policy);
        }
        CompoundGenerator generator = new CompoundGenerator();
        builders.forEach((builder) -> generator.add(buildGenerator(builder, wordlist, policy)));
        return generator;
    }

    private static QuestionGenerator buildGenerator(LevelBuilder builder, Wordlist wordlist, PolicyCallback policy)
    {
        if (builder instanceof PolicyLevelBuilder)
        {
            return ((PolicyLevelBuilder) builder).build(wordlist, policy.policy());
        }
        else if (builder instanceof GeneratedLevelBuilder)
        {
            return ((GeneratedLevelBuilder) builder).build(wordlist);
        }
        else
        {
            return null;
        }
    }

    @SuppressWarnings({"unchecked"})
    private static void buildSelector(final ScoreFileBuilder scores, GameSelector<LevelBuilder> selector)
    {
        abstract class Item implements GameSelector.Item<LevelBuilder>
        {
        }
        
        final GameSelector<LevelBuilder>.Category misc = selector.addCategory("MISC");
        {
            final class MiscItem extends Item
            {
                private final Function<Predicate<SentenceQuestion>, LevelBuilder> callback;
                
                private MiscItem(Function<Predicate<SentenceQuestion>, LevelBuilder> callback) {
                    this.callback = callback;
                }
                
                @Override
                @SuppressWarnings("unchecked")
                public final LevelBuilder build(Object[] filters) {
                    return callback.apply(Filters.or(Arrays.asList(filters).toArray(new Predicate[0])));
                }
            }
            misc.addLeft("Vocabulary", new MiscItem((filter) -> (PolicyLevelBuilder)(wordlist, policy) -> new MiscVocabulary(scores, policy, filter)));
            misc.addLeft("Direct/Indirect Verbs", new Item()
            {
                @Override
                public LevelBuilder build(Object[] unused)
                {
                    return (PolicyLevelBuilder)(wordlist, policy) -> new DirectIndirectVerbs();
                }
            });
            misc.addLeft("Phrasal Verbs", new Item()
            {
                @Override
                public LevelBuilder build(Object[] unused)
                {
                    return (GeneratedLevelBuilder)(wordlist) -> new PhrasalVerbs(wordlist, null, null); 
                }
            });
//            misc.addLeft("Disjunctive Pronouns", new Item()
//            {
//                @Override
//                public LevelBuilder build(Object[] unused)
//                {
//                    return new GeneratedLevelBuilder()
//                    {
//                        @Override
//                        public QuestionGenerator build(Wordlist wordlist)
//                        {
//                            return new DisjunctivePronouns();//new PhrasalVerbs2(scores, wordlist);
//                        }
//                    };
//                }
//            });
            misc.addRight("Adverbial", (Predicate<SentenceQuestion>)(SentenceQuestion item) -> item.isTag(MiscVocabulary.DONT) || item.isTag(MiscVocabulary.EN) || item.isTag(MiscVocabulary.Y));
            misc.addRight("Agreement", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.AGREEMENT));
            misc.addRight("Causative", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.FAIRE));
            misc.addRight("Clitic", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.CLITIC));
            misc.addRight("Conditional", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.CONDITIONAL));
            misc.addRight("Locative", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.LOCUTION));
            misc.addRight("Partative", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.DE));
            misc.addRight("Participle", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.PARTICIPLE));
            misc.addRight("Temporal", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.Preposition.TEMPORAL));
            misc.addRight("Pronominal", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.PRONOMINAL));
            misc.addRight("Subjunctive", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.SUBJUNCTIVE));
            misc.addRight("Physical", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.Preposition.PHYSICAL));
            misc.addRight("Y", (Predicate<SentenceQuestion>)(item) -> item.isTag(MiscVocabulary.Y));
            misc.addRight("(Arriver)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*(arriv)+.*"));
            misc.addRight("(Depuis)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*(depuis)+.*"));
            misc.addRight("(Falloir)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*il.*(falloir|fallu|faut|fallait|faudra|faudrait|faille)+.*"));
            misc.addRight("(Manquer)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*(manqu)+.*"));
            misc.addRight("(Valoir)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*(valoir|valu|vaut|valez|valait)+.*"));
            misc.addRight("(Venir)", (Predicate<SentenceQuestion>)(item) -> item.getAnswer().matches("(?i).*(venir|vemu|vien|venons|venez|vienn)+.*"));
            misc.addRight("NONE", (Predicate<SentenceQuestion>)(item) -> item.getTags().isEmpty());
        }
        
        final GameSelector<LevelBuilder>.Category nouns = selector.addCategory("NOUNS");
        {
            abstract class NounItem extends Item
            {
                @Override
                public final LevelBuilder build(Object[] modifier)
                {
                    return build((Producer<Predicate<Noun>>) null);
                }
                
                public abstract LevelBuilder build(Producer<Predicate<Noun>> filter);
            }
            
            nouns.addLeft("Nouns", new NounItem()
            {
                @Override
                public PolicyLevelBuilder build(final Producer<Predicate<Noun>> filter) {
                    return (wordlist, policy) -> new Nouns(scores, policy, wordlist, Producer.next(filter));
                }
            });
            
            nouns.addLeft("De Partative", new NounItem()
            {
                @Override
                public LevelBuilder build(final Producer<Predicate<Noun>> filter) {
                    return (GeneratedLevelBuilder)(wordlist) -> new DePartative(scores, wordlist, Producer.next(filter));
                }
            });
            
            nouns.addLeft("Demonstrative Adjectives", new NounItem()
            {
                @Override
                public LevelBuilder build(final Producer<Predicate<Noun>> filter) {
                    return (GeneratedLevelBuilder) ThisThatTheseThose::new;
                }
            });

            nouns.addRight("Important", new WeightedProducer<Predicate<Noun>>().add(NounFilters.tag(NounTag.STARRED)));
        }
        
        final GameSelector<LevelBuilder>.Category verbs = selector.addCategory("VERBS");
        {
            final class VerbItem extends Item
            {
                private final Function<Producer<Predicate<Verb>>, LevelBuilder> callback;
                
                private VerbItem(Function<Producer<Predicate<Verb>>, LevelBuilder> callback) {
                    this.callback = callback;
                }
                
                @Override
                public final LevelBuilder build(Object[] modifiers) {
                    if (modifiers.length == 0) {
                        return callback.apply(null);
                    }
                    final CircularProducer<Predicate<Verb>> producer = new CircularProducer<>();
                    for (Object modifier: modifiers) {
                        Supplier<Producer<Predicate<Verb>>> supplier = (Supplier<Producer<Predicate<Verb>>>) modifier;
                        producer.add(supplier.get());
                    }
                    return callback.apply(producer);
                }
            }
            
            verbs.addLeft("Present Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new PresentTense(wordlist, filter)));
            verbs.addLeft("Perfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new PerfectTense(wordlist, filter)));
            verbs.addLeft("Pluperfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new PluperfectTense(wordlist, filter)));
            verbs.addLeft("Imperfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new ImperfectTense(wordlist, filter)));
            verbs.addLeft("Future Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new FutureTense(wordlist, filter)));
            verbs.addLeft("Future Perfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new FuturePerfectTense(wordlist, filter)));
            verbs.addLeft("Subjunctive Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new SubjunctiveTense(wordlist, filter)));
            verbs.addLeft("Subjunctive Perfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new SubjunctivePerfect(wordlist, filter)));
            verbs.addLeft("Conditional Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new ConditionalTense(wordlist, filter)));
            verbs.addLeft("Conditional Perfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new ConditionalPerfectTense(wordlist, filter)));
            verbs.addLeft("Infinitive Perfect Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new InfinitivePerfectTense(wordlist, filter)));
            verbs.addLeft("Imperative Tense", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new ImperativeTense(wordlist, filter)));
            verbs.addLeft("Present Participle", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new PresentParticiple(wordlist, filter)));
            verbs.addLeft("Perfect Participle", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> new PerfectParticiple(wordlist, filter)));
            verbs.addLeft("All Compound Tenses", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> tenseBuilder(wordlist, filter, false, true, false)));
            verbs.addLeft("All Conjugated Tenses", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> tenseBuilder(wordlist, filter, true, false, false)));
            verbs.addLeft("All (Compound + Conjugated + Participle)", new VerbItem((filter) -> (GeneratedLevelBuilder)(wordlist) -> tenseBuilder(wordlist, filter, true, true, true)));

            verbs.addLeft("HITLIST", new VerbItem((filter) ->
                    (GeneratedLevelBuilder) (Wordlist wordlist) ->
                    {
                        CompoundGenerator generator = new CompoundGenerator();
                        // PRESENT
                        generator.add(new PresentTense(wordlist, infinitive("appeler")));
                        generator.add(new PresentTense(wordlist, infinitive("choisir"), person(NOUS, VOUS, ILS)));
                        generator.add(new PresentTense(wordlist, infinitive("connaitre")));
                        generator.add(new PresentTense(wordlist, infinitive("croire"), person(NOUS, VOUS, ILS)));
                        generator.add(new PresentTense(wordlist, infinitive("décevoir")));
                        generator.add(new PresentTense(wordlist, infinitive("dire"), person(NOUS, VOUS, ILS)));
                        generator.add(new PresentTense(wordlist, infinitive("embrasser")));
                        generator.add(new PresentTense(wordlist, infinitive("essayer")));
                        // generator.add(new PresentTense(wordlist, infinitive("falloir")));
                        generator.add(new PresentTense(wordlist, infinitive("mener")));
                        generator.add(new PresentTense(wordlist, infinitive("paraitre")));
                        // generator.add(new PresentTense(wordlist, infinitive("pleuvoir")));
                        generator.add(new PresentTense(wordlist, infinitive("préférer")));
                        generator.add(new PresentTense(wordlist, infinitive("prendre"), person(ILS)));
                        generator.add(new PresentTense(wordlist, pronominal("promener")));
                        generator.add(new PresentTense(wordlist, infinitive("promettre")));
                        generator.add(new PresentTense(wordlist, infinitive("rappeler")));
                        generator.add(new PresentTense(wordlist, infinitive("recevoir")));
                        generator.add(new PresentTense(wordlist, infinitive("venir"), person(ILS)));
                        generator.add(new PresentTense(wordlist, infinitive("vieillir")));
                        generator.add(new PresentTense(wordlist, infinitive("vouloir"), person(NOUS, ILS)));
                        generator.add(new PresentTense(wordlist, pronominal("sentir")));
                        generator.add(new PresentTense(wordlist, pronominal("servir")));
                        // IMPERFECT
                        generator.add(new ImperfectTense(wordlist, infinitive("aller")));
                        // IMPERATIVE
                        generator.add(new ImperativeTense(wordlist, infinitive("aller")));
                        generator.add(new ImperativeTense(wordlist, infinitive("avoir")));
                        generator.add(new ImperativeTense(wordlist, infinitive("vouloir")));
                        // SUBJUNCTIVE
                        generator.add(new SubjunctiveTense(wordlist, infinitive("aller")));
                        generator.add(new SubjunctiveTense(wordlist, infinitive("avoir")));
                        generator.add(new SubjunctiveTense(wordlist, infinitive("aller"), person(JE, TU, IL, NOUS, VOUS, ILS)));
                        generator.add(new SubjunctiveTense(wordlist, infinitive("dire")));
                        generator.add(new SubjunctiveTense(wordlist, infinitive("voir")));
                        generator.add(new SubjunctiveTense(wordlist, infinitive("vouloir")));
                        return generator;
                    }));

            verbs.addRight("Aller", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.infinitive("aller")));

            verbs.addRight("Aller/Etre", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.infinitive("aller"))
                    .add(VerbFilters.infinitive("être")));

            verbs.addRight("Aller/Etre/Avoir/Faire/Venir", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.infinitive("aller"))
                    .add(VerbFilters.infinitive("avoir"))
                    .add(VerbFilters.infinitive("être"))
                    .add(VerbFilters.infinitive("faire"))
                    .add(VerbFilters.infinitive("venir")));

            verbs.addRight("Important", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.infinitive("aller"))
                    .add(VerbFilters.infinitive("arriver"))
                    .add(VerbFilters.infinitive("avoir"))
                    .add(VerbFilters.infinitive("croire"))
                    .add(VerbFilters.infinitive("connaitre"))
                    .add(VerbFilters.infinitive("devenir"))
                    .add(VerbFilters.infinitive("devoir"))
                    .add(VerbFilters.infinitive("descendre"))
                    .add(VerbFilters.infinitive("dire"))
                    .add(VerbFilters.infinitive("entrer"))
                    .add(VerbFilters.infinitive("être"))
                    .add(VerbFilters.infinitive("faire"))
                    .add(VerbFilters.infinitive("falloir"))
                    .add(VerbFilters.infinitive("finir"))
                    .add(VerbFilters.infinitive("laisser"))
                    .add(VerbFilters.infinitive("lever"))
                    .add(VerbFilters.infinitive("lire"))
                    .add(VerbFilters.infinitive("mettre"))
                    .add(VerbFilters.infinitive("monter"))
                    .add(VerbFilters.infinitive("mourir"))
                    .add(VerbFilters.infinitive("partir"))
                    .add(VerbFilters.infinitive("passer"))
                    .add(VerbFilters.infinitive("prendre"))
                    .add(VerbFilters.infinitive("pouvoir"))
                    .add(VerbFilters.infinitive("rendre"))
                    .add(VerbFilters.infinitive("rester"))
                    .add(VerbFilters.infinitive("savoir"))
                    .add(VerbFilters.infinitive("servir"))
                    .add(VerbFilters.infinitive("sortir"))
                    .add(VerbFilters.infinitive("tenir"))
                    .add(VerbFilters.infinitive("tomber"))
                    .add(VerbFilters.infinitive("valoir"))
                    .add(VerbFilters.infinitive("venir"))
                    .add(VerbFilters.infinitive("visiter"))
                    .add(VerbFilters.infinitive("voir"))
                    .add(VerbFilters.infinitive("vouloir")));
            
            verbs.addRight("Pronominal", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.tag(VerbTag.PRONOMINAL)));

            verbs.addRight("Template", (Supplier<Producer<Predicate<Verb>>>)() -> new CircularProducer<Predicate<Verb>>()
                    .add(VerbFilters.tag(VerbTag.TEMPLATE))
                    .add(Filters.and(VerbFilters.tag(VerbTag.TEMPLATE), VerbFilters.tag(VerbTag.ER)))
                    .add(Filters.and(VerbFilters.tag(VerbTag.TEMPLATE), VerbFilters.tag(VerbTag.IR)))
                    .add(Filters.and(VerbFilters.tag(VerbTag.TEMPLATE), VerbFilters.tag(VerbTag.RE))));
            
            verbs.addRight("Custom", (Supplier<Producer<Predicate<Verb>>>)() ->
                    new CircularProducer<Predicate<Verb>>()
                        .add(VerbFilters.infinitive(Swing.input(Swing.Type.INFO, "Verb", "Infinitive(s)").split(","))));
        }

//        final GameSelector<LevelBuilder>.Category revisions = selector.addCategory("REVISION");
//        {
//            revisions.addLeft("Vocabulary+Nouns (by score)", new Item()
//            {
//                @Override
//                public LevelBuilder build(Object[] unused)
//                {
//                    return (GeneratedLevelBuilder) (Wordlist wordlist) -> new CompoundGenerator()
//                                .add(new MiscVocabulary(scores, SortingPolicy.byScore(), null))
//                                .add(new Nouns(scores, SortingPolicy.byScore(), wordlist, null));
//                }
//            });
//            revisions.addLeft("MODAL VERBS", new Item()
//            {
//                @SuppressWarnings("unchecked")
//                private final Producer<Filter<Verb>> filter = new WeightedProducer<>(VerbFilters.infinitives(
//                        "être",
//                        "avoir",
//                        "aller",
//                        "venir",
//                        "devoir",
//                        "pouvoir",
//                        "savoir",
//                        "faire",
//                        "laisser",
//                        "vouloir"));
//
//                @Override
//                public LevelBuilder build(Object[] unused)
//                {
//                    return (GeneratedLevelBuilder)(Wordlist wordlist) -> tenseBuilder(wordlist, filter, true, true, false);
//                }
//            });
//        }
//
        
////        map.put("NOUNS - Possessive Adjectives", new LevelBuilder()
////        {
////            @Override
////            public QuestionGenerator build(Wordlist wordlist)
////            {
////                return new PossessiveAdjectives(wordlist);
////            }
////        });
////        map.put("Possessive Pronouns", new LevelBuilder()
////        {
////            @Override
////            public QuestionGenerator build(Wordlist wordlist)
////            {
////                return new PossessivePronouns(wordlist);
////            }
////        });
////        map.put("Adjective Agreement", new LevelBuilder()
////        {
////            @Override
////            @SuppressWarnings("unchecked")
////            public QuestionGenerator build(Wordlist wordlist)
////            {
////                CompoundGenerator generator = new CompoundGenerator();
////                generator.add(new AdjectiveAgreement(wordlist));
////                return generator;
////            }
////        });
////        map.put("Possessive+Disjunctive Pronouns", new LevelBuilder()
////        {
////            @Override
////            public QuestionGenerator build(Wordlist wordlist)
////            {
////                CompoundGenerator generator = new CompoundGenerator();
////                generator.add(new ObjectPronouns(wordlist));
////                //generator.add(new PossessivePronouns(wordlist));
////                //generator.add(new DisjunctivePronouns());
////                return generator;
////            }
////        });
//        /*
//        map.put("Pronouns (Possessive)", new LevelBuilder()
//        {
//            @Override
//            public QuestionGenerator build(Wordlist wordlist)
//            {
//                return new PossessivePronouns(wordlist);
//            }
//        });
//        */
    }
    
    private interface LevelBuilder
    {
        
    }

    private interface GeneratedLevelBuilder extends LevelBuilder
    {
        QuestionGenerator build(Wordlist wordlist);
    }
    
    private interface PolicyLevelBuilder extends LevelBuilder
    {
        QuestionGenerator build(Wordlist wordlist, SortingPolicy sortPolicy);
    }

    private static Producer<Predicate<Verb>> infinitive(String infinitive) {
        return new WeightedProducer<>(VerbFilters.infinitive(infinitive));
    }
    
    private static Producer<Predicate<Verb>> pronominal(String infinitive) {
        return new WeightedProducer<>(VerbFilters.pronominal(infinitive));
    }

    private static Producer<VerbPerson> person(VerbPerson... person)
    {
        return new WeightedProducer<>(person);
    }

    private static CompoundGenerator tenseBuilder(Wordlist wordlist, Producer<Predicate<Verb>> filter, boolean conjugated, boolean compound, boolean participle) {
        final CompoundGenerator generator = new CompoundGenerator();
        if (conjugated) {
            generator.add(new PresentTense(wordlist, filter));
            generator.add(new ImperfectTense(wordlist, filter));
            generator.add(new FutureTense(wordlist, filter));
            generator.add(new ImperativeTense(wordlist, filter));
            generator.add(new ConditionalTense(wordlist, filter));
            generator.add(new SubjunctiveTense(wordlist, filter));
        }
        if (compound) {
            generator.add(new InfinitivePerfectTense(wordlist, filter));
            generator.add(new PerfectTense(wordlist, filter));
            generator.add(new PluperfectTense(wordlist, filter));
            generator.add(new FuturePerfectTense(wordlist, filter));
            generator.add(new ConditionalPerfectTense(wordlist, filter));
            generator.add(new SubjunctivePerfect(wordlist, filter));
        }
        if (participle) {
            generator.add(new PresentParticiple(wordlist, filter));
            generator.add(new PerfectParticiple(wordlist, filter));
        }
        return generator;
    }
}