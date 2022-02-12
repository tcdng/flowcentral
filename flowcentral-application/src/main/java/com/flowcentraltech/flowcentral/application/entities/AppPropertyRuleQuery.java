/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

/**
 * Application property rule query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppPropertyRuleQuery extends BaseApplicationEntityQuery<AppPropertyRule> {

    public AppPropertyRuleQuery() {
        super(AppPropertyRule.class);
    }

}
