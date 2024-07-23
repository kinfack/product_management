package com.example.product.exceptions;

public class ResourceAlreadyExistException extends RuntimeException {

    public ResourceAlreadyExistException(String resourceName) {
        super(String.format("%s already exists", resourceName));
    }
}
