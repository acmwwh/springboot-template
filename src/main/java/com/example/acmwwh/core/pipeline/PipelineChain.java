package com.example.acmwwh.core.pipeline;

import java.util.List;
import java.util.Map;

/**
 * @author linfan
 * @since 2024/08/21
 */
public interface PipelineChain {

    Map<String, List<String>> pipeLineBizExecuteChain();
}
