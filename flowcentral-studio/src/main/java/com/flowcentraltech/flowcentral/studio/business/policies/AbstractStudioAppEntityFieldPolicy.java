/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Convenient abstract base class studio application entity field policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractStudioAppEntityFieldPolicy extends AbstractStudioEntityActionPolicy {

    @Configurable
    private ReportModuleService reportModuleService;

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    @Override
    public boolean checkAppliesTo(Entity inst) throws UnifyException {
        return true;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {

    }

    protected ReportModuleService getRds() {
        return reportModuleService;
    }

    protected Long getReportableDefinitionId(AppEntityField appEntityField) throws UnifyException {
        String entity = getAms().getAppEntity(appEntityField.getAppEntityId());
        return reportModuleService.getReportableDefinitionId(entity);
    }

}
