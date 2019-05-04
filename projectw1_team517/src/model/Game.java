package model;

public class Game extends Item {

    public Game() {
        title = "";
        author = "";
        genre = null;
        availableCopies = 0;
    }

    public Game(String title, String author, String genreName) {
        this.title = title;
        this.author = author;
        this.availableCopies = 1;
        Genre g = new Genre();
        g.setGenre(genreName);
        genre = g;
    }

    // EFFECTS: prints String that shows what user does with item
    @Override
    public void action() { System.out.println("Play game"); }

}
