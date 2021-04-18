package fr;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public final class GameSelectorPrev<R> implements java.io.Serializable
{
    private final JList<Object> listLeft = new JList<>();

    private final JList<Object> listRight = new JList<>();

    private final DefaultComboBoxModel<Category> categories = new DefaultComboBoxModel<>();
    
    private final Object notify = new java.io.Serializable()
    {
        private static final long serialVersionUID = 1L;
    };
    
    private static final long serialVersionUID = 1L;
    
    public Category addCategory(String name, Merger<R> merger)
    {
        Category category = new Category(name, merger);
        categories.addElement(category);
        return category;
    }
    
    public java.util.List<R> go()
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        final JFrame wnd = new JFrame();
        wnd.setLayout(new BorderLayout());
        wnd.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        // List left
        {
            listLeft.setModel(categories.getElementAt(0).left);
            wnd.getContentPane().add(listLeft, BorderLayout.WEST);
        }
        // List right
        {
            listRight.setModel(categories.getElementAt(0).right);
            wnd.getContentPane().add(listRight, BorderLayout.EAST);
        }
        // Category combo box
        {
            final JComboBox<Category> cmbCategories = new JComboBox<>();
            cmbCategories.setModel(categories);
            cmbCategories.addActionListener(new ActionListener()
            {
                @Override
                @SuppressWarnings("unchecked")
                public void actionPerformed(ActionEvent e)
                {
                    listLeft.setModel(((Category) categories.getSelectedItem()).left);
                    listRight.setModel(((Category) categories.getSelectedItem()).right);
                }
            });
            wnd.getContentPane().add(cmbCategories, BorderLayout.NORTH);
        }
        // Submit button
        {
            final JButton btnSubmit = new JButton();
            btnSubmit.setText("Start !");
            btnSubmit.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    synchronized(notify)
                    {
                        notify.notifyAll();
                    }
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
        java.util.List<R> results = new ArrayList<>();
        for(Object o: listLeft.getSelectedValuesList())
        {
            //results.add(((GameSelector<R>.Category) categories.getSelectedItem()).merger.merge(o, listRight.getSelectedValuesList()));
        }
        return results;
    }
    
    public interface Merger<R>
    {
        public R merge(Object left, java.util.List<?> right);
    }
    
    public final class Category implements java.io.Serializable
    {
        private final String name;
        
        private final Merger<R> merger;

        private final DefaultListModel<Object> left = new DefaultListModel<>();
        
        private final DefaultListModel<Object> right = new DefaultListModel<>();
        
        private static final long serialVersionUID = 1L;

        public Category(String name, Merger<R> merger)
        {
            this.name = name;
            this.merger = merger;
        }
        
        public final <T> T addLeft(T value)
        {
            left.addElement(value);
            return value;
        }
        
        public final <T> T addRight(T value)
        {
            right.addElement(value);
            return value;
        }
        
        @Override
        public final String toString()
        {
            return name;
        }
    }
}
