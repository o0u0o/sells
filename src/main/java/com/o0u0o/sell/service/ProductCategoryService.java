package com.o0u0o.sell.service;

import com.o0u0o.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/3 2:55 下午
 * @Descripton: 类目
 **/
public interface ProductCategoryService {

    /**
     * 查询一条类目
     * @param categoryId 分类ID
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查询所有类目 - 后台管理
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 通过类目集合查询
     * @param categoryTypeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    /**
     * 新增&更新
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
