/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.common.constants.DialogFormMode;
import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor;
import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor.FormTab;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.panel.AbstractDialogPanel;

/**
 * Form tab editor panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formtabeditorpanel")
@UplBinding("web/studio/upl/formtabeditorpanel.upl")
public class FormTabEditorPanel extends AbstractDialogPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        FormTab formTab = getValue(FormEditor.class).getEditTab();
        boolean isCreate = DialogFormMode.CREATE.equals(DialogFormMode.fromName(formTab.getMode()));
        setVisible("addBtn", isCreate);
        setVisible("applyBtn", !isCreate);

        TabContentType type = TabContentType.fromName(formTab.getContentType());
        boolean referenceVisible = false;
        boolean appletVisible = false;
        boolean editActionVisible = false;
        if (type != null) {
            switch (type) {
                case CHILD:
                case CHILD_LIST:
                    referenceVisible = true;
                    appletVisible = true;
                    break;
                case FIELD_SEQUENCE:
                    break;
                case FILTER_CONDITION:
                    break;
                case MINIFORM:
                    break;
                case MINIFORM_CHANGELOG:
                    break;
                case PARAM_VALUES:
                    break;
                case PROPERTY_LIST:
                    break;
                case SET_VALUES:
                    break;
                default:
                    break;
            }
        }

        setVisible("frmReference", referenceVisible);
        setVisible("frmApplet", appletVisible);
        setVisible("frmEditAction", editActionVisible);
    }

    @Action
    public void add() throws UnifyException {
        getValue(FormEditor.class).performTabAdd();
        commandHidePopup();
    }

    @Action
    public void apply() throws UnifyException {
        commandHidePopup();
    }
}
