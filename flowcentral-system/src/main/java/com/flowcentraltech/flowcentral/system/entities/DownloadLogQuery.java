/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntityQuery;

/**
 * Download log query.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DownloadLogQuery extends BaseAuditEntityQuery<DownloadLog> {

    public DownloadLogQuery() {
        super(DownloadLog.class);
    }

}
