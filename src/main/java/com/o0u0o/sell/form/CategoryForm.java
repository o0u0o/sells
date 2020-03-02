package com.o0u0o.sell.form;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author aiuiot
 * @Date 2020/3/2 9:34 下午
 * @Descripton: 分类表单
 **/
@Data
public class CategoryForm {

    /** 类目ID. */
    private Integer categoryId;

    /** 类目名称. */
    private String categoryName;

    /** 类型编号. */
    private Integer categoryType;
}
