/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.PropertyRuleDef;
import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniForm;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniFormScope;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.MapValues;
import com.tcdng.unify.core.database.Entity;

/**
 * Edit property list object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EditPropertyList {

    private final AppletContext ctx;

    private final SweepingCommitPolicy sweepingCommitPolicy;

    private final PropertyRuleDef propertyRuleDef;

    private final Entity inst;

    private final BreadCrumbs breadCrumbs;

    private String childFkFieldName;

    private MiniForm inputForm;

    private String displayItemCounter;

    private String displayItemCounterClass;

    public EditPropertyList(AppletContext ctx, SweepingCommitPolicy sweepingCommitPolicy,
            PropertyRuleDef propertyRuleDef, Entity inst, BreadCrumbs breadCrumbs, String childFkFieldName) {
        this.ctx = ctx;
        this.sweepingCommitPolicy = sweepingCommitPolicy;
        this.propertyRuleDef = propertyRuleDef;
        this.inst = inst;
        this.breadCrumbs = breadCrumbs;
        this.childFkFieldName = childFkFieldName;
    }

    public String getMainTitle() {
        return breadCrumbs.getLastBreadCrumb().getTitle();
    }

    public String getSubTitle() {
        return breadCrumbs.getLastBreadCrumb().getSubTitle();
    }

    public BreadCrumbs getBreadCrumbs() {
        return breadCrumbs;
    }

    public AppletUtilities getAu() {
        return ctx.getAu();
    }

    public AppletContext getCtx() {
        return ctx;
    }

    public PropertyRuleDef getPropertyRuleDef() {
        return propertyRuleDef;
    }

    public EntityDef getEntityDef() {
        return propertyRuleDef.getEntityDef();
    }

    public MiniForm getInputForm() {
        return inputForm;
    }

    public void setInputForm(MiniForm inputForm) {
        this.inputForm = inputForm;
    }

    public String getDisplayItemCounter() {
        return displayItemCounter;
    }

    public void setDisplayItemCounter(String displayItemCounter) {
        this.displayItemCounter = displayItemCounter;
    }

    public String getDisplayItemCounterClass() {
        return displayItemCounterClass;
    }

    public void setDisplayItemCounterClass(String displayItemCounterClass) {
        this.displayItemCounterClass = displayItemCounterClass;
    }

    public void clearDisplayItem() {
        displayItemCounter = null;
        displayItemCounterClass = null;
    }

    public void loadPropertyList(FormContext ctx) throws UnifyException {
        MapValues propValues = ctx.getAu().getPropertyListValues(inst, childFkFieldName, propertyRuleDef);
        inputForm = new MiniForm(MiniFormScope.PROPERTY_LIST,
                new FormContext(ctx.getAppletContext(), ctx.getFormDef(), ctx.getFormSwitchOnChangeHandlers(), propValues),
                propertyRuleDef.getPropertyListDef(inst).getFormTabDef());
    }

    public void commitPropertyList() throws UnifyException {
        ctx.getAu().savePropertyListValues(sweepingCommitPolicy, inst, childFkFieldName, propertyRuleDef,
                (MapValues) inputForm.getFormBean());
    }
}
