package com.example.acmwwh.core.pipeline.impl;

import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;

/**
 * 
 * 
 * @author linfan
 * @since 2024/08/21
 */
@Component
@Slf4j
public class PipelineMain {

    @Resource
    private IdleIMLPipelineFactory idleIMLPipelineFactory;

    public Boolean consume() {

        IdleUserRightsContext context = new IdleUserRightsContext();

        log.info("IdleIMLimitWriteServiceImpl.consumeQuota start, context:{}", context);
        context = idleIMLPipelineFactory.execute(context, "IMLConsumeQuotaPipeline");
        log.info("IdleIMLimitWriteServiceImpl.consumeQuota end, context:{}, result:{}", context, context.getResult());

        return context.getResult().isSuccess();
    }
}
