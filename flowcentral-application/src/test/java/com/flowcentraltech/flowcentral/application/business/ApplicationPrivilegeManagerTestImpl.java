/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.business;

import java.util.Collections;
import java.util.List;

import com.flowcentraltech.flowcentral.common.business.ApplicationPrivilegeManager;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;

/**
 * Test Appliaction Privilege Manager.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("test-applicationprivilegemanager")
public class ApplicationPrivilegeManagerTestImpl extends AbstractUnifyComponent implements ApplicationPrivilegeManager {

    @Override
    public void registerPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode,
            String privilegeDesc) throws UnifyException {

    }

    @Override
    public boolean unregisterPrivilege(Long applicationId, String privilegeCategoryCode, String privilegeCode)
            throws UnifyException {
        return false;
    }

    @Override
    public List<String> findRolePrivileges(String privilegeCategoryCode, String roleCode) throws UnifyException {
        return Collections.emptyList();
    }

    @Override
    public boolean assignPrivilegeToRole(String roleCode, String privilegeCode) throws UnifyException {
        return true;
    }

    @Override
    public boolean isRoleWithPrivilege(String roleCode, String privilegeCode) throws UnifyException {
        return false;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
