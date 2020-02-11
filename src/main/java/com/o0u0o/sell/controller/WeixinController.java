package com.o0u0o.sell.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author aiuiot
 * @Date 2020/2/11 9:27 上午
 * @Descripton: 微信接口DEMO
 **/
@RestController
@RequestMapping("/weixin")
@Slf4j
public class WeixinController {

    private static String APPID = "wxc19f4cd1f87ebf3c";
    private static String SECRET = "3bf784ecfb89a4c63c57976a26b2c63a";


    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入了auth方法");
        log.info("code={}", code);

        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + APPID + "&secret="+ SECRET +"&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        log.info("response={}", response);
    }
}
