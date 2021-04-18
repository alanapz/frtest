package fr.gen;
import apz.fr.utils.*;
import fr.*;
import fr.score.*;
import java.util.*;
import java.util.function.Predicate;

public final class NounParticles extends NounQuestionSupport
{
    private static final List<Particle> particles = new ArrayList<>();
    
    public NounParticles(ScoreFileBuilder scores, SortingPolicy sortPolicy, Wordlist wordlist, Predicate<Noun> filter) {
        super(scores, sortPolicy, wordlist, filter);
    }
    
    @Override
    public Question generate(Noun noun) {
        final Particle particle = Utils.random(particles);
        return new TextQuestion(this, noun.getName(), particle.en(noun), particle.fr(noun));
    }

    static {
        particles.add(new Particle("ci", "This", "These"));
        particles.add(new Particle("là", "That", "Those"));
    }
    
    private static final class Particle
    {
        private final String frParticle, enSingular, enPlural;
        
        public Particle(String frParticle, String enSingular, String enPlural) {
            this.frParticle = frParticle;
            this.enSingular = enSingular;
            this.enPlural = enPlural;
        }
        
        public String en(Noun noun) {
            return "*" + noun.select(enSingular, enSingular, enPlural) + "* " + noun.getTranslation();
        }

        public String fr(Noun noun) {
            return noun.select(noun.isTag(NounTag.CONTRACTED) ? "Cet" : "Ce", "Cette", "Ces") + " " + noun.getName() + "-" + frParticle;
        }
    }
}