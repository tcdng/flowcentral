/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.organization.business.policies;

import com.flowcentraltech.flowcentral.common.business.policies.AbstractAssignmentUpdatePolicy;
import com.flowcentraltech.flowcentral.organization.business.OrganizationModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;

/**
 * Role privilege assignment commit policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("roleprivilge-assignmentcommitpolicy")
public class RolePrivilegeAssignmentCommitPolicy extends AbstractAssignmentUpdatePolicy {

    @Configurable
    private OrganizationModuleService organizationModuleService;

    public void setOrganizationModuleService(OrganizationModuleService organizationModuleService) {
        this.organizationModuleService = organizationModuleService;
    }

    @Override
    public void postUpdate(Class<? extends Entity> entityClass, String baseField, Object baseId) throws UnifyException {
        String roleCode = organizationModuleService.getRoleCode((Long) baseId);
        organizationModuleService.invalidateRolePrivilegesCache(roleCode);
    }

}
