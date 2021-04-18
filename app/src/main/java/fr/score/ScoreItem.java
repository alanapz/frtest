package fr.score;

public interface ScoreItem extends java.io.Serializable
{
    public int attempts();
    
    public int correct();

    public long attemptTime();
    
    public long correctTime();
}