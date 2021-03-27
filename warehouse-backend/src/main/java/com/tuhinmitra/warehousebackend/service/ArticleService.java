package com.tuhinmitra.warehousebackend.service;

import com.tuhinmitra.warehousebackend.controller.ArticleController;
import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.exception.EntityNotFoundException;
import com.tuhinmitra.warehousebackend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;
    @Autowired
    private ArticleController articleController;

    public List<Article> getAll(){
        return articleRepository.findAll();
    }

    public Article getById(String id){
        return articleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Article save(Article article){
        return articleRepository.save(article);
    }

    public void deleteById(String id){
        articleRepository.deleteById(id);
    }

    public void updateStock(String id, int soldAmount){
        Article article = this.getById(id);
        article.setAvailableStock(article.getAvailableStock() - soldAmount);
        articleRepository.save(article);
    }

}
