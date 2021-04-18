package fr;
import java.util.function.Predicate;

public final class AdjectiveFilters
{
    private AdjectiveFilters() {
        
    }
    
    public static Predicate<Adjective> name(final String name) {
        return new Predicate<Adjective>() {

            @Override
            public boolean test(Adjective item)
            {
                return name.equals(item.name());
            }
            
            @Override
            public String toString()
            {
                return name;
            }
        };
    }
    
    public static Predicate<Adjective> tag(final AdjectiveTag tag) {
        return new Predicate<Adjective>() {

            @Override
            public boolean test(Adjective item)
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
}
