package com.example.totalAfterDiscount.controller;

import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class DiscountCalculatorController {
    @Autowired
    DiscountService discountService;
    public BigDecimal getPriceAfterDiscount(Order order){
        return discountService.getPriceAfterDiscount(order);
    }

}
