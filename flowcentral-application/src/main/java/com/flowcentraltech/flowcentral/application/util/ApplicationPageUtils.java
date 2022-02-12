/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.util;

import com.flowcentraltech.flowcentral.configuration.constants.AppletType;

/**
 * Application page utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ApplicationPageUtils {

    private ApplicationPageUtils() {

    }

    public static String constructAppletOpenPagePath(AppletType type, String appletName) {
        return ApplicationPageUtils.constructAppletOpenPagePath(type.path(), appletName);
    }

    public static String constructAppletOpenPagePath(String controllerName, String appletName) {
        return new StringBuilder().append(controllerName).append(':').append(appletName).append("/openPage").toString();
    }

    public static String constructAppletReplacePagePath(String controllerName, String appletName) {
        return new StringBuilder().append(controllerName).append(':').append(appletName).append("/replacePage")
                .toString();
    }
}
