package fr.score;
import apz.fr.utils.CSV2;
import fr.GameSelector.Item;
import java.io.Closeable;
import java.io.File;
import java.util.Map;

public class Profile //implements Closeable
{
    private final File profileFile = new File("profile.csv");
    
    private final Map<String, Integer> x = null;
    
//    public Profile()
//    {
//        CSV2.importFromFile(profileFile, new CSV2.Importer<Item>()
//        {
//            @Override
//            public Item read(String[] input)
//            {
//                return items.put(input[0], new Item(input[1], input[2], input[3]));
//            }
//        });
//    }
//        
//    public synchronized void flush()
//    {
//        CSV2.write(scoreFile, items.entrySet(), new CSV2.Exporter<Map.Entry<String, Item>>()
//        {
//            @Override
//            public String[] write(Map.Entry<String, Item> row)
//            {
//                Item value = row.getValue();
//                return new String[] {
//                    row.getKey(),
//                    value.timestamp + "",
//                    value.attempts + "",
//                    value.correct + ""};
//            }
//        });
//    }
}
