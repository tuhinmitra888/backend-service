package com.tuhinmitra.warehousebackend.service;

import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.exception.EntityNotFoundException;
import com.tuhinmitra.warehousebackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public Product getByName(String name){
        return productRepository.findById(name).orElseThrow(EntityNotFoundException::new);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public void deleteByName(String name){
        productRepository.deleteById(name);
    }

}
