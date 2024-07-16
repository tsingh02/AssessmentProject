package com.example.totalAfterDiscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer orderId;
    private Integer userId;
    private List<Item> items;
    private BigDecimal orderAmount;
}
