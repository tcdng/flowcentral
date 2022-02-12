/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Edit property list panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-editpropertylistpanel")
@UplBinding("web/application/upl/editpropertylistpanel.upl")
public class EditPropertyListPanel extends AbstractPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        EditPropertyList editPropertyList = getValue(EditPropertyList.class);
        editPropertyList.clearDisplayItem();
        AppletContext appCtx = editPropertyList.getCtx();
        if (appCtx.isInWorkflow() && !appCtx.isReview()) {
            editPropertyList.setDisplayItemCounterClass("fc-dispcounterorange");
            editPropertyList.setDisplayItemCounter(
                    resolveSessionMessage("$m{editpropertylist.parentinworkflow.viewonly}"));
        } else {
            editPropertyList.setDisplayItemCounter(
                    resolveSessionMessage("$m{assignmentpage.viewing}"));
        }
    }

    @Action
    public void saveProperties() throws UnifyException {
        EditPropertyList editPropertyList = getValue(EditPropertyList.class);
        editPropertyList.commitPropertyList();
        hintUser("$m{entityformapplet.editpropertylist.success.hint}", editPropertyList.getSubTitle());
    }
}
