package com.example.acmwwh.core.pipeline.impl;

import com.example.acmwwh.core.pipeline.AbstractStageIdempotent;
import com.example.acmwwh.core.pipeline.base.StageConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 
 * @author linfan 
 * @since 2024/08/21
 */
@StageConfig(name = "CreateCardHistory")
@RequiredArgsConstructor
@Slf4j
public class CreateCardHistory extends AbstractStageIdempotent<IdleUserRightsContext> {
    @Override
    protected IdleUserRightsContext executeBusinessLogic(IdleUserRightsContext context) {
        return context;
    }

    @Override
    protected boolean getMark(String key, IdleUserRightsContext context) {
        return false;
    }

    @Override
    protected boolean marked(String key, IdleUserRightsContext context) {
        return false;
    }

    @Override
    public String getIdempotentKey(IdleUserRightsContext context) {
        return null;
    }

    @Override
    public String genIdempotentKey(String appName, String simpleName, String idempotentKey) {
        return null;
    }
}
