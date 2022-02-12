/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import java.util.Set;

import com.flowcentraltech.flowcentral.common.data.FormStateRule;
import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.tcdng.unify.core.constant.TriState;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Application set state definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetStateDef implements FormStateRule {

    private FormElementType type;

    private Set<String> target;

    private TriState required;

    private TriState visible;

    private TriState editable;

    private TriState disabled;

    public SetStateDef(FormElementType type, Set<String> target, TriState required, TriState visible, TriState editable,
            TriState disabled) {
        this.type = type;
        this.target = DataUtils.unmodifiableSet(target);
        this.required = required;
        this.visible = visible;
        this.editable = editable;
        this.disabled = disabled;
    }

    public FormElementType getType() {
        return type;
    }

    @Override
    public Set<String> getTarget() {
        return target;
    }

    @Override
    public TriState getRequired() {
        return required;
    }

    @Override
    public TriState getVisible() {
        return visible;
    }

    @Override
    public TriState getEditable() {
        return editable;
    }

    @Override
    public TriState getDisabled() {
        return disabled;
    }

    public boolean isAnnotationRule() {
        return type.isAnnotationType();
    }

    @Override
    public boolean isTabRule() {
        return type.isTabType();
    }

    @Override
    public boolean isSectionRule() {
        return type.isSectionType();
    }

    @Override
    public boolean isFieldRule() {
        return type.isFieldType();
    }

    @Override
    public String toString() {
        return "SetStateDef [type=" + type + ", target=" + target + ", required=" + required + ", visible=" + visible
                + ", editable=" + editable + ", disabled=" + disabled + "]";
    }
}
