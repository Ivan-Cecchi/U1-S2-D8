package it.epicode.libreria;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ArticleService {
    void addArticle(it.epicode.libreria.Article article);
    void deleteArticleByISBN(Long ISBN);
    Optional<it.epicode.libreria.Article> findByISBN(Long ISBN);
    List<it.epicode.libreria.Article> findByYear(int year);
    List<it.epicode.libreria.Article> findByAuthor(String author);
    ArrayList<it.epicode.libreria.Article> getArticles();
}
