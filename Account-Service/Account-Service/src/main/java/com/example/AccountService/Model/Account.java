package com.example.AccountService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data //getter and setter
@Table(name = "account")
public class Account {

    private int accountId;
    @Id
    private int customerId;
    private Date createdDate;
    private String accountBalance;
}
