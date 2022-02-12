/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Applet parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppletParams extends AbstractListParam {

    private String reference;

    private String entity;

    public AppletParams(String reference, String entity) {
        this.reference = reference;
        this.entity = entity;
    }

    public String getReference() {
        return reference;
    }

    public String getEntity() {
        return entity;
    }

    @Override
    public boolean isPresent() {
        return reference != null && entity != null;
    }
}
