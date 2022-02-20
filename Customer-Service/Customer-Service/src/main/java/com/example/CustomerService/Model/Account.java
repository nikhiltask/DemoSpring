package com.example.CustomerService.Model;

import com.example.CustomerService.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Data //getter and setter
public class Account {
    @Id
    @NotNull(message = "Account id cannot be null")
    private int accountId;
    @NotNull(message = "customer id cannot be null")
    private int customerid;
    private AccountType accountType;
    @NotNull(message = "account Balance cannot be null")
    private double accountBalance;
    private boolean isactive;

}
