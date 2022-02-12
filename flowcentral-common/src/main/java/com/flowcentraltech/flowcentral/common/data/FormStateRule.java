/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Set;

import com.tcdng.unify.core.constant.TriState;

/**
 * Form state rule interface.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FormStateRule {

    /**
     * Gets target form element names.
     * 
     * @return the target list
     */
    Set<String> getTarget();

    /**
     * Gets the required state.
     * 
     * @return the required tri-state
     */
    TriState getRequired();

    /**
     * Gets the visible state.
     * 
     * @return the visible tri-state
     */
    TriState getVisible();

    /**
     * Gets the editable state.
     * 
     * @return the editable tri-state
     */
    TriState getEditable();

    /**
     * Gets the disabled state.
     * 
     * @return the disabled tri-state
     */
    TriState getDisabled();

    /**
     * Checks if rule is TAB element rule
     * 
     * @return the indicator
     */
    boolean isTabRule();

    /**
     * Checks if rule is SECTION element rule
     * 
     * @return the indicator
     */
    boolean isSectionRule();

    /**
     * Checks if rule is FIELD element rule
     * 
     * @return the indicator
     */
    boolean isFieldRule();
}
