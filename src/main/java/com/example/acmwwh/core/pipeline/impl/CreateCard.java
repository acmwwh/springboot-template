package com.example.acmwwh.core.pipeline.impl;

import com.example.acmwwh.core.pipeline.AbstractStageIdempotent;
import com.example.acmwwh.core.pipeline.base.StageProcessedResultEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.acmwwh.core.pipeline.base.StageConfig;

/**
 * 
 * 
 * @author linfan
 * @since 2024/08/21
 */
@StageConfig(name = "CreateCard")
@RequiredArgsConstructor
@Slf4j
public class CreateCard extends AbstractStageIdempotent<IdleUserRightsContext> {

    private final IdleUserRightsService userRightsService;

    @Override
    protected IdleUserRightsContext executeBusinessLogic(IdleUserRightsContext context) {
        String card = context.getCard();
        Long cardId = userRightsService.createCard(card);
        context.setResult(null == cardId ? StageProcessedResultEnum.BUSINESS_FAIL : StageProcessedResultEnum.SUCCESS);
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
