package com.martin.cars.exception;

public class ResourceMissingException extends RuntimeException{
    public ResourceMissingException(String message) {
        super(message);
    }
}
