package com.example.acmwwh.module.helloworld.repository;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.acmwwh.module.helloworld.model.dto.HelloWorldDTO;
import com.example.acmwwh.module.helloworld.repository.mapper.HelloWorldMapper;

/**
 * HelloWorld仓储类
 * 
 * @author acmwwh
 * @since 2024/5/7
 */
@Repository
public class HelloWorldRepo {

    @Resource
    private HelloWorldMapper helloWorldMapper;

    public HelloWorldDTO get(String id) {

        return helloWorldMapper.selectById(id);
    }

    public void save(HelloWorldDTO bo) {

        if (null == helloWorldMapper.selectById(bo.getId())) {
            helloWorldMapper.insert(bo);
        } else {
            helloWorldMapper.updateById(bo);
        }
    }
}
