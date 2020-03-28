package com.o0u0o.sell.service.impl;

import com.o0u0o.sell.dataobject.ProductInfo;
import com.o0u0o.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoServiceImplTest {

    @Autowired
    private ProductInfoServiceImpl productInfoService;

    @Test
    public void findOne() {
        ProductInfo result = productInfoService.findOne("123456");
        Assert.assertEquals("123456", result.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> result = productInfoService.findUpAll();
        Assert.assertNotEquals(0, result.size());
    }

    @Test
    public void findAll() throws Exception{
        PageRequest request = PageRequest.of(0, 2);
        Page<ProductInfo> productInfos = productInfoService.findAll(request);
        //System.out.println(productInfos.getTotalElements());
        Assert.assertNotEquals(0, productInfos.getTotalElements());
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123459");
        productInfo.setCategoryType(2);
        productInfo.setProductName("四川城口老腊肉");
        productInfo.setProductDescription("特别好吃");
        productInfo.setProductIcon("http://www.o0u0o.com");
        productInfo.setProductStock(100);
        productInfo.setProductPrice(new BigDecimal(43));
        productInfo.setProductStatus(ProductStatusEnum.UP.getCode());
        ProductInfo save = productInfoService.save(productInfo);
        Assert.assertNotNull(save);
    }
}