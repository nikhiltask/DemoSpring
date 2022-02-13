package com.example.CustomerService.Repo;

import com.example.CustomerService.Model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Customer,Integer> {

}
