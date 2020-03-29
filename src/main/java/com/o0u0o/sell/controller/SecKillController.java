package com.o0u0o.sell.controller;

import com.o0u0o.sell.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author aiuiot
 * @Date 2020/3/29 10:21 上午
 * @Descripton: 秒杀接口
 *
 * 分布式锁相关内容
 * 演示 synchronized 处理并发
 *
 **/
@RestController
@RequestMapping("/skill")
@Slf4j
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId 秒杀商品ID
     * @return
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId){
        return secKillService.querySecKillProductInfo(productId);
    }

    /**
     * 秒杀， 如果没有抢到 获得"哎哟喂，xxxxx"， 抢到了会返回剩余的库存量
     * @param productId
     * @return
     */
    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId){
        log.info("@skill request, productId:" + productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductInfo(productId);
    }
}
