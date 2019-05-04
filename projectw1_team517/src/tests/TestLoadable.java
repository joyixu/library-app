package tests;

import model.Item;
import model.Loadable;
import org.junit.jupiter.api.Test;
import ui.LibraryApp;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestLoadable {
    private Loadable l = new LibraryApp();

    @Test
    public void testLoadable() throws IOException {
        l.load("test");
        ArrayList<Item> list = l.getItems();
        for (Item i : list) {
            assertEquals(i.getTitle(), "test");
            assertEquals(i.getAuthor(), "test");
        }
    }
}
