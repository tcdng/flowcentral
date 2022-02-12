/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.ui.widget.AbstractPanel;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Convenient abstract base class for form panels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@UplBinding("web/application/upl/formpanel.upl")
public abstract class AbstractFormPanel extends AbstractPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        AbstractForm form = getValue(AbstractForm.class);
        setWidgetVisible("formErrors", form.isWithValidationErrors());
    }

    public EventHandler[] getSwitchOnChangeEventHandler() throws UnifyException {
        return getWidgetByShortName("switchOnChangeLabel").getUplAttribute(EventHandler[].class, "eventHandler");
    }
}
