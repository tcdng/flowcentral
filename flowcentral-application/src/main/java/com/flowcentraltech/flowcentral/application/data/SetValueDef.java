/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.configuration.constants.SetValueType;

/**
 * Application set value definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetValueDef {

    private SetValueType type;

    private String fieldName;

    private String param;

    public SetValueDef(SetValueType type, String fieldName, String param) {
        this.type = type;
        this.fieldName = fieldName;
        this.param = param;
    }

    public SetValueType getType() {
        return type;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "SetValueDef [type=" + type + ", fieldName=" + fieldName + ", param=" + param + "]";
    }
}
