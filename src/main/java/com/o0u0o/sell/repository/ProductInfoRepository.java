package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/4 6:08 下午
 * @Descripton: 商品信息
 **/
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    /**
     * 查询上架的的商品
     * @param productStatus 状态 0-正常 1-下架
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
