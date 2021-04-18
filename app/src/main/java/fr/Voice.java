package fr;

public enum Voice
{
    JE      (1),
    TU      (2),
    IL      (3),
    ELLE    (3),
    ON      (3),
    NOUS    (4),
    VOUS    (5),
    ILS     (6),
    ELLES   (6);

    public final int person;
    
    private Voice(int person)
    {
        this.person = person;
    }
    
    public <T> T select(T je, T tu, T il, T elle, T on, T nous, T vous, T ils, T elles)
    {
        if (this == JE)
        {
            return je;
        }
        else if (this == TU)
        {
            return tu;
        }
        else if (this == IL)
        {
            return il;
        }
        else if (this == ELLE)
        {
            return elle;
        }
        else if (this == ON)
        {
            return on;
        }
        else if (this == NOUS)
        {
            return nous;
        }
        else if (this == VOUS)
        {
            return vous;
        }
        else if (this == ILS)
        {
            return ils;
        }
        else if (this == ELLES)
        {
            return elles;
        }
        else
        {
            return null;
        }
    }        
}