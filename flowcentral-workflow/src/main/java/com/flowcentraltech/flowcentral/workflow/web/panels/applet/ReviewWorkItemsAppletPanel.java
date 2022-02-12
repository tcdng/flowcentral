/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.web.panels.applet;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.EvaluationMode;
import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntityFormAppletPanel;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Review work items applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-reviewworkitemsappletpanel")
@UplBinding("web/workflow/upl/reviewworkitemsappletpanel.upl")
public class ReviewWorkItemsAppletPanel extends AbstractEntityFormAppletPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setVisible("entitySearchPanel.reportBtn", false);
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        ReviewWorkItemsApplet applet = getReviewWorkItemsApplet();
        final ReviewWorkItemsApplet.ViewMode viewMode = applet.getMode();
        switch (viewMode) {
            case ASSIGNMENT_PAGE:
            case PROPERTYLIST_PAGE:
            case LISTING_FORM:
            case MAINTAIN_FORM_SCROLL:
            case MAINTAIN_CHILDLIST_FORM_NO_SCROLL:
            case MAINTAIN_RELATEDLIST_FORM_NO_SCROLL:
            case MAINTAIN_HEADLESSLIST_FORM_NO_SCROLL:
            case MAINTAIN_FORM:
            case MAINTAIN_CHILDLIST_FORM:
            case MAINTAIN_RELATEDLIST_FORM:
            case MAINTAIN_HEADLESSLIST_FORM:
            case NEW_FORM:
            case NEW_CHILD_FORM:
            case NEW_CHILDLIST_FORM:
            case NEW_RELATEDLIST_FORM:
            case NEW_HEADLESSLIST_FORM:
            case HEADLESS_TAB:
                break;
            case SEARCH:
                switchContent("entitySearchPanel");
            default:
                break;
        }
    }

    @Action
    public void performUserAction() throws UnifyException {
        final ReviewWorkItemsApplet applet = getReviewWorkItemsApplet();
        final FormContext ctx = evaluateCurrentFormContext(EvaluationMode.UPDATE);
        if (!ctx.isWithFormErrors()) {
            final String actionName = getRequestTarget(String.class);
            if (ctx.getFormDef().isInputForm()) {
                applet.updateInst();
            }
            applet.applyUserAction(actionName);
            hintUser("$m{reviewworkitemsapplet.apply.success.hint}");
        }
    }

    protected ReviewWorkItemsApplet getReviewWorkItemsApplet() throws UnifyException {
        return getValue(ReviewWorkItemsApplet.class);
    }
}
