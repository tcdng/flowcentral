/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.FormTabDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;

/**
 * Mini form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class MiniForm {

    private MiniFormScope scope;

    private FormContext ctx;

    private FormTabDef formTabDef;
    
    public MiniForm(MiniFormScope scope, FormContext ctx, FormTabDef formTabDef) {
        this.scope = scope;
        this.ctx = ctx;
        this.formTabDef = formTabDef;
    }

    public MiniFormScope getScope() {
        return scope;
    }

    public FormContext getCtx() {
        return ctx;
    }

    public FormTabDef getFormTabDef() {
        return formTabDef;
    }

    public boolean isAllocateTabIndex() {
        return scope.isMainForm();
    }

    public Object getFormBean() {
        return ctx.getInst();
    }
}
