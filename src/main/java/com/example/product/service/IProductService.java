package com.example.product.service;

import com.example.product.models.Product;

import java.util.List;

public interface IProductService {
    Product create(Product product);
    List<Product> findAll();
    Product findById(Long id);
    void deleteById(Long id);
    Product update(Long id, Product product);
}
