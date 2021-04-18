package fr.gen.phrases;
import fr.gen.*;
import fr.score.*;
import java.lang.reflect.*;
import java.util.*;

/* package */ abstract class AutoSentenceGenerator extends SentenceGenerator
{
    public AutoSentenceGenerator(ScoreFileBuilder scores, SortingPolicy sortPolicy)
    {
        super(scores, sortPolicy, null);
    }

    @Override
    public final void setup()
    {
        Arrays.stream(getClass().getDeclaredMethods())
                .filter((m) -> m.getParameterTypes().length == 0)
                .filter((m) -> !m.isSynthetic())
                .forEach(this::runMethod);
    }
    
    private void runMethod(Method m)
    {
        try
        {
            m.setAccessible(true);
            m.invoke(this);
        }
        catch(IllegalAccessException|InvocationTargetException e)
        {
            throw new RuntimeException("Couldn't invoke: " + m, e);
        }
    }
    
    public void append(Collection<? super SentenceQuestion> c)
    {
        c.addAll(items);
    }
}