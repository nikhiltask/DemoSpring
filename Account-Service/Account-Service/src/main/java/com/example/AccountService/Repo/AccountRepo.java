package com.example.AccountService.Repo;

import com.example.AccountService.Model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepo extends CrudRepository<Account,Integer> {

}
