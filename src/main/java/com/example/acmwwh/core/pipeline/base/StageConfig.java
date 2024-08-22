package com.example.acmwwh.core.pipeline.base;

import java.lang.annotation.*;

import org.springframework.stereotype.Component;

/**
 * 自定义注解，用于标记每个 Stage 方法类
 * 
 * @author linfan
 * @since 2024/08/21
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StageConfig {
    String name();
}
