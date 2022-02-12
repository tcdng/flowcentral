/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.business.RequestUserPhotoGenerator;
import com.flowcentraltech.flowcentral.common.constants.CollaborationType;

/**
 * Collaboration locked resource information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CollaborationLockedResourceInfo {

    private final RequestUserPhotoGenerator requestUserPhotoGenerator;

    private CollaborationType type;

    private String resourceName;

    private String lockedByUserLoginId;

    private String lockedByUserName;

    private String lockedByUserBranch;

    private Date lockedOn;

    public CollaborationLockedResourceInfo(RequestUserPhotoGenerator requestUserPhotoGenerator, CollaborationType type,
            String resourceName, String lockedByUserLoginId, String lockedByUserName, String lockedByUserBranch,
            Date lockedOn) {
        this.requestUserPhotoGenerator = requestUserPhotoGenerator;
        this.type = type;
        this.resourceName = resourceName;
        this.lockedByUserLoginId = lockedByUserLoginId;
        this.lockedByUserName = lockedByUserName;
        this.lockedByUserBranch = lockedByUserBranch;
        this.lockedOn = lockedOn;
    }

    public RequestUserPhotoGenerator getRequestUserPhotoGenerator() {
        return requestUserPhotoGenerator;
    }

    public CollaborationType getType() {
        return type;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getLockedByUserLoginId() {
        return lockedByUserLoginId;
    }

    public String getLockedByUserName() {
        return lockedByUserName;
    }

    public String getLockedByUserBranch() {
        return lockedByUserBranch;
    }

    public Date getLockedOn() {
        return lockedOn;
    }

}
