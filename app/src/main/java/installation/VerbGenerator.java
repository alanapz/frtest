package installation;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VerbGenerator
{
    private static final Map<String, String> entityMappings = new HashMap<>();

    private static final Map<String, String> urlMappings = new HashMap<>();
    
    private static final Collection<String> ignored = Arrays.asList("preferer", "amenager", "photographier", "boiter", "enclore", "advenir", "payer", "dissoudre", "zezayer");
    
    private VerbGenerator()
    {
    }

    public static void main(String[] args) throws Exception
    {
        List<String> infinitives = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader("verbs.txt")))
        {
            String current;
            while((current = reader.readLine()) != null)
            {
                infinitives.add(current);
            }
        }
        System.out.println(infinitives.size() + " remaining");
        for(String infinitive: new ArrayList<>(infinitives))
        {
            if (ignored.contains(infinitive))
            {
                continue;
            }
            try
            {
                buildVerb(infinitive, infinitives.size());
                infinitives.remove(infinitive);
                saveStatus(infinitives);
            }
            catch(IllegalArgumentException e)
            {
                // Ignore
                //throw e;
                e.printStackTrace();
            }
        }
    }
    
    private static void saveStatus(Collection<String> list) throws IOException
    {
        try(FileWriter writer = new FileWriter("verbs.txt"))
        {
            for(String entry: list)
            {
                writer.write(entry);
                writer.write("\r\n");
            }
        }
    }
    
    public static void buildVerb(final String infinitive, int index) throws IOException
    {
        String URL;
        
        HttpURLConnection conn = (HttpURLConnection) new URL(URL = buildUrl(infinitive)).openConnection();
        StringBuilder buffer = new StringBuilder();
        int i;
        while((i = conn.getInputStream().read()) != -1)
        {
            buffer.append((char) i);
        }
        conn.disconnect();

        String value = buffer.toString();
        value = value.replace("&#8212;", " ");
        value = value.replace("&#160;", " ");
        value = value.replace("&nbsp;", " ");
        for(Map.Entry<String, String> entityMapping: entityMappings.entrySet())
        {
            value = value.replace(entityMapping.getKey(), entityMapping.getValue());
        }
        if (value.contains("&#"))
        {
            System.out.println(value);
            System.out.println("UNESCAPED VALUE");
            System.exit(0);
        }
        
        Pattern start = Pattern.compile("(?si).*<h1><span class=\"fn\">(?<infinitive>.*) - (?<translation>.*)</span></h1>.*");
        Matcher matcher = start.matcher(value);
        if (!matcher.matches())
        {
            throw new IllegalArgumentException("No match!");
        }
        System.out.println(index + ": " + URL);
        Pattern row1 = Pattern.compile("(?si).*Present</a></b>\\s*</td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td>\\s*<b><a href=\".*?\">Future</a></b>\\s*</td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td>\\s*<b><a href=\".*?\">Imperfect</a></b>\\s*</td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td colspan=2>\\s*<b><a href=\".*?\">Present participle</a></b>\\s*</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:je|j'|je me|je / j'|je \\(j'\\))</td>\\s*<td><b>(?<present1>.*?)</b>\\s*</td>\\s*<td><b>(?<future1>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect1>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<presentparticiple>.*?)</b>\\s*</?td*>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:tu|tu te)</td>\\s*<td><b>(?<present2>.*?)</b>\\s*</td>\\s*<td><b>(?<future2>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect2>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:il|il se)</td>\\s*<td><b>(?<present3>.*?)</b>\\s*</td>\\s*<td><b>(?<future3>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect3>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b><a href=\".*\">Passé composé</a></b>\\s*</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:nous|nous nous)</td>\\s*<td>\\s*<b>(?<present4>.*?)</b>\\s*</td>\\s*<td><b>(?<future4>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect4>.*?)</b>\\s*</td>\\s*<td(?: colspan=\\d)?>\\s*<a href=\".*\">Auxiliary verb</a>\\s*</td>\\s*<td><b><a href=\".*\">(?<auxillary>.*?)</a></b>\\s*</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:vous|vous vous)</td>\\s*<td>\\s*<b>(?<present5>.*?)</b>\\s*</td>\\s*<td><b>(?<future5>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect5>.*?)</b>\\s*</td>\\s*<td(?: colspan=\\d)?>\\s*<a href=\".*\">Past participle</a>\\s*</td>\\s*<td>\\s*<b>(?<pastparticiple>.*?)</b>.*?</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:ils|ils se)</td>\\s*<td>\\s*<b>(?<present6>.*?)</b>\\s*</td>\\s*<td><b>(?<future6>.*?)</b>\\s*</td>\\s*<td><b>(?<imperfect6>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*</td>\\s*</tr>"+
                ".*Subjunctive.*");
        Matcher row1M = row1.matcher(value);
        if (!row1M.matches())
        {
            System.out.println(value);
            throw new IllegalArgumentException("No match! (row 1)");
        }
        
        
        
        Pattern row2 = Pattern.compile("(?si).*Subjunctive</a></b></td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td><b><a href=\".*?\">Conditional</a></b></td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td><b><a href=\".*?\">Passé simple</a></b></td>\\s*" +
                "(?:<td rowspan=7>\\s*</td>\\s*)?<td colspan=2>\\s*<b>\\s*<a href=\".*?\">Imperfect subjunctive</a>\\s*</b>\\s*</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:je|j'|je me)</td>\\s*<td>\\s*<b>(?<subjunctive1>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional1>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple1>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj1>.*?)</b>\\s*</?td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:tu|tu te)</td>\\s*<td>\\s*<b>(?<subjunctive2>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional2>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple2>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj2>.*?)</b>\\s*(?:</?td>)?\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:il|ils se)</td>\\s*<td>\\s*<b>(?<subjunctive3>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional3>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple3>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj3>.*?)</b>\\s*</?td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:nous|nous nous)</td>\\s*<td>\\s*<b>(?<subjunctive4>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional4>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple4>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj4>.*?)</b>\\s*</?td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:vous|vous vous)</td>\\s*<td>\\s*<b>(?<subjunctive5>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional5>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple5>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj5>.*?)</b>\\s*</?td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>(?:ils|ils se)</td>\\s*<td>\\s*<b>(?<subjunctive6>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<conditional6>.*?)</b>\\s*</td>\\s*<td>\\s*<b>(?<simple6>.*?)</b>\\s*</td>\\s*<td colspan=2>\\s*<b>(?<impsubj6>.*?)</b>\\s*</?td>\\s*</tr>\\s*"+
                ".*?Imperative.*");
        Matcher row2M = row2.matcher(value);
        if (!row2M.matches())
        {
            System.out.println(row2M);
            System.out.println(value);
            throw new IllegalArgumentException("No match! (row 2)");
        }
        Pattern row3 = Pattern.compile("(?si).*Imperative</a></b></td>\\s*(?:<td colspan=7>\\s*</td>)?\\s*</tr>\\s*" +
                "<tr>\\s*<td>\\s*\\(tu\\)\\s*</td>\\s*(?:<td>|<td colspan=4>)\\s*<b>(?<imperative1>.*?)</b>\\s*</td>\\s*(?:<td>\\s*</td>|<td colspan=3>\\s*</td>)?\\s*<td colspan=\\d rowspan=\\d>(?<pattern>.*?)</td>\\s*</tr>\\s*" +
                "<tr>\\s*<td>\\s*\\(nous\\)\\s*</td>\\s*(?:<td>|<td colspan=4>)\\s*<b>(?<imperative2>.*?)</b>\\s*</td>\\s*(?:(?:<td>|<td colspan=7>)?</td>)?\\s*</tr>\\s*" +
                "<tr>\\s*<td>\\s*\\(vous\\)\\s*</td>\\s*(?:<td>|<td colspan=4>)\\s*<b>(?<imperative3>.*?)</b>\\s*</td>\\s*(?:<td>|<td colspan=7>)?(?:</td>)?\\s*</tr>\\s*" +
                ".*?\\Q<!--/gc-->\\E.*");
        Matcher row3M = row3.matcher(value);
        
        if (!row3M.matches())
        {
            row3 = Pattern.compile("(?si).*Imperative</a></b></td></tr>\\s*" +
                "<tr><td></td><td><b>n/a</b></td><td></td>\\s*" +
                "<td colspan=6 rowspan=3>(?<pattern>.*?)</td>\\s*" +
                ".*?</table>\\Q<!--/gc-->\\E.*");
            row3M = row3.matcher(value);
            if (!row3M.matches())
            {
                System.out.println(row3M);
                System.out.println(value);
                throw new IllegalArgumentException("No match! (row 3)");
            }
        }

        
        System.out.println("Auxillary:\t" + getGroup(row1M, "auxillary"));
        
        System.out.println("\nPresent participle:\t" + getGroup(row1M, "presentparticiple"));
        System.out.println("Past participle:\t" + getGroup(row1M, "pastparticiple"));
        
        System.out.println("\nPresent 1:\t" + getGroup(row1M, "present1"));
        System.out.println("Present 2:\t" + getGroup(row1M, "present2"));
        System.out.println("Present 3:\t" + getGroup(row1M, "present3"));
        System.out.println("Present 4:\t" + getGroup(row1M, "present4"));
        System.out.println("Present 5:\t" + getGroup(row1M, "present5"));
        System.out.println("Present 6:\t" + getGroup(row1M, "present6"));
        
        System.out.println("\nFuture 1:\t" + getGroup(row1M, "future1"));
        System.out.println("Future 2:\t" + getGroup(row1M, "future2"));
        System.out.println("Future 3:\t" + getGroup(row1M, "future3"));
        System.out.println("Future 4:\t" + getGroup(row1M, "future4"));
        System.out.println("Future 5:\t" + getGroup(row1M, "future5"));
        System.out.println("Future 6:\t" + getGroup(row1M, "future6"));

        System.out.println("\nImperfect 1:\t" + getGroup(row1M, "imperfect1"));
        System.out.println("Imperfect 2:\t" + getGroup(row1M, "imperfect2"));
        System.out.println("Imperfect 3:\t" + getGroup(row1M, "imperfect3"));
        System.out.println("Imperfect 4:\t" + getGroup(row1M, "imperfect4"));
        System.out.println("Imperfect 5:\t" + getGroup(row1M, "imperfect5"));
        System.out.println("Imperfect 6:\t" + getGroup(row1M, "imperfect6"));
        
        System.out.println("\nSubjunctive 1:\t" + getGroup(row2M, "subjunctive1"));
        System.out.println("Subjunctive 2:\t" + getGroup(row2M, "subjunctive2"));
        System.out.println("Subjunctive 3:\t" + getGroup(row2M, "subjunctive3"));
        System.out.println("Subjunctive 4:\t" + getGroup(row2M, "subjunctive4"));
        System.out.println("Subjunctive 5:\t" + getGroup(row2M, "subjunctive5"));
        System.out.println("Subjunctive 6:\t" + getGroup(row2M, "subjunctive6"));
        
        System.out.println("\nConditional 1:\t" + getGroup(row2M, "conditional1"));
        System.out.println("Conditional 2:\t" + getGroup(row2M, "conditional2"));
        System.out.println("Conditional 3:\t" + getGroup(row2M, "conditional3"));
        System.out.println("Conditional 4:\t" + getGroup(row2M, "conditional4"));
        System.out.println("Conditional 5:\t" + getGroup(row2M, "conditional5"));
        System.out.println("Conditional 6:\t" + getGroup(row2M, "conditional6"));
        
        System.out.println("\nSimple 1:\t" + getGroup(row2M, "simple1"));
        System.out.println("Simple 2:\t" + getGroup(row2M, "simple2"));
        System.out.println("Simple 3:\t" + getGroup(row2M, "simple3"));
        System.out.println("Simple 4:\t" + getGroup(row2M, "simple4"));
        System.out.println("Simple 5:\t" + getGroup(row2M, "simple5"));
        System.out.println("Simple 6:\t" + getGroup(row2M, "simple6"));
        
        System.out.println("\nImpsub 1:\t" + getGroup(row2M, "impsubj1"));
        System.out.println("Impsub 2:\t" + getGroup(row2M, "impsubj2"));
        System.out.println("Impsub 3:\t" + getGroup(row2M, "impsubj3"));
        System.out.println("Impsub 4:\t" + getGroup(row2M, "impsubj4"));
        System.out.println("Impsub 5:\t" + getGroup(row2M, "impsubj5"));
        System.out.println("Impsub 6:\t" + getGroup(row2M, "impsubj6"));

        System.out.println("\nImperative 1:\t" + getGroup(row3M, "imperative1"));
        System.out.println("Imperative 2:\t" + getGroup(row3M, "imperative2"));
        System.out.println("Imperative 3:\t" + getGroup(row3M, "imperative3"));
        
        System.out.println("Pattern:\t" + getGroup(row3M, "pattern"));
        
        new File("db/verbs").mkdirs();
        try(FileWriter writer = new FileWriter("db/verbs/" + matcher.group("infinitive") + ".xml"))
        {
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n");
            writer.write("<!DOCTYPE dictionary SYSTEM \"verbs.dtd\">\r\n");
            writer.write("<dictionary>\r\n<verbs>\r\n<verb>\r\n");
            writer.write("\t<infinitive>" + matcher.group("infinitive").toLowerCase() + "</infinitive>\r\n");
            for(String translation: matcher.group("translation").split("[,;]"))
            {
                writer.write("\t<translation>" + translation.trim() + "</translation>\r\n");
            }
            String pattern = row3M.group("pattern");
            if (pattern.contains("common"))
            {
                writer.write("\t<important />\r\n");
            }
            if (pattern.contains("irregular"))
            {
                writer.write("\t<irregular />\r\n");
            }
            else if (pattern.contains("spelling change"))
            {
                writer.write("\t<spellingChange />\r\n");
            }
            else if (pattern.contains("stem-changing"))
            {
                writer.write("\t<stemChange />\r\n");
            }
            else if (!pattern.contains("regular"))
            {
                throw new IllegalArgumentException("Verb is neither regular not irregular: " + pattern);
            }
            String auxillary = row1M.group("auxillary");
            if (auxillary.equals("être"))
            {
                writer.write("\t<takesEtreInPerfect />\r\n");
            }
            else if (!auxillary.equals("avoir"))
            {
                throw new IllegalArgumentException("Verb takes neither être nor avoir: " + pattern);
            }
            writer.write("\t<presentParticiple>" + row1M.group("presentparticiple") + "</presentParticiple>\r\n");
            writer.write("\t<pastParticiple>" + row1M.group("pastparticiple") + "</pastParticiple>\r\n");
            writer.write("\t<present>\r\n");
            writer.write("\t\t<je>" + lookup(row1M, "present1", false) + "</je>\r\n");
            writer.write("\t\t<tu>" + lookup(row1M, "present2", false) + "</tu>\r\n");
            writer.write("\t\t<il>" + row1M.group("present3").trim() + "</il>\r\n");
            writer.write("\t\t<nous>" + row1M.group("present4").trim() + "</nous>\r\n");
            writer.write("\t\t<vous>" + row1M.group("present5").trim() + "</vous>\r\n");
            writer.write("\t\t<ils>" + row1M.group("present6").trim() + "</ils>\r\n");
            writer.write("\t</present>\r\n");
            writer.write("\t<imperative>\r\n");
            writer.write("\t\t<tu>" + lookup(row3M, "imperative1", true) + "</tu>\r\n");
            writer.write("\t\t<nous>" + lookup(row3M, "imperative2", true) + "</nous>\r\n");
            writer.write("\t\t<vous>" + lookup(row3M, "imperative3", true) + "</vous>\r\n");
            writer.write("\t</imperative>\r\n");
            writer.write("\t<imperfect>\r\n");
            writer.write("\t\t<je>" + row1M.group("imperfect1").trim() + "</je>\r\n");
            writer.write("\t\t<tu>" + row1M.group("imperfect2").trim() + "</tu>\r\n");
            writer.write("\t\t<il>" + row1M.group("imperfect3").trim() + "</il>\r\n");
            writer.write("\t\t<nous>" + row1M.group("imperfect4").trim() + "</nous>\r\n");
            writer.write("\t\t<vous>" + row1M.group("imperfect5").trim() + "</vous>\r\n");
            writer.write("\t\t<ils>" + row1M.group("imperfect6").trim() + "</ils>\r\n");
            writer.write("\t</imperfect>\r\n");
            writer.write("\t<future>\r\n");
            writer.write("\t\t<je>" + row1M.group("future1").trim() + "</je>\r\n");
            writer.write("\t\t<tu>" + row1M.group("future2").trim() + "</tu>\r\n");
            writer.write("\t\t<il>" + row1M.group("future3").trim() + "</il>\r\n");
            writer.write("\t\t<nous>" + row1M.group("future4").trim() + "</nous>\r\n");
            writer.write("\t\t<vous>" + row1M.group("future5").trim() + "</vous>\r\n");
            writer.write("\t\t<ils>" + row1M.group("future6").trim() + "</ils>\r\n");
            writer.write("\t</future>\r\n");
            writer.write("\t<subjunctive>\r\n");
            writer.write("\t\t<je>" + row2M.group("subjunctive1").trim() + "</je>\r\n");
            writer.write("\t\t<tu>" + row2M.group("subjunctive2").trim() + "</tu>\r\n");
            writer.write("\t\t<il>" + row2M.group("subjunctive3").trim() + "</il>\r\n");
            writer.write("\t\t<nous>" + row2M.group("subjunctive4").trim() + "</nous>\r\n");
            writer.write("\t\t<vous>" + row2M.group("subjunctive5").trim() + "</vous>\r\n");
            writer.write("\t\t<ils>" + row2M.group("subjunctive6").trim() + "</ils>\r\n");
            writer.write("\t</subjunctive>\r\n");
            writer.write("\t<conditional>\r\n");
            writer.write("\t\t<je>" + row2M.group("conditional1").trim() + "</je>\r\n");
            writer.write("\t\t<tu>" + row2M.group("conditional2").trim() + "</tu>\r\n");
            writer.write("\t\t<il>" + row2M.group("conditional3").trim() + "</il>\r\n");
            writer.write("\t\t<nous>" + row2M.group("conditional4").trim() + "</nous>\r\n");
            writer.write("\t\t<vous>" + row2M.group("conditional5").trim() + "</vous>\r\n");
            writer.write("\t\t<ils>" + row2M.group("conditional6").trim() + "</ils>\r\n");
            writer.write("\t</conditional>\r\n");
            writer.write("</verb>\r\n</verbs>\r\n</dictionary>\r\n");
        }
        //initialiseLevels();
    }
    
    private static String buildUrl(String infinitive)
    {
        if (infinitive.startsWith("http://"))
        {
            return infinitive;
        }
        infinitive = infinitive.toLowerCase();
        for(Map.Entry<String, String> urlMapping: urlMappings.entrySet())
        {
            infinitive = infinitive.replace(urlMapping.getKey(), urlMapping.getValue());
        }
        return "http://french.about.com/od/verb_conjugations/a/" + infinitive + ".htm";
    }
    
    private static String getGroup(Matcher matcher, String groupName)
    {
        try
        {
            return matcher.group(groupName).trim();
        }
        catch(IllegalArgumentException e)
        {
            return "***";
        }
    }
    
    private static String lookup(Matcher matcher, String groupName, boolean optional)
    {
        try
        {
            return matcher.group(groupName).split(",")[0].trim();
        }
        catch(IllegalArgumentException e)
        {
            if (optional)
            {
                return "";
            }
            else
            {
                throw e;
            }
        }
    }

    static
    {
        addMapping("&#194;", "Â", "A");
        addMapping("&#199;", "Ç", "C");
        addMapping("&#201;", "É", "E");
        addMapping("&#202;", "Ê", "E");
        addMapping("&#206;", "Î", "I");
        addMapping("&#207;", "Ï", "I");
        addMapping("&#212;", "Ô", "O");
        addMapping("&#219;", "Û", "U");
        addMapping("&#226;", "â", "a");
        addMapping("&#231;", "ç", "c");
        addMapping("&#232;", "è", "e");
        addMapping("&#233;", "é", "e");
        addMapping("&#234;", "ê", "e");
        addMapping("&#238;", "î", "i");
        addMapping("&#239;", "ï", "i");
        addMapping("&#244;", "ô", "o");
        addMapping("&#251;", "û", "u");
    }
    
    private static void addMapping(String entity, String resolved, String urlChar)
    {
        entityMappings.put(entity, resolved);
        urlMappings.put(resolved, urlChar);
    }
}