package fr;
import apz.fr.utils.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

public final class GameSelector<T> implements java.io.Serializable
{
    private final JList<ToString<Item<T>>> listLeft = new JList<>();

    private final JList<ToString<?>> listRight = new JList<>();

    private final List<Category> categories = new ArrayList<>();
    
    private final Object notify = new java.io.Serializable()
    {
        private static final long serialVersionUID = 1L;
    };
    
    private static final long serialVersionUID = 1L;
    
    public Category addCategory(String name)
    {
        Category category = new Category(name);
        categories.add(category);
        return category;
    }
    
    public java.util.List<T> go()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame wnd = new JFrame();
        wnd.setLayout(new BorderLayout());
        wnd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Collections.shuffle(categories);
        // List left
        {
            listLeft.setModel(categories.get(0).left);
            wnd.getContentPane().add(listLeft, BorderLayout.WEST);
        }
        // List right
        {
            listRight.setModel(categories.get(0).right);
            wnd.getContentPane().add(listRight, BorderLayout.EAST);
        }
        // Category combo box
        {
            final JComboBox<Category> cmbCategories = new JComboBox<>();
            cmbCategories.setModel(new DefaultComboBoxModel<>(new Vector<>((categories))));
            cmbCategories.addActionListener( e -> {
                listLeft.setModel((ListModel) ((Category) cmbCategories.getSelectedItem()).left);
                listRight.setModel((ListModel) ((Category) cmbCategories.getSelectedItem()).right);
                wnd.pack();
                wnd.validate();
            });
            wnd.getContentPane().add(cmbCategories, BorderLayout.NORTH);
            wnd.addWindowListener(new WindowListener()
            {
                @Override
                public void windowOpened(WindowEvent e){}

                @Override
                public void windowClosing(WindowEvent e)
                {
                    synchronized(notify)
                    {
                        notify.notifyAll();
                    }
                }

                @Override
                public void windowClosed(WindowEvent e){}

                @Override
                public void windowIconified(WindowEvent e){}

                @Override
                public void windowDeiconified(WindowEvent e){}

                @Override
                public void windowActivated(WindowEvent e){}

                @Override
                public void windowDeactivated(WindowEvent e){}
            });
        }
        // Submit button
        {
            final JButton btnSubmit = new JButton();
            btnSubmit.setText("Start !");
            btnSubmit.addActionListener(e -> {
                synchronized(notify) {
                    notify.notifyAll();
                    wnd.dispose();
                }
            });
            wnd.getContentPane().add(btnSubmit, BorderLayout.SOUTH);
        }
        wnd.pack();
        wnd.setVisible(true);
        synchronized(notify)
        {
            try
            {
                notify.wait();
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        
        java.util.List<Object> right = new ArrayList<>();
        for(ToString<?> item: listRight.getSelectedValuesList())
        {
            right.add(item.value);
        }
        java.util.List<T> out = new ArrayList<>();
        for(ToString<Item<T>> item: listLeft.getSelectedValuesList())
        {
            out.add(ToString.value(item).build(right.toArray(new Object[0])));
        }
        return out;
    }
    
    public interface Item<T>
    {
        T build(Object[] modifier);
    }
    
    public final class Category implements java.io.Serializable
    {
        private final String name;
        
        private final DefaultListModel<ToString<Item<T>>> left = new DefaultListModel<>();
        
        private final DefaultListModel<ToString<?>> right = new DefaultListModel<>();
        
        private static final long serialVersionUID = 1L;

        public Category(String name)
        {
            this.name = name;
        }
        
        public final <U extends Item<T>> U addLeft(String label, U value)
        {
            left.addElement(ToString.of(label, value));
            return value;
        }
        
        public final <U> U addRight(String label, U value)
        {
            right.addElement(ToString.of(label, value));
            return value;
        }
        
        @Override
        public final String toString()
        {
            return name;
        }
    }
}
