package fr;

public interface Verb extends java.io.Serializable
{
    public String infinitive();

    public boolean isTag(VerbTag tag);

    public VerbTag family();

    public String auxiliary();

    public String gerund();

    public String participle(WordGender directObj);

    public String participle(VerbPerson person, VerbGender gender);
    
    public String present(VerbPerson person);

    public String subjunctive(VerbPerson person);

    public String imperfect(VerbPerson person);

    public String future(VerbPerson person);
    
    public String conditional(VerbPerson person);

    public String imperative(ImperativePerson person);
    
    public VerbTranslation translation(Wordlist wordlist);
    
    public interface Translation extends VerbTranslation
    {
        public Verb parent();
    }
}