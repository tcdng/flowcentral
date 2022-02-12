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
 * Entity field sequence panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityfieldsequencepanel")
@UplBinding("web/application/upl/entityfieldsequencepanel.upl")
public class EntityFieldSequencePanel extends AbstractStandalonePanel {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        EntityFieldSequence entitySetValues = getEntityFieldSequence();
        setVisible("clearBtn", entitySetValues.isClearButtonVisible());
        setVisible("applyBtn", entitySetValues.isApplyButtonVisible());
    }

    @Action
    public void clear() throws UnifyException {
        getEntityFieldSequence().clear();
    }

    @Action
    public void apply() throws UnifyException {
        getEntityFieldSequence().save();
    }

    private EntityFieldSequence getEntityFieldSequence() throws UnifyException {
        return getValue(EntityFieldSequence.class);
    }
}
