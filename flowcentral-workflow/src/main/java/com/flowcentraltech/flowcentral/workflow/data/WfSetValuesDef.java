/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.data;

import com.flowcentraltech.flowcentral.application.data.SetValuesDef;

/**
 * Workflow set values definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfSetValuesDef {

    private SetValuesDef setValues;

    public WfSetValuesDef(SetValuesDef setValues) {
        this.setValues = setValues;
    }

    public SetValuesDef getSetValues() {
        return setValues;
    }

    public boolean isSetValues() {
        return setValues != null;
    }
}
