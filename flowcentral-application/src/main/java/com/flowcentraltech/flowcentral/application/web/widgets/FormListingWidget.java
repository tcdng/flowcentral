/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.web.ui.widget.AbstractContainer;

/**
 * Form listing widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formlisting")
public class FormListingWidget extends AbstractContainer {
    
    public FormListing getFormListing() throws UnifyException {
        return getValue(FormListing.class);
    }
}
