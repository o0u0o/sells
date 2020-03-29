package com.o0u0o.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author aiuiot
 * @Date 2020/3/29 12:52 下午
 * @Descripton: Redis 分布式锁
 **/
@Component
@Slf4j
public class RedisLock {

    @Autowired
    private StringRedisTemplate redisTemplate;


    /**
     * 加锁 - 使用redis分布式锁
     * @param key   商品ID
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value){

        //如果可以锁住
        if (redisTemplate.opsForValue().setIfAbsent(key, value)){
            return true;
        }

        String currentValue = redisTemplate.opsForValue().get(key);
        //如果锁超时(时间小于当前时间) -防止死锁
        if (!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            //改判断 作用只让其中一个线程拿到锁
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }

        return false;
    }

    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value){
        try{
            //获取redis里的值
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                //删掉redis的值（解锁就是删掉redis的值）
                redisTemplate.opsForValue().getOperations().delete(value);
            }
        } catch (Exception e){
            log.error("【Redis分布式锁】解锁异常", e);
        }

    }

}
