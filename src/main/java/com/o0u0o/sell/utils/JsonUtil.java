package com.o0u0o.sell.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @Author aiuiot
 * @Date 2020/2/12 2:16 下午
 * @Descripton: json格式化
 **/
public class JsonUtil {


    /**
     * 将对象转为json格式
     * @param object
     * @return
     */
    public static String toJson(Object object){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
