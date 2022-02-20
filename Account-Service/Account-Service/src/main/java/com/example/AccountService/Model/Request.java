package com.example.AccountService.Model;

import com.example.AccountService.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    private int balance;
    private int id;
    private AccountType accountsType;
}
