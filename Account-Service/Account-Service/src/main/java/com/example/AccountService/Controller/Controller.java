package com.example.AccountService.Controller;

import com.example.AccountService.Model.Account;
import com.example.AccountService.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class Controller {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>>  getList(){
        List<Account> lt= accountService.getList();
        return new ResponseEntity<List<Account>>(lt, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Account> addCount(@RequestBody Account account){
        Account ac= accountService.addCount(account);
        return  new ResponseEntity<Account>(ac,HttpStatus.CREATED);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Account> getById(@PathVariable("id") Integer id){
        Account one= accountService.findById(id);
        return  new ResponseEntity<Account>(one,HttpStatus.OK);
    }
}
