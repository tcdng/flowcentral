/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.panel.AbstractStandalonePanel;

/**
 * Child panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-childpanel")
@UplBinding("web/application/upl/childpanel.upl")
public class ChildPanel extends AbstractStandalonePanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setWidgetEditable("childFormPanel", false);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        EntityChild entityChild = getEntityChild();
        boolean editMode = entityChild.isWithChild();
        setWidgetVisible("createBtn", !editMode && entityChild.isCreateButtonVisible());
        setWidgetVisible("editBtn", editMode && entityChild.isEditButtonVisible());
        setWidgetVisible("viewBtn", editMode && entityChild.isViewButtonVisible());
        setWidgetVisible("childFormPanel", editMode);
    }

    private EntityChild getEntityChild() throws UnifyException {
        return getValue(EntityChild.class);
    }
}
