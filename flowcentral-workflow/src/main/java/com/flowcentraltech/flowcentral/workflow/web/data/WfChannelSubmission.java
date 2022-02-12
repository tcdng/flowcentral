/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.data;

import java.util.Arrays;

/**
 * Workflow channel document submission object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfChannelSubmission {

    private String channel;
    
    private String departmentCode;
    
    private String branchCode;
    
    private String[] documents;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public String[] getDocuments() {
        return documents;
    }

    public void setDocuments(String[] documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return "WfChannelSubmission [channel=" + channel + ", documents=" + Arrays.toString(documents) + "]";
    }
}
