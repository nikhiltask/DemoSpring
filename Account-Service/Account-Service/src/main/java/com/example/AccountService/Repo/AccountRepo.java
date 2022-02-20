package com.example.AccountService.Repo;

import com.example.AccountService.Model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepo extends CrudRepository<Account,Integer> {
    public List<Account> findByCustomerid(Integer id);
}

