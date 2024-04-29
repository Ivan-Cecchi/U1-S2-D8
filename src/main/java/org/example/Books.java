package it.epicode.libreria;

public class Book extends it.epicode.libreria.Article {
    private String author;
    private String genre;

    public Book(String title, int year, int pages, String author, String genre) {
        super(title, year, pages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    @Override
    public String toString() {
        return "This is the list of our Books: [" +
                "\nISBN:" + this.getISBN() +
                "\nTitle:" + this.getTitle() +
                "\nYear:" + this.getYear() +
                "\nPages:" + this.getPages() +
                "\nAuthor:" + author +
                "\nGenre:" + genre +
                "\n]";
    }

}
