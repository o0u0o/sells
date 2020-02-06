package com.o0u0o.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author aiuiot
 * @Date 2020/2/5 1:35 下午
 * @Descripton: 订单主表
 **/
@Entity
@Data
public class OrderMaster {

    @Id
    @GeneratedValue
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认未支付. */
    private Integer payStatus;
}
