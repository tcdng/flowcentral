/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.configuration.constants.WorkflowStepType;
import com.flowcentraltech.flowcentral.studio.web.widgets.WorkflowEditor;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.panel.AbstractDialogPanel;

/**
 * Workflow step edit panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-wfstepeditpanel")
@UplBinding("web/studio/upl/wfstepeditpanel.upl")
public class WfStepEditPanel extends AbstractDialogPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setDisabled("frmName", true);
        setDisabled("frmNextStepName", true);
        setDisabled("frmAltNextStepName", true);
        setDisabled("frmType", true);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        WorkflowEditor workflowEditor = getValue(WorkflowEditor.class);
        WorkflowStepType type = workflowEditor.getEditStep() != null ? workflowEditor.getEditStep().getType() : null;
        boolean isPolicy = type != null ? type.isPolicy() : false;
        boolean isUserAct =  type != null ? type.isUserInteractive() : false;
        setVisible("frmPolicy", isPolicy);
        setVisible("frmRule", isPolicy);
        setVisible("frmBinaryConditionName", WorkflowStepType.BINARY_ROUTING.equals(type));
        setVisible("frmActionType", WorkflowStepType.RECORD_ACTION.equals(type));
        setVisible("frmAppletName", isUserAct);
        setVisible("frmCriticalMinutes", isUserAct);
        setVisible("frmExpiryMinutes", isUserAct);
        setVisible("frmAudit", isUserAct);
        setVisible("frmBranchOnly", isUserAct);
        setVisible("frmIncludeForwarder", isUserAct);
        setVisible("frmReadOnlyConditionName", isUserAct);
    }

    @Action
    public void apply() throws UnifyException {
        commandHidePopup();
    }
}
