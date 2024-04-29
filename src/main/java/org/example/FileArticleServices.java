package it.epicode.libreria;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class FileArticleService implements it.epicode.libreria.ArticleService {


    private static final Logger logger = LoggerFactory.getLogger(FileArticleService.class);
    private static final String STORAGE = "./Articles.my";

    private static final ArrayList<it.epicode.libreria.Article> articles = new ArrayList<>();

    public void save() {
        File f = new File(STORAGE);
        try {
            FileUtils.delete(f);
        } catch (IOException err) {
            IOException e = err;
            logger.error("Exception during delete", e);
        }
        articles.forEach(e -> {
            try {
                if (e instanceof it.epicode.libreria.Book) {
                    var lines = List.of(e.getISBN().toString() + "," + e.getTitle() + "," + ((it.epicode.libreria.Book) e).getGenre() + "," + e.getPages() + "," + ((it.epicode.libreria.Book) e).getAuthor() + "," + e.getYear());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);

                } else if (e instanceof Magazine) {
                    var lines = List.of(e.getISBN().toString() + "," + e.getTitle() + "," + e.getYear() + "," + e.getPages() + "," + ((Magazine) e).getPeriodicity());
                    FileUtils.writeLines(f, StandardCharsets.ISO_8859_1.name(), lines, true);
                }

            } catch (IOException exception) {
                logger.error("Exception:", exception);
            }
        });
    }

    public void load() throws IOException {
        File f = new File(STORAGE);
        List<String> lines = FileUtils.readLines(f, StandardCharsets.ISO_8859_1);
        for (String line : lines) {
            String[] properties = line.split(",");
            if (properties.length == 6) {
                try {
                    articles.add(new it.epicode.libreria.Book(properties[1], Integer.parseInt(properties[2]), Integer.parseInt(properties[3]), properties[4], properties[5]));
                } catch (NumberFormatException e) {
                    logger.error("Error on ISBN format", e.getMessage());
                }
            } else if (properties.length == 5) {
                try {
                    Periodicity periodicity = Periodicity.valueOf(properties[4]);
                    articles.add(new Magazine(properties[1], Integer.parseInt(properties[2]), Integer.parseInt(properties[3]), periodicity));
                } catch (NumberFormatException e) {
                    logger.error("Error on ISBN format", e.getMessage());

                }

            }
        }
    }


    @Override
    public void addArticle(it.epicode.libreria.Article article) {
        articles.add(article);
        save();
    }

    @Override
    public void deleteArticleByISBN(Long ISBN) {
        var article = articles.stream().filter(e -> e.getISBN() == ISBN).findAny();
        if (article.isPresent()) {
            articles.remove(article);
            save();
        }
    }

    @Override
    public Optional<it.epicode.libreria.Article> findByISBN(Long ISBN) {
        return articles.stream().filter(e -> e.getISBN() == ISBN).findAny();
    }

    @Override
    public List<it.epicode.libreria.Article> findByYear(int year) {
        return articles.stream().filter(e -> e.getYear() == year).toList();
    }

    @Override
    public List<it.epicode.libreria.Article> findByAuthor(String author) {
        return articles.stream().filter(e -> e instanceof it.epicode.libreria.Book && ((it.epicode.libreria.Book) e).getAuthor().equals(author)).toList();
    }

    @Override
    public ArrayList<it.epicode.libreria.Article> getArticles() {
        return articles;
    }
}
