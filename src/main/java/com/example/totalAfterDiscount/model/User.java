package com.example.totalAfterDiscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer userId;
    private UserType type;
    private LocalDate joinDate;
    private Integer empId;

    public enum UserType{
        CUSTOMER, ADMIN;
    }
}
