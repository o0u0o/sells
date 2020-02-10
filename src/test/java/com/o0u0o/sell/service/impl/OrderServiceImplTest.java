package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.dataobject.OrderDetail;
import com.o0u0o.sell.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    private final String ORDER_ID = "1581324744150239124";

    /**
     * 创建订单
     *
     */
    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("王焕枝");
        orderDTO.setBuyerAddress("贵州省贵阳市南明区");
        orderDTO.setBuyerPhone("13009791620");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123458");
        o1.setProductQuantity(1);


        // 2件城口老腊肉
        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123459");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("创建订单 result={}", result);
        Assert.assertNotNull(result);
    }

    /**
     * 查询单个订单
     * @throws Exception
     */
    @Test
    public void findOne() throws Exception {
        OrderDTO result = orderService.findOne(ORDER_ID);
        log.info("【查询单个订单】result{}", result);
        Assert.assertEquals(ORDER_ID, result.getOrderId());
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}