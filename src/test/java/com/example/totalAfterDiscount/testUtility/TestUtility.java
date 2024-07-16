package com.example.totalAfterDiscount.testUtility;

import com.example.totalAfterDiscount.model.Employee;
import com.example.totalAfterDiscount.model.Employee.EmpType;
import com.example.totalAfterDiscount.model.Item;
import com.example.totalAfterDiscount.model.Item.ItemType;
import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.model.User;
import com.example.totalAfterDiscount.model.User.UserType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TestUtility {

    public static Order getMockOrder(){
        Order order = new Order();
        order.setOrderId(11);
        order.setOrderAmount(new BigDecimal(990));
        order.setUserId(1);
        List<Item> itemList = new ArrayList<>();
        Item item1 = new Item(111, ItemType.COSMETIC, new BigDecimal(600));
        Item item2 = new Item(112, ItemType.GROSSARY, new BigDecimal(390));
        itemList.add(item1);
        itemList.add(item2);

        order.setItems(itemList);

        return order;
    }

    public static User getMockUser(){
        User user = new User();

        user.setUserId(1);
        user.setEmpId(1);
        user.setJoinDate(LocalDate.of(2020, 11, 17));
        user.setType(UserType.CUSTOMER);

        return user;
    }
    public static User getMockUserAffiliate(){
        User user = new User();

        user.setUserId(1);
        user.setEmpId(2);
        user.setJoinDate(LocalDate.of(2020, 11, 17));
        user.setType(UserType.CUSTOMER);

        return user;
    }

    public static User getMockUserNoEmp(){
        User user = new User();

        user.setUserId(1);
        user.setJoinDate(LocalDate.of(2020, 11, 17));
        user.setType(UserType.CUSTOMER);

        return user;
    }

    public static User getMockNewUserNoEmp(){
        User user = new User();

        user.setUserId(1);
        user.setJoinDate(LocalDate.of(2024, 02, 17));
        user.setType(UserType.CUSTOMER);

        return user;
    }

    public static Employee getMockEmployee(){
        Employee emp = new Employee();

        emp.setEId(1);
        emp.setEmpType(EmpType.PERMANENT);

        return emp;
    }

    public static Employee getMockAffiliateEmp(){
        Employee emp = new Employee();

        emp.setEId(2);
        emp.setEmpType(EmpType.AFFILIATE);

        return emp;
    }

}
