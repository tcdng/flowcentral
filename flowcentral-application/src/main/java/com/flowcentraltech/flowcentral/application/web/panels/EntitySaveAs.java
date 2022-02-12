/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.FormFieldDef;
import com.flowcentraltech.flowcentral.application.data.FormSectionDef;
import com.flowcentraltech.flowcentral.application.data.FormTabDef;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniForm;
import com.flowcentraltech.flowcentral.application.web.widgets.MiniFormScope;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.common.business.policies.SweepingCommitPolicy;
import com.flowcentraltech.flowcentral.configuration.constants.RecordActionType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Entity save-as object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntitySaveAs {

    private final AppletUtilities au;

    private final SweepingCommitPolicy scp;

    private final Entity inst;

    private MiniForm inputForm;

    public EntitySaveAs(AppletUtilities au, SweepingCommitPolicy scp, Entity inst) {
        this.au = au;
        this.scp = scp;
        this.inst = inst;
    }

    public AppletUtilities getAu() {
        return au;
    }

    public MiniForm getInputForm() {
        return inputForm;
    }

    public void loadEntitySaveAs(FormContext ctx) throws UnifyException {
        FormContext _ctx = new FormContext(ctx.getAppletContext(), ctx.getFormDef(), ctx.getFormSwitchOnChangeHandlers(),
                inst);
        _ctx.setSaveAsMode(true);
        _ctx.revertTabStates();
        FormTabDef saveAsFormTabDef = ctx.getFormDef().getSaveAsFormTabDef();
        for (FormSectionDef formSectionDef : saveAsFormTabDef.getFormSectionDefList()) {
            for (FormFieldDef formFieldDef : formSectionDef.getFormFieldDefList()) {
                if (formFieldDef.isEditable() && !formFieldDef.isDisabled()) {
                    DataUtils.setBeanProperty(inst, formFieldDef.getFieldName(), null);
                }
            }
        }

        inputForm = new MiniForm(MiniFormScope.MAIN_FORM, _ctx, saveAsFormTabDef);
    }

    public EntityActionResult commitEntitySaveAs(String saveAsPolicy) throws UnifyException {
        EntityActionContext ctx = new EntityActionContext(inputForm.getCtx().getFormDef().getEntityDef(),
                (Entity) inputForm.getCtx().getInst(), RecordActionType.CREATE, scp, saveAsPolicy);
        return au.getEnvironment().create(ctx);
    }
}
