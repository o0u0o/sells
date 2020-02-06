package com.o0u0o.sell.repository;

import com.o0u0o.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.Arrays;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    /**
     * 查询出一条数据
     */
    @Test
    public void findOneTest(){
        ProductCategory category = repository.findOne(1);
        System.out.println(category.toString());
    }

    /**
     * 新增一条数据
     * 注解 @Transactional 测试后回滚
     */
    @Test
    @Transactional
    public void saveTest(){
        ProductCategory productCategory = new ProductCategory("母婴用品",7);
        ProductCategory result = repository.save(productCategory);
        //断言，不为空
        Assert.assertNotNull(result);
    }

    /**
     * 更新内容
     */
    @Test
    public void updateTest(){
        ProductCategory category = repository.findOne(2);
        //category.setCategoryName("鞋靴箱包");
        category.setCategoryType(3);
        repository.save(category);
    }

    @Test
    public void findByCategoryTypeInTest(){
        List<Integer> list = Arrays.asList(2,3);
        List<ProductCategory> result = repository.findByCategoryTypeIn(list);
        //断言，结果不等于0
        Assert.assertNotEquals(0, result.size());
    }

}