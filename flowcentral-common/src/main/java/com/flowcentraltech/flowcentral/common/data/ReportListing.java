/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

/**
 * Report listing.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportListing {

    private String applicationName;

    private String applicationDesc;

    private String longName;

    private String description;

    public ReportListing(String applicationName, String applicationDesc, String longName, String description) {
        this.applicationName = applicationName;
        this.applicationDesc = applicationDesc;
        this.longName = longName;
        this.description = description;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public String getLongName() {
        return longName;
    }

    public String getDescription() {
        return description;
    }
}
