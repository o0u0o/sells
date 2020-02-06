package com.o0u0o.sell.enums;

import lombok.Getter;

/**
 * @Author aiuiot
 * @Date 2020/2/6 12:45 下午
 * @Descripton: 响应码
 **/
@Getter
public enum  ResponseEnum {

    SUCCESS(0, "成功"),
    ERROR(1, "失败")
    ;

    Integer code;

    String desc;

    ResponseEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
