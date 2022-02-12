/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.FormDef;
import com.flowcentraltech.flowcentral.application.entities.AppForm;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.web.panels.FormEditorPage;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Studio application form applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioAppFormApplet extends StudioAppComponentApplet {

    private FormEditorPage formEditorPage;

    public StudioAppFormApplet(StudioModuleService sms, AppletUtilities au, String pathVariable, String applicationName,
            EventHandler[] formSwitchOnChangeHandlers, EventHandler[] assnSwitchOnChangeHandlers)
            throws UnifyException {
        super(sms, au, pathVariable, applicationName, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers);
    }

    public FormEditorPage getFormEditorPage() {
        return formEditorPage;
    }

    public void designChildItem(int childTabIndex) throws UnifyException {
        currFormTabDef = form.getFormDef().getFormTabDef(childTabIndex);
        AppForm appForm = (AppForm) form.getFormBean();
        Object id = appForm.getId();
        String subTitle = appForm.getDescription();
        saveCurrentForm();
        formEditorPage = constructNewFormEditorPage(
                ApplicationNameUtils.getApplicationEntityLongName(getApplicationName(), appForm.getName()), id,
                subTitle);
        formEditorPage.newEditor();
        viewMode = ViewMode.CUSTOM_PAGE;
    }

    private FormEditorPage constructNewFormEditorPage(String formName, Object id, String subTitle)
            throws UnifyException {
        BreadCrumbs breadCrumbs = form.getBreadCrumbs().advance();
        FormDef formDef = getFormDef(formName);
        breadCrumbs.setLastCrumbTitle(au.resolveSessionMessage("$m{formeditor.formdesigner}"));
        breadCrumbs.setLastCrumbSubTitle(subTitle);
        return new FormEditorPage(au, formDef, id, breadCrumbs);
    }

}
