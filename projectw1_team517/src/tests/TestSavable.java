/*
package tests;

import model.Book;
import model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.LibraryApp;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestSavable {
    private LibraryApp l = new LibraryApp();

    @BeforeEach
    private void setUp(){
        ArrayList<Item> list = l.getList();
        Item b = new Book ("test","test",1);
        list.add(b);
    }

    @Test
    public void testSavable() throws IOException {
        l.save("test");
        l.load("test");
        ArrayList<Item> list = l.getList();
        for (Item i : list) {
            assertEquals(i.getTitle(), "test");
            assertEquals(i.getAuthor(), "test");
        }
    }
}*/
