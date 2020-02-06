package com.o0u0o.sell.utils;

import java.util.Random;

/**
 * @Author aiuiot
 * @Date 2020/2/6 5:02 下午
 * @Descripton: 随机生成订单号
 **/
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间+随机数
     * 避免多线程生成重复订单
     * @return
     */
    public static synchronized String genUniqueKey(){
        Random random = new Random();

        //随机的位数是相同的 6位数
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
