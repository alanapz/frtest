package fr;

public enum NounTag
{
    STARRED,
    PARTATIVE,
    CONTRACTED;
    
    public <T> T select(T starred, T partative, T contracted)
    {
        if (this == STARRED)
        {
            return starred;
        }
        else if (this == PARTATIVE)
        {
            return partative;
        }
        else if (this == CONTRACTED)
        {
            return contracted;
        }
        else
        {
            return null;
        }
    }
    
    @Override
    public String toString()
    {
        return select("*", "p", "c");
    }
}
