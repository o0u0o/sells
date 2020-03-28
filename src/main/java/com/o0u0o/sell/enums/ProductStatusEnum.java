package com.o0u0o.sell.enums;

import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/2/4 6:24 下午
 * @Descripton: 商品状态枚举
 **/
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "上架"),

    DOWN(1, "下架");

    /** 状态码. */
    private Integer code;

    /** 消息. */
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
