package com.o0u0o.sell.service;

import com.o0u0o.sell.dataobject.ProductInfo;
import com.o0u0o.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/4 6:18 下午
 * @Descripton: 商品信息
 **/
public interface ProductInfoService {
    /**
     * 查询一件商品
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询上架的商品
     * @return
     */
    List<ProductInfo> findUpAll();

    /**
     * 查询所有商品
     * @param pageable
     * @return
     */
    Page<ProductInfo> findAll(Pageable pageable);

    /**
     * 保存&更新
     * @param productInfo
     * @return
     */
    ProductInfo save(ProductInfo productInfo);

    /**
     * 加库存
     * @param cartDTOList
     */
     void increaseStock(List<CartDTO> cartDTOList);


    /**
     * 减库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);

    /**
     * 上架商品
     * @param productId 商品ID
     */
    ProductInfo onSale(String productId);

    /**
     * 下架ID
     * @param productId 商品ID
     * @return
     */
    ProductInfo offSale(String productId);


}
