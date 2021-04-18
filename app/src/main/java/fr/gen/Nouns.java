package fr.gen;
import apz.fr.utils.*;
import fr.*;
import fr.score.*;
import static apz.fr.utils.Utils.*;

import java.util.function.Predicate;

public final class Nouns extends NounQuestionSupport
{
    private static final WeightedProducer<Generator> generators = new WeightedProducer<>();

    public Nouns(ScoreFileBuilder scores, SortingPolicy sortPolicy, Wordlist wordlist, Predicate<Noun> filter) {
        super(scores, sortPolicy, wordlist, filter);
    }
    
    @Override
    public Question generate(Noun noun) {
        final String[] question = generators.next().generate(noun);
        return new TextQuestion(this,
                noun.getName(),
                question[0],
                question[1]);
    }
    
    private interface Generator {
        String[] generate(Noun noun);
    }
    
    static {
        generators.add(noun -> of(select(noun.isPlural(), "These ones", "This one") + " (" + noun.getTranslation() + ")", noun.select("celui", "celle", "ceux", "celles") + " (" + noun.getName() + ")"));
        generators.add(noun -> of("All the " + noun.getTranslation(), PackageUtils.elide(noun.select("tout", "toute", "tous", "toutes"), PackageUtils.nounDefiniteFr(noun))));
        generators.add(noun -> of("Which " + noun.getTranslation() + " ?", noun.select("Quel", "Quelle", "Quels", "Quelles") + " " + noun.getName() + " ?"));
    }
}