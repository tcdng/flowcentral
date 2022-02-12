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
import com.flowcentraltech.flowcentral.common.entities.WorkEntity;
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
 * Review wizard create action policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(WorkflowModuleNameConstants.REVIEW_WIZARD_CREATE_ACTION_POLICY)
public class ReviewWizardCreateActionPolicy extends AbstractEntityActionPolicy {

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
        int wfWizardStepIndex = ctx.getAttribute(int.class, WfWizardAppletPropertyConstants.WIZARD_STEP_INDEX);
        if (wfWizardStepIndex == 0) {
            ((WorkEntity) ctx.getInst()).setInWorkflow(true);
        }
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        WfWizardDef wfWizardDef = ctx.getAttribute(WfWizardDef.class,
                WfWizardAppletPropertyConstants.WIZARD_DEFINITION);
        int wfWizardStepIndex = ctx.getAttribute(int.class, WfWizardAppletPropertyConstants.WIZARD_STEP_INDEX);
        int percentCompleted = wfWizardDef.stepCount() > 0 ? ((wfWizardStepIndex + 1) * 100) / wfWizardDef.stepCount()
                : 100;
        if (wfWizardStepIndex == 0) {
            WorkEntity entityInst = (WorkEntity) ctx.getInst();
            WfWizardItem wfWizardItem = new WfWizardItem();
            wfWizardItem.setWizard(wfWizardDef.getLongName());
            wfWizardItem.setPrimaryEntityId((Long) entityInst.getId());
            wfWizardItem.setTitle(entityInst.getDescription());
            wfWizardItem.setOwnerId(getUserToken().getUserLoginId());
            wfWizardItem.setPercentCompleted(percentCompleted);
            appletUtil.getEnvironment().create(wfWizardItem);
        } else {
            Long priEntityInstId = ctx.getAttribute(Long.class,
                    WfWizardAppletPropertyConstants.WIZARD_PRIMARY_ENTITY_INST_ID);
            WfWizardItem wfWizardItem = appletUtil.getEnvironment()
                    .find(new WfWizardItemQuery().wizard(wfWizardDef.getLongName()).primaryEntityId(priEntityInstId));
            wfWizardItem.setPercentCompleted(percentCompleted);
            appletUtil.getEnvironment().updateByIdVersion(wfWizardItem);
        }

        return null;
    }

}
