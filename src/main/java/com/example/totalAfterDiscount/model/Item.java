package com.example.totalAfterDiscount.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Integer itemId;
   // private Integer quantity;
    private ItemType itemType;
    private BigDecimal itemPrice;

    public static enum ItemType{
        GROSSARY, COSMETIC, ELECTRONIC;
    }

   /* public BigDecimal getTotalPrice(){
        return itemPrice.multiply(new BigDecimal(quantity));
    }*/
}
