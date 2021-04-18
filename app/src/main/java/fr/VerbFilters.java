package fr;
import apz.fr.utils.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.*;

public final class VerbFilters
{
    private VerbFilters()
    {
        
    }
    
    public static Predicate<Verb> infinitive(final String... infinitives) {
        return new Predicate<Verb>() {

            private final Set<String> set = new HashSet<>(Arrays.asList(infinitives));
            
            @Override
            public boolean test(Verb verb) {
                return set.contains(verb.infinitive()) && !verb.isTag(VerbTag.PRONOMINAL);
            }
            
            @Override
            public String toString()
            {
                return set.toString();
            }
        };
    }

    public static Predicate<Verb> pronominal(final String infinitive) {
        return new Predicate<Verb>() {

            @Override
            public boolean test(Verb verb) {
                return infinitive.equals(verb.infinitive()) && verb.isTag(VerbTag.PRONOMINAL);
            }
            
            @Override
            public String toString()
            {
                return "(se)" + infinitive;
            }
        };
    }
    
    @SuppressWarnings("unchecked")
    public static Predicate<Verb>[] infinitives(String... infinitives) {
        Predicate<Verb>[] out = (Predicate<Verb>[]) new Predicate<?>[infinitives.length];
        for (int i=0; i<infinitives.length; i++) {
            out[i] = infinitive(infinitives[i]);
        }
        return out;
    }

    public static Predicate<Verb> matches(final String regex) {
        return new Predicate<Verb>() {

            private final Pattern pattern = Pattern.compile(regex);
            
            @Override
            public boolean test(Verb verb)
            {
                return pattern.matcher(verb.infinitive()).matches();
            }
            
            @Override
            public String toString()
            {
                return regex;
            }
        };
    }

    public static Predicate<Verb> tag(final VerbTag tag) {
        return new Predicate<Verb>()
        {
            @Override
            public boolean test(Verb verb)
            {
                return verb.isTag(tag);
            }
            
            @Override
            public String toString()
            {
                return tag.name();
            }
        };
    }    

    public static Predicate<Verb> tagAny(final VerbTag... tags) {
        return new Predicate<Verb>() {

            @Override
            public boolean test(Verb verb) {
                for (VerbTag tag: tags) {
                    if (verb.isTag(tag)) {
                        return true;
                    }
                }
                return false;
            }
            
            @Override
            public String toString() {
                return "any[" + Arrays.toString(tags) + "]";
            }
        };
    }    
    
    public static Predicate<Verb> tagAll(final VerbTag... tags) {
        return new Predicate<Verb>()
        {
            @Override
            public boolean test(Verb verb) {
                for(VerbTag tag: tags) {
                    if (!verb.isTag(tag)) {
                        return false;
                    }
                }
                return true;
            }
            
            @Override
            public String toString() {
                return "all[" + Arrays.toString(tags) + "]";
            }
        };
    }
    
    public static List<Predicate<Verb>> cartesian(Predicate<Verb>[][] map) {
        final List<Predicate<Verb>> all = new ArrayList<>();
        for (int currOuter = 0; currOuter < map.length; currOuter++) {
            for (int currInner = 0; currInner < map[currOuter].length; currInner++) {
                for (int allOuter = currOuter+1; allOuter < map.length; allOuter++) {
                    for (int allInner = 0; allInner < map[allOuter].length; allInner++) {
                        all.add(Filters.and(map[currOuter][currInner], map[allOuter][allInner]));
                    }
                }
            }
        }
        return all;
    }
}