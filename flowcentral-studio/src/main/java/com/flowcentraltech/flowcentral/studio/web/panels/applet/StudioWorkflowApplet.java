/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.web.panels.WorkflowEditorPage;
import com.flowcentraltech.flowcentral.workflow.entities.Workflow;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Studio workflow applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioWorkflowApplet extends StudioAppComponentApplet {

    private WorkflowEditorPage workflowEditorPage;

    public StudioWorkflowApplet(StudioModuleService sms, AppletUtilities au, String pathVariable,
            String applicationName, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(sms, au, pathVariable, applicationName, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
    }

    public WorkflowEditorPage getWorkflowEditorPage() {
        return workflowEditorPage;
    }

    public void designChildItem(int childTabIndex) throws UnifyException {
        currFormTabDef = form.getFormDef().getFormTabDef(childTabIndex);
        Workflow workflow = (Workflow) form.getFormBean();
        Long workflowId = workflow.getId();
        String subTitle = workflow.getDescription();
        saveCurrentForm();
        workflowEditorPage = constructNewWorkflowEditorPage(workflow.getEntity(), workflowId, subTitle);
        workflowEditorPage.newEditor();
        viewMode = ViewMode.CUSTOM_PAGE;
    }

    private WorkflowEditorPage constructNewWorkflowEditorPage(String entityName, Long workflowId, String subTitle)
            throws UnifyException {
        BreadCrumbs breadCrumbs = form.getBreadCrumbs().advance();
        EntityDef entityDef = getEntityDef(entityName);
        breadCrumbs.setLastCrumbTitle(au.resolveSessionMessage("$m{workfloweditor.workflowdesigner}"));
        breadCrumbs.setLastCrumbSubTitle(subTitle);
        return new WorkflowEditorPage(au, entityDef, workflowId, breadCrumbs);
    }

}
