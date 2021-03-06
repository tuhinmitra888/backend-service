package com.tuhinmitra.warehousebackend.controller;

import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.exception.EntityNotFoundException;
import com.tuhinmitra.warehousebackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> findAll() {
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable String id) {
        try {return articleService.getById(id);}
        catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Article not found", exception);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody HashMap<String, List<Article>> inventory) {
        List<Article> articleList = inventory.get("inventory");
        for (Article article : articleList) {
            articleService.save(article);
        }
        return ResponseEntity.ok("Article(s) is created");
    }

    @PutMapping("/{id}")
    public Article update(@RequestBody Article article) {
        return articleService.save(article);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable String id) {
        return articleService.deleteById(id);
    }
}
