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

import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Form validation policy definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormValidationPolicyDef {

    private String name;

    private String description;

    private String errorMatcher;

    private FilterDef errorCondition;

    private Set<String> target;

    private String message;

    public FormValidationPolicyDef(FilterDef errorCondition, String name, String description, String message,
            String errorMatcher, List<String> targetList) {
        this.name = name;
        this.description = description;
        this.errorCondition = errorCondition;
        this.message = message;
        this.errorMatcher = errorMatcher;
        if (!DataUtils.isBlank(targetList)) {
            this.target = Collections.unmodifiableSet(new HashSet<String>(targetList));
        } else {
            this.target = Collections.emptySet();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMatcher() {
        return errorMatcher;
    }

    public FilterDef getErrorCondition() {
        return errorCondition;
    }

    public boolean isErrorMatcher() {
        return !StringUtils.isBlank(errorMatcher);
    }

    public boolean isErrorCondition() {
        return errorCondition != null;
    }

    public Set<String> getTarget() {
        return target;
    }
    
    public boolean isWithTarget() {
        return !target.isEmpty();
    }
}
