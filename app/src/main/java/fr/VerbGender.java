package fr;

public enum VerbGender
{
    IL,
    ELLE;
    
    public <T> T select(T il, T elle)
    {
        if (this == IL)
        {
            return il;
        }
        else if (this == ELLE)
        {
            return elle;
        }
        else
        {
            return null;
        }
    }
}