package com.example.acmwwh.demo.strategy;

/**
 * 字符串处理反射枚举类
 *
 * @author acmwwh
 * @since 2023/6/20
 */
public enum StrHandlerClazzEnum {

    REPLACE(StrReplaceHandler.class),

    LOWER(StrLowerHandler.class);

    private final Class<? extends StrHandler> clazz;

    StrHandlerClazzEnum(Class<? extends StrHandler> clazz) {
        this.clazz = clazz;
    }

    public Class<? extends StrHandler> getHandler() {
        return this.clazz;
    }
}
