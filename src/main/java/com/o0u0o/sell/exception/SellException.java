package com.o0u0o.sell.exception;

import com.o0u0o.sell.enums.ResultEnum;

/**
 * @Author aiuiot
 * @Date 2020/2/6 4:48 下午
 * @Descripton: 自定义异常
 **/
public class SellException extends RuntimeException{

    private Integer code;


    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
