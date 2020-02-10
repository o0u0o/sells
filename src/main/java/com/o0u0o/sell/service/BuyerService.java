package com.o0u0o.sell.service;

import com.o0u0o.sell.dto.OrderDTO;

/**
 * @Author aiuiot
 * @Date 2020/2/11 12:04 上午
 * @Descripton: 买家服务接口
 **/
public interface BuyerService {

    /**
     * 查询一个订单
     * @param openid 微信openId
     * @param orderId 订单ID
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);


    /**
     * 取消订单
     * @param openid 微信openId
     * @param orderId 订单ID
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
