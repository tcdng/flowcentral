/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Form applet list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormAppletParams extends AbstractListParam {

    private Long formId;

    private String appletName;

    public FormAppletParams(Long formId, String appletName) {
        this.formId = formId;
        this.appletName = appletName;
    }

    public Long getFormId() {
        return formId;
    }

    public String getAppletName() {
        return appletName;
    }

    @Override
    public boolean isPresent() {
        return formId != null && appletName != null;
    }

    @Override
    public String toString() {
        return "FormAppletParams [formId=" + formId + ", appletName=" + appletName + "]";
    }
}
