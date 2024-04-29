package it.epicode.libreria;

public class Magazine extends it.epicode.libreria.Article {
    private Periodicity periodicity;

    public Magazine(String title, int year, int pages, Periodicity periodicity) {
        super(title, year, pages);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }
    public String toString() {
        return "This is the list of our Books: [" +
                "\nISBN:" + this.getISBN() +
                "\nTitle:" + this.getTitle() +
                "\nYear:" + this.getYear() +
                "\nPages:" + this.getPages() +
                "\n Periodicity:" + periodicity +
                "\n]";
    }


}
