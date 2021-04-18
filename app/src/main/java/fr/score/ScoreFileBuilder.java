package fr.score;
import fr.gen.*;
import java.io.*;
import java.util.*;

public final class ScoreFileBuilder implements Closeable {

    private final Map<FixedQuestionGenerator, ScoreFile> scores = new HashMap<>();
    
    public synchronized ScoreFile open(FixedQuestionGenerator source) {
        if (scores.containsKey(source)) {
            return scores.get(source);
        }
        final ScoreFile scoreFile = new ScoreFile(source.getResultsSource());
        scores.put(source, scoreFile);
        return scoreFile;
    }

    @Override
    public synchronized void close()
    {
        scores.values().forEach(ScoreFile::flush);
    }
}
