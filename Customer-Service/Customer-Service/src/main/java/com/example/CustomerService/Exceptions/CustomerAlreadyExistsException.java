package com.example.CustomerService.Exceptions;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlElementRefs;


public class CustomerAlreadyExistsException extends RuntimeException {
    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
