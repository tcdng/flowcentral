/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.util;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.FactoryMap;

/**
 * Workspace naming utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class WorkspaceNamingUtils {

    private static FactoryMap<Long, String> workspaceCodes = new FactoryMap<Long, String>()
        {
            @Override
            protected String create(Long workspaceId, Object... arg1) throws Exception {
                return String.format("wksp_%04x", workspaceId);
            }

        };

    private WorkspaceNamingUtils() {

    }

    public static String getWorkspaceCodeFromId(Long workspaceId) throws UnifyException {
        return workspaceCodes.get(workspaceId);
    }
}
