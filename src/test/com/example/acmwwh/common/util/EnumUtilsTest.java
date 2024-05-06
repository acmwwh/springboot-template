package com.example.acmwwh.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.acmwwh.common.api.IndexedEnum;

/**
 * @author acmwwh
 * @since 2024/5/6
 */
@SpringBootTest
@Slf4j
class EnumUtilsTest {

    @AllArgsConstructor
    @Getter
    private enum TestEnum implements IndexedEnum<TestEnum, Integer> {
        A(1);

        private final Integer index;
    }

    @Test
    void ofTest() {

        assertEquals(TestEnum.A, EnumUtils.of(TestEnum.class, 1));
        assertThrows(IllegalArgumentException.class, () -> EnumUtils.of(TestEnum.class, 0));
    }
}
