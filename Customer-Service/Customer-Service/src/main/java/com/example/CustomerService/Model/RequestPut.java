package com.example.CustomerService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPut {
    private int id;
    private String lastname;
    private String middlename;
    private String address;
    @Size(min=10,max=10)
    private String phone;
    private String email;
}
