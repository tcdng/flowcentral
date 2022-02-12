/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.tcdng.unify.core.task.TaskSetup;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Entity action result
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityActionResult {

    private TaskSetup resultTaskSetup;

    private String resultTaskCaption;

    private String resultPath;

    private String successHint;

    private Object result;

    private boolean refreshMenu;

    private boolean closeView;

    private boolean closePage;

    public EntityActionResult(EntityActionContext ctx, TaskSetup resultTaskSetup, String resultTaskCaption) {
        this.resultTaskSetup = resultTaskSetup;
        this.resultTaskCaption = resultTaskCaption;
        this.result = ctx.getResult();
    }

    public EntityActionResult(EntityActionContext ctx, String resultPath) {
        this.resultPath = resultPath;
        this.result = ctx.getResult();
    }

    public EntityActionResult(EntityActionContext ctx) {
        this.result = ctx.getResult();
    }

    public EntityActionResult() {

    }

    public TaskSetup getResultTaskSetup() {
        return resultTaskSetup;
    }

    public String getResultTaskCaption() {
        return resultTaskCaption;
    }

    public String getResultPath() {
        return resultPath;
    }

    public Object getResult() {
        return result;
    }

    public boolean isWithTaskResult() {
        return resultTaskSetup != null;
    }

    public boolean isWithResultPath() {
        return !StringUtils.isBlank(resultPath);
    }

    public boolean isRefreshMenu() {
        return refreshMenu;
    }

    public void setRefreshMenu(boolean refreshMenu) {
        this.refreshMenu = refreshMenu;
    }

    public boolean isClosePage() {
        return closePage;
    }

    public void setClosePage(boolean closePage) {
        this.closePage = closePage;
    }

    public boolean isCloseView() {
        return closeView;
    }

    public void setCloseView(boolean closeView) {
        this.closeView = closeView;
    }

    public String getSuccessHint() {
        return successHint;
    }

    public void setSuccessHint(String successHint) {
        this.successHint = successHint;
    }
}
