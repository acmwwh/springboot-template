package com.example.acmwwh.module.helloworld.service.impl;

import com.example.acmwwh.module.helloworld.service.HelloWorldService;
import org.springframework.stereotype.Service;

/**
 * the implement of hello-world service
 *
 * @author acmwwh
 * @since 2024/5/3
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHi() {
        return "Hi";
    }

    @Override
    public String echo(String echo) {
        return echo;
    }
}
