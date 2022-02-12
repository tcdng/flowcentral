/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.FactoryMap;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Privilege name utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class PrivilegeNameUtils {

    private static final FactoryMap<String, PrivilegeNameParts> privilegeNameParts;

    static {
        privilegeNameParts = new FactoryMap<String, PrivilegeNameParts>()
            {

                @Override
                protected PrivilegeNameParts create(String privilegeName, Object... arg1) throws Exception {
                    try {
                        int index = privilegeName.indexOf('.');
                        return new PrivilegeNameParts(privilegeName.substring(0, index),
                                privilegeName.substring(index + 1));
                    } catch (Exception e) {
                        throw new RuntimeException("Name parts error: privilegeName = " + privilegeName, e);
                    }
                }

            };
    }

    private PrivilegeNameUtils() {

    }

    public static PrivilegeNameParts getPrivilegeNameParts(String privilegeName) throws UnifyException {
        return privilegeNameParts.get(privilegeName);
    }

    public static String getApplicationPrivilegeName(String applicationName) {
        return StringUtils.dotify("pApp", applicationName);
    }

    public static String getAppletPrivilegeName(String appletName) {
        return StringUtils.dotify("pApl", appletName);
    }

    public static String getAddPrivilegeName(String entityName) {
        return StringUtils.dotify("pAdd", entityName);
    }

    public static String getEditPrivilegeName(String entityName) {
        return StringUtils.dotify("pEdt", entityName);
    }

    public static String getDeletePrivilegeName(String entityName) {
        return StringUtils.dotify("pDel", entityName);
    }

    public static String getReportablePrivilegeName(String entityName) { // Yes, entity name
        return StringUtils.dotify("pRpb", entityName);
    }

    public static String getAttachPrivilegeName(String entityName) {
        return StringUtils.dotify("pAtc", entityName);
    }

    public static String getReportConfigPrivilegeName(String reportConfigName) {
        return StringUtils.dotify("pRpc", reportConfigName);
    }

    public static String getFormActionPrivilegeName(String formActionName) {
        return StringUtils.dotify("pFac", formActionName);
    }

    public static String getFeaturePrivilegeName(String featureName) {
        return StringUtils.dotify("pFtr", featureName);
    }

    public static String getWfWizardPrivilegeName(String wfWizardName) {
        return StringUtils.dotify("pWfz", wfWizardName);
    }

    public static String getDashboardPrivilegeName(String dashboardName) {
        return StringUtils.dotify("pDsh", dashboardName);
    }

    public static String getWorkspacePrivilegeName(String workspaceName) {
        return StringUtils.dotify("pWks", workspaceName);
    }
}
