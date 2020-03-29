package com.o0u0o.sell.service;

/**
 * @Author aiuiot
 * @Date 2020/3/29 10:28 上午
 * @Descripton: 秒杀服务接口
 **/
public interface SecKillService {

    /** 查询秒杀商品信息 */
    String querySecKillProductInfo(String productId);

    /**
     * 秒杀业务
     * @param productId 商品ID
     */
    void orderProductMockDiffUser(String productId);
}
