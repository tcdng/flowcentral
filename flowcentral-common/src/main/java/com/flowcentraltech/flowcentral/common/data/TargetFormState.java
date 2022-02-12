/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.tcdng.unify.core.constant.TriState;

/**
 * Target form state.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormState implements FormStateRule {

    private FormElementType type;

    private Set<String> target;

    private TriState required;

    private TriState visible;

    private TriState editable;

    private TriState disabled;

    public TargetFormState(FormElementType type, TriState required, TriState visible,
            TriState editable, TriState disabled, String... target) {
        this.type = type;
        this.target = new HashSet<String>(Arrays.asList(target));
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

}
