package com.example.acmwwh.demo.strategy;

/**
 * 字符串处理对象枚举类
 *
 * @author acmwwh
 * @since 2023/6/20
 */
public enum StrHandlerInstanceEnum {

    REPLACE(new StrReplaceHandler()),

    LOWER(new StrLowerHandler());

    private final StrHandler handler;

    StrHandlerInstanceEnum(StrHandler handler) {
        this.handler = handler;
    }

    public StrHandler getHandler() {
        return this.handler;
    }
}
