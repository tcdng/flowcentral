/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.panel.AbstractStandalonePanel;

/**
 * Entity parameter values panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityparamvaluespanel")
@UplBinding("web/application/upl/entityparamvaluespanel.upl")
public class EntityParamValuesPanel extends AbstractStandalonePanel {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        EntityParamValues entitySetValues = getEntityParamValues();
        setVisible("clearBtn", entitySetValues.isClearButtonVisible());
        setVisible("applyBtn", entitySetValues.isApplyButtonVisible());
    }

    @Action
    public void clear() throws UnifyException {
        getEntityParamValues().clear();
    }

    @Action
    public void apply() throws UnifyException {
        getEntityParamValues().save();
    }

    private EntityParamValues getEntityParamValues() throws UnifyException {
        return getValue(EntityParamValues.class);
    }
}
