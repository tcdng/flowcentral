/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.report.entities.ReportableFieldQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.util.QueryUtils;

/**
 * Studio on delete application entity field policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioondeleteappentityfield-policy")
public class StudioOnDeleteAppEntityFieldPolicy extends AbstractStudioAppEntityFieldPolicy {

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        final AppEntityField appEntityField = (AppEntityField) ctx.getInst();
        // Update Reportable
        Long reportableDefinitionId = getReportableDefinitionId(appEntityField);
        if (QueryUtils.isValidLongCriteria(reportableDefinitionId)) {
            getRds().deleteReportableField(
                    new ReportableFieldQuery().reportableId(reportableDefinitionId).name(appEntityField.getName()));
        }

        // TODO Auditable, tables and forms
        return new EntityActionResult(ctx);
    }

}
