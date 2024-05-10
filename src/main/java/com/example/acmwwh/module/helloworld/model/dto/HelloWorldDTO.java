package com.example.acmwwh.module.helloworld.model.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.Data;

import org.hibernate.validator.constraints.Length;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * the request of echo
 *
 * @author acmwwh
 * @since 2024/5/3
 */
@TableName("hello_world")
@Data
public class HelloWorldDTO implements Serializable {

    @NotNull(message = "The ID of request should not be null")
    private String id;

    @NotNull(message = "Echo cannot be null")
    @Length(max = 64, message = "Echo cannot be longer than 64 characters")
    private String echo;
}
