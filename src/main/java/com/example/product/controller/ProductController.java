package com.example.product.controller;


import com.example.product.models.Product;
import com.example.product.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(
        name = "Product",
        description = "CRUD REST APIS for Product in Product to CREATE, FETCH, UPDATE, DELETE product details"
)

@RestController
@RequestMapping("/products")
public class ProductController {

    private final IProductService productService;


    @Autowired
    public ProductController(IProductService productService) {
        this.productService = productService;
    }


    @Operation(
            summary = "Create product REST API",
            description = "Create product REST API in Product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTPS Status create"
    )
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        Product createdProduct = productService.create(product);
        return ResponseEntity.status(201).body(createdProduct);
    }

    @Operation(
            summary = "Get all products REST API",
            description = "Get all products REST API in Product"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS Status OK"
    )
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {

        return ResponseEntity.ok(productService.findAll());
    }

    @Operation(
            summary = "Get product by id REST API",
            description = "Get product by id REST API in Product"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS Status OK"
    )
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {

        return ResponseEntity.ok(productService.findById(id));
    }


    @Operation(
            summary = "Delete product by id REST API",
            description = "Delete product by id REST API in Product"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS Status OK"
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {

        productService.deleteById(id);
        return ResponseEntity.ok("Product deleted successfully");
    }


    @Operation(
            summary = "Update product REST API",
            description = "Update product REST API in Product"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTPS Status OK"
    )
    @PatchMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {

        Product updatedProduct = productService.update(id, product);
        return ResponseEntity.ok(updatedProduct);
    }
}
