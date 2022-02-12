/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.business;

import com.flowcentraltech.flowcentral.system.constants.SystemModuleSysParamConstants;
import com.flowcentraltech.flowcentral.system.entities.DownloadLog;
import com.tcdng.unify.core.SessionContext;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.AbstractDownloadPathLogger;

/**
 * System download path logger.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("system-downloadpathlogger")
public class SystemDownloadPathLogger extends AbstractDownloadPathLogger {

    @Configurable
    private SystemModuleService systemService;

    public void setSystemService(SystemModuleService systemService) {
        this.systemService = systemService;
    }

    @Override
    public void logDownloadAttempt(String resourceName) throws UnifyException {
        if (systemService.getSysParameterValue(boolean.class,
                SystemModuleSysParamConstants.SYSTEM_DOWNLOADPATH_LOG_ENABLED)) {
            SessionContext ctx = getSessionContext();
            DownloadLog downloadLog = new DownloadLog(resourceName, ctx.getRemoteAddress(), ctx.getRemoteHost());
            systemService.createDownloadLog(downloadLog);
        }
    }

}
