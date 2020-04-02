package com.o0u0o.sell.controller;

import com.o0u0o.sell.dataobject.ProductCategory;
import com.o0u0o.sell.dataobject.ProductInfo;
import com.o0u0o.sell.service.ProductCategoryService;
import com.o0u0o.sell.service.ProductInfoService;
import com.o0u0o.sell.vo.ProductInfoVO;
import com.o0u0o.sell.vo.ProductVO;
import com.o0u0o.sell.vo.ResultVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author aiuiot
 * @Date 2020/2/5 4:54 下午
 * @Descripton: 买家商品接口
 **/
@RestController
@RequestMapping("/buyer/product")
public class BuyerProductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService categoryService;

    /**
     *
     * @return
     */
    @GetMapping("/list")
    //@Cacheable(cacheNames = "sells_product", key = "product_list")
    //@Cacheable(cacheNames = "sells_product", key = "123")
    //@Cacheable(cacheNames = "sells_product", key = "#sellerId", condition = "#sellerId > 3", unless = "#result.getCode() != 0")
    public ResultVo list(){
        //1.查询所有上架的商品
        List<ProductInfo> productInfoList = productInfoService.findUpAll();
        
        //2.查询类目（一次性查询 性能提升） 查询出类目列表
        List<Integer> categoryTypeList = productInfoList.stream()
                .map(e -> e.getCategoryType())
                .collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        //3.数据拼装
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory : productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo : productInfoList) {
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo, productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }

        return  ResultVo.success(productVOList);
    }

}
