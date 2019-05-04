package model;

import java.util.ArrayList;
import java.util.Objects;

public class Genre {
    private String genre;
    private ArrayList<Item> items = new ArrayList<>();

    // MODIFIES: this, i
    // EFFECTS: adds i to items
    public void addItem(Item i) {
        if (i == null)
            return;
        if (!items.contains(i)) {
            items.add(i);
            i.setGenre(this);
        }
    }

    // MODIFIES: this, i
    // EFFECTS: removes i from items
    public void removeItem(Item i) {
        if (i == null)
            return;
        if (items.contains(i)) {
            items.remove(i);
            i.setGenre(this);
        }
    }

    // REQUIRES: genre must not be null
    // MODIFIES: this
    // EFFECTS: sets the genre
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // EFFECTS: returns genre field
    public String getGenre() {
        return genre;
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
