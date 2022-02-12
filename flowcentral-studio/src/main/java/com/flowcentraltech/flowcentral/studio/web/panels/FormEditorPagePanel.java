/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels;

import com.flowcentraltech.flowcentral.studio.web.widgets.FormEditor;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Form editor page panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formeditorpagepanel")
@UplBinding("web/studio/upl/formeditorpagepanel.upl")
public class FormEditorPagePanel extends AbstractStudioEditorPagePanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        final boolean readOnly = isAppletContextReadOnly();
        FormEditor formEditor = getFormEditorPage().getFormEditor();
        formEditor.setReadOnly(readOnly);
        if (!formEditor.isInitialized()) {
            formEditor.init(getWidgetByShortName("formEditorBodyPanel").getLongName(),
                    getWidgetByShortName("editTabPanel").getLongName(),
                    getWidgetByShortName("editSectionPanel").getLongName(),
                    getWidgetByShortName("editFieldPanel").getLongName());
        }

        boolean isEditable = !readOnly;
        setWidgetVisible("saveBtn", isEditable);
        setWidgetEditable("editTabPanel", isEditable);
        setWidgetEditable("editSectionPanel", isEditable);
        setWidgetEditable("editFieldPanel", isEditable);
    }

    @Action
    public void saveDesign() throws UnifyException {
        FormEditorPage formEditorPage = getFormEditorPage();
        formEditorPage.commitDesign();
        hintUser("$m{studioappformapplet.formeditor.success.hint}", formEditorPage.getSubTitle());
    }

    private FormEditorPage getFormEditorPage() throws UnifyException {
        return getValue(FormEditorPage.class);
    }
}
