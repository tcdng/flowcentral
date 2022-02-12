/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.controllers;

import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Convenient abstract base class for forwarder page beans.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AbstractForwarderPageBean extends AbstractPageBean {

    private String targetPath;

    public String getTargetPath() {
        return targetPath;
    }

    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }

}
