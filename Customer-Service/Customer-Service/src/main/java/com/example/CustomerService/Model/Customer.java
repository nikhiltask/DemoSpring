package com.example.CustomerService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "CustomerDataBase")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    private int id;
    private String customerName;
    private Date createdDate;
    private Boolean isActive;

}
