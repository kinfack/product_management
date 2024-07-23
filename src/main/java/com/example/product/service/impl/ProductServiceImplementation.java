package com.example.product.service.impl;


import com.example.product.exceptions.ResourceNotFoundException;
import com.example.product.models.Product;
import com.example.product.repository.ProductRepository;
import com.example.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements IProductService {


    private final ProductRepository productRepository;


    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Create a product
     * @param product
     * @return
     */
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }


    /**
     * Find all products
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }


    /**
     * Find a product by id
     * @param id
     * @return
     */
    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product doesn't exist with id: " + id));
    }

    /**
     * Delete a product by id
     * @param id
     */
    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        productRepository.delete(product);
    }


    /**
     * Update a product
     * @param id
     * @param product
     * @return
     */
    @Override
    public Product update(Long id, Product product) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        existingProduct.setCode(product.getCode());
        existingProduct.setImage(product.getImage());
        existingProduct.setInventoryStatus(product.getInventoryStatus());
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setDescription(product.getDescription());


        return productRepository.save(existingProduct);

    }


}
