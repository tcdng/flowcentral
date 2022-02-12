/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.business.policies;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractEntityActionPolicy;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.workflow.constants.WfWizardAppletPropertyConstants;
import com.flowcentraltech.flowcentral.workflow.constants.WorkflowModuleNameConstants;
import com.flowcentraltech.flowcentral.workflow.data.WfWizardDef;
import com.flowcentraltech.flowcentral.workflow.entities.WfWizardItem;
import com.flowcentraltech.flowcentral.workflow.entities.WfWizardItemQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Review wizard update action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(WorkflowModuleNameConstants.REVIEW_WIZARD_UPDATE_ACTION_POLICY)
public class ReviewWizardUpdateActionPolicy extends AbstractEntityActionPolicy {

    @Configurable
    private AppletUtilities appletUtil;

    public void setAppletUtil(AppletUtilities appletUtil) {
        this.appletUtil = appletUtil;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {

    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        WfWizardDef wfWizardDef = ctx.getAttribute(WfWizardDef.class,
                WfWizardAppletPropertyConstants.WIZARD_DEFINITION);
        int wfWizardStepIndex = ctx.getAttribute(int.class, WfWizardAppletPropertyConstants.WIZARD_STEP_INDEX);
        if (wfWizardStepIndex == 0) {
            Entity entityInst = (Entity) ctx.getInst();
            WfWizardItem wfWizardItem = appletUtil.getEnvironment().find(new WfWizardItemQuery()
                    .wizard(wfWizardDef.getLongName()).primaryEntityId((Long) entityInst.getId()));
            wfWizardItem.setTitle(entityInst.getDescription());
            appletUtil.getEnvironment().updateByIdVersion(wfWizardItem);
        }

        return null;
    }

}
