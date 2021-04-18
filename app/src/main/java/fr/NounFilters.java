package fr;
import apz.fr.utils.*;
import java.util.function.Predicate;
import java.util.regex.*;

public final class NounFilters {

    private NounFilters() {
        
    }
    
    public static Predicate<Noun> name(final String name) {
        return new Predicate<Noun>() {

            @Override
            public boolean test(Noun noun)
            {
                return name.equals(noun.getName());
            }
            
            @Override
            public String toString()
            {
                return name;
            }
        };
    }
    
    public static Predicate<Noun> tag(final NounTag tag) {
        return new Predicate<Noun>() {

            @Override
            public boolean test(Noun item)
            {
                return item.isTag(tag);
            }
            
            @Override
            public String toString()
            {
                return tag.name();
            }
        };
    }

    public static Predicate<Noun> gender(final WordGender gender) {
        return new Predicate<Noun>()
        {
            @Override
            public boolean test(Noun item)
            {
                return item.getGender() == gender;
            }
            
            @Override
            public String toString()
            {
                return gender.name();
            }
        };
    }

    public static Predicate<Noun> startsWithVowel() {
        return (Noun noun) -> Pattern.compile("[aeiou]+.*").matcher(noun.getName()).matches();
    }
    
    public static WeightedProducer<Predicate<Noun>> nounGroupByGender() {
        final WeightedProducer<Predicate<Noun>> list = new WeightedProducer<>();
        list.add(gender(WordGender.IL));
        list.add(gender(WordGender.ELLE));
        list.add(gender(WordGender.ILS));
        list.add(gender(WordGender.ELLES));
        return list;
    }
}