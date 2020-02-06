package com.o0u0o.sell.dto;

import lombok.Data;

/**
 * @Author aiuiot
 * @Date 2020/2/6 5:15 下午
 * @Descripton: 购物车
 **/
@Data
public class CartDTO {

    /** 商品ID. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
