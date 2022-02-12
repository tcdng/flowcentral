/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.writers;

import java.util.Set;

import com.flowcentraltech.flowcentral.application.data.FormActionDef;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.FormMode;
import com.flowcentraltech.flowcentral.application.web.widgets.FormActionButtons;
import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.Writes;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.EventHandler;
import com.tcdng.unify.web.ui.widget.ResponseWriter;
import com.tcdng.unify.web.ui.widget.Widget;
import com.tcdng.unify.web.ui.widget.writer.AbstractControlWriter;

/**
 * Form action button writer.
 *
 * @author Lateef Ojulari
 * @since 1.0
 */
@Writes(FormActionButtons.class)
@Component("formactionbuttons-writer")
public class FormActionButtonsWriter extends AbstractControlWriter {

    @Configurable
    private ApplicationPrivilegeManager applicationPrivilegeManager;

    public void setApplicationPrivilegeManager(ApplicationPrivilegeManager applicationPrivilegeManager) {
        this.applicationPrivilegeManager = applicationPrivilegeManager;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doWriteStructureAndContent(ResponseWriter writer, Widget component) throws UnifyException {
        FormActionButtons formActionButtons = (FormActionButtons) component;
        writer.write("<div ");
        writeTagAttributes(writer, formActionButtons);
        writer.write(">");

        writer.write("<div class=\"fabrow\">");

        Entity inst = (Entity) ((AbstractForm) formActionButtons.getValueStore().getValueObject()).getCtx().getInst();
        UserToken userToken = getUserToken();
        final FormMode formMode = formActionButtons.getValue(FormMode.class, "formMode");
        final Set<String> showActionSet = (Set<String>) formActionButtons.getWriteWork()
                .get(FormActionButtons.WORK_SHOWACTIONSET);
        Control actionCtrl = formActionButtons.getActionCtrl();
        for (ValueStore valueStore : formActionButtons.getValueList()) {
            FormActionDef formActionDef = (FormActionDef) valueStore.getValueObject();
            if (formActionDef.isButtonType()
                    && (formMode.isListing() || (formActionDef.isShowOnCreate() && formMode.isCreate())
                            || (formActionDef.isShowOnMaintain() && formMode.isMaintain()))
                    && (!formActionDef.isWithPolicy()
                            || ((EntityActionPolicy) getComponent(formActionDef.getPolicy())).checkAppliesTo(inst))
                    && (!formActionDef.isWithPrivilege() || applicationPrivilegeManager
                            .isRoleWithPrivilege(userToken.getRoleCode(), formActionDef.getPrivilege()))) {
                showActionSet.add(formActionDef.getName());
                writer.write("<div class=\"fabcell\">");
                actionCtrl.setValueStore(valueStore);
                writer.writeStructureAndContent(actionCtrl);
                writer.write("</div>");
            }
        }

        writer.write("</div>");

        writer.write("</div>");
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void doWriteBehavior(ResponseWriter writer, Widget widget) throws UnifyException {
        FormActionButtons formActionButtons = (FormActionButtons) widget;
        // All behavior should be tied to action control
        EventHandler[] eventHandlers = formActionButtons.getUplAttribute(EventHandler[].class, "eventHandler");
        if (eventHandlers != null) {
            Control actionCtrl = formActionButtons.getActionCtrl();
            final Set<String> showActionSet = (Set<String>) formActionButtons.getWriteWork()
                    .get(FormActionButtons.WORK_SHOWACTIONSET);
            for (ValueStore valueStore : formActionButtons.getValueList()) {
                FormActionDef formActionDef = (FormActionDef) valueStore.getValueObject();
                if (showActionSet.contains(formActionDef.getName())) {
                    actionCtrl.setValueStore(valueStore);
                    getRequestContext().setQuickReference(valueStore);
                    for (EventHandler eventHandler : eventHandlers) {
                        writer.writeBehavior(eventHandler, actionCtrl.getId(), null);
                    }
                }
            }
        }
    }
}
