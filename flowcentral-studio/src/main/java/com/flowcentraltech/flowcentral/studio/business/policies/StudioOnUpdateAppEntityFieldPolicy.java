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
import com.flowcentraltech.flowcentral.report.entities.ReportableField;
import com.flowcentraltech.flowcentral.report.entities.ReportableFieldQuery;
import com.flowcentraltech.flowcentral.report.util.ReportEntityUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.util.QueryUtils;

/**
 * Studio on update application entity field policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioonupdateappentityfield-policy")
public class StudioOnUpdateAppEntityFieldPolicy extends AbstractStudioAppEntityFieldPolicy {

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        final AppEntityField appEntityField = (AppEntityField) ctx.getInst();
        // Update Reportable
        Long reportableDefinitionId = getReportableDefinitionId(appEntityField);
        if (appEntityField.isReportable() && appEntityField.getDataType().isTableViewable()) {
            if (QueryUtils.isValidLongCriteria(reportableDefinitionId)) {
                ReportableField oldReportableField = getRds().findReportableField(
                        new ReportableFieldQuery().reportableId(reportableDefinitionId).name(appEntityField.getName()));
                if (oldReportableField == null) {
                    ReportableField reportableField = new ReportableField();
                    reportableField.setReportableId(reportableDefinitionId);
                    ReportEntityUtils.populateReportableField(reportableField, appEntityField);
                    getRds().createReportableField(reportableField);
                } else {
                    ReportEntityUtils.populateReportableField(oldReportableField, appEntityField);
                    getRds().updateReportableField(oldReportableField);
                }
            }
        } else {
            if (QueryUtils.isValidLongCriteria(reportableDefinitionId)) {
                getRds().deleteReportableField(
                        new ReportableFieldQuery().reportableId(reportableDefinitionId).name(appEntityField.getName()));
            }
        }

        // TODO Auditable, tables and forms
        return new EntityActionResult(ctx);
    }

}
