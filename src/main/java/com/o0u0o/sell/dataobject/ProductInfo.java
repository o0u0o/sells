package com.o0u0o.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.o0u0o.sell.enums.ProductStatusEnum;
import com.o0u0o.sell.utils.EnumUtil;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author aiuiot
 * @Date 2020/2/4 6:02 下午
 * @Descripton: 商品信息
 * 注解 @DynamicUpdate 作用 自动跟新时间
 **/
@Entity
@Data
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -1853630273949744924L;

    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 商品描述. */
    private String productDescription;

    /** 商品小图. */
    private String productIcon;

    /** 商品状态 0-正常 1-下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

    /**
     * 图片链接加host拼接成完整 url
     * @param host
     * @return
     */
    public ProductInfo addImageHost(String host) {
        if (productIcon.startsWith("//")||productIcon.startsWith("http")){
            return this;
        }

        if (!host.startsWith("http")){
            host = "//" + host;
        }

        if (!host.endsWith("/")){
            host = host + "/";
        }

        productIcon = host + productIcon;
        return this;
    }
}
