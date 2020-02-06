package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("100100");
        orderDetail.setDetailId("1234567810");
        orderDetail.setProductIcon("http://xxxxx.jpg");
        orderDetail.setProductId("111112");
        orderDetail.setProductName("牛奶蛋卷");
        orderDetail.setProductPrice(new BigDecimal(5.3));
        orderDetail.setProductQuantity(2);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOrderId() {
        List<OrderDetail> result = repository.findByOrderId("100100");
        Assert.assertNotEquals(0, result.size());
    }
}