package com.example.AccountService.Model;

import com.example.AccountService.Enum.AccountType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //getter and setter
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Account id cannot be null")
    private int accountId;
    @NotNull(message = "customer id cannot be null")
    private int customerid;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    @NotNull(message = "account Balance cannot be null")
    private double accountBalance;
    private boolean isactive;

}
