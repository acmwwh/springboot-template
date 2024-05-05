package com.example.acmwwh.demo;

import com.example.acmwwh.demo.strategy.StrHandlerClazzEnum;
import com.example.acmwwh.demo.strategy.StrHandlerInstanceEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class HandlerEnumTest {

    static final String words = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Test
    void objTest() {

        String replaceWords = StrHandlerInstanceEnum.REPLACE.getHandler().handle(words);
        log.info("使用对象枚举方式替换后的值：{}", replaceWords);

        String lowerWords = StrHandlerInstanceEnum.LOWER.getHandler().handle(words);
        log.info("使用对象枚举方式小写后的值：{}", lowerWords);
    }

    @Test
    void classTest() throws Exception {

        String replaceWords = StrHandlerClazzEnum.REPLACE.getHandler().newInstance().handle(words);
        log.info("使用反射枚举方式替换后的值：{}", replaceWords);

        String lowerWords = StrHandlerClazzEnum.LOWER.getHandler().newInstance().handle(words);
        log.info("使用反射枚举方式小写后的值：{}", lowerWords);
    }
}
