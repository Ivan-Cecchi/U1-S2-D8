package it.epicode.libreria;

public abstract class Article {
    private static long counter = 0;
    private Long ISBN;
    private String title;
    private int year;
    private int pages;

    public Article(String title, int year, int pages) {
        this.ISBN = counter++;
        this.title = title;
        this.year = year;
        this.pages = pages;
    }

    public Long getISBN() {
        return ISBN;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

}
