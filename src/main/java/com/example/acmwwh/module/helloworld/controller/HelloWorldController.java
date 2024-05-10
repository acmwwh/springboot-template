package com.example.acmwwh.module.helloworld.controller;

import javax.annotation.Resource;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.acmwwh.core.param.ResponseResult;
import com.example.acmwwh.module.helloworld.model.dto.HelloWorldDTO;
import com.example.acmwwh.module.helloworld.service.HelloWorldService;

/**
 * the controller of hello-world
 *
 * @author acmwwh
 * @since 2024/5/3
 */
@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Resource
    private HelloWorldService helloWorldService;

    @GetMapping("/hi")
    public ResponseResult<String> sayHi() {

        return ResponseResult.success(helloWorldService.sayHi());
    }

    @PostMapping("/echo")
    public ResponseResult<String> echo(@RequestBody @Validated HelloWorldDTO dto) {

        return ResponseResult.success(helloWorldService.echo(dto.getEcho()));
    }

    @GetMapping("/get")
    public ResponseResult<HelloWorldDTO> get(@RequestParam("id") String id) {

        return ResponseResult.success(helloWorldService.get(id));
    }

    @PostMapping("/save")
    public ResponseResult<String> save(@RequestBody HelloWorldDTO bo) {

        helloWorldService.save(bo);
        return ResponseResult.success();
    }
}
