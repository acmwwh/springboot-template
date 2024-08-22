package com.example.acmwwh.core.pipeline.base;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 状态执行结果枚举
 * 
 * @author linfan
 * @since 2024/08/21
 */
@RequiredArgsConstructor
@Getter
public enum StageProcessedResultEnum {
    /**
     * 幂等失败
     */
    IDEMPOTENT_FAIL(false),

    /**
     * 跳过所有操作
     */
    SKIP_ALL(true),

    /**
     * 业务失败
     */
    BUSINESS_FAIL(false),

    /**
     * 成功
     */
    SUCCESS(true);

    private final boolean isSuccess;
}
