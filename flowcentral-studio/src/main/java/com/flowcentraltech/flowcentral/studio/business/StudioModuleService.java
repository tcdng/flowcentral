/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.business;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.tcdng.unify.core.UnifyException;

/**
 * Studio module service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface StudioModuleService extends FlowCentralService {

    /**
     * Gets a studio applet definition.
     * 
     * @param appletName
     *                   the applet long name
     * @return the applet definition
     * @throws UnifyException
     *                        if applet name is invalid. If applet with name is
     *                        unknown. If an error occurs
     */
    AppletDef getAppletDef(String appletName) throws UnifyException;

    /**
     * Gets applet definitions for application entities.
     * 
     * @param applicationName
     *                        the application name
     * @param type
     *                        the component type
     * @return list of applet definitions
     * @throws UnifyException
     *                        if an error occurs
     */
    List<AppletDef> findAppletDefs(String applicationName, StudioAppComponentType type) throws UnifyException;
}
