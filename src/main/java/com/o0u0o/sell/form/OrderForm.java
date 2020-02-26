package com.o0u0o.sell.form;

import lombok.Data;
import javax.validation.constraints.NotEmpty;
/**
 * @Author aiuiot
 * @Date 2020/2/10 8:32 下午
 * @Descripton: 订单表单
 *
 * 升级改动：
 *  由 org.hibernate.validator.constraints.NotEmpty 改为 javax.validation.constraints.NotEmpty;
 *
 **/
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车
     */
    @NotEmpty(message = "购物车不能空")
    private String items;

}
