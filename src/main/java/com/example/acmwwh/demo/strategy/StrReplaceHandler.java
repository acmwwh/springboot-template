package com.example.acmwwh.demo.strategy;

/**
 * 字符串替换处理类
 *
 * @author acmwwh
 * @since 2023/6/20
 */
public class StrReplaceHandler extends StrAbstractHandler {
    @Override
    protected String doHandler(String str) {
        return str.replace("A", "@");
    }
}
