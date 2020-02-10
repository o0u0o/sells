package com.o0u0o.sell.enums;

import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/2/6 12:45 下午
 * @Descripton: 响应码
 **/
@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    ERROR(1, "失败"),

    PRODUCT_NOT_EXIST(10, "商品不存在"),

    PRODUCT_STOCK_ERROR(11, "商品库存不正确"),

    ORDER_NOT_EXIST(12, "订单不存在"),

    ORDER_DETAIL_NOT_EXIST(13, "订单详情不存在")

    ;

    Integer code;

    String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}