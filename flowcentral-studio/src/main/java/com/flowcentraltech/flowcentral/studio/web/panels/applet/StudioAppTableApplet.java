/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.entities.AppTable;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.web.panels.TableEditorPage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Studio application table applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioAppTableApplet extends StudioAppComponentApplet {

    private TableEditorPage tableEditorPage;

    public StudioAppTableApplet(StudioModuleService sms, AppletUtilities au, String pathVariable,
            String applicationName, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(sms, au, pathVariable, applicationName, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
    }

    public TableEditorPage getTableEditorPage() {
        return tableEditorPage;
    }

    public void designChildItem(int childTabIndex) throws UnifyException {
        currFormTabDef = form.getFormDef().getFormTabDef(childTabIndex);
        AppTable appTable = (AppTable) form.getFormBean();
        Object id = appTable.getId();
        String subTitle = appTable.getDescription();
        saveCurrentForm();
        tableEditorPage = constructNewTableEditorPage(appTable.getEntity(), id, subTitle);
        tableEditorPage.newEditor();
        viewMode = ViewMode.CUSTOM_PAGE;
    }

    private TableEditorPage constructNewTableEditorPage(String entityName, Object id, String subTitle)
            throws UnifyException {
        BreadCrumbs breadCrumbs = form.getBreadCrumbs().advance();
        EntityDef entityDef = getEntityDef(entityName);
        breadCrumbs.setLastCrumbTitle(au.resolveSessionMessage("$m{tableeditor.tabledesigner}"));
        breadCrumbs.setLastCrumbSubTitle(subTitle);
        return new TableEditorPage(au, entityDef, id, breadCrumbs);
    }

}
