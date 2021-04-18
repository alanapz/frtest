package fr.dict;
import apz.fr.utils.*;
import fr.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import static apz.fr.utils.Utils.*;

/* package */ final class VerbImpl implements Verb, java.io.Serializable
{
    private final String infinitive, translation;

    private final VerbTag family;

    private final String gerund;

    private final String participle;

    private final String[] present = new String[VerbPerson.values().length];

    private final String[] future = new String[present.length];

    private final String[] imperfect = new String[present.length];

    private final String[] subjunctive = new String[present.length];

    private final String[] conditional = new String[present.length];

    private final String[] imperative = new String[ImperativePerson.values().length];

    private final Set<VerbTag> tags = EnumSet.noneOf(VerbTag.class);

    private static final long serialVersionUID = 1L;
    
    private static final List<String> templateVerbs = Arrays.asList(
            "abolir",
            "acheter",
            "agir",
            "aimer",
            "ajouter",
            "appeler",
            "arrêter",
            "attendre",
            "avertir",
            "bénir",
            "choisir",
            "conduire",
            "connaitre",
            "courir",
            "débrouiller",
            "descendre",
            "déshabiller",
            "devoir",
            "dire",
            "dormir",
            "faire",
            "falloir",  
            "finir",
            "grossir",
            "grandir",
            "lire",
            "mettre",
            "monter",
            "nager",
            "naitre",
            "oublier",
            "prendre",
            "penser",
            "perdre",
            "pouvoir",
            "prévenir",
            "punir",
            "rappeler",
            "réfléchir",
            "reprendre",
            "transmettre",
            "venir",
            "voir");
    
    private static final Map<VerbPerson, String> personMappings = new HashMap<VerbPerson, String>()
    {
        private static final long serialVersionUID = 1L;
        {
            put(VerbPerson.JE, "je");
            put(VerbPerson.TU, "tu");
            put(VerbPerson.IL, "il");
            put(VerbPerson.NOUS, "nous");
            put(VerbPerson.VOUS, "vous");
            put(VerbPerson.ILS, "ils");
        }
    };

    private static final Map<ImperativePerson, String> imperativeMappings = new HashMap<ImperativePerson, String>()
    {
        private static final long serialVersionUID = 1L;
        {
            put(ImperativePerson.TU, "tu");
            put(ImperativePerson.NOUS, "nous");
            put(ImperativePerson.VOUS, "vous");
        }
    };
    
    private VerbImpl(String infinitive, String translation, boolean pronominal, Element xml) throws IOException
    {
        if ((this.infinitive = infinitive) == null)
        {
            throw new NullPointerException("infinitive");
        }
        if ((this.translation = translation) == null)
        {
            throw new NullPointerException("translation");
        }
        if ((this.family = parseFamily(infinitive)) != null)
        {
            tags.add(family);
        }
        if (pronominal)
        {
            tags.add(VerbTag.PRONOMINAL);
        }
        if (xml.getChild("transitive") != null)
        {
            tags.add(VerbTag.TRANSITIVE);
        }
        if (pronominal || xml.getChild("takesEtreInPerfect") != null)
        {
            tags.add(VerbTag.ETRE);
        }
        this.gerund = select(xml.getChildTextTrim("presentParticiple"), () -> VerbConjugations.gerund(family, infinitive));
        this.participle = select(xml.getChildTextTrim("pastParticiple"), () -> VerbConjugations.participle(family, infinitive));
        for(Map.Entry<VerbPerson, String> entry: personMappings.entrySet())
        {
            final int ordinal = entry.getKey().ordinal();
            present[ordinal] = select(XmlUtils.getChildText(xml, "present", entry.getValue()), () -> VerbConjugations.present(family, entry.getKey(), infinitive));
            future[ordinal] = select(XmlUtils.getChildText(xml, "future", entry.getValue()), () -> VerbConjugations.future(family, entry.getKey(), infinitive));
            imperfect[ordinal] = select(XmlUtils.getChildText(xml, "imperfect", entry.getValue()), () -> VerbConjugations.imperfect(family, entry.getKey(), infinitive));
            subjunctive[ordinal] = select(XmlUtils.getChildText(xml, "subjunctive", entry.getValue()), () -> VerbConjugations.subjunctive(family, entry.getKey(), infinitive));
            conditional[ordinal] = select(XmlUtils.getChildText(xml, "conditional", entry.getValue()), () -> VerbConjugations.conditional(family, entry.getKey(), infinitive));
        }
        for(Map.Entry<ImperativePerson, String> entry: imperativeMappings.entrySet())
        {
            imperative[entry.getKey().ordinal()] = select(XmlUtils.getChildText(xml, "imperative", entry.getValue()), () -> VerbConjugations.imperative(family, entry.getKey(), infinitive));
        }
        if (templateVerbs.contains(infinitive))
        {
            tags.add(VerbTag.TEMPLATE);
        }
    }
    
    @Override
    public String infinitive()
    {
        return infinitive;
    }

    @Override
    public boolean isTag(VerbTag tag)
    {
        return tag != null && tags.contains(tag);
    }

    @Override
    public VerbTag family()
    {
        return family;
    }

    @Override
    public String auxiliary()
    {
        return tags.contains(VerbTag.ETRE) ? "être" : "avoir";
    }

    @Override
    public String gerund()
    {
        return gerund;
    }
    
    @Override
    public String participle(WordGender directObj)
    {
        String result = participle;
        if (directObj != null)
        {
            result += directObj.select("", "e", participle.endsWith("s") ? "" : "s", "es");
        }
        return result;
    }

    @Override
    public String participle(VerbPerson person, VerbGender gender)
    {
        if (!tags.contains(VerbTag.ETRE))
        {
            return participle;
        }
        String result = participle;
        if (gender == VerbGender.ELLE)
        {
            result += "e";
        }
        if (Arrays.asList(VerbPerson.NOUS, VerbPerson.VOUS, VerbPerson.ILS).contains(person))
        {
            result += "s";
        }
        return result;
    }
    
    @Override
    public String present(VerbPerson person)
    {
        return present[person.ordinal()];
    }

    @Override
    public String future(VerbPerson person)
    {
        return future[person.ordinal()];
    }

    @Override
    public String imperfect(VerbPerson person)
    {
        return imperfect[person.ordinal()];
    }

    @Override
    public String subjunctive(VerbPerson person)
    {
        return subjunctive[person.ordinal()];
    }

    @Override
    public String conditional(VerbPerson person)
    {
        return conditional[person.ordinal()];
    }

    @Override
    public String imperative(ImperativePerson person)
    {
        return imperative[person.ordinal()];
    }

    @Override
    public Translation translation(Wordlist wordlist)
    {
        final VerbTranslation verb = wordlist.lookupVerbTranslation(this.translation);
        if (verb == null)
        {
            throw new NullPointerException("no translation for: " + translation);
        }
        return new Translation()
        {
            private static final long serialVersionUID = 1L;
            
            @Override
            public Verb parent()
            {
                return VerbImpl.this;
            }
            
            @Override
            public String infinitive()
            {
                return verb.infinitive();
            }

            @Override
            public String gerund()
            {
                return verb.gerund();
            }

            @Override
            public String participle()
            {
                return verb.participle();
            }

            @Override
            public String present(VerbPerson person)
            {
                return verb.present(person);
            }

            @Override
            public String past(VerbPerson person)
            {
                return verb.past(person);
            }

            @Override
            public String toString()
            {
                return verb.toString();
            }
        };
    }

    private static VerbTag parseFamily(String infinitive)
    {
        if (infinitive.endsWith("er"))
        {
            return VerbTag.ER;
        }
        else if (infinitive.endsWith("ir"))
        {
            return VerbTag.IR;
        }
        else if (infinitive.endsWith("re"))
        {
            return VerbTag.RE;
        }
        else
        {
            return null;
        }
    }
    
    private static String lookupConjugation(Element xml, String type, VerbPerson person)
    {
        String value = xml.getChild("present").getChildTextTrim(personMappings.get(person));
        if (value == null)
        {
            throw new RuntimeException("null");
        }
        if ((value = value.trim()).isEmpty())
        {
            throw new RuntimeException("empty");
        }
        return value;
    }
    
    public static List<VerbImpl> parse(File file, final Element xml) throws IOException
    {
        String infinitive = xml.getChildTextNormalize("infinitive");
        if (infinitive == null || (infinitive = infinitive.trim()).isEmpty())
        {
            throw new IOException("Couldn't parse infinitive for: " + file);
        }
        // Make sure we don't have any reflexive prefixes
        if (infinitive.startsWith("se ") || infinitive.startsWith("s'"))
        {
            throw new IOException("Couldn't parse infinitive for: " + file);
        }
//        final String seInfinitive = select(!startsWithVowel(infinitive) || xml.getChild("hAspire") != null,
//                "se " + infinitive,
//                "s'" + infinitive);
        final List<VerbImpl> out = new ArrayList<>();
        // First parse non-reflexive usages
        {
            final Set<String> translations = parseTranslations(xml);
            if (translations.isEmpty())
            {
                System.out.println("WARNING: " + infinitive + " has no non-reflexive usage");
            }
            // Next add transitive usages (if any)
            if (xml.getChild("transitive") != null && xml.getChild("pronominal") == null)
            {
                for(String translation: translations)
                {
                    out.add(new VerbImpl(infinitive, translation, true, xml));
                }
            }
            /// XXX: At the moment, assume transitive verbs can only be used reflexively
            /// This is not true (for example casser) but we would need to change verb generators to accept object
            //XXX: FIXME: 
            {
                for(String translation: translations)
                {
                    // out.add(new VerbImpl(infinitive, translation, xml.getChild("transitive") != null, xml));
                    out.add(new VerbImpl(infinitive, translation, false, xml));
                }
            }
        }
        // Finally, reflexive usages
        if (xml.getChild("pronominal") != null)
        {
            for(String translation: parseTranslations(xml.getChild("pronominal")))
            {
                out.add(new VerbImpl(infinitive, translation, true, xml));
            }
        }
        return out;
    }
    
    private static Set<String> parseTranslations(Element xml)
    {
        final Set<String> out = new HashSet<>();
        for(Element current: XmlUtils.children(xml, "translation"))
        {
            String translation = current.getText().trim().toLowerCase();
            // Remove English 'to' if present
            if (translation.startsWith("to "))
            {
                translation = translation.substring("to ".length());
            }
            out.add(translation);
        }
        return out;
    }
}