/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.tcdng.unify.core.task.TaskSetup;

/**
 * Entity list action result
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityListActionResult {

    private TaskSetup resultTaskSetup;

    private String resultTaskCaption;

    private Object result;

    public EntityListActionResult(EntityListActionContext ctx, TaskSetup resultTaskSetup, String resultTaskCaption) {
        this.resultTaskSetup = resultTaskSetup;
        this.resultTaskCaption = resultTaskCaption;
        this.result = ctx.getResult();
    }

    public EntityListActionResult(EntityListActionContext ctx) {
        this.result = ctx.getResult();
    }

    public TaskSetup getResultTaskSetup() {
        return resultTaskSetup;
    }

    public String getResultTaskCaption() {
        return resultTaskCaption;
    }

    public Object getResult() {
        return result;
    }

    public boolean isWithTaskResult() {
        return resultTaskSetup != null;
    }
}
