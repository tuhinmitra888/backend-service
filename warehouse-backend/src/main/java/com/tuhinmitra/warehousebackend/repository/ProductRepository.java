package com.tuhinmitra.warehousebackend.repository;

import com.tuhinmitra.warehousebackend.data.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {


}
