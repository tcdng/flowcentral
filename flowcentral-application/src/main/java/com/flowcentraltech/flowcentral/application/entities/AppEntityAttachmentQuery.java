/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntityQuery;

/**
 * Application entity attachment query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityAttachmentQuery extends BaseConfigNamedEntityQuery<AppEntityAttachment> {

    public AppEntityAttachmentQuery() {
        super(AppEntityAttachment.class);
    }

    public AppEntityAttachmentQuery appEntityId(Long appEntityId) {
        return (AppEntityAttachmentQuery) addEquals("appEntityId", appEntityId);
    }

}
