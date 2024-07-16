package com.example.totalAfterDiscount.service;

import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User getUser(Order order){
        return new User();
    }
}
