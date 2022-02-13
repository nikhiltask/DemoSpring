package com.example.CustomerService.Controller;


import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.Account;
import com.example.CustomerService.Model.RequireResponce;
import com.example.CustomerService.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService service;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getList(){
        List<Customer> ls=service.getCustomers();
        return  new ResponseEntity<List <Customer>>(ls , HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer (@RequestBody Customer customer){
      Customer  cs=service.addCustomer(customer);
        return new ResponseEntity<Customer>(cs,HttpStatus.CREATED);
    }

    @GetMapping("/id/ids/{id}")
    public ResponseEntity<RequireResponce> getAllDataBasedOnCentreId(@PathVariable("id") Integer id){
        RequireResponce requiredResponse=new RequireResponce();
        Customer cus= service.findById(id);
        requiredResponse.setCustomer_model(cus);

        Account accounts=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id, Account.class);
        requiredResponse.setAccount_model((Account) accounts);
        return new ResponseEntity<RequireResponce>(requiredResponse,HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
        Customer one= service.findById(id);
        return  new ResponseEntity<Customer>(one,HttpStatus.OK);
    }
}
