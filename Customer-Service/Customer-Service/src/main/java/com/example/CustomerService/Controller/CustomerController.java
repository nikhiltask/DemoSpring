package com.example.CustomerService.Controller;


import com.example.CustomerService.FeignClient.FeignClientsIMP;
import com.example.CustomerService.Model.Account;
import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Model.RequestPut;
import com.example.CustomerService.Model.RequireResponce;
import com.example.CustomerService.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Autowired
    private FeignClientsIMP feignClent;
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getList(){
        logger.info("Customer complete list");
        List<Customer> ls=service.getCustomers();
        logger.info("Customer list",ls);
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

//        Account accounts=  restTemplate.getForObject("http://ACCOUNT-SERVICE/account/id/"+id, Account.class);
       List<Account> accounts=feignClent.getIds(id);
        requiredResponse.setAccount_model( accounts);
        return new ResponseEntity<RequireResponce>(requiredResponse,HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Integer id){
        Customer one= service.findById(id);
        return  new ResponseEntity<Customer>(one,HttpStatus.OK);
    }

    @PatchMapping("/updateActive/{id}")
    public ResponseEntity<Customer> delete(@PathVariable("id") Integer id){

        return new ResponseEntity<Customer>(service.deleteCust(id),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateLastName")
    public ResponseEntity<Customer> updateLastName(@RequestBody RequestPut p){
        return new ResponseEntity<Customer>(service.updateLastName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateMiddleName")
    public ResponseEntity<Customer> updateMiddleName(@RequestBody RequestPut p){
        return new ResponseEntity<Customer>(service.updateMiddleName(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateAddress")
    public ResponseEntity<Customer> updateAddress(@RequestBody RequestPut p){
        return new ResponseEntity<Customer>(service.updateAddress(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updatePhone")
    public ResponseEntity<Customer> updatePhone(@RequestBody RequestPut p){
        return new ResponseEntity<Customer>(service.updatePhone(p),HttpStatus.ACCEPTED);
    }

    @PatchMapping("/updateEmail")
    public ResponseEntity<Customer> updateEmail(@RequestBody RequestPut p){
        return new ResponseEntity<Customer>(service.updateEmail(p),HttpStatus.ACCEPTED);
    }
}
