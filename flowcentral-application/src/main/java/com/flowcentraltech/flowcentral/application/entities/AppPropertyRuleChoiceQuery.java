/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntityQuery;

/**
 * Application property rule choice query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppPropertyRuleChoiceQuery extends BaseConfigEntityQuery<AppPropertyRuleChoice> {

    public AppPropertyRuleChoiceQuery() {
        super(AppPropertyRuleChoice.class);
    }

    public AppPropertyRuleChoiceQuery appPropertyRuleId(Long appPropertyRuleId) {
        return (AppPropertyRuleChoiceQuery) addEquals("appPropertyRuleId", appPropertyRuleId);
    }
}
