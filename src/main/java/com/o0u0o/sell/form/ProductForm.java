package com.o0u0o.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author aiuiot
 * @Date 2020/3/29 2:24 下午
 * @Descripton: 商品表单
 **/
@Data
public class ProductForm {

    /** 产品名 */
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
