/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.EntityFieldDef;
import com.flowcentraltech.flowcentral.application.data.LabelSuggestionDef;
import com.flowcentraltech.flowcentral.application.util.InputWidgetUtils;
import com.flowcentraltech.flowcentral.common.input.AbstractInput;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.FilterConditionListType;
import com.tcdng.unify.core.criterion.FilterConditionType;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Filter condition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FilterCondition {

    private EntityDef entityDef;

    private LabelSuggestionDef labelSuggestionDef;

    private FilterConditionType type;

    private FilterConditionListType listType;

    private String typeSelector;

    private String fieldName;

    private String paramFieldA;

    private String paramFieldB;

    private AbstractInput<?> paramInputA;

    private AbstractInput<?> paramInputB;

    private Long ownerInstId;

    private int depth;

    private boolean typeChange;

    private boolean fieldChange;

    private boolean editable;

    public FilterCondition(EntityDef entityDef, LabelSuggestionDef labelSuggestionDef, Long ownerInstId,
            FilterConditionType type, FilterConditionListType listType, int depth, boolean editable) {
        this.entityDef = entityDef;
        this.labelSuggestionDef = labelSuggestionDef;
        this.ownerInstId = ownerInstId;
        this.type = type;
        this.listType = listType;
        this.depth = depth;
        this.editable = editable;
    }

    public FilterCondition(EntityDef entityDef, LabelSuggestionDef labelSuggestionDef, Long ownerInstId,
            FilterConditionListType listType, int depth, boolean editable) {
        this.entityDef = entityDef;
        this.labelSuggestionDef = labelSuggestionDef;
        this.ownerInstId = ownerInstId;
        this.listType = listType;
        this.depth = depth;
        this.editable = editable;
    }

    public FilterConditionType getType() {
        return type;
    }

    public void setType(FilterConditionType type) {
        this.typeChange = !DataUtils.equals(this.type, type);
        this.type = type;type.isLingual();
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldChange = !DataUtils.equals(this.fieldName, fieldName);
        this.fieldName = fieldName;
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public LabelSuggestionDef getLabelSuggestionDef() {
        return labelSuggestionDef;
    }

    public Long getOwnerInstId() {
        return ownerInstId;
    }

    public EntityFieldDef getEntityFieldDef() {
        return entityDef.getFieldDef(fieldName);
    }

    public String getTypeSelector() {
        return typeSelector;
    }

    public String getParamFieldA() {
        return paramFieldA;
    }

    public void setParamFieldA(String paramFieldA) {
        this.paramFieldA = paramFieldA;
    }

    public String getParamFieldB() {
        return paramFieldB;
    }

    public void setParamFieldB(String paramFieldB) {
        this.paramFieldB = paramFieldB;
    }

    public AbstractInput<?> getParamInputA() {
        return paramInputA;
    }

    public AbstractInput<?> getParamInputB() {
        return paramInputB;
    }

    public boolean isWithParamInputA() {
        return paramInputA != null;
    }

    public boolean isWithParamInputB() {
        return paramInputB != null;
    }

    public int getDepth() {
        return depth;
    }

    public boolean isEditable() {
        return editable;
    }

    public boolean isValidState() {
        return type != null;
    }

    public void swapLogic() {
        if (FilterConditionType.AND.equals(type)) {
            type = FilterConditionType.OR;
        } else if (FilterConditionType.OR.equals(type)) {
            type = FilterConditionType.AND;
        }
    }

    public void normalize() throws UnifyException {
        if (fieldName == null) {
            typeSelector = null;
            paramFieldA = null;
            paramFieldB = null;
            paramInputA = null;
            paramInputB = null;
        } else {
            EntityFieldDef entityFieldDef = entityDef.getFieldDef(fieldName);
            typeSelector = InputWidgetUtils.getFilterConditionTypeSelectDescriptior(entityFieldDef, listType);
            if (type != null) {
                if (!InputWidgetUtils.isSupportedFilterConditionType(entityFieldDef, type, listType)) {
                    type = null;
                }
            }

            if (type == null) {
                paramFieldA = null;
                paramFieldB = null;
                paramInputA = null;
                paramInputB = null;
            } else {
                if (type.isFieldVal() || type.isParameterVal()) {
                    paramInputA = null;
                    paramInputB = null;
                } else {
                    if (type.isSingleParam()) {
                        paramInputA = evalInput(entityFieldDef, paramInputA);
                        paramInputB = null;
                    } else if (type.isAmongst()) {
                        paramInputA = evalMultiInput(entityFieldDef, paramInputA);
                        paramInputB = null;
                    } else if (type.isRange()) {
                        paramInputA = evalInput(entityFieldDef, paramInputA);
                        paramInputB = evalInput(entityFieldDef, paramInputB);
                    } else {
                        paramInputA = null;
                        paramInputB = null;
                    }

                    paramFieldA = null;
                    paramFieldB = null;
                }
            }
        }

        typeChange = false;
        fieldChange = false;
    }

    private AbstractInput<?> evalInput(EntityFieldDef entityFieldDef, AbstractInput<?> currentIn)
            throws UnifyException {
        if (currentIn == null) {
            return InputWidgetUtils.newInput(entityFieldDef, type.isLingual(), false);
        }

        if (fieldChange || typeChange) {
            AbstractInput<?> newIn = InputWidgetUtils.newInput(entityFieldDef, type.isLingual(), false);
            if (!newIn.compatible(currentIn)) {
                return newIn;
            }
        }

        return currentIn;
    }

    private AbstractInput<?> evalMultiInput(EntityFieldDef entityFieldDef, AbstractInput<?> currentIn)
            throws UnifyException {
        if (currentIn == null) {
            return InputWidgetUtils.newMultiInput(entityFieldDef);
        }

        if (fieldChange || typeChange) {
            AbstractInput<?> newIn = InputWidgetUtils.newMultiInput(entityFieldDef);
            if (!newIn.compatible(currentIn)) {
                return newIn;
            }
        }

        return currentIn;
    }

    @Override
    public String toString() {
        return "FilterCondition [type=" + type + ", listType=" + listType + ", typeSelector=" + typeSelector
                + ", fieldName=" + fieldName + ", paramFieldA=" + paramFieldA + ", paramFieldB=" + paramFieldB
                + ", paramInputA=" + paramInputA + ", paramInputB=" + paramInputB + ", ownerInstId=" + ownerInstId
                + ", depth=" + depth + ", typeChange=" + typeChange + ", fieldChange=" + fieldChange + ", editable="
                + editable + "]";
    }
}
