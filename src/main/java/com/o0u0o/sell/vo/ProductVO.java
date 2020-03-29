package com.o0u0o.sell.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author aiuiot
 * @Date 2020/2/5 5:08 下午
 * @Descripton: 商品VO(包含类目)
 **/
@Data
public class ProductVO implements Serializable {

    private static final long serialVersionUID = -7759873034249192976L;

    /** 渲染给前端展示为 "name" */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
