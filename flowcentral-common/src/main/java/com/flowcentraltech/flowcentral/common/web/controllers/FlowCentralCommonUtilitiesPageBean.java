/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.web.controllers;

import com.tcdng.unify.web.ui.CommonUtilitiesPageBean;

/**
 * Flow central common utilities page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FlowCentralCommonUtilitiesPageBean extends CommonUtilitiesPageBean {

    private String searchSelectPath;

    public String getSearchSelectPath() {
        return searchSelectPath;
    }

    public void setSearchSelectPath(String searchSelectPath) {
        this.searchSelectPath = searchSelectPath;
    }
}
