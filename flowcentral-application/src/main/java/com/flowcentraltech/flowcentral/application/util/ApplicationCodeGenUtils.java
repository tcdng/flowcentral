/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.tcdng.unify.core.util.SqlUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Application code generation utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ApplicationCodeGenUtils {

    private ApplicationCodeGenUtils() {

    }

    public static String generateCustomEntityTableName(String moduleShortName, String entityName) {
        return StringUtils.isBlank(entityName) ? null
                : "U_" + moduleShortName + "_" + SqlUtils.generateSchemaElementName(entityName, true);
    }

    public static String generateCustomEntityClassName(ConfigType type, String applicationName, String entityName) {
        String supPackage = type.isStatic() ? "z" : "u";
        return StringUtils.isBlank(entityName) ? null
                : "com.flowcentraltech.flowcentral." + applicationName.toLowerCase() + "." + supPackage + "."
                        + StringUtils.capitalizeFirstLetter(entityName) + supPackage;
    }

    public static String generateExtensionEntityClassName(String basePackage, String moduleName, String entityName) {
        return StringUtils.isBlank(entityName) ? null
                : basePackage + "." + moduleName.toLowerCase() + ".extension.entities."
                        + StringUtils.capitalizeFirstLetter(entityName);
    }
}
