package com.example.acmwwh.core.pipeline;

import lombok.extern.slf4j.Slf4j;

import com.example.acmwwh.core.pipeline.base.BasePipelineContext;
import com.example.acmwwh.core.pipeline.base.StageProcessedResultEnum;
import com.example.acmwwh.core.pipeline.base.api.Idempotent;
import com.example.acmwwh.core.pipeline.base.api.Stage;

/**
 * 幂等模版类，用于在Stage方法执行的前后加上幂等的校验
 * 
 * @author linfan
 * @since 2024/08/21
 */
@Slf4j
public abstract class AbstractStageIdempotent<T extends BasePipelineContext> implements Stage<T>, Idempotent<T> {
    public static final String APP_NAME = "DEFAULT";

    /**
     * 提供一个用于子类处理业务逻辑的入口
     * 
     * @param context
     *            上下文
     * @return 执行结果
     */
    protected abstract T executeBusinessLogic(T context);

    public T execute(T context) {
        // 拿到当前执行的Stage名称
        String simpleName = this.getClass().getSimpleName();
        String idempotentKey = getIdempotentKey(context);
        String key = genIdempotentKey(APP_NAME, simpleName, idempotentKey);
        try {
            // 如果已经处理过，则无需执行业务逻辑，直接跳过当前流程
            if (idempotentKey != null && getMark(key, context)) {
                log.info(simpleName + " is already processed, the idempotent key:{}", key);
                return context;
            }
            // 执行业务逻辑
            context = executeBusinessLogic(context);
            // 标记为处理过（仅当业务执行成功时）
            if (idempotentKey != null && context.getResult() != null && context.getResult().isSuccess()) {
                if (!marked(key, context)) {
                    // 执行失败，则抛出异常
                    log.error(simpleName + " marked error, the idempotent key:{}", key);
                    context.setResult(StageProcessedResultEnum.IDEMPOTENT_FAIL);
                }
                log.info(simpleName + " execute success, marked idempotent key:{}", key);
            }
        } catch (Exception e) {
            log.error(simpleName + " execute error, the idempotent key:{}, context:{}", key, e, context);
            context.setResult(StageProcessedResultEnum.IDEMPOTENT_FAIL);
        }
        return context;
    }

    /**
     * 检查是否存在标记值
     * 
     * @param key
     *            幂等key
     * @return 是否存在
     */
    protected abstract boolean getMark(String key, T context);

    /**
     * 标记
     * 
     * @param key
     *            幂等key
     * @return 标记结果
     */
    protected abstract boolean marked(String key, T context);
}
