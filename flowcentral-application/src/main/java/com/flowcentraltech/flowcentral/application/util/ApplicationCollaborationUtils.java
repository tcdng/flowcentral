/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import java.util.HashMap;
import java.util.Map;

import com.flowcentraltech.flowcentral.application.entities.AppApplet;
import com.flowcentraltech.flowcentral.application.entities.AppEntity;
import com.flowcentraltech.flowcentral.application.entities.AppForm;
import com.flowcentraltech.flowcentral.application.entities.AppRef;
import com.flowcentraltech.flowcentral.application.entities.AppTable;
import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.common.constants.CollaborationType;

/**
 * Application collaboration utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ApplicationCollaborationUtils {

    private static Map<Class<? extends BaseApplicationEntity>, CollaborationType> collaborationEntityTypeMapping;

    static {
        collaborationEntityTypeMapping = new HashMap<Class<? extends BaseApplicationEntity>, CollaborationType>();
        collaborationEntityTypeMapping.put(AppEntity.class, CollaborationType.ENTITY);
        collaborationEntityTypeMapping.put(AppRef.class, CollaborationType.REFERENCE);
        collaborationEntityTypeMapping.put(AppApplet.class, CollaborationType.APPLET);
        collaborationEntityTypeMapping.put(AppForm.class, CollaborationType.FORM);
        collaborationEntityTypeMapping.put(AppTable.class, CollaborationType.TABLE);
    }

    private ApplicationCollaborationUtils() {

    }

    public static CollaborationType getCollaborationType(
            Class<? extends BaseApplicationEntity> applicationEntityClass) {
        return collaborationEntityTypeMapping.get(applicationEntityClass);
    }

    public static void registerCollaborationType(Class<? extends BaseApplicationEntity> appEntityType,
            CollaborationType type) {
        collaborationEntityTypeMapping.put(appEntityType, type);
    }
}
