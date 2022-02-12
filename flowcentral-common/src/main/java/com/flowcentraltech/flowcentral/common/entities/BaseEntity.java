/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.annotation.Policy;
import com.tcdng.unify.core.annotation.Version;
import com.tcdng.unify.core.system.entities.AbstractSequencedEntity;

/**
 * Base class for all entities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Policy("base-entitypolicy")
public abstract class BaseEntity extends AbstractSequencedEntity {

    @Version
    private long versionNo;

    public final long getVersionNo() {
        return versionNo;
    }

    public final void setVersionNo(long versionNo) {
        this.versionNo = versionNo;
    }
}
