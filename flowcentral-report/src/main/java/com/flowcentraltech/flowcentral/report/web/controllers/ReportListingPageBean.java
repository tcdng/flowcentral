/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.web.controllers;

import com.tcdng.unify.web.ui.AbstractPageBean;
import com.tcdng.unify.web.ui.widget.data.LinkGridInfo;

/**
 * Report listing page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReportListingPageBean extends AbstractPageBean {

    private LinkGridInfo linkGridInfo;

    public LinkGridInfo getLinkGridInfo() {
        return linkGridInfo;
    }

    public void setLinkGridInfo(LinkGridInfo linkGridInfo) {
        this.linkGridInfo = linkGridInfo;
    }
}
