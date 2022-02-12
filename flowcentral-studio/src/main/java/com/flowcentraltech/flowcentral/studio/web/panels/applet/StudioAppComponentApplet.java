/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.panels.applet;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.FormMode;
import com.flowcentraltech.flowcentral.application.web.panels.applet.AbstractEntityFormApplet;
import com.flowcentraltech.flowcentral.studio.business.StudioModuleService;
import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.flowcentraltech.flowcentral.studio.constants.StudioAppletPropertyConstants;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Studio application component applet object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioAppComponentApplet extends AbstractEntityFormApplet {

    final private StudioModuleService sms;

    final private String instTitle;

    final private String typeTitle;

    final private String applicationName;

    public StudioAppComponentApplet(StudioModuleService sms, AppletUtilities au, String pathVariable,
            String applicationName, EventHandler[] formSwitchOnChangeHandlers,
            EventHandler[] assnSwitchOnChangeHandlers) throws UnifyException {
        super(au, pathVariable, formSwitchOnChangeHandlers, assnSwitchOnChangeHandlers, true);
        this.sms = sms;
        this.applicationName = applicationName;

        currFormAppletDef = getRootAppletDef();
        StudioAppComponentType type = currFormAppletDef.getPropValue(StudioAppComponentType.class,
                StudioAppletPropertyConstants.ENTITY_TYPE);
        this.instTitle = currFormAppletDef.getDescription();
        this.typeTitle = au.resolveSessionMessage(type.caption());
        Long instId = currFormAppletDef.getPropValue(Long.class, StudioAppletPropertyConstants.ENTITY_INST_ID);
        if (instId == null || instId.longValue() == 0L) {
            form = constructNewForm(FormMode.ENTITY_CREATE, null, false);
            ((BaseApplicationEntity) form.getCtx().getInst()).setApplicationId(
                    au.getSessionAttribute(Long.class, StudioSessionAttributeConstants.CURRENT_APPLICATION_ID));
            viewMode = ViewMode.NEW_PRIMARY_FORM;
        } else {
            Entity _inst = au.getEnvironment().listLean(type.componentType(), instId);
            form = constructForm(_inst, FormMode.ENTITY_MAINTAIN, null, false);
            viewMode = ViewMode.MAINTAIN_PRIMARY_FORM_NO_SCROLL;
        }
    }

    public String getInstTitle() {
        return instTitle;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    @Override
    protected AppletDef getAlternateFormAppletDef() throws UnifyException {
        return null;
    }

    @Override
    public AppletDef getRootAppletDef() throws UnifyException {
        return sms.getAppletDef(getAppletName());
    }

    @Override
    protected boolean restoreForm() {
        super.restoreForm();
        return true; // Do this so applet does not revert to search mode at terminal form
    }

    protected StudioModuleService getSms() {
        return sms;
    }

    protected String getApplicationName() {
        return applicationName;
    }
}
