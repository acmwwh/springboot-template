package com.example.acmwwh.core.pipeline.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.acmwwh.core.pipeline.PipelineChain;

/**
 * 
 * 
 * @author linfan
 * @since 2024/08/21
 */
@Component
public class BizPipelineChain implements PipelineChain {
    @Override
    public Map<String, List<String>> pipeLineBizExecuteChain() {
        return new HashMap<String, List<String>>() {
            {
                put("IMLConsumeQuotaPipeline", Arrays.asList(
                    // 创建权益卡
                    "CreateCard",
                    // 创建流水记录
                    "CreateCardHistory",
                    // ......
                    "其他操作"));
            }
        };
    }
}
