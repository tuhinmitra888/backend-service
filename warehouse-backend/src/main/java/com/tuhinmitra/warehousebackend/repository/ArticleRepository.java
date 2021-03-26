package com.tuhinmitra.warehousebackend.repository;

import com.tuhinmitra.warehousebackend.data.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArticleRepository extends MongoRepository<Article, String> {
    Article findByArtId(String artId);
}
