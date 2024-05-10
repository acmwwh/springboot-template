package com.example.acmwwh.module.helloworld.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.acmwwh.module.helloworld.model.dto.HelloWorldDTO;
import com.example.acmwwh.module.helloworld.repository.HelloWorldRepo;
import com.example.acmwwh.module.helloworld.service.HelloWorldService;

/**
 * the implement of hello-world service
 *
 * @author acmwwh
 * @since 2024/5/3
 */
@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Resource
    private HelloWorldRepo helloWorldRepo;

    @Override
    public String sayHi() {
        return "Hi";
    }

    @Override
    public String echo(String echo) {
        return echo;
    }

    @Override
    public HelloWorldDTO get(String id) {
        return helloWorldRepo.get(id);
    }

    @Override
    public void save(HelloWorldDTO bo) {
        helloWorldRepo.save(bo);
    }
}
