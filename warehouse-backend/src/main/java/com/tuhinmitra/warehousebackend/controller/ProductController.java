package com.tuhinmitra.warehousebackend.controller;

import com.tuhinmitra.warehousebackend.data.Article;
import com.tuhinmitra.warehousebackend.data.Product;
import com.tuhinmitra.warehousebackend.exception.EntityNotFoundException;
import com.tuhinmitra.warehousebackend.exception.OperationNotAllowedException;
import com.tuhinmitra.warehousebackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        try{return productService.getByName(name);}
        catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", exception);
        }
    }

    @PostMapping
    public ResponseEntity create(@RequestBody HashMap<String, List<Product>> products){
        List<Product> productList = products.get("products");
        for(Product product: productList){
            productService.save(product);
        }
        return ResponseEntity.ok("Product(s) is created");
    }

    @PutMapping("/{name}")
    public Product update(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity deleteByName(@PathVariable String name){
        try{return productService.deleteByName(name);
        }
        catch (EntityNotFoundException exception){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", exception);
        }
        catch (OperationNotAllowedException exception){
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "Article stock is too low", exception);
        }
    }
}
