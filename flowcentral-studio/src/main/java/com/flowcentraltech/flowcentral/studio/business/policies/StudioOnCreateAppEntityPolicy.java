/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleSysParamConstants;
import com.flowcentraltech.flowcentral.application.constants.ApplicationPrivilegeConstants;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.entities.AppEntity;
import com.flowcentraltech.flowcentral.application.entities.AppRef;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.util.PrivilegeNameUtils;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionResult;
import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.flowcentraltech.flowcentral.report.entities.ReportableDefinition;
import com.flowcentraltech.flowcentral.report.entities.ReportableField;
import com.flowcentraltech.flowcentral.report.util.ReportEntityUtils;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.message.MessageResolver;

/**
 * Studio on create application entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiooncreateappentity-policy")
public class StudioOnCreateAppEntityPolicy extends StudioOnCreateComponentPolicy {

    @Configurable
    private ReportModuleService reportModuleService;

    @Configurable
    private MessageResolver messageResolver;

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    public void setMessageResolver(MessageResolver messageResolver) {
        this.messageResolver = messageResolver;
    }

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        super.doExecutePreAction(ctx);
        AppEntity appEntity = (AppEntity) ctx.getInst();
        appEntity.setFieldList(getAms().getEntityBaseTypeFieldList(appEntity.getBaseType(), ConfigType.CUSTOM));
    }

    @Override
    protected EntityActionResult doExecutePostAction(EntityActionContext ctx) throws UnifyException {
        EntityActionResult result = super.doExecutePostAction(ctx);
        final String applicationName = (String) getSessionAttribute(
                StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
        final Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        final AppEntity appEntity = (AppEntity) ctx.getInst();
        final String entity = ApplicationNameUtils.ensureLongNameReference(applicationName, appEntity.getName());
        final String nameDesc = appEntity.getDescription();

        // Create application reference
        AppRef appRef = new AppRef();
        appRef.setApplicationId(applicationId);
        appRef.setName(appEntity.getName() + "Ref");
        appRef.setDescription(resolveSessionMessage("$m{studio.appref.reference.template}", nameDesc));
        appRef.setEntity(entity);
        if (((EntityDef) ctx.getEntityDef()).isWithDescriptionField()) {
            appRef.setSearchField("description");
        }

        getAms().createAppRef(appRef);

        // Create reportable if necessary
        if (appEntity.getReportable()) {
            String description = resolveApplicationMessage("$m{report.managedreport.description}",
                    nameDesc);
            ReportableDefinition reportableDefinition = new ReportableDefinition();
            reportableDefinition.setApplicationId(applicationId);
            reportableDefinition.setEntity(entity);
            reportableDefinition.setTitle(description);
            reportableDefinition.setName(appEntity.getName());
            reportableDefinition.setDescription(description);
            List<ReportableField> baseReportableFieldList = ReportEntityUtils
                    .getEntityBaseTypeReportableFieldList(messageResolver, appEntity.getBaseType());
            reportableDefinition.setFieldList(baseReportableFieldList);
            reportModuleService.createReportableDefinition(reportableDefinition);

            final String privilegeCode = PrivilegeNameUtils.getReportablePrivilegeName(
                    ApplicationNameUtils.ensureLongNameReference(applicationName, appEntity.getName()));
            registerPrivilege(applicationId, ApplicationPrivilegeConstants.APPLICATION_REPORTABLE_CATEGORY_CODE,
                    privilegeCode, description);

            UserToken userToken = getUserToken();
            if (!userToken.isReservedUser() && getSystemModuleService().getSysParameterValue(boolean.class,
                    ApplicationModuleSysParamConstants.ASSIGN_APPLICATIONENTITY_ONCREATE)) {
                assignPrivilegeToRole(userToken.getRoleCode(), privilegeCode);
            }
        }

        return result;
    }

}
