package com.disturbedechoes.blog.rest.webservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ArticleResource {

    @Autowired
    public  ArticleRepository repository;

    @GetMapping("/users/{username}/articles")
    public List<Article> getArticles(@PathVariable String username) {
        return repository.findByUsername(username);
    }

    @GetMapping("/users/{username}/articles/{id}")
    public Article getArticle(@PathVariable String username,@PathVariable long id) {
        return repository.findById(id).get();
    }

    @DeleteMapping("/users/{username}/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable String username, @PathVariable long id) {
        Article article = repository.findById(id).get();
        if (article!=null) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/users/{username}/articles/{id}")
    public ResponseEntity<Article> putArticle(@PathVariable String username, @PathVariable long id , @RequestBody Article article) {
        article.setUsername(username);
        if (repository.existsById(id)) {
            repository.save(article);
            return new ResponseEntity<Article>(article, HttpStatus.OK) ;
        }
        return new ResponseEntity<Article>(article, HttpStatus.NOT_FOUND) ;
    }

    @PostMapping("/users/{username}/articles")
    public ResponseEntity<Void> postArticle(@PathVariable String username,  @RequestBody Article article) {
        article.setUsername(username);
        Article insertedArticle = repository.save(article);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(insertedArticle.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }
}