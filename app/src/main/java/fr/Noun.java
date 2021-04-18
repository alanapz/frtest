package fr;

public interface Noun
{
    public String getName();

    public String getTranslation();

    public boolean isTag(NounTag tag);
    
    public WordGender getGender();

    public boolean isPlural();

    public <T> T select(T MS, T FS, T plural);

    public <T> T select(T MS, T FS, T MP, T FP);
}
