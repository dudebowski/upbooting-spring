package com.disturbedechoes.blog.rest.webservices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    private static List<Article> articles = new ArrayList<>();
    private static long idCounter = 0;

    public static List<Article> GetArticles() {
        return articles;
    }

    protected Article ReadArticle(long id) {
        for (Article article : GetArticles()) {
            if (article.getId()==id) {
                return article;
            }
        }
        return null;
    }

    protected Article UpSertArticle(Article article) {
        if (article.getId() < 1) {
            article.setId(++idCounter);
        } else {
            DeleteArticle(article.getId());
        }
        articles.add(article);
        return article;
    }

    public Article DeleteArticle(long id) {
        Article article = ReadArticle(id);
        if (article!=null) {
            if (articles.remove(article)) {
                return article;
            }
        }
        return null;
    }

    static {
        articles.add(new Article(++idCounter,"dudebowski","The journey", "How thing got out of hand", true, new Date()));
        articles.add(new Article(++idCounter,"dudebowski","Brooks law", "Kinematics in IT planning", true, new Date()));
        articles.add(new Article(++idCounter,"dudebowski","Make your bed", "If you want to change the world", false, new Date()));
    }
}
