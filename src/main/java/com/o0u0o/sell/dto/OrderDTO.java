package com.o0u0o.sell.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.o0u0o.sell.dataobject.OrderDetail;
import com.o0u0o.sell.enums.OrderStatusEnum;
import com.o0u0o.sell.enums.PayStatusEnum;
import com.o0u0o.sell.utils.serializer.Date2LongSerializer;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/6 2:15 下午
 * @Descripton: 订单数据传输对象
 **/
@Data
public class OrderDTO {

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

    /** 支付状态, 默认 0 未支付. */
    private Integer payStatus;

    /** 创建时间. */
    //@JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /** 更新时间 */
    //@JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;
}
