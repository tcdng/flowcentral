/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.common.constants.DialogFormMode;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor.FormField;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.panel.AbstractDialogPanel;

/**
 * Form field editor panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formfieldeditorpanel")
@UplBinding("web/studio/upl/formfieldeditorpanel.upl")
public class FormFieldEditorPanel extends AbstractDialogPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        setDisabled("frmName", true);
        setDisabled("frmColumn", true);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        FormField formField = getValue(FormEditor.class).getEditField();
        EntityFieldDataType dataType = EntityFieldDataType.fromCode(formField.getDataType());
        boolean isRef = dataType.isForeignKey() && ! dataType.isEnumDataType();
        setVisible("frmInputReference", isRef);
        
        boolean isCreate = DialogFormMode.CREATE.equals(DialogFormMode.fromName(formField.getMode()));
        setVisible("addBtn", isCreate);
        setVisible("applyBtn", !isCreate);
    }

    @Action
    public void add() throws UnifyException {
        getValue(FormEditor.class).performFieldAdd();
        commandHidePopup();
    }

    @Action
    public void apply() throws UnifyException {
        commandHidePopup();
    }

}
