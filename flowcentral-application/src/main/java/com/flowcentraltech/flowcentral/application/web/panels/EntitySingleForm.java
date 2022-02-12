/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.SingleForm;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;

/**
 * Entity single form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntitySingleForm extends AbstractForm {

    public enum UpdateType {
        SWITCH_ON_CHANGE,
        MAINTAIN_INST,
        NAV_BACK_TO_PREVIOUS,
        FORMACTION_ON_INST,
        UPDATE_INST
    }

    private SingleForm singleForm;

    private UpdateType updateType;

    public EntitySingleForm(FormContext ctx, BreadCrumbs breadCrumbs, String panelName, SingleFormBean bean) {
        super(ctx, breadCrumbs);
        singleForm = new SingleForm(ctx, panelName, bean);
    }

    public SingleForm getSingleForm() {
        return singleForm;
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }
    
    public void loadSingleFormBean() throws UnifyException {
        singleForm.getBean().load((Entity) getFormBean()); 
    }
    
    public void saveSingleFormBean() throws UnifyException {
        singleForm.getBean().save((Entity) getFormBean());
    }
}
