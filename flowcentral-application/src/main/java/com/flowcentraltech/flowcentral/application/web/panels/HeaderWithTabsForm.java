/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniForm;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniFormScope;
import com.flowcentraltech.flowcentral.application.web.widgets.TabSheet;

/**
 * Header with tabs form.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class HeaderWithTabsForm extends AbstractForm {

    public enum UpdateType {
        SWITCH_ON_CHANGE,
        MAINTAIN_INST,
        NAV_BACK_TO_PREVIOUS,
        FORMACTION_ON_INST,
        UPDATE_INST
    }

    private MiniForm headerForm;

    private TabSheet tabSheet;

    private TabSheet relatedListTabSheet;

    private UpdateType updateType;

    public HeaderWithTabsForm(FormContext ctx, BreadCrumbs breadCrumbs) {
        super(ctx, breadCrumbs);
        headerForm = new MiniForm(MiniFormScope.MAIN_FORM, ctx, ctx.getFormDef().getFormTabDef(0));
    }

    public String getFocusWidgetId() {
        return getCtx().getFocusWidgetId();
    }

    public void setFocusWidgetId(String focusWidgetId) {
        getCtx().setFocusWidgetId(focusWidgetId);
    }

    public String getTabWidgetId() {
        return getCtx().getTabWidgetId();
    }

    public void setTabWidgetId(String tabWidgetId) {
        getCtx().setTabWidgetId(tabWidgetId);
    }

    public MiniForm getHeaderForm() {
        return headerForm;
    }

    public void setTabSheet(TabSheet tabSheet) {
        this.tabSheet = tabSheet;
    }

    public TabSheet getTabSheet() {
        return tabSheet;
    }

    public boolean isWithTabSheet() {
        return tabSheet != null;
    }

    public boolean isTabSheetInStateForDisplay() {
        return tabSheet != null && tabSheet.isInStateForDisplay();
    }

    public void setRelatedListTabSheet(TabSheet relatedListTabSheet) {
        this.relatedListTabSheet = relatedListTabSheet;
    }

    public TabSheet getRelatedListTabSheet() {
        return relatedListTabSheet;
    }

    public boolean isWithRelatedListTabSheet() {
        return relatedListTabSheet != null;
    }

    public boolean isRelatedListTabSheetInStateForDisplay() {
        return relatedListTabSheet != null && relatedListTabSheet.isInStateForDisplay();
    }

    public UpdateType getUpdateType() {
        return updateType;
    }

    public void setUpdateType(UpdateType updateType) {
        this.updateType = updateType;
    }
}
