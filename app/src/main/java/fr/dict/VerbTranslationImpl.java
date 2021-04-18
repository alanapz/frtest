package fr.dict;
import fr.*;

/* package */ final class VerbTranslationImpl implements VerbTranslation
{
    private final String infinitive, present1, present2456, present3, past123, past456, participle, gerund;
    
    private static final long serialVersionUID = 1L;
    
    /* package */ VerbTranslationImpl(String infinitive, String present1, String present2456, String present3, String past123, String past456, String participle, String gerund)
    {
        if ((this.infinitive = infinitive) == null)
            throw new NullPointerException("infinitive");
        if ((this.present1 = present1) == null)
            throw new NullPointerException("present1");
        if ((this.present2456 = present2456) == null)
            throw new NullPointerException("present2456");
        if ((this.present3 = present3) == null)
            throw new NullPointerException("present3");
        if ((this.past123 = past123) == null)
            throw new NullPointerException("past123");
        if ((this.past456 = past456) == null)
            throw new NullPointerException("past456");
        if ((this.participle = participle) == null)
            throw new NullPointerException("participle");
        if ((this.gerund = gerund) == null)
            throw new NullPointerException("gerund");
    }
    
    @Override
    public String infinitive()
    {
        return infinitive;
    }

    @Override
    public String gerund()
    {
        return gerund;
    }

    @Override
    public String participle()
    {
        return participle;
    }
    
    @Override
    public String present(VerbPerson person)
    {
        return person.select(present1, present2456, present3, present2456, present2456, present2456);
    }
    
    @Override
    public String past(VerbPerson person)
    {
        return person.select(past123, past123, past123, past456, past456, past456);
    }
    
    @Override
    public String toString()
    {
        return infinitive + ";present1=" + present1 + ";present2456=" + present2456 + ";present3=" + present3 + ";past123=" + past123 + ";past456=" + past456 +";participle=" + participle + ";gerund=" + gerund;
    }
}