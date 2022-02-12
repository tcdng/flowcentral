/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.CollaborationType;

/**
 * Collaboration lock information
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CollaborationLockInfo {

    private CollaborationType type;

    private String resourceName;

    private String lockedBy;

    private Date lockDate;

    public CollaborationLockInfo(CollaborationType type, String resourceName, String lockedBy, Date lockDate) {
        this.type = type;
        this.resourceName = resourceName;
        this.lockedBy = lockedBy;
        this.lockDate = lockDate;
    }

    public CollaborationType getType() {
        return type;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getLockedBy() {
        return lockedBy;
    }

    public Date getLockDate() {
        return lockDate;
    }
}
