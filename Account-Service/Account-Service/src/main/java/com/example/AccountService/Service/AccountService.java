package com.example.AccountService.Service;

import com.example.AccountService.Model.Account;
import com.example.AccountService.Model.Request;
import com.example.AccountService.Repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepo accountRepo;

    public List<Account> getList() {
        return (List<Account>) accountRepo.findAll();
    }

    public Account addCount(Account account) {
        return accountRepo.save(account);
    }

    public Account findById(Integer id) {
        return accountRepo.findById(id).get();
    }

    public List<Account> updateMoney(Request r) {
        List<Account> id = accountRepo.findByCustomerid(r.getId());
        List<Account> cId = accountRepo.findByCustomerid(r.getId());
        for (Account i : id) {
            if (i.getAccountType().compareTo(r.getAccountsType()) == 0) {
                double b = i.getAccountBalance();
                double sum = b + (float) r.getBalance();
                i.setAccountBalance(sum);
                accountRepo.save(i);
            } else
                cId.remove(i);
        }
        return cId;


    }
    public List<Account> getCustomerById(Integer id) {
        return accountRepo.findByCustomerid(id);
    }
    public List<Account> updateActive(Integer id){
        List<Account> acount = (List<Account>) findById(id);

        for(Account i : acount){
            i.setIsactive(false);
            accountRepo.save(i);
        }
        List<Account> ac = (List<Account>) findById(id);
        return  ac;

    }
}
