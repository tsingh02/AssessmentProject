package com.example.totalAfterDiscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer eId;
    private EmpType empType;

    public static enum EmpType{
        PERMANENT, AFFILIATE;
    }
}
