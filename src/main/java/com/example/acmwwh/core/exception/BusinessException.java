package com.example.acmwwh.core.exception;

/**
 * business exception
 *
 * @author acmwwh
 * @since 2024/5/3
 */
public class BusinessException extends RuntimeException {

    public BusinessException() {}

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}
