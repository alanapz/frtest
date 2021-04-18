package fr.dict;
import fr.*;
import java.util.*;
import java.util.stream.*;

/* package */ final class AdjectiveAdverbImpl implements Adverb
{
    private final String name;

    private final Set<TranslationImpl> translations;

    private static final long serialVersionUID = 1L;
    
    public AdjectiveAdverbImpl(String name, Collection<String> translations)
    {
        if ((this.name = name) == null)
            throw new NullPointerException("name");
        if (translations == null || translations.isEmpty())
            throw new NullPointerException("translations");
        this.translations = translations.stream().map(translation -> new TranslationImpl(translation)).collect(Collectors.toSet());
    }
    
    @Override
    public String name()
    {
        return name;
    }

    @Override
    public Set<? extends Translation> translations()
    {
        return translations;
    }
    
    @Override
    public String toString()
    {
        return name + "=" + translations;
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
        public Adverb adverb()
        {
            return AdjectiveAdverbImpl.this;
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