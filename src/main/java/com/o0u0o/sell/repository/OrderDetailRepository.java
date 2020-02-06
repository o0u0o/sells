package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/6 1:36 下午
 * @Descripton:
 **/
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    /**
     * 根据orderId查询
     * @param orderId 订单ID
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
