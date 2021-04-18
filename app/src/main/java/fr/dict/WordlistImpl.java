package fr.dict;
import apz.fr.utils.*;
import apz.fr.utils.Filters;
import fr.*;
import java.util.*;
import java.util.function.Predicate;

/* package */ final class WordlistImpl implements Wordlist
{
    private final MappedList<String, Noun> nouns = new MappedList<>();

    private final MappedList<String, Verb> verbs = new MappedList<>();
    
    private final MappedList<String, VerbTranslation> verbTranslations = new MappedList<>();

    private final MappedList<String, Adjective> adjectives = new MappedList<>();

    private final MappedList<String, Adverb> adverbs = new MappedList<>();
    
    @Override
    public void addNoun(Noun noun)
    {
        nouns.add(noun.getName(), noun);
    }

    public void addVerb(Verb verb)
    {
        verbs.add(verb.infinitive(), verb);
    }
    
    @Override
    public void addAdjective(Adjective adjective)
    {
        adjectives.add(adjective.name(), adjective);
    }

    @Override
    public void addAdverb(Adverb adverb)
    {
        adverbs.add(adverb.name(), adverb);
    }
    
    @Override
    public synchronized NounList nouns()
    {
        return new NounListImpl(nouns.values());
    }
    
    @Override
    public synchronized List<Noun> nouns(Predicate<Noun> filter) {
        return Filters.filter(nouns.values(), filter);
    }
    
    @Override
    public synchronized List<Adjective> adjectives(Predicate<Adjective> filter) {
        return Filters.filter(adjectives.values(), filter);
    }

    @Override
    public synchronized Producer<Adjective> adjectives() {
        return new ItemImpl<>(adjectives.values());
    }

    @Override
    public Verb lookupVerb(String infinitive)
    {
        return verbs.get(infinitive);
    }

    @Override
    public synchronized VerbTranslation lookupVerbTranslation(String infinitive)
    {
        VerbTranslation item = verbTranslations.get(infinitive);
        if (item == null)
        {
            final int separator = infinitive.indexOf(' ');
            if (separator > 0)
            {
                item = new CompoundVerbTranslation(
                        lookupVerbTranslation(infinitive.substring(0, separator)),
                        infinitive.substring(separator + 1));
            }
            else
            {
                item = new VerbTranslationImpl(
                        infinitive,
                        infinitive,
                        infinitive,
                        infinitive + (infinitive.endsWith("s") ? "es" : "s"),
                        infinitive + (infinitive.endsWith("e") ? "d" : "ed"),
                        infinitive + (infinitive.endsWith("e") ? "d" : "ed"),
                        infinitive + (infinitive.endsWith("e") ? "d" : "ed"),
                        infinitive.endsWith("e") ? infinitive.substring(0, infinitive.length() - 1) + "ing" : infinitive + "ing");
            }
            verbTranslations.add(infinitive, item);
        }
        return item;
    }

    @Override
    public synchronized void addVerbTranslation(VerbTranslation item)
    {
        verbTranslations.add(item.infinitive(), item);
    }

    @Override
    public List<Verb> takeVerbs(Producer<Predicate<Verb>> filter, int size) {
        final List<Verb> out = new ArrayList<>();

        final List<Verb> buffer = new ArrayList<>(verbs.values());
        Collections.shuffle(buffer);

        while (out.size() < size) {
            final Verb next = popMatchingVerb(filter, buffer);
            if (next == null) {
                buffer.addAll(verbs.values());
                Collections.shuffle(buffer);
                continue;
            }
            out.add(next);
        }
        return out;
    }

    private static Verb popMatchingVerb(Producer<? extends Predicate<Verb>> filters, List<Verb> verbs) {
        final Iterator<Verb> iterator = verbs.iterator();
        final Predicate<Verb> filter = Producer.next(filters);
        while(iterator.hasNext()) {
            final Verb current = iterator.next();
            if (filter == null || filter.test(current)) {
                iterator.remove();
                return current;
            }
        }
        return null;
    }

    private static class ItemImpl<T> implements Producer<T> {

        private final CircularProducer<T> list;
        
        private ItemImpl(List<? extends T> source) {
            this.list = new CircularProducer<>(source);
        }
        
        @Override
        public T next() {
            return list.next();
        }

        @Override
        public T[] next(T[] out) {
            return list.next(out);
        }
    }

    private static class NounListImpl implements NounList
    {
        private final CircularProducer<Noun> nouns;
        
        private NounListImpl(List<Noun> source)
        {
            this.nouns = new CircularProducer<>(source);
        }
        
        @Override
        public Noun next(Predicate<Noun> filter) {
            while (true) {
                final Noun item = nouns.next();
                if (filter.test(item)) {
                    return item;
                }
            }
        }

        @Override
        public Noun[] next(Noun[] out, Predicate<Noun> filter) {
            int pos = 0;
            while (pos != out.length) {
                final Noun item = nouns.next();
                if (filter.test(item)) {
                    out[pos++] = item;
                }
            }
            return out;
        }
    }
}