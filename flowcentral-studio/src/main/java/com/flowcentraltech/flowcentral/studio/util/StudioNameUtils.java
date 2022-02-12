/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.util;

import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Studio name utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class StudioNameUtils {

    private static final int STUDIOAPPCOMPTYPE_CODE_LEN = 4;

    private StudioNameUtils() {

    }

    public static String getStudioAppletName(String applicationName, StudioAppComponentType type, Long instId) {
        return applicationName + "." + type.code() + instId;
    }

    public static StudioAppletNameParts getStudioAppletNameParts(String appletName) {
        String[] po = StringUtils.dotSplit(appletName);
        return new StudioAppletNameParts(po[0],
                StudioAppComponentType.fromCode(po[1].substring(0, STUDIOAPPCOMPTYPE_CODE_LEN)),
                Long.valueOf(po[1].substring(STUDIOAPPCOMPTYPE_CODE_LEN)));
    }

    public static class StudioAppletNameParts {

        private String applicationName;

        private StudioAppComponentType type;

        private Long instId;

        public StudioAppletNameParts(String applicationName, StudioAppComponentType type, Long instId) {
            this.applicationName = applicationName;
            this.type = type;
            this.instId = instId;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public StudioAppComponentType getType() {
            return type;
        }

        public Long getInstId() {
            return instId;
        }

        public boolean isNullInstId() {
            return instId == null || instId.longValue() == 0L;
        }
    }
}
