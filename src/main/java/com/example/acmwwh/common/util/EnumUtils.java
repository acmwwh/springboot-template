package com.example.acmwwh.common.util;

import java.util.Arrays;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import com.example.acmwwh.common.api.IndexedEnum;

/**
 * 枚举工具类
 * 
 * @author acmwwh
 * @since 2024/5/6
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumUtils {

    public static <E extends Enum<E> & IndexedEnum<E, T>, T> E of(Class<E> enumType, T index) {

        return Arrays.stream(enumType.getEnumConstants()).filter(e -> e.getIndex().equals(index)).findAny()
            .orElseThrow(() -> new IllegalArgumentException("No enum constant " + enumType + "." + index));
    }
}
