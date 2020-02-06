package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author aiuiot
 * @Date 2020/2/6 1:33 下午
 * @Descripton:
 **/
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    /**
     * 根据买家openID查询
     * @param buyerOpenid 买家openID
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);


}
