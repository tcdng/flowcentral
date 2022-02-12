/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractControl;

/**
 * Form bread crumbs widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formbreadcrumbs")
public class FormBreadCrumbsWidget extends AbstractControl {

    public BreadCrumbs getBreadCrumbs() throws UnifyException {
        return getValue(BreadCrumbs.class);
    }
}
