package fr.dict;
import apz.fr.utils.*;
import apz.utils.csv.*;
import fr.*;
import java.io.*;
import java.util.*;
import org.jdom.*;
import org.jdom.input.*;
import org.xml.sax.*;
import static apz.fr.utils.Utils.*;

public final class DictionaryBuilder
{
    private DictionaryBuilder()
    {
        
    }
    
    public static Wordlist buildWordlist() throws IOException
    {
        WordlistImpl wordlist = new WordlistImpl();
        for(Verb verb: new VerbCacheStore().retrieve())
        {
            wordlist.addVerb(verb);
        }
        for(NounEntry noun: CSV.importCSV(NounEntry.class, CharacterSet.LATIN_1, new FileInputStream("db/nouns.csv")))
        {
            try
            {
                noun.build(wordlist);
            }
            catch(ParseException e)
            {
                throw new IOException("Couldn't parse: " + noun, e);
            }
        }
        for(VerbTranslationEntry verb: CSV.importCSV(VerbTranslationEntry.class, CharacterSet.LATIN_1, new FileInputStream("db/verbs_en.csv")))
        {
            try
            {
                verb.build(wordlist);
            }
            catch(ParseException e)
            {
                throw new IOException("Couldn't parse: " + verb, e);
            }
        }
        for(AdjectiveEntry adjective: CSV.importCSV(AdjectiveEntry.class, CharacterSet.LATIN_1, new FileInputStream("db/adjectives.csv")))
        {
            try
            {
                adjective.build(wordlist);
            }
            catch(ParseException e)
            {
                throw new IOException("Couldn't parse: " + adjective, e);
            }
        }
        return wordlist;
    }
    
    private static final class VerbCacheStore extends CacheStore<Verb>
    {
        public VerbCacheStore()
        {
            super("verbs");
        }
        
        @Override
        public Set<Verb> parse(File file) throws IOException
        {
            final SAXBuilder xmlBuilder = new SAXBuilder();
            xmlBuilder.setReuseParser(true);
            xmlBuilder.setValidation(true);
            xmlBuilder.setEntityResolver((String publicId, String systemId) -> new InputSource(DictionaryBuilder.class.getResourceAsStream(systemId.substring(systemId.lastIndexOf('/')))));

            final Set<Verb> results = new HashSet<>();
            try(FileInputStream inputStream = new FileInputStream(file))
            {
                final Document document = xmlBuilder.build(inputStream);
                final String docType = document.getDocType().getSystemID();
                System.out.println("Parsing " + file.getAbsolutePath());
                if ("verbs.dtd".equals(docType))
                {
                    for(Element xml: XmlUtils.children(document.getRootElement().getChild("verbs"), "verb"))
                    {
                        results.addAll(VerbImpl.parse(file, xml));
                    }
                    return results;
                }
                else
                {
                    throw new IOException("Unexpected doctype: " + docType);
                }
            }
            catch(JDOMException e)
            {
                throw new IOException("Couldn't parse file: " + file, e);
            }
        }
    }
    
    public static final class NounEntry implements java.io.Serializable
    {
        public String frSingle;
        
        public String[] enSingle;
        
        public String frPlural;
        
        public String[] enPlural;
        
        @EnumMapping({
            @EnumValue(name = "m", value = "IL"),
            @EnumValue(name = "f", value = "ELLE")})
        public WordGender gender;
        
        public String flags;

        private static final long serialVersionUID = 1L;
        
        public void build(Wordlist out) throws ParseException
        {
            if (frSingle != null)
            {
                parseComponent(false, frSingle, enSingle, out);
            }
            if (frPlural != null)
            {
                parseComponent(true, frPlural, enPlural, out);
            }
        }

        @Override
        public String toString()
        {
            return "fr=" + frSingle + ";uk=" + Arrays.toString(enSingle) + ";fpl=" + frPlural + ";epl=" + Arrays.toString(enPlural) + ";gender=" + gender + ";flags=" + flags;
        }

