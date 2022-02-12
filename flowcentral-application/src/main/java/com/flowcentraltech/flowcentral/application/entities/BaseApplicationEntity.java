/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.UniqueConstraint;
import com.tcdng.unify.core.annotation.UniqueConstraints;

/**
 * Convenient abstract base class for application definitions.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@UniqueConstraints({ @UniqueConstraint({ "applicationId", "name" }),
        @UniqueConstraint({ "applicationId", "description" }) })
public abstract class BaseApplicationEntity extends BaseConfigNamedEntity {

    @ForeignKey(Application.class)
    private Long applicationId;

    @ListOnly(key = "applicationId", property = "name")
    private String applicationName;

    @ListOnly(key = "applicationId", property = "description")
    private String applicationDesc;

    public final Long getApplicationId() {
        return applicationId;
    }

    public final void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public final String getApplicationName() {
        return applicationName;
    }

    public final void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public final String getApplicationDesc() {
        return applicationDesc;
    }

    public final void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }

}
