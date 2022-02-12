/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.common.constants.DialogFormMode;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor.FormSection;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.panel.AbstractDialogPanel;

/**
 * Form section editor panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formsectioneditorpanel")
@UplBinding("web/studio/upl/formsectioneditorpanel.upl")
public class FormSectionEditorPanel extends AbstractDialogPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        FormSection formSection = getValue(FormEditor.class).getEditSection();
        boolean isCreate = DialogFormMode.CREATE.equals(DialogFormMode.fromName(formSection.getMode()));
        setVisible("addBtn", isCreate);
        setVisible("applyBtn", !isCreate);
    }

    @Action
    public void add() throws UnifyException {
        getValue(FormEditor.class).performSectionAdd();
        commandHidePopup();
    }

    @Action
    public void apply() throws UnifyException {
        commandHidePopup();
    }

}
