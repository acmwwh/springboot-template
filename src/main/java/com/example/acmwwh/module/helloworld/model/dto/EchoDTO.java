package com.example.acmwwh.module.helloworld.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * the request of echo
 *
 * @author acmwwh
 * @since 2024/5/3
 */
@Getter
@Setter
public class EchoDTO {

    @NotNull(message = "The ID of request should not be null")
    private String requestId;

    @NotNull(message = "Echo cannot be null")
    private String echo;
}
