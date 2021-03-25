package com.tuhinmitra.warehousebackend.controller;

import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll(){
        return productService.getAll();
    }

    @GetMapping("/{name}")
    public Product findByName(@PathVariable String name){
        return productService.getByName(name);
    }

    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("/{name}")
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{name}")
    public void deleteByName(@PathVariable String name){
        productService.deleteByName(name);
    }
}
