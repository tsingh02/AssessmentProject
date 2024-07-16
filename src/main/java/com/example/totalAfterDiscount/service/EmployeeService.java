package com.example.totalAfterDiscount.service;

import com.example.totalAfterDiscount.model.Employee;
import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.model.User;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    public Employee getEmployeeDetails(Integer eId){
        return new Employee();
    }
}
