package com.example.CustomerService.FeignClient;

import com.example.CustomerService.Model.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ACCOUNT-SERVICE")
public interface FeignClientsIMP {
    @GetMapping(value = "/account/customer/id/{customerid}")
    List<Account> getIds(@PathVariable Integer customerid);
    @PatchMapping("/account/disableisActive/{id}")
    List<Account> updateActive(@PathVariable Integer id);

    @PostMapping("/account/add")
    Account createAccount(@RequestBody Account accountModel);

}
