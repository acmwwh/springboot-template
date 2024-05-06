package com.example.acmwwh.common.api;

/**
 * @author acmwwh
 * @since 2024/5/6
 */
public interface IndexedEnum<E extends Enum<E>, T> {

    T getIndex();
}
