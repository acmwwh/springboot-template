package com.example.acmwwh.core.pipeline.base.api;

import com.example.acmwwh.core.pipeline.base.BasePipelineContext;

/**
 * 幂等接口
 * 
 * @author linfan
 * @since 2024/08/21
 */
public interface Idempotent<T extends BasePipelineContext> {

    /**
     * 获取幂等key，返回null代表不需要幂等
     * 
     * @param context
     *            上下文
     * @return 幂等key
     */
    String getIdempotentKey(T context);

    /**
     * 生成幂等key
     * 
     * @param appName
     *            应用名
     * @param simpleName
     *            简类名
     * @param idempotentKey
     *            幂等键
     * @return 幂等键
     */
    String genIdempotentKey(String appName, String simpleName, String idempotentKey);
}
