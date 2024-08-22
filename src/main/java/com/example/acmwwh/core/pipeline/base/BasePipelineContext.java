package com.example.acmwwh.core.pipeline.base;

import java.util.Map;

import lombok.Data;

/**
 * pipeline 基础上下文，用于保存管道处理的结果
 * 
 * @author linfan
 * @since 2024/08/21
 */
@Data
public class BasePipelineContext {

    /**
     * 拓展信息
     */
    private Map<String, String> extInfo;

    /**
     * 处理结果
     */
    private StageProcessedResultEnum result;
}
