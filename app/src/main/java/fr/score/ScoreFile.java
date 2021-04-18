package fr.score;
import apz.fr.utils.*;
import fr.*;
import fr.gen.*;
import java.io.*;
import java.util.*;
import static apz.fr.utils.Utils.*;
 
public final class ScoreFile implements Flushable
{
    private final File scoreFile;
    
    private final Map<String, Item> items = new TreeMap<>();
    
    /* package */ ScoreFile(String source)
    {
        if ((this.scoreFile = new File("scores/" + source + ".csv")).exists())
        {
            CSV2.importFromFile(scoreFile, (String[] input) -> items.put(input[0], new Item(input[1], input[2], input[3], input[4])));
        }
        int correct = 0, attempts = 0;
        for(Item item: items.values())
        {
            correct += item.correct;
            attempts += item.attempts;
        }
        System.out.println("correct: " + correct + ", attempts: " + attempts + ", av: " + (100D * correct / attempts));
    }
    
    public interface Mapper<T>
    {
        public String key(T obj);
        
        public default boolean weighted(T obj)
        {
            return false;
        }
    }

    public synchronized <T extends Question> List<T> map(List<T> source, SortingPolicy sortPolicy, int size)
    {
        return map(source, sortPolicy, size, new Mapper<T>()
        {
            @Override
            public String key(T obj)
            {
                return obj.getId();
            }
            
            @Override
            public boolean weighted(T obj)
            {
                return false;
            }
        });
    }
    
    public synchronized <T> List<T> map(List<T> source, final SortingPolicy sortPolicy, int size, final Mapper<? super T> mapper)
    {
        final List<T> buffer = shuffle(new ArrayList<>(source));
        // Remove all items previously attempted in last 50 days
        {
            final long cutoff = (System.currentTimeMillis() / 1000L) - (60L * 60 * 24 * 50);
            buffer.removeIf((item) -> apply(items.get(mapper.key(item)), false, (scoreItem) -> scoreItem.attemptTime() > cutoff));
        }
        // Now attempt to sort by policy and otem
        if (sortPolicy != null)
        {
            // Build a mapping of item => weight
            final Map<T, Double> itemWeights = new HashMap<>();
            Iterator<T> iterator = buffer.iterator();
            while(iterator.hasNext())
            {
                final T sourceItem = iterator.next();
                final ScoreItem scoreItem = items.get(mapper.key(sourceItem));
                // Unmapped items (items that are not in score file) are given a default weight of 0
                if (scoreItem == null)
                {
                    itemWeights.put(sourceItem, 0D);
                    continue;
                }
                // Items with MAX_VALUE are skipped
                double weight = sortPolicy.value(scoreItem);
                if (weight == Double.MAX_VALUE)
                {
                    iterator.remove();
                    continue;
                }
                // Mapped items have their weight halved
                if (mapper.weighted(sourceItem))
                {
                    weight /= 2;
                }
                itemWeights.put(sourceItem, weight);
            }
            Collections.sort(buffer, (T q1, T q2) -> Double.compare(itemWeights.get(q1), itemWeights.get(q2)));
        }
        
        int unmapped = 0;
        
        for(T object: buffer)
        {
            if (sortPolicy != null && apply(items.get(mapper.key(object)), 0D, (item) -> sortPolicy.value(item)) <= 0D)
            {
                unmapped++;
            }
        }
        if (unmapped > 0)
        {
            System.out.println(unmapped + " UNMAPPED");
        }
        
        System.out.println("scorefile: returning " + Math.min(size, buffer.size()) + " of " + buffer.size() + "/" + source.size() + " with " + unmapped + " unmapped");
        
        return buffer.subList(0, Math.min(size, buffer.size()));
    }
    
    public synchronized void update(Result result)
    {
        // Make sure we have no results in both categories.. :-\
        result.getCorrect().removeAll(result.getWrong());
        addResult(result, true);
        addResult(result, false);
    }
    
    private void addResult(Result result, boolean correct)
    {
        String questionId;
        for(Question question: correct ? result.getCorrect() : result.getWrong())
        {
            if ((questionId = question.getId()) != null)
            {
                Item item = items.get(questionId);
                if (item == null)
                {
                    items.put(questionId, (item = new Item()));
                }
                item.update(correct);
            }
        }
    }

    @Override
    public synchronized void flush()
    {
        CSV2.write(scoreFile, items.entrySet(), (row) ->
        {
            Item value = row.getValue();
            return new String[] {
                row.getKey(),
                value.attemptTime + "",
                value.correctTime + "",
                value.attempts + "",
                value.correct + ""};
        });
    }
    
    private static final class Item implements ScoreItem
    {
        private volatile long attemptTime, correctTime;
        
        private volatile int attempts, correct;
        
        private static final long serialVersionUID = 1L;
        
        private Item()
        {
            
        }
        
        private Item(String attemptTime, String correctTime, String attempts, String correct)
        {
            this.attemptTime = parseLong(attemptTime);
            this.correctTime = parseLong(correctTime);
            this.attempts = parseInt(attempts);
            this.correct = parseInt(correct);
        }

        @Override
        public int attempts()
        {
            return attempts;
        }

        @Override
        public int correct()
        {
            return correct;
        }

        @Override
        public long attemptTime()
        {
            return attemptTime;
        }

        @Override
        public long correctTime()
        {
            return correctTime;
        }

        public void update(boolean correct)
        {
            this.attempts++;
            this.attemptTime = (System.currentTimeMillis() / 1000L);
            if (correct)
            {
                this.correct++;
                this.correctTime = (System.currentTimeMillis() / 1000L);
            }
        }
    }
 }