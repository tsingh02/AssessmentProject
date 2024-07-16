package com.example.totalAfterDiscount.utility;

import com.example.totalAfterDiscount.model.Employee;
import com.example.totalAfterDiscount.model.Employee.EmpType;
import com.example.totalAfterDiscount.model.Item;
import com.example.totalAfterDiscount.model.Item.ItemType;
import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.model.User;
import com.example.totalAfterDiscount.model.User.UserType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Component
public class DiscountUtility {
    public static BigDecimal getDiscountedPrice(User user, Order order, Employee employee){
        int generalDiscount = getGeneralDiscount(order.getOrderAmount());
        int discountPerc = getDiscountPercentages(user, employee);
        List<Item> items = order.getItems();
        BigDecimal nonGrossaryTotalPrice = items.stream().filter(i -> !ItemType.GROSSARY.name().equals(i.getItemType().name()))
                .map(item -> item.getItemPrice())
                .reduce(BigDecimal.ZERO, BigDecimal:: add);
        BigDecimal percBasedDiscAmount = (nonGrossaryTotalPrice.multiply(new BigDecimal(discountPerc))).divide(new BigDecimal(100));

        return order.getOrderAmount().subtract(percBasedDiscAmount.add(new BigDecimal(generalDiscount)));
    }

    public static int getGeneralDiscount(BigDecimal price){
        return Math.multiplyExact(Math.floorDiv(price.intValue(), 100), 5);
    }

    public static int getDiscountPercentages(User user, Employee employee){
        LocalDate today =  LocalDate.now();
        if(employee == null && UserType.CUSTOMER.name().equalsIgnoreCase(user.getType().name()) && user.getJoinDate().isBefore(today.minusYears(2))){
            return 5;
        } else if(employee != null && EmpType.PERMANENT.name().equalsIgnoreCase(employee.getEmpType().name())){
            return 30;
        } else if(employee != null &&  EmpType.AFFILIATE.name().equalsIgnoreCase(employee.getEmpType().name())){
            return 10;
        }
        return 0;

    }

}
