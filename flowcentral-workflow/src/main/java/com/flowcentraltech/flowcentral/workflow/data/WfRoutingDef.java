/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.data;

/**
 * Workflow routing definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfRoutingDef {

    private String name;

    private String description;

    private String conditionName;

    private String nextStepName;

    public WfRoutingDef(String name, String description, String conditionName, String nextStepName) {
        this.name = name;
        this.description = description;
        this.conditionName = conditionName;
        this.nextStepName = nextStepName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getNextStepName() {
        return nextStepName;
    }

    public String getCondition() {
        return conditionName;
    }

    public boolean isWithCondition() {
        return conditionName != null;
    }
}
