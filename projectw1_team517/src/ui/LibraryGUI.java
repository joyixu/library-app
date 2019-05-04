package ui;

import javax.swing.*;
import java.awt.*;

public class LibraryGUI extends JFrame {
    private LibraryApp library;
    private LibraryPanel panel;

    private LibraryGUI() {
        super("Library");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));

        library = new LibraryApp();
        panel = new LibraryPanel(library);
        add(panel);

        pack();
        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args)
    {
        new LibraryGUI();
    }
}