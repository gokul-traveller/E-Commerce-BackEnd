package com.example.SpringJDBC.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @JsonProperty("userEmail")
    private String userEmail;
    @JsonProperty("userPassword")
    private String userPassword;
//    private String userName;
//    private String userAddress;
//    private int userPhoneNo;
}
