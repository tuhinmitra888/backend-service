package com.tuhinmitra.warehousebackend.service;

import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ArticleService articleService;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByName(String name){
        return productRepository.findByName(name);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteByName(String name){
        List<Product.ContainArticles> list = this.getByName(name).getContainArticles();
        for(Product.ContainArticles conatinedArticle: list){
            articleService.updateStock(conatinedArticle.getArtId(), conatinedArticle.getAmountOf());
        }
        productRepository.delete(productRepository.findByName(name));
    }

}
