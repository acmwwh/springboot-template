package com.example.acmwwh.core;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author acmwwh
 * @since 2024/5/3
 */
@SpringBootTest
@Slf4j
class LoggerTest {

    @Test
    void testLog() {
        log.info("This is a info log");
        log.warn("This is a warn log");
        log.error("This is a error log");
    }
}
