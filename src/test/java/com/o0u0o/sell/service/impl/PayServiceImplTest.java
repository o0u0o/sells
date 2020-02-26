package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.dto.OrderDTO;
import com.o0u0o.sell.service.OrderService;
import com.o0u0o.sell.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class PayServiceImplTest {

    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @Test
    public void create() {
        OrderDTO orderDTO = orderService.findOne("1581324744150239124");
        payService.create(orderDTO);
    }
}