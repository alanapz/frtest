package fr.gen;

/* package */ final class SubjunctiveExpressions extends MiscVocabulary.PhraseSource {

    public SubjunctiveExpressions(SentenceGenerator generator) {
        super(generator);
    }

    @Override
    protected void setup()
    {
        // IMPORTER
        {
            //add("Il importe qu'elle vienne", "It's important that she come");
            //add("Il importe de le faire", "It's important to do it");
        }


        // CROIR QUE
        {
        }

        // SE POUVOIR
        {
            // add("se pouvoir", "(v.) to be possible");
            //add("Il se peut qu'elles soient là", "It's possible that they(f) will be there");
            //add("Se peut-il que Luc finisse ?", "Is it possible that Luc will finish?");
        }

        // PENDANT QUE
        // http://french.about.com/od/grammar/qt/subjunctive_pendantque.htm
        {
            add("J'étudie pendant qu'il fait la cuisine", "I study while he does he cooking");
            add("Pendant que le soleil se levait, les oiseaux chantaient", "While the sun was rising, the birds were singing");
        }
    }
}