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

import com.flowcentraltech.flowcentral.configuration.constants.FormReviewType;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.constant.MessageType;

/**
 * Form review policy definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormReviewPolicyDef extends FormValidationPolicyDef {

    private Set<FormReviewType> reviewTypes;

    private MessageType messageType;

    public FormReviewPolicyDef(List<FormReviewType> reviewTypeList, FilterDef errorCondition, String name,
            String description, MessageType messageType, String message, String errorMatcher, List<String> targetList) {
        super(errorCondition, name, description, message, errorMatcher, targetList);
        this.messageType = messageType;
        if (!DataUtils.isBlank(reviewTypeList)) {
            this.reviewTypes = Collections.unmodifiableSet(new HashSet<FormReviewType>(reviewTypeList));
        } else {
            this.reviewTypes = Collections.emptySet();
        }
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public boolean supports(FormReviewType type) {
        return reviewTypes.contains(type);
    }

    @Override
    public String toString() {
        return "FormReviewPolicyDef [reviewTypes=" + reviewTypes + ", messageType=" + messageType + ", getName()="
                + getName() + ", getDescription()=" + getDescription() + ", getMessage()=" + getMessage()
                + ", getErrorMatcher()=" + getErrorMatcher() + ", getErrorCondition()=" + getErrorCondition()
                + ", isErrorMatcher()=" + isErrorMatcher() + ", isErrorCondition()=" + isErrorCondition()
                + ", getTarget()=" + getTarget() + ", isWithTarget()=" + isWithTarget() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }
}
