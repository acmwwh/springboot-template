package com.example.acmwwh.module.helloworld.service;

import com.example.acmwwh.module.helloworld.model.dto.HelloWorldDTO;

/**
 * the service of hello-world
 *
 * @author acmwwh
 * @since 2024/5/3
 */
public interface HelloWorldService {

    String sayHi();

    String echo(String echo);

    HelloWorldDTO get(String id);

    void save(HelloWorldDTO dto);
}