        private void parseComponent(boolean isPlural, String fr, String[] en, Wordlist out) throws ParseException
        {
            if (fr == null)
                throw new ParseException("fr required for non-null en");
            if (en == null || en.length == 0)
                throw new ParseException("en required for non-null fr");
            final Set<NounTag> tags = EnumSet.noneOf(NounTag.class);
            if (startsWithVowel(fr) || fr.startsWith("h"))
            {
                tags.add(NounTag.CONTRACTED);
            }
            if (tags.contains(NounTag.PARTATIVE) && isPlural)
            {
                throw new ParseException("Cannot have uncountable plural noun");
            }
            populateFlags(str2chars(flags), tags);
            for(String enItem: en)
            {
                out.addNoun(new NounImpl(fr, enItem, select(isPlural, gender.toPlural(), gender), tags));
            }
        }

        private static Set<NounTag> populateFlags(Set<Character> flags, Set<NounTag> tags) throws ParseException
        {
            if (flags.remove('*'))
            {
                tags.add(NounTag.STARRED);
            }
            if (flags.remove('p'))
            {
                tags.add(NounTag.PARTATIVE);
            }
            if (flags.remove('a'))
            {
                tags.remove(NounTag.CONTRACTED);
            }
            if (!flags.isEmpty())
            {
                throw new ParseException("unsupported flags: " + flags);
            }
            return tags;
        }
    }
    
    public static final class VerbTranslationEntry implements java.io.Serializable
    {
        public String infinitive;
        
        public String present;
        
        public String past;
        
        public String participle;
        
        public String gerund;
        
        private static final String PIPE = quote("|");
        
        private static final long serialVersionUID = 1L;
        
        public void build(Wordlist out) throws ParseException
        {
            final String[] presents = present.split(PIPE);
            final String[] pasts = past.split(PIPE);
            out.addVerbTranslation(new VerbTranslationImpl(
                    infinitive,
                    presents.length == 3 ? presents[0] : infinitive,
                    presents.length == 3 ? presents[1] : infinitive,
                    presents.length == 3 ? presents[2] : presents[0],
                    pasts[0],
                    pasts.length == 2 ? pasts[1] : pasts[0],
                    participle,
                    gerund));
        }
    }    
    
    public static final class AdjectiveEntry implements java.io.Serializable
    {
        public String il;

        public String[] prefixesEn;
        
        public String[] suffixesEn;

        public String elle;
        
        public String ils;
        
        public String elles;
        
        public String adverbial;
        
        public String[] adverbsEn;

        public final Flags flags = new Flags();

        private static final long serialVersionUID = 1L;
        
        public void build(Wordlist out) throws ParseException
        {
            String lElle, lIls, lElles;
            if (il == null)
                throw new ParseException("il");
            if ((lElle = this.elle) == null)
            {
                lElle = il + "e";
            }
            if ((lIls = this.ils) == null)
            {
                lIls = il.endsWith("x") ? il : (il + "s");
            }
            if ((lElles = this.elles) == null)
            {
                lElles = lElle + "s";
            }
            if (prefixesEn != null)
            {
                out.addAdjective(new TextAdjective(il, lElle, lIls, lElles, add(flags.values(), AdjectiveTag.PREFIX), prefixesEn));
            }
            if (suffixesEn != null)
            {
                out.addAdjective(new TextAdjective(il, lElle, lIls, lElles, flags.flags, suffixesEn));
            }
            if (adverbial != null && adverbsEn != null && adverbsEn.length > 0)
            {
                out.addAdverb(new AdjectiveAdverbImpl(adverbial, Arrays.asList(adverbsEn)));
            }
        }
        
        public static final class Flags implements CustomField
        {
            private final EnumSet<AdjectiveTag> flags = EnumSet.noneOf(AdjectiveTag.class);

            private static final long serialVersionUID = 1L;

            @Override
            public void read(String value)
            {
                for(char c: value.toCharArray())
                {
                    if (c == '*')
                    {
                        flags.add(AdjectiveTag.STARRED);
                    }                
                }
            }
            
            public EnumSet<AdjectiveTag> values()
            {
                return EnumSet.copyOf(flags);
            }
        }
    }
}