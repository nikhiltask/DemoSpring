package com.example.CustomerService.Service;

import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private Repository repository;

    public List<Customer> getCustomers(){
       return repository.findAll();
    }

    public Customer addCustomer(Customer customer){
        return repository.save(customer);
    }

    public Customer findById(Integer id) {
        return repository.findById(id).get();
    }

}
