package com.example.acmwwh.module.helloworld.controller;

import com.example.acmwwh.core.param.ResponseResult;
import com.example.acmwwh.module.helloworld.model.dto.EchoDTO;
import com.example.acmwwh.module.helloworld.service.HelloWorldService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
    public ResponseResult<String> echo(@RequestBody @Validated EchoDTO dto) {

        return ResponseResult.success(helloWorldService.echo(dto.getEcho()));
    }
}
