package com.example.acmwwh.core.pipeline.base.api;

import com.example.acmwwh.core.pipeline.base.BasePipelineContext;

/**
 * 基本方法接口，封装了阶段执行业务逻辑
 * 
 * @author linfan
 * @since 2024/08/21
 */
public interface Stage<T extends BasePipelineContext> {

    /**
     * 执行当前阶段逻辑
     * 
     * @param context
     *            上下文
     * @return 上下文
     */
    T execute(T context);
}
