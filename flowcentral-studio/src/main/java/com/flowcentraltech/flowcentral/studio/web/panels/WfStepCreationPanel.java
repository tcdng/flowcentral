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
import com.tcdng.unify.web.ui.widget.panel.AbstractDialogPanel;

/**
 * Workflow step creation panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-wfstepcreationpanel")
@UplBinding("web/studio/upl/wfstepcreationpanel.upl")
public class WfStepCreationPanel extends AbstractDialogPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setDisabled("frmType", true);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        WorkflowEditor workflowEditor = getValue(WorkflowEditor.class);
        WorkflowStepType type = workflowEditor.getEditStep() != null ? workflowEditor.getEditStep().getType() : null;
        boolean isPolicy = type != null ? type.isPolicy() : false;
        setVisible("frmPolicy", isPolicy);
        setVisible("frmRule", isPolicy);
        setVisible("frmBinaryConditionName", WorkflowStepType.BINARY_ROUTING.equals(type));
        setVisible("frmActionType", WorkflowStepType.RECORD_ACTION.equals(type));
        setVisible("frmAppletName", WorkflowStepType.USER_ACTION.equals(type));
        setVisible("frmReadOnlyConditionName", WorkflowStepType.USER_ACTION.equals(type));
    }

}
