/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.studio.web.widgets.WorkflowEditor;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Workflow editor page panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-workfloweditorpagepanel")
@UplBinding("web/studio/upl/workfloweditorpagepanel.upl")
public class WorkflowEditorPagePanel extends AbstractStudioEditorPagePanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        final boolean readOnly = isAppletContextReadOnly();
        WorkflowEditor workflowEditor = getWorkflowEditorPage().getWorkflowEditor();
        workflowEditor.setReadOnly(readOnly);
        if (!workflowEditor.isInitialized()) {
            workflowEditor.init(getWidgetByShortName("createStepPanel").getLongName(),
                    getWidgetByShortName("editStepPanel").getLongName(),
                    getWidgetByShortName("stepSetValuesPanel").getLongName(),
                    getWidgetByShortName("stepAlertsCrudPanel").getLongName(),
                    getWidgetByShortName("stepRoutingsCrudPanel").getLongName(),
                    getWidgetByShortName("stepUserActionsCrudPanel").getLongName());
        }

        boolean isEditable = !readOnly;
        setWidgetVisible("saveBtn", isEditable);
        setWidgetEditable("createStepPanel", isEditable);
        setWidgetEditable("editStepPanel", isEditable);
        setWidgetEditable("stepSetValuesPanel", isEditable);
        setWidgetEditable("stepAlertsCrudPanel", isEditable);
        setWidgetEditable("stepRoutingsCrudPanel", isEditable);
        setWidgetEditable("stepUserActionsCrudPanel", isEditable);
    }

    @Action
    public void createStep() throws UnifyException {
        getWorkflowEditorPage().getWorkflowEditor().createStep();
        commandHidePopup();
    }

    @Action
    public void updateStepDesign() throws UnifyException {
        getWorkflowEditorPage().getWorkflowEditor().updateStepDesign();
        commandHidePopup();
    }

    @Action
    public void saveDesign() throws UnifyException {
        WorkflowEditorPage workflowEditorPage = getWorkflowEditorPage();
        workflowEditorPage.commitDesign();
        hintUser("$m{studioworkflowapplet.workfloweditor.success.hint}", workflowEditorPage.getSubTitle());
    }

    @Action
    public void applySetValues() throws UnifyException {
        getWorkflowEditorPage().getWorkflowEditor().applySetValues();
        commandHidePopup();
    }

    @Action
    public void cancelSetValues() throws UnifyException {
        commandHidePopup();
    }

    private WorkflowEditorPage getWorkflowEditorPage() throws UnifyException {
        return getValue(WorkflowEditorPage.class);
    }
}
