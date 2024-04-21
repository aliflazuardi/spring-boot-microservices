package com.aliflazuardi.productservice.repository;

import com.aliflazuardi.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

}
