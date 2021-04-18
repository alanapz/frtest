package apz.fr.utils;
import java.lang.reflect.*;
import java.util.concurrent.atomic.*;
import javax.swing.*;

public final class Swing
{
    private Swing()
    {
        
    }
    
    public interface YesNoCancel
    {
        public void yes();
        
        public void no();
        
        public void cancel();
    }

    public static enum Type
    {
        INFO(JOptionPane.INFORMATION_MESSAGE),
        WARN(JOptionPane.WARNING_MESSAGE),
        ERROR(JOptionPane.ERROR_MESSAGE);
        
        private final int value;
        
        private Type(int value)
        {
            this.value = value;
        }
    }

    public static String input(final Type type, final String title, final String text)
    {
        return new SwingAction<String>()
        {
            @Override
            public String execute()
            {
                return JOptionPane.showInputDialog(null, text, title, type.value);
            }
        }.invoke();
    }

    public static void yesNoCancel(final Type type, final String message, final YesNoCancel callback)
    {
        int result = new SwingAction<Integer>()
        {
            @Override
            public Integer execute()
            {
                return JOptionPane.showConfirmDialog(
                        null,
                        message,
                        System.getProperty("sun.java.command"),
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        type.value);
            }
        }.invoke();
        if (result == JOptionPane.YES_OPTION)
        {
            callback.yes();
        }
        else if (result == JOptionPane.NO_OPTION)
        {
            callback.no();
        }
        else
        {
            callback.cancel();
        }
    }
    
    public static boolean confirm(final Type type, final String title, final String message)
    {
        return 1 != new SwingAction<Integer>()
        {
            @Override
            public Integer execute()
            {
                return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION, type.value);
            }
        }.invoke();
    }

    public static void message(final Type type, final String title, final String text)
    {
        execute(() -> JOptionPane.showMessageDialog(null, text, title, type.value));
    }
    
    private static abstract class SwingAction<T>
    {
        public abstract T execute();
        
        public final T invoke()
        {
            final AtomicReference<T> out = new AtomicReference<>();
            Swing.execute(new Runnable()
            {
                @Override
                public void run()
                {
                    out.set(execute());
                }
            });
            return out.get();
        }
    }
    
    public static void execute(Runnable action)
    {
        if (SwingUtilities.isEventDispatchThread())
        {
            action.run();
            return;
        }
        try
        {
            SwingUtilities.invokeAndWait(action);
        }
        catch(InterruptedException | InvocationTargetException e)
        {
            throw new RuntimeException("Couldnt invoke Swing action", e);
        }
    }
}
