package ui;

import model.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class LibraryPanel extends JPanel implements ActionListener {
    private LibraryApp library;
    private JTextArea displayItems;

    LibraryPanel(LibraryApp library) {
        this.library = library;
        setLayout(new FlowLayout());
        JLabel mainLabel = new JLabel("What would you like to do?");
        displayItems = new JTextArea();

        JButton browseBtn = new JButton("Browse Items");
        JButton borrowBtn = new JButton("Borrow Item");
        JButton returnBtn = new JButton("Return Item");
        JButton saveBtn = new JButton("Save");
        JButton loadBtn = new JButton("Load");

        browseBtn.setActionCommand("browse");
        borrowBtn.setActionCommand("borrow");
        returnBtn.setActionCommand("return");
        saveBtn.setActionCommand("save");
        loadBtn.setActionCommand("load");

        browseBtn.addActionListener(this);
        borrowBtn.addActionListener(this);
        returnBtn.addActionListener(this);
        saveBtn.addActionListener(this);
        loadBtn.addActionListener(this);

        add(mainLabel);
        add(browseBtn);
        add(borrowBtn);
        add(returnBtn);
        add(saveBtn);
        add(loadBtn);
        add(displayItems);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("browse")) {
            String txt = library.seeAll();
            displayItems.setText(txt);
        }
        if (e.getActionCommand().equals("borrow")){
            String title = JOptionPane.showInputDialog(null,"Please enter the title you are looking for");
            String author = JOptionPane.showInputDialog(null,"Please enter the author's name");
            Boolean isAvailable = library.search(title, author, 1);
            if (!isAvailable)
                JOptionPane.showMessageDialog(null,"This item is not available.");
            else
                JOptionPane.showMessageDialog(null,"You have checked out an item. Enjoy!");
        }
        if (e.getActionCommand().equals("return")){
            String title = JOptionPane.showInputDialog(null,"Please enter the title of the book");
            String author = JOptionPane.showInputDialog(null,"Please enter the author of the book");
            Boolean isExisting = library.search(title, author, 2);
            if (!isExisting)
                JOptionPane.showMessageDialog(null,"This item does not exist in the library.");
            else
                JOptionPane.showMessageDialog(null,"Item has been returned. Thank you!");
        }
        if (e.getActionCommand().equals("save")) {
            try {
                library.save("outputfile.txt");
                JOptionPane.showMessageDialog(null,"Saved!");
            }
            catch (IOException i){
                JOptionPane.showMessageDialog(null,"File not found.");
            }
        }
        if (e.getActionCommand().equals("load")) {
            try {
                library.load("outputfile.txt");
                JOptionPane.showMessageDialog(null,"Loaded!");
            }
            catch (IOException i){
                JOptionPane.showMessageDialog(null,"File not found.");
            }
        }
    }
}
