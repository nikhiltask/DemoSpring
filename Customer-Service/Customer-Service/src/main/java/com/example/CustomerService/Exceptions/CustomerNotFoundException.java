package com.example.CustomerService.Exceptions;

import org.springframework.stereotype.Component;


public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
