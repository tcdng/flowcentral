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
 * Entity set values panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entitysetvaluespanel")
@UplBinding("web/application/upl/entitysetvaluespanel.upl")
public class EntitySetValuesPanel extends AbstractStandalonePanel {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        EntitySetValues entitySetValues = getEntitySetValues();
        setVisible("clearBtn", entitySetValues.isClearButtonVisible());
        setVisible("applyBtn", entitySetValues.isApplyButtonVisible());
    }

    @Action
    public void clear() throws UnifyException {
        getEntitySetValues().clear();
    }

    @Action
    public void apply() throws UnifyException {
        getEntitySetValues().save();
    }

    private EntitySetValues getEntitySetValues() throws UnifyException {
        return getValue(EntitySetValues.class);
    }
}
