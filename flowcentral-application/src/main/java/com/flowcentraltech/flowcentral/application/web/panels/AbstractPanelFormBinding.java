/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import java.util.List;

import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.flowcentraltech.flowcentral.common.data.FormMessage;
import com.tcdng.unify.core.UnifyException;

/**
 * Abstract base class for form binding objects.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractPanelFormBinding {

    private final FormContext ctx;

    private final SweepingCommitPolicy sweepingCommitPolicy;

    private final String tabName;

    public AbstractPanelFormBinding(FormContext ctx, SweepingCommitPolicy sweepingCommitPolicy, String tabName) {
        this.ctx = ctx;
        this.sweepingCommitPolicy = sweepingCommitPolicy;
        this.tabName = tabName;
    }

    public FormContext getFormCtx() {
        return ctx;
    }

    public AppletContext getAppletCtx() {
        return ctx.getAppletContext();
    }

    public SweepingCommitPolicy getSweepingCommitPolicy() {
        return sweepingCommitPolicy;
    }

    public String getTabName() {
        return tabName;
    }

    public List<FormMessage> getMessages() throws UnifyException {
        return ctx.getReviewMessages(tabName);
    }
}
