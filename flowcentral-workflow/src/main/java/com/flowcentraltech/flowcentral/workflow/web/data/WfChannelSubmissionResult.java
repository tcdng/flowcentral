/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.web.data;

/**
 * Workflow channel document submission result object.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfChannelSubmissionResult {

    int errorCode;
    
    String errorMsg;

    public WfChannelSubmissionResult(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public WfChannelSubmissionResult(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
