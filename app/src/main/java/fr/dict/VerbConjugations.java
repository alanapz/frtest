package fr.dict;
import fr.*;
import java.util.*;

/* package */ final class VerbConjugations
{
    private static final Map<VerbTag, Family> families = new EnumMap<>(VerbTag.class);
    
    private VerbConjugations()
    {
        
    }
    
    public static String gerund(VerbTag family, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).gerund);
    }
    
    public static String participle(VerbTag family, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).participle);
    }

    public static String present(VerbTag family, VerbPerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).present.get(person));
    }
    
    public static String future(VerbTag family, VerbPerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).future.get(person));
    }
    
    public static String imperfect(VerbTag family, VerbPerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).imperfect.get(person));
    }
    
    public static String subjunctive(VerbTag family, VerbPerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).subjunctive.get(person));
    }
    
    public static String conditional(VerbTag family, VerbPerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).conditional.get(person));
    }
    
    public static String imperative(VerbTag family, ImperativePerson person, String infinitive)
    {
        return resolve(family, infinitive, families.get(family).imperative.get(person));
    }

    private static String resolve(VerbTag family, String infinitive, String value)
    {
        if (value == null || (value = value.trim()).isEmpty())
        {
            return null;
        }
        else
        {
            return infinitive.substring(0, infinitive.length() - family.name().length()) + value;
        }
    }
    
    static
    {
        addFamily(VerbTag.ER, new Family())
            .gerund("ant")
            .participle("é")
            .present("e", "es", "e", "ons", "ez", "ent")
            .future("erai", "eras", "era", "erons", "erez", "erent")
            .imperfect("ais", "ais", "ait", "ions", "iez", "aient")
            .subjunctive("e", "es", "e", "ions", "iez", "ent")
            .conditional("erais", "erais", "erait", "erions", "eriez", "eraient")
            .imperative("e", "ons", "ez");
        addFamily(VerbTag.IR, new Family())
            .gerund("issant")
            .participle("i")
            .present("is", "is", "it", "issons", "issez", "issent")
            .future("irai", "iras", "ira", "irons", "irez", "irent")
            .imperfect("issais", "issais", "issait", "issions", "issiez", "issaient")
            .subjunctive("isse", "isses", "isse", "issions", "isseez", "issent")
            .conditional("irais", "irais", "irait", "irions", "iriez", "iraient")
            .imperative("is", "issons", "issez");
        addFamily(VerbTag.RE, new Family())
            .gerund("ant")
            .participle("u")
            .present("s", "s", "", "ons", "ez", "ent")
            .future("rai", "ras", "ra", "rons", "rez", "rent")
            .imperfect("ais", "ais", "ait", "ions", "iez", "aient")
            .subjunctive("e", "es", "e", "ions", "iez", "ent")
            .conditional("rais", "rais", "rait", "rions", "riez", "raient")
            .imperative("s", "ons", "ez");
    }
    
    private static Family addFamily(VerbTag tag, Family family)
    {
        families.put(tag, family);
        return family;
    }

    private static final class Family implements java.io.Serializable
    {
        private String gerund;
        
        private String participle;

        private final Map<VerbPerson, String> present = new EnumMap<>(VerbPerson.class);
        
        private final Map<VerbPerson, String> future = new EnumMap<>(VerbPerson.class);

        private final Map<VerbPerson, String> imperfect = new EnumMap<>(VerbPerson.class);

        private final Map<VerbPerson, String> subjunctive = new EnumMap<>(VerbPerson.class);

        private final Map<VerbPerson, String> conditional = new EnumMap<>(VerbPerson.class);

        private final Map<ImperativePerson, String> imperative = new EnumMap<>(ImperativePerson.class);

        private static final long serialVersionUID = 1L;
        
        public Family gerund(String gerund)
        {
            if ((this.gerund = gerund) == null)
                throw new NullPointerException("gerund");
            return this;
        }
        
        public Family participle(String participle)
        {
            if ((this.participle = participle) == null)
                throw new NullPointerException("participle");
            return this;
        }

        public Family present(String je, String tu, String il, String nous, String vous, String ils)
        {
            VerbPerson.populate(present, je, tu, il, nous, vous, ils);
            return this;
        }

        public Family future(String je, String tu, String il, String nous, String vous, String ils)
        {
            VerbPerson.populate(future, je, tu, il, nous, vous, ils);
            return this;
        }
    
        public Family imperfect(String je, String tu, String il, String nous, String vous, String ils)
        {
            VerbPerson.populate(imperfect, je, tu, il, nous, vous, ils);
            return this;
        }

        public Family subjunctive(String je, String tu, String il, String nous, String vous, String ils)
        {
            VerbPerson.populate(subjunctive, je, tu, il, nous, vous, ils);
            return this;
        }

        public Family conditional(String je, String tu, String il, String nous, String vous, String ils)
        {
            VerbPerson.populate(conditional, je, tu, il, nous, vous, ils);
            return this;
        }
    
        public Family imperative(String tu, String nous, String vous)
        {
            ImperativePerson.populate(imperative, tu, nous, vous);
            return this;
        }
    }
}