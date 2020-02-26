package com.o0u0o.sell.controller;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.o0u0o.sell.dto.OrderDTO;
import com.o0u0o.sell.enums.ResultEnum;
import com.o0u0o.sell.exception.SellException;
import com.o0u0o.sell.service.OrderService;
import com.o0u0o.sell.service.PayService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author aiuiot
 * @Date 2020/2/11 9:25 下午
 * @Descripton: 支付接口
 **/
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PayService payService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl")String returnUrl){

        //1、查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }

        //2、发起支付


    }

}
