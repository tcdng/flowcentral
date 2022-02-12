/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Application applet definition provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ApplicationAppletDefProvider extends UnifyComponent {

    /**
     * Checks if this provider provides applet.
     * 
     * @param appletName
     *                   the applet name
     * @return a true if provider provides applet otherwise false
     */
    boolean providesApplet(String appletName);

    /**
     * Gets an applet definition.
     * 
     * @param appletName
     *                   the applet long name
     * @return the applet definition
     * @throws UnifyException
     *                        if applet with name is not found. if an error occurs
     */
    AppletDef getAppletDef(String appletName) throws UnifyException;

    /**
     * Gets a list of applet definitions by role.
     * 
     * @param applicationName
     *                        the application name
     * @param roleCode
     *                        the role code
     * @param appletFilter
     *                        optional applet filter by label
     * @return list of applet definitions
     * @throws UnifyException
     *                        if an error occurs
     */
    List<AppletDef> getAppletDefsByRole(String applicationName, String roleCode, String appletFilter)
            throws UnifyException;
}
