package model;

import exceptions.NegativeCopiesException;
import java.util.Objects;

abstract public class Item {
    public String title;
    public String author;
    public Genre genre;
    public Integer availableCopies;

    public Item() {
        title = "";
        author = "";
        genre = null;
        availableCopies = 0;
    }

    public Item(String title, String author, Genre genre, Integer availableCopies) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availableCopies = availableCopies;
    }

    // REQUIRES: genre must not be null
    // MODIFIES: this, genre
    // EFFECTS: sets the book's genre, and adds this book to genre's collection
    public void setGenre(Genre genre) {
        if (genre == null)
            return;
        if (this.genre != null)
            genre.removeItem(this);
        if (!genre.equals(this.genre)) {
            this.genre = genre;
            this.genre.addItem(this);
        }
    }


    // REQUIRES: title must not be null
    // MODIFIES: this
    // EFFECTS: sets the title to parameter value
    public void setTitle(String title) {
        this.title = title;
    }

    // REQUIRES: author must not be null
    // MODIFIES: this
    // EFFECTS: sets the author to parameter value
    public void setAuthor(String author) {
        this.author = author;
    }

    // REQUIRES: title must not be null
    // MODIFIES: this
    // EFFECTS: sets the title to parameter value
    public void setAvailability(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    // EFFECTS: returns the title of a book
    public String getTitle() {
        return title;
    }

    // EFFECTS: returns the name of the book's author
    public String getAuthor() { return author; }

    // EFFECTS: returns true if the book is available to check out
    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void borrow() throws NegativeCopiesException {
        if (getAvailableCopies() < 1) {
            throw new NegativeCopiesException();
        }
        else
            availableCopies--;
    }

    public void returnItem () {
            availableCopies++;
    }

    // EFFECTS: prints String that shows what user does with item
    public abstract void action();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(title, item.title) &&
                Objects.equals(author, item.author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(title, author);
    }

    @Override
    public String toString() {
        return "Item{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre=" + genre +
                ", availableCopies=" + availableCopies +
                '}';
    }
}
