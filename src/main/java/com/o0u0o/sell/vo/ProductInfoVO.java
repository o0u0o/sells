package com.o0u0o.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author aiuiot
 * @Date 2020/2/5 5:12 下午
 * @Descripton: 商品详情
 **/
@Data
public class ProductInfoVO implements Serializable {

    private static final long serialVersionUID = -3379934944601962221L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;
}
