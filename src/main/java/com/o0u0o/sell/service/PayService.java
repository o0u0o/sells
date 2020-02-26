package com.o0u0o.sell.service;

import com.o0u0o.sell.dto.OrderDTO;

/**
 * @Author aiuiot
 * @Date 2020/2/11 9:30 下午
 * @Descripton: 支付服务接口
 **/
public interface PayService {

    void create(OrderDTO orderDTO);
}
