/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Form listing.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormListing {

    private FormContext ctx;
    
    public FormListing(FormContext ctx) {
        this.ctx = ctx;
    }

    public FormContext getCtx() {
        return ctx;
    }

    public ValueStore getFormValueStore() {
        return ctx.getFormValueStore();
    }
    
    public String getListingGenerator() {
        return ctx.getFormDef().getListingGenerator();
    }
}
