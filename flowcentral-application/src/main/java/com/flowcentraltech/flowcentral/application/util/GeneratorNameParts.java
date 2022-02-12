/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

/**
 * Generator name parts.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class GeneratorNameParts {

    private String fullName;

    private String componentName;

    private String rule;

    public GeneratorNameParts(String fullName, String componentName, String rule) {
        this.fullName = fullName;
        this.componentName = componentName;
        this.rule = rule;
    }

    public String getFullName() {
        return fullName;
    }

    public String getComponentName() {
        return componentName;
    }

    public String getRule() {
        return rule;
    }

}
