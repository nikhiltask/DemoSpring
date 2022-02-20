package com.example.CustomerService.Model;

import com.example.CustomerService.Enum.CustomerType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Document(collection = "CustomerDataBase")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    //    @Id
//    private int id;
//    private String customerName;
//    private Date createdDate;
//    private Boolean isActive;
    @Id

    private int customerId;

    @NotEmpty(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Address is required")
    private String customerAddress;

    @NotEmpty(message = "Customer Address is required")
    private Date createdDate;
    private Account accountModel;

    private boolean isactive;

    private LocalDateTime dateTime = LocalDateTime.now();

    @NotEmpty(message = "Customer Type is required")
    private CustomerType customerType;

    @NotNull(message = "Phone number  can't be null")
    @Size(min=10,max = 10)
    private String phonenumber;

    @NotNull(message = "Email can't be null")
    private String email;

    public boolean getisactive(){
        return this.isactive;
    }
}
