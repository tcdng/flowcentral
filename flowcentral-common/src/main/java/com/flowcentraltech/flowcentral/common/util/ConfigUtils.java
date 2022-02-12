/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.util;

import java.util.List;

import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.flowcentraltech.flowcentral.common.entities.ConfigEntity;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UnifyOperationException;

/**
 * Configuration utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ConfigUtils {

    private ConfigUtils() {

    }

    public static void preCreate(ConfigEntity configEntity) throws UnifyException {
        final ConfigType type = configEntity.getConfigType();
        if (ConfigType.STATIC_INSTALL.equals(type)) {
            configEntity.setConfigType(ConfigType.STATIC);
        } else if (ConfigType.MUTABLE_INSTALL.equals(type)) {
            configEntity.setConfigType(ConfigType.MUTABLE);
        } else {
            configEntity.setConfigType(ConfigType.CUSTOM);
        }
    }

    public static void preUpdate(ConfigEntity configEntity) throws UnifyException {
        final ConfigType type = configEntity.getConfigType();
        if (ConfigType.STATIC.equals(type)) {
            throw new UnifyOperationException("Attempt to alter static configuration record.");
        }

        if (ConfigType.STATIC_INSTALL.equals(type)) {
            configEntity.setConfigType(ConfigType.STATIC);
        } else if (ConfigType.MUTABLE_INSTALL.equals(type)) {
            configEntity.setConfigType(ConfigType.MUTABLE);
        } else if (ConfigType.MUTABLE.equals(type)) {
            configEntity.setConfigType(ConfigType.CUSTOMIZED);
        }
    }

    public static boolean isChanged(List<? extends ConfigEntity> configEntityList) {
        boolean noChange = true;
        for (ConfigEntity configEntity : configEntityList) {
            noChange &= ConfigUtils.isSetInstall(configEntity);
        }
        
        return noChange;
    }
    
    public static boolean isSetInstall(ConfigEntity configEntity) {
        final ConfigType type = configEntity.getConfigType();
        if (type != null && type.isInitial()) {
            if (ConfigType.STATIC.equals(type)) {
                configEntity.setConfigType(ConfigType.STATIC_INSTALL);
                return true;
            }

            if (ConfigType.MUTABLE.equals(type)) {
                configEntity.setConfigType(ConfigType.MUTABLE_INSTALL);
                return true;
            }
        }

        return false;
    }

}
