package fr.dict;
import fr.*;

/* package */ final class CompoundVerbTranslation implements VerbTranslation
{
    private final VerbTranslation parent;
    
    private final String suffix;
    
    private static final long serialVersionUID = 1L;
    
    /* package */ CompoundVerbTranslation(VerbTranslation parent, String suffix)
    {
        if ((this.parent = parent) == null)
            throw new NullPointerException("parent");
        if ((this.suffix = suffix) == null)
            throw new NullPointerException("suffix");
   }
    
    @Override
    public String infinitive()
    {
        return parent.infinitive() + " " + suffix;
    }

    @Override
    public String gerund()
    {
        return parent.gerund() + " " + suffix;
    }

    @Override
    public String participle()
    {
        return parent.participle() + " " + suffix;
    }
    
    @Override
    public String present(VerbPerson person)
    {
        return parent.present(person) + " " + suffix;
    }
    
    @Override
    public String past(VerbPerson person)
    {
        return parent.past(person) + " " + suffix;
    }
    
    @Override
    public String toString()
    {
        return parent.toString() + ";suffix=" + suffix;
    }
}