package com.example.product.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String resourceName) {
        super(String.format("%s not found", resourceName));
    }
}
