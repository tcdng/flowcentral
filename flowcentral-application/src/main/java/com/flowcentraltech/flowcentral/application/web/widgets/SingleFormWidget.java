/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.SingleFormPanel;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl;

/**
 * Single form widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-singleform")
public class SingleFormWidget extends AbstractMultiControl {

    private SingleForm oldSingleForm;

    private SingleFormPanel singleFormPanel;

    public SingleForm getSingleForm() throws UnifyException {
        SingleForm singleForm = getValue(SingleForm.class);
        if (singleForm != oldSingleForm) {
            removeAllExternalChildWidgets();
            singleFormPanel = (SingleFormPanel) addExternalChildStandalonePanel(singleForm.getPanelName(),
                    getId() + "_sg");
            singleFormPanel.setValueStore(singleForm.getBeanValueStore());
            oldSingleForm = singleForm;
        }

        return singleForm;
    }

    public FormContext getCtx() throws UnifyException {
        return getSingleForm().getCtx();
    }

    public SingleFormPanel getSingleFormPanel() throws UnifyException {
        getSingleForm();
        return singleFormPanel;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {

    }

}
