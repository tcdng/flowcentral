/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.widgets.BreadCrumbs;
import com.flowcentraltech.flowcentral.application.web.widgets.FormListing;

/**
 * Listing form
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ListingForm extends AbstractForm {

    private FormListing formListing;

    public ListingForm(FormContext ctx, BreadCrumbs breadCrumbs) {
        super(ctx, breadCrumbs);
        formListing = new FormListing(ctx);
    }

    public FormListing getFormListing() {
        return formListing;
    }
}
