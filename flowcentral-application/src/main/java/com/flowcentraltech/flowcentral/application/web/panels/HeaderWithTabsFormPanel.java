/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.widgets.MiniFormWidget;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;

/**
 * Header with tabs form panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-headerwithtabsformpanel")
@UplBinding("web/application/upl/headerwithtabsformpanel.upl")
public class HeaderWithTabsFormPanel extends AbstractFormPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        HeaderWithTabsForm headerWithTabsForm = getValue(HeaderWithTabsForm.class);
        MiniFormWidget widget = getWidgetByShortName(MiniFormWidget.class, "headerMiniForm");
        headerWithTabsForm.getCtx().setTriggerEvaluator(widget);
        headerWithTabsForm.getCtx().evaluateTabStates();
        setWidgetVisible("formAnnotation", headerWithTabsForm.isWithVisibleAnnotations());
        setVisible("formTabSheetPanel", headerWithTabsForm.isTabSheetInStateForDisplay());
        setVisible("relatedListPanel", headerWithTabsForm.isRelatedListTabSheetInStateForDisplay());
    }

}
