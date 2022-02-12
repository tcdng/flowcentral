/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.util.InputWidgetUtils;
import com.flowcentraltech.flowcentral.common.input.AbstractInput;
import com.flowcentraltech.flowcentral.common.input.StringInput;
import com.flowcentraltech.flowcentral.configuration.constants.SetValueType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Set value entry.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetValueEntry {

    private EntityDef entityDef;

    private SetValueType type;

    private String fieldName;

    private String paramField;

    private AbstractInput<?> paramInput;

    private boolean fieldChange;

    private boolean typeChange;

    private boolean editable;

    public SetValueEntry(EntityDef entityDef, boolean editable) {
        this.entityDef = entityDef;
        this.editable = editable;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldChange = !DataUtils.equals(this.fieldName, fieldName);
        this.fieldName = fieldName;
    }

    public SetValueType getType() {
        return type;
    }

    public void setType(SetValueType type) {
        this.typeChange = !DataUtils.equals(this.type, type);
        this.type = type;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public EntityFieldDef getEntityFieldDef(String fieldName) {
        return entityDef.getFieldDef(fieldName);
    }

    public String getParamField() {
        return paramField;
    }

    public void setParamField(String paramField) {
        this.paramField = paramField;
    }

    public AbstractInput<?> getParamInput() {
        return paramInput;
    }

    public boolean isWithFieldName() {
        return fieldName != null;
    }

    public boolean isWithParamInput() {
        return paramInput != null;
    }

    public boolean isEditable() {
        return editable;
    }

    public void normalize() throws UnifyException {
        if (fieldName == null) {
            type = null;
            paramField = null;
            paramInput = null;
        } else {
            if (type == null || type.isNoParam()) {
                paramField = null;
                paramInput = null;
            } else {
                EntityFieldDef entityFieldDef = entityDef.getFieldDef(fieldName);
                paramInput = evalInput(entityFieldDef, paramInput);
                paramField = null;
            }
        }

        fieldChange = false;
        typeChange = false;
    }

    private AbstractInput<?> evalInput(EntityFieldDef entityFieldDef, AbstractInput<?> currentIn)
            throws UnifyException {
        if (currentIn == null) {
            switch (type) {
                case GENERATOR:
                    return new StringInput(
                            "!ui-select blankOption:$s{} list:fieldsetvaluegenlist listParams:$s{entityDef}");
                case IMMEDIATE_FIELD:
                    return new StringInput(
                            "!ui-select blankOption:$s{} list:entityfielddeflist listParams:$s{entityDef}");
                case IMMEDIATE:
                case IMMEDIATE_LINGUAL:
                default:
                    return InputWidgetUtils.newInput(entityFieldDef, type.isLingual(), false);
            }
        }

        if (fieldChange || typeChange) {
            switch (type) {
                case GENERATOR:
                    return new StringInput(
                            "!ui-select blankOption:$s{} list:fieldsetvaluegenlist listParams:$s{entityDef}");
                case IMMEDIATE_FIELD:
                    return new StringInput(
                            "!ui-select blankOption:$s{} list:entityfielddeflist listParams:$s{entityDef}");
                case IMMEDIATE:
                case IMMEDIATE_LINGUAL:
                default:
                    AbstractInput<?> newIn = InputWidgetUtils.newInput(entityFieldDef, type.isLingual(), false);
                    if (!newIn.compatible(currentIn)) {
                        return newIn;
                    }
            }
        }

        return currentIn;
    }

    @Override
    public String toString() {
        return "SetValueEntry [entityDef=" + entityDef + ", type=" + type + ", fieldName=" + fieldName + ", paramField="
                + paramField + ", paramInput=" + paramInput + ", fieldChange=" + fieldChange + ", typeChange="
                + typeChange + ", editable=" + editable + "]";
    }
}
