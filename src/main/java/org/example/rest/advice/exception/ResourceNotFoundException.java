package org.example.rest.advice.exception;

public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Integer id;


    public ResourceNotFoundException(String resourceName, Integer id) {
        super(String.format("Resource %s with id %d not found", resourceName, id));
        this.resourceName = resourceName;
        this.id = id;
    }
}
