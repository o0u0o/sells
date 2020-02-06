package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/3 2:00 下午
 * @Descripton: 商品类目
 * JpaRepository<ProductCategory, Integer> 主键为int类型
 **/
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

    /**
     * 根据类目编号数组查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

}
