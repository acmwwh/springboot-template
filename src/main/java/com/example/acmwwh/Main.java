package com.example.acmwwh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author acmwwh
 * @since 2024/5/3
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(value = {"com.example.acmwwh.module.*.repository.mapper"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
