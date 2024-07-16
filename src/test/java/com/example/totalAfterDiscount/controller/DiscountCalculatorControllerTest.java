package com.example.totalAfterDiscount.controller;


import com.example.totalAfterDiscount.model.Order;
import com.example.totalAfterDiscount.service.DiscountService;
import com.example.totalAfterDiscount.testUtility.TestUtility;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiscountCalculatorControllerTest {

    @InjectMocks
    private DiscountCalculatorController discountCalculatorController;
    @Mock
    private DiscountService discountService;

    @Test
    void getPriceAfterDiscountTest(){
        Order mockOrder = TestUtility.getMockOrder();
        when(discountService.getPriceAfterDiscount(mockOrder))
                .thenReturn(getExpectedDiscountedPrice());

        BigDecimal actualResponse =
                discountCalculatorController.getPriceAfterDiscount(mockOrder);
        assertEquals(getExpectedDiscountedPrice(), actualResponse);

    }

    private BigDecimal getExpectedDiscountedPrice() {
        return new BigDecimal(23423);
    }


}
