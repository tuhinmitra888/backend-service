package com.tuhinmitra.warehousebackend.controller;

import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    public ArrayList<Product> create(@RequestBody HashMap<String, List<Product>> products){
        ArrayList<Product> productArrayList = new ArrayList<>();
        List<Product> productList = products.get("products");
        for(Product product: productList){
            productArrayList.add(productService.save(product));
        }
        return productArrayList;
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
