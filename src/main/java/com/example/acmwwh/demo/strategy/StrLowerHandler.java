package com.example.acmwwh.demo.strategy;

/**
 * 字符串小写处理类
 *
 * @author acmwwh
 * @since 2023/6/20
 */
public class StrLowerHandler extends StrAbstractHandler {
    @Override
    protected String doHandler(String str) {
        return str.toLowerCase();
    }
}
