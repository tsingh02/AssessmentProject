package com.example.totalAfterDiscount.service;

import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.testUtility.TestUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiscountServiceTest {

    @InjectMocks
    DiscountService discountService;

    @Mock
    UserService userService;

    @Mock
    EmployeeService empService;

    @Test
    void getPriceAfterDiscountForPermEmpTest(){
        Order mockOrder = TestUtility.getMockOrder();
        when(userService.getUser(mockOrder))
                .thenReturn(TestUtility.getMockUser());
        when(empService.getEmployeeDetails(1))
                .thenReturn(TestUtility.getMockEmployee());
        BigDecimal actualResponse =
                discountService.getPriceAfterDiscount(mockOrder);
        assertEquals(new BigDecimal(765), actualResponse);
    }


    @Test
    void getPriceAfterDiscountForAffiliateEmpTest(){
        Order mockOrder = TestUtility.getMockOrder();
        when(userService.getUser(mockOrder))
                .thenReturn(TestUtility.getMockUserAffiliate());
        when(empService.getEmployeeDetails(2))
                .thenReturn(TestUtility.getMockAffiliateEmp());
        BigDecimal actualResponse =
                discountService.getPriceAfterDiscount(mockOrder);
        assertEquals(new BigDecimal(885), actualResponse);
    }

    @Test
    void getPriceAfterDiscountForNoEmpTest(){
        Order mockOrder = TestUtility.getMockOrder();
        when(userService.getUser(mockOrder))
                .thenReturn(TestUtility.getMockUserNoEmp());
        BigDecimal actualResponse =
                discountService.getPriceAfterDiscount(mockOrder);
        assertEquals(new BigDecimal(915), actualResponse);
    }

    @Test
    void getPriceAfterDiscountForNonEmpNewUserTest(){
        Order mockOrder = TestUtility.getMockOrder();
        when(userService.getUser(mockOrder))
                .thenReturn(TestUtility.getMockNewUserNoEmp());
        BigDecimal actualResponse =
                discountService.getPriceAfterDiscount(mockOrder);
        assertEquals(new BigDecimal(945), actualResponse);
    }
}