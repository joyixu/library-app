package model;

public class Book extends Item {

    public Book() {
        title = "";
        author = "";
        genre = null;
        availableCopies = 0;
    }

    public Book(String title, String author, Integer availableCopies, String genreName) {
        this.title = title;
        this.author = author;
        this.availableCopies = availableCopies;
        Genre g = new Genre();
        g.setGenre(genreName);
        genre = g;
    }

    // EFFECTS: prints String that shows what user does with item
    @Override
    public void action(){
        System.out.println("Read book");
    }


}
