package com.o0u0o.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author aiuiot
 * @Date 2020/2/6 1:25 下午
 * @Descripton: 订单详情
 **/
@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    /** 订单ID. */
    private String orderId;

    /** 商品ID */
    private String productId;

    /** 商品名 */
    private String productName;

    /** 商品单价 */
    private BigDecimal productPrice;

    /** 商品数量 */
    private Integer productQuantity;

    /** 商品小图 */
    private String productIcon;
}
