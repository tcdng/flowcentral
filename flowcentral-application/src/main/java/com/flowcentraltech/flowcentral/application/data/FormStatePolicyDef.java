/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.configuration.constants.FormStatePolicyType;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Form state policy definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormStatePolicyDef implements Listable {

    private FormStatePolicyType type;

    private FilterDef onCondition;

    private SetStatesDef setStatesDef;

    private SetValuesDef setValuesDef;

    private Set<String> triggers;

    private String name;

    private String description;

    public FormStatePolicyDef(String name, String description, FormStatePolicyType type, FilterDef onCondition,
            SetStatesDef setStatesDef, SetValuesDef setValuesDef, List<String> triggerList) {
        this.name = name;
        this.description = description;
        this.type = type;
        this.onCondition = onCondition;
        this.setStatesDef = setStatesDef;
        this.setValuesDef = setValuesDef;
        if (!DataUtils.isBlank(triggerList)) {
            this.triggers = Collections.unmodifiableSet(new HashSet<String>(triggerList));
        } else {
            this.triggers = Collections.emptySet();
        }
    }

    @Override
    public String getListDescription() {
        return description;
    }

    @Override
    public String getListKey() {
        return name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public FormStatePolicyType getType() {
        return type;
    }

    public FilterDef getOnCondition() {
        return onCondition;
    }

    public boolean isWithCondition() {
        return onCondition != null;
    }

    public SetStatesDef getSetStatesDef() {
        return setStatesDef;
    }

    public SetValuesDef getSetValuesDef() {
        return setValuesDef;
    }

    public boolean isSetValues() {
        return setValuesDef != null;
    }

    public boolean isTriggered(String src) {
        if (!triggers.isEmpty()) {
            return src != null && triggers.contains(src);
        }
        
        return true;
    }

    @Override
    public String toString() {
        return "FormStatePolicyDef [onCondition=" + onCondition + ", setStatesDef=" + setStatesDef + ", setValuesDef="
                + setValuesDef + ", triggers=" + triggers + ", name=" + name + ", description=" + description + "]";
    }
}
