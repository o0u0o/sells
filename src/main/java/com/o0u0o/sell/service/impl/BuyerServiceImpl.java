package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.dto.OrderDTO;
import com.o0u0o.sell.enums.ResultEnum;
import com.o0u0o.sell.exception.SellException;
import com.o0u0o.sell.service.BuyerService;
import com.o0u0o.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author aiuiot
 * @Date 2020/2/11 12:08 上午
 * @Descripton:
 **/
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    /**
     * 查询一个对象
     * @param openid 微信openId
     * @param orderId 订单ID
     * @return
     */
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    /**
     * 取消订单
     * @param openid 微信openId
     * @param orderId 订单ID
     * @return
     */
    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null){
            log.info("【取消订单】查不到该订单，orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId){
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null){
            return null;
        }
        //判断openID鉴别是否为本人
        if (orderDTO.getBuyerOpenid().equals(openid)){
            log.info("【查询订单】订单的 openid 不一致 openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
