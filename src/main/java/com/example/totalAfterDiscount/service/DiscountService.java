package com.example.totalAfterDiscount.service;

import com.example.totalAfterDiscount.model.Employee;
import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.model.User;
import com.example.totalAfterDiscount.utility.DiscountUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DiscountService {

    @Autowired
    UserService userService;

    @Autowired
    EmployeeService empService;
    public BigDecimal getPriceAfterDiscount(Order order){
        User user = userService.getUser(order);
        Employee emp = null;
        if(user.getEmpId() != null){
            emp = empService.getEmployeeDetails(user.getEmpId());
        }

        return DiscountUtility.getDiscountedPrice(user, order, emp);
    }


}
