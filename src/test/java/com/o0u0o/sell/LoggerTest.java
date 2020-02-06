package com.o0u0o.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author aiuiot
 * @Date 2020/1/31 4:54 下午
 * @Descripton: Logger测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    @Test
    public void test1(){
        String name = "o0u0o";
        String password = "123456";
        logger.debug("debug...");
        logger.info("info...");
        logger.info("name:{}, password{}", name, password);
        logger.error("error...");
    }
}
