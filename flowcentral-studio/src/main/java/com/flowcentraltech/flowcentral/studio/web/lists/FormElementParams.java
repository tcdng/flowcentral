/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.tcdng.unify.core.list.AbstractListParam;

/**
 * Form applet list parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormElementParams extends AbstractListParam {

    private Long parentId;

    private FormElementType type;

    public FormElementParams(Long parentId, FormElementType type) {
        this.parentId = parentId;
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public FormElementType getType() {
        return type;
    }

    @Override
    public boolean isPresent() {
        return parentId != null && type != null;
    }

    @Override
    public String toString() {
        return "FormElementParams [parentId=" + parentId + ", type=" + type + "]";
    }
}
