package fr;

public enum AdjectiveTag
{
    STARRED,
    PREFIX;
    
    public <T> T select(T starred, T prefix) {
        if (this == STARRED) {
            return starred;
        }
        else if (this == PREFIX) {
            return prefix;
        }
        else {
            return null;
        }
    }
    
    @Override
    public String toString()
    {
        return select("*", "&");
    }
}
