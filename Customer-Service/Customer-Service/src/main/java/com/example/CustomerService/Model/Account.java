package com.example.CustomerService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data //getter and setter
public  class Account {

    private int accountId;
    @Id
    private int customerId;
    private Date createdDate;
    private String accountBalance;


}