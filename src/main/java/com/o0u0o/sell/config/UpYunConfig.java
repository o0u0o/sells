package com.o0u0o.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author aiuiot
 * @Date 2020/2/11 3:51 下午
 * @Descripton: 又拍云配置
 **/
@Component
@ConfigurationProperties("upyun")
@Data
public class UpYunConfig {

    private String bucketName;

    private String username;

    private String password;

    private String imageHost;
}
