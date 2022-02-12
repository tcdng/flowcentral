/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Download log entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table("FC_DOWNLOADLOG")
public class DownloadLog extends BaseAuditEntity {

    @Column(name = "RESOURCE_NM", length = 128)
    private String resourceName;

    @Column(length = 64)
    private String remoteAddress;

    @Column(length = 96, nullable = true)
    private String remoteHost;

    public DownloadLog(String resourceName, String remoteAddress, String remoteHost) {
        this.resourceName = resourceName;
        this.remoteAddress = remoteAddress;
        this.remoteHost = remoteHost;
    }

    public DownloadLog() {

    }

    @Override
    public String getDescription() {
        return this.resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getRemoteAddress() {
        return remoteAddress;
    }

    public void setRemoteAddress(String remoteAddress) {
        this.remoteAddress = remoteAddress;
    }

    public String getRemoteHost() {
        return remoteHost;
    }

    public void setRemoteHost(String remoteHost) {
        this.remoteHost = remoteHost;
    }

}
