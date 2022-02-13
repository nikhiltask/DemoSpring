package com.example.CustomerService.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequireResponce {
    private Account account_model;
    private Customer customer_model;
}

