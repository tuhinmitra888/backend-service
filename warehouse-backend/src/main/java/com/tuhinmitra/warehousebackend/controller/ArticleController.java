package com.tuhinmitra.warehousebackend.controller;

import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> findAll(){
        return articleService.getAll();
    }

    @GetMapping("/{id}")
    public Article findById(@PathVariable String id){
        return articleService.getById(id);
    }

    @PostMapping
    public Article create(@RequestBody Article article){
        return articleService.save(article);
    }

    @PutMapping("/{id}")
    public Article update(@RequestBody Article article){
        return articleService.save(article);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        articleService.deleteById(id);
    }
}
