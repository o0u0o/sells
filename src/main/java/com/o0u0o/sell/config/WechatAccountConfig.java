package com.o0u0o.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author aiuiot
 * @Date 2020/2/11 1:08 下午
 * @Descripton: 微信账号配置
 **/
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {


    private String mpAppId;

    private String mpAppSecret;
}
