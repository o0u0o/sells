package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.exception.SellException;
import com.o0u0o.sell.service.SecKillService;
import com.o0u0o.sell.utils.KeyUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author aiuiot
 * @Date 2020/3/29 10:30 上午
 * @Descripton: 秒杀服务实现
 **/
@Service
public class SecKillServiceImpl implements SecKillService {

    /**
     * 国庆活动，皮蛋粥特价，限量 100000 份
     */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    /** 模拟多个表，商品信息表、库存表、秒杀成功订单表 */
    static {
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();

        products.put("123456", 100000);
        stock.put("123456", 100000);
    };

    /**
     * 查询方法
     * @param productId 商品ID
     * @return
     */
    private String queryMap(String productId){
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                + " 还剩："+stock.get(productId) + "份"
                + " 该商品成功下单用户数目：" + orders.size() + "人";
    }

    /**
     * 查询秒杀商品
     * @param productId
     * @return
     */
    @Override
    public String querySecKillProductInfo(String productId) {
        return this.queryMap(productId);
    }


    /**
     * 秒杀的核心代码
     * @param productId 商品ID
     * 分布式锁
     * 如何解决"超卖" 问题？？？
     * 1、为防止并发导致的"超卖" 只加上 synchronized 同步锁
     *    - 解决了"超卖问题" 访问慢（单线程）
     *    - 无法做到细粒度控制
     *    - 只适合单点的情况，不适合集群方案
     *
     * 2、基于Redis 分布式锁
     */
    @Override
    public synchronized void orderProductMockDiffUser(String productId) {
        //1、查询该商品库存，为 0 则活动结束
        int stockNum = stock.get(productId);
        if (stockNum == 0){
            throw new SellException(100, "秒杀活动结束");
        }

        //2、下单 随机生产orderId
        orders.put(KeyUtil.genUniqueKey(), productId);

        //3、减库存 库存 -1
        stockNum = stockNum - 1;
        try {
            //模拟业务处理时间
            Thread.sleep(100);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        stock.put(productId, stockNum);
    }

}
