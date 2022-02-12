/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.SingleFormBean;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Single form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SingleForm {

    private final FormContext ctx;
    
    private final String panelName;
    
    private final SingleFormBean bean;
    
    private ValueStore beanValueStore;
    
    public SingleForm(FormContext ctx, String panelName, SingleFormBean bean) {
        this.ctx = ctx;
        this.panelName = panelName;
        this.bean = bean;
    }

    public FormContext getCtx() {
        return ctx;
    }

    public Object getFormBean() {
        return ctx.getInst();
    }

    public String getPanelName() {
        return panelName;
    }

    public SingleFormBean getBean() {
        return bean;
    }

    public ValueStore getBeanValueStore() {
        if (beanValueStore == null) {
            beanValueStore = new BeanValueStore(bean);
        }
        
        return beanValueStore;
    }
}
