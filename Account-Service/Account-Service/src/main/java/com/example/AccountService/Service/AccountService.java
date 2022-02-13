package com.example.AccountService.Service;

import com.example.AccountService.Model.Account;
import com.example.AccountService.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

     public List<Account> getList(){
         return (List<Account>) accountRepo.findAll();
     }
     public Account addCount(Account account){
         return accountRepo.save(account);
     }
    public Account findById(Integer id) {
        return accountRepo.findById(id).get();
    }

}
