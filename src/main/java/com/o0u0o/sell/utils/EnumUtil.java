package com.o0u0o.sell.utils;

import com.o0u0o.sell.enums.CodeEnum;

/**
 * @Author aiuiot
 * @Date 2020/3/3 12:47 上午
 * @Descripton: 枚举工具类
 **/
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())){
                return each;
            }
        }
        return null;
    }

}
