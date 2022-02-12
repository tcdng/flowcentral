/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

/**
 * Mini form scope.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum MiniFormScope {

    MAIN_FORM,
    CHILD_FORM,
    PROPERTY_LIST;

    public boolean isMainForm() {
        return MAIN_FORM.equals(this);
    }
}
