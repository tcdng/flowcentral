/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Form validation policy configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormValidationPolicyConfig extends BaseNameConfig {

    private String message;

    private String target;

    private String errorMatcher;

    private FilterConfig errorCondition;

    public String getMessage() {
        return message;
    }

    @XmlAttribute(required = true)
    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMatcher() {
        return errorMatcher;
    }

    public String getTarget() {
        return target;
    }

    @XmlAttribute
    public void setTarget(String target) {
        this.target = target;
    }

    @XmlAttribute
    public void setErrorMatcher(String errorMatcher) {
        this.errorMatcher = errorMatcher;
    }

    public FilterConfig getErrorCondition() {
        return errorCondition;
    }

    @XmlElement(required = true)
    public void setErrorCondition(FilterConfig errorCondition) {
        this.errorCondition = errorCondition;
    }

}
