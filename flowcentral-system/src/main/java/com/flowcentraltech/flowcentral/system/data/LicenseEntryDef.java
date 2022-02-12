/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.data;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.LicenseStatus;

/**
 * License entry definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LicenseEntryDef {

    private String featureCode;

    private String featureDesc;

    private Date issueDate;

    private Date expiryDate;

    private LicenseStatus status;

    private Integer capacity;
    
    public LicenseEntryDef(String featureCode, String featureDesc, Date issueDate, Date expiryDate,
            LicenseStatus status, Integer capacity) {
        this.featureCode = featureCode;
        this.featureDesc = featureDesc;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
        this.status = status;
        this.capacity = capacity;
    }

    public String getFeatureCode() {
        return featureCode;
    }

    public String getFeatureDesc() {
        return featureDesc;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public LicenseStatus getStatus() {
        return status;
    }

    public Integer getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "LicenseEntryDef [featureCode=" + featureCode + ", featureDesc=" + featureDesc + ", issueDate="
                + issueDate + ", expiryDate=" + expiryDate + ", status=" + status + ", capacity=" + capacity + "]";
    }

}
