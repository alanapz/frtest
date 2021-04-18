package fr.dict;
import apz.fr.utils.Utils;
import fr.*;
import java.util.*;

/* package */ final class TextAdjective implements Adjective
{
    private final String il, elle, ils, elles;

    private final EnumSet<AdjectiveTag> tags;
    
    private final Set<TranslationImpl> translations = new HashSet<>();

    private static final long serialVersionUID = 1L;
    
    public TextAdjective(String il, String elle, String ils, String elles, EnumSet<AdjectiveTag> tags, String[] translations)
    {
        this(il, elle, ils, elles, tags, Arrays.asList(translations));
    }
    
    public TextAdjective(String il, String elle, String ils, String elles, EnumSet<AdjectiveTag> tags, Collection<String> translations)
    {
        if ((this.il = il) == null)
            throw new NullPointerException("il");
        if ((this.elle = elle) == null)
            throw new NullPointerException("elle");
        if ((this.ils = ils) == null)
            throw new NullPointerException("ils");
        if ((this.elles = elles) == null)
            throw new NullPointerException("elles");
        if (tags == null || (this.tags = EnumSet.copyOf(tags)) == null)
            throw new NullPointerException("tags for");
        if (translations == null || translations.isEmpty())
            throw new NullPointerException("translations");
        for(String translation: translations)
        {
            this.translations.add(new TranslationImpl(translation));
        }
    }
    
    @Override
    public String name()
    {
        return ils;
    }

    @Override
    public boolean isTag(AdjectiveTag tag)
    {
        return tags.contains(tag);
    }

    @Override
    public String lookup(Noun noun)
    {
        return noun.getGender().select(il, elle, ils, elles);
    }
    
    @Override
    public Set<? extends Translation> translations()
    {
        return translations;
    }
    
    @Override
    public String toString()
    {
        return il + "," + elle + "," + ils + "," + elles + Utils.toString(tags) + "=" + translations;
    }
    
    private final class TranslationImpl implements Translation
    {
        private final String translation;
        
        private static final long serialVersionUID = 1L;
        
        private TranslationImpl(String translation)
        {
            this.translation = translation;
        }
        
        @Override
        public Adjective adjective()
        {
            return TextAdjective.this;
        }

        @Override
        public String translation()
        {
            return translation;
        }
        
        @Override
        public String toString()
        {
            return translation;
        }
    }
}