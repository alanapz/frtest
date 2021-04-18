package fr.gen.phrases;
import fr.gen.*;
import fr.score.*;
import java.util.*;

public final class Phrases
{
    private Phrases()
    {
        
    }
    
    public static void go(ScoreFileBuilder scores, SortingPolicy sortPolicy, List<SentenceQuestion> items)
    {
        new AdditionalPhrases(scores, sortPolicy).append(items);
        new AmeliorerSonFrancaisPhrases(scores, sortPolicy).append(items);
        new BertrandBoutinPhrases(scores, sortPolicy).append(items);
        new EdExcelFrenchPhrases(scores, sortPolicy).append(items);
        new FrancaisFacilePhrases(scores, sortPolicy).append(items);
        new FrenchAboutComPhrases(scores, sortPolicy).append(items);
        new FrenchForDummiesPhrases(scores, sortPolicy).append(items);
        new GceLevelFrenchPhrases(scores, sortPolicy).append(items);
        new ImproveYourFrenchPhrases(scores, sortPolicy).append(items);
        new LeNouvelObservateurPhrases(scores, sortPolicy).append(items);
        //items.addAll(new PhrasesVocabulary(scores, sortPolicy).items);
        new RealFrenchGrammer(scores, sortPolicy).append(items);
        new RosettaStonePhrases(scores, sortPolicy).append(items);
    }
}