package tests;

import exceptions.NegativeCopiesException;
import model.Book;
import model.Item;
import model.Loadable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.LibraryApp;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.fail;

public class TestException {
    private Loadable l = new LibraryApp();

    @Test
    private void testExpectedIOException() {
        try {
            l.load("File");
            fail("Not expecting this");
        } catch (IOException e) {
            System.out.println("Exception is thrown.");
        }
    }

    @Test
    private void testNonExpectedIOException() {
            try {
                l.load("test");
                System.out.println("Passed.");
            } catch (IOException e) {
                fail("Not expecting this");
            }
    }
}