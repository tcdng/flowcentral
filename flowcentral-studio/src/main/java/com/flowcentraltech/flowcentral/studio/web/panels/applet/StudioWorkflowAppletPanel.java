/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels.applet;

import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntityFormApplet;
import com.flowcentraltech.flowcentral.studio.web.panels.WorkflowEditorPage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Studio workflow applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-studioworkflowappletpanel")
@UplBinding("web/studio/upl/studioworkflowappletpanel.upl")
public class StudioWorkflowAppletPanel extends StudioAppComponentAppletPanel {

    @Override
    public void switchState() throws UnifyException {
        super.switchState();
        AbstractEntityFormApplet applet = getEntityFormApplet();
        final AbstractEntityFormApplet.ViewMode viewMode = applet.getMode();

        switch (viewMode) {
            case ASSIGNMENT_PAGE:
            case PROPERTYLIST_PAGE:
            case LISTING_FORM:
            case MAINTAIN_FORM_SCROLL:
            case MAINTAIN_PRIMARY_FORM_NO_SCROLL:
            case MAINTAIN_CHILDLIST_FORM_NO_SCROLL:
            case MAINTAIN_RELATEDLIST_FORM_NO_SCROLL:
            case MAINTAIN_HEADLESSLIST_FORM_NO_SCROLL:
            case MAINTAIN_FORM:
            case MAINTAIN_CHILDLIST_FORM:
            case MAINTAIN_RELATEDLIST_FORM:
            case MAINTAIN_HEADLESSLIST_FORM:
            case NEW_FORM:
            case NEW_PRIMARY_FORM:
            case NEW_CHILD_FORM:
            case NEW_CHILDLIST_FORM:
            case NEW_RELATEDLIST_FORM:
            case NEW_HEADLESSLIST_FORM:
            case SEARCH:
            case HEADLESS_TAB:
                break;
            case CUSTOM_PAGE:
                setWidgetVisible("saveDesignCloseBtn", !applet.getCtx().isReadOnly());
                switchContent("workflowEditorPagePanel");
                break;
            default:
                break;
        }
    }

    @Action
    public void saveDesignAndClose() throws UnifyException {
        StudioWorkflowApplet applet = getValue(StudioWorkflowApplet.class);
        WorkflowEditorPage workflowEditorPage = applet.getWorkflowEditorPage();
        workflowEditorPage.commitDesign();
        applet.navBackToPrevious();
        hintUser("$m{studioworkflowapplet.workfloweditor.success.hint}", workflowEditorPage.getSubTitle());
    }

}
