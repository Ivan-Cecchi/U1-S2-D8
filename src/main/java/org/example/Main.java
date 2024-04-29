package it.epicode.libreria;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("The Bible", 400, 3000, "Io", "Unkown");
        Book book2 = new Book("The Bible", 400, 3000, "Io", "Unkown");
        Magazine magazine1 = new Magazine("Food", 2000, 60, Periodicity.WEEKLY);
        Magazine magazine2 = new Magazine("Food", 2000, 60, Periodicity.WEEKLY);

        FileArticleService catalogue = new FileArticleService();

        catalogue.addArticle(book1);
        catalogue.addArticle(book2);
        catalogue.addArticle(magazine1);
        catalogue.addArticle(magazine2);

        catalogue.deleteArticleByISBN(1L);

        catalogue.getArticles().forEach(System.out::println);
    }
}