/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.tcdng.unify.core.UnifyException;

/**
 * Field sequence entry.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FieldSequenceEntry {

    private EntityDef entityDef;

    private String fieldName;

    private String param;

    private boolean editable;

    public FieldSequenceEntry(EntityDef entityDef, boolean editable) {
        this.entityDef = entityDef;
        this.editable = editable;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public EntityFieldDef getEntityFieldDef(String fieldName) {
        return entityDef.getFieldDef(fieldName);
    }

    public boolean isWithFieldName() {
        return fieldName != null;
    }

    public boolean isWithParam() {
        return param != null;
    }

    public boolean isEditable() {
        return editable;
    }

    public void normalize() throws UnifyException {
        if (fieldName == null) {
            param = null;
        }
    }

    @Override
    public String toString() {
        return "FieldSequenceEntry [fieldName=" + fieldName + ", param=" + param + ", editable=" + editable + "]";
    }

}
