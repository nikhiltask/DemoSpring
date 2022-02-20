package com.example.CustomerService.Exceptions;
import org.springframework.stereotype.Component;

public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
