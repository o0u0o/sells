package com.o0u0o.sell.service.impl;

import com.lly835.bestpay.enums.BestPayTypeEnum;
import com.lly835.bestpay.model.PayRequest;
import com.lly835.bestpay.model.PayResponse;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.o0u0o.sell.dto.OrderDTO;
import com.o0u0o.sell.service.PayService;
import com.o0u0o.sell.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author aiuiot
 * @Date 2020/2/11 9:31 下午
 * @Descripton:
 **/
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    private static final String ORDER_NAME = "微信点餐订单";

    @Autowired
    private BestPayServiceImpl bestPayService; //哈哈

    /**
     * 发起支付
     * 1、设置配置
     * @param orderDTO
     */
    @Override
    public void create(OrderDTO orderDTO) {
        PayRequest payRequest = new PayRequest();
        payRequest.setOpenid(orderDTO.getBuyerOpenid());
        payRequest.setOrderAmount(orderDTO.getOrderAmount().doubleValue());
        payRequest.setOrderId(orderDTO.getOrderId());
        payRequest.setOrderName(ORDER_NAME);
        payRequest.setPayTypeEnum(BestPayTypeEnum.WXPAY_H5);
        log.info("【微信支付】request={}", JsonUtil.toJson(payRequest) );

        PayResponse payResponse = bestPayService.pay(payRequest);
        log.info("【微信支付response】={}", JsonUtil.toJson(payResponse));
    }
}
