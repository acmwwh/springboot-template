package com.example.acmwwh.demo.strategy;

import com.example.acmwwh.core.exception.BusinessException;

import java.util.Objects;

/**
 * 字符串处理抽象类
 *
 * @author acmwwh
 * @since 2023/6/20
 */
public abstract class StrAbstractHandler implements StrHandler {

    @Override
    public String handle(String str) {
        if (Objects.isNull(str)) {
            throw new BusinessException("string cant be null");
        }
        return doHandler(str);
    }

    protected abstract String doHandler(String str);
}
