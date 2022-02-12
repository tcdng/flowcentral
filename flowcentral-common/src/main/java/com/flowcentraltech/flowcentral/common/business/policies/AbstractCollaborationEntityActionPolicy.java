/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.business.CollaborationProvider;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;

/**
 * Convenient abstract base class for collaboration entity action policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractCollaborationEntityActionPolicy extends AbstractEntityActionPolicy {

    @Configurable
    private CollaborationProvider collaborationProvider;

    public void setCollaborationProvider(CollaborationProvider collaborationProvider) {
        this.collaborationProvider = collaborationProvider;
    }

    protected CollaborationProvider getCollaborationProvider() {
        return collaborationProvider;
    }

    protected boolean isLicensedForCollaboration() throws UnifyException {
        return collaborationProvider != null && collaborationProvider.isLicensedForCollaboration();
    }
}
