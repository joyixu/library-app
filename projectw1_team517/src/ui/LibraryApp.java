package ui;

import exceptions.NegativeCopiesException;
import model.*;
import observer.BookObserver;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class LibraryApp extends Observable implements Savable, Loadable {
    private ArrayList<Item> items;

    // EFFECTS: constructor for LibraryApp
    public LibraryApp() {
        items = new ArrayList<>();
        addObserver(new BookObserver());
//        items.add(new Book("Harry Potter","J.K. Rowling",5, "Fantasy"));
//        items.add(new Book("The Lord Of The Rings", "J. R. R. Tolkien",2,"Fantasy"));
//        items.add(new Book("The Great Gatsby","F. Scott Fitzgerald",3, "Literature"));
//        items.add(new Book("To Kill a Mockingbird","Harper Lee", 1, "Literature"));
//        items.add(new Book("1984","George Orwell",6,"Literature"));
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    // EFFECTS: passes title to searchCollection();
    public Boolean search(String title, String author, Integer cursor) {
        if (cursor == 1) {
            for (Item item : items) {
                if (item.getTitle().equals(title)) {
                    try {
                        item.borrow();
                        return true;
                    } catch (NegativeCopiesException e) {
                        return false;
                    }
                }
            }
        }
        if (cursor == 2) {
            for (Item item : items) {
                if (item.getTitle().equals(title)) {
                    item.returnItem();
                    return true;
                }
            }
        }
        return false;
    }

    // EFFECTS: prints out elements in items using StringBuilder (Java tutorial)
    public String seeAll() {
        String allItems = "";
        for (Item i : items)
            allItems = allItems + "Title: " + i.getTitle() + ", Author: " + i.getAuthor() + ", Available copies: " + i.getAvailableCopies() + "\n";
        return allItems;
    }

    // EFFECTS: returns String of Item's title, author, and available copies
    private String toString(Item i) {
        return i.getTitle() + "," + i.getAuthor() + "," + i.getAvailableCopies();
    }

    @Override
    public void save(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        PrintWriter writer = new PrintWriter(fileName);
        for (Item i : items) {
            String line = toString(i);
            lines.add(line);
            writer.println(line);
        }
        writer.close();
    }

    @Override
    public void load(String fileName) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(fileName));
        for (String line : lines) {
            String[] partsOfLine = line.split(",");
            Item i = new Book();
            i.setTitle(partsOfLine[0]);
            i.setAuthor(partsOfLine[1]);
            i.setAvailability(Integer.parseInt(partsOfLine[2]));
            items.add(i);
        }
    }
}