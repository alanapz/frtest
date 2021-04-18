package fr;

public enum WordGender
{
    IL,
    ELLE,
    ILS,
    ELLES;
    
    public <T> T select(T MS, T FS, T MP, T FP)
    {
        if (this == IL)
        {
            return MS;
        }
        else if (this == ELLE)
        {
            return FS;
        }
        else if (this == ILS)
        {
            return MP;
        }
        else if (this == ELLES)
        {
            return FP;
        }
        else
        {
            return null;
        }
    }
    
    public WordGender toSingular()
    {
        return select(WordGender.IL, WordGender.ELLE, WordGender.IL, WordGender.ELLE);
    }

    public WordGender toPlural()
    {
        return select(WordGender.ILS, WordGender.ELLES, WordGender.ILS, WordGender.ELLES);
    }
}    
