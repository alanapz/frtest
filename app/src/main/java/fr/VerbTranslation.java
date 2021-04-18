package fr;

public interface VerbTranslation extends java.io.Serializable {

    String infinitive();
        
    String gerund();
        
    String participle();

    String present(VerbPerson person);
    
    String past(VerbPerson person);
}