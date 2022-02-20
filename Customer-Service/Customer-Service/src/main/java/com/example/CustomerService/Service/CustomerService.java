package com.example.CustomerService.Service;

import com.example.CustomerService.Exceptions.CustomerNotFoundException;
import com.example.CustomerService.FeignClient.FeignClientsIMP;
import com.example.CustomerService.Model.Account;
import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.RequestPut;
import com.example.CustomerService.Repo.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private Repository repository;

    @Autowired
    private FeignClientsIMP feignIMP;

    public List<Customer> getCustomers() {
        if(repository.findAll().isEmpty())
            throw new CustomerNotFoundException("No customer found for this id");
        return repository.findAll();
    }

    public Customer updateLastName(RequestPut p){
        Customer cus = findById(p.getId());
        cus.setLastName(p.getLastname());
        repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer addCustomer(Customer customer) {
        if ( !repository.findById(customer.getCustomerId()).isPresent()){
            Account accountModel = feignIMP.createAccount(customer.getAccountModel());
            return repository.save(customer);
        }
        else{
            Customer customerModel = repository.findById(customer.getCustomerId()).get();
            if(customerModel.getisactive()==true){
                Account accountModel= feignIMP.createAccount(customer.getAccountModel());
                return repository.save(customer);
            }
            else{
                throw new CustomerNotFoundException("Customer is already inactive,cannnot create account") ;
            }
        }
//        return repository.save(customer);
    }

    public Customer findById(Integer id) {
        if(!repository.findById(id).isPresent())
            throw new CustomerNotFoundException("id doesnt exist");
        return repository.findById(id).get();
    }
    public Customer deleteCust(Integer id) {
        Customer customer = findById(id);
        if (customer.getisactive() == false) {
            throw new CustomerNotFoundException("Customer is already inactive");
        }
        customer.setIsactive(false);
        repository.save(customer);
        List<Account> accountLists = (List<Account>) feignIMP.updateActive(id);
        customer = findById(id);
        return customer;
    }

    public Customer updatePhone(RequestPut p){
        Customer cus = findById(p.getId());
        cus.setPhonenumber(p.getPhone());
        repository.save(cus);
        return cus = findById(p.getId());

    }

    public Customer updateMiddleName(RequestPut p){
        Customer cus = findById(p.getId());
        cus.setMiddleName(p.getMiddlename());
        repository.save(cus);
        return cus = findById(p.getId());

    }
    public Customer updateEmail(RequestPut p){
        Customer cus = findById(p.getId());
        cus.setEmail(p.getEmail());
        repository.save(cus);
        return cus = findById(p.getId());

    }
    public Customer updateAddress(RequestPut p){
        Customer cus = findById(p.getId());
        cus.setCustomerAddress(p.getAddress());
        repository.save(cus);
        return cus = findById(p.getId());

    }
}
