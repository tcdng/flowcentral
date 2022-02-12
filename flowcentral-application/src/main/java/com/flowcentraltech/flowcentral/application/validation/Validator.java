/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.flowcentraltech.flowcentral.common.business.RuleListComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Validator component.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface Validator extends RuleListComponent {

    /**
     * Validates supplied value.
     * 
     * @param val
     *            the value to validate
     * @return true if successfully validated otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean validate(Object val) throws UnifyException;

    /**
     * Validates supplied value using rule.
     * 
     * @param rule
     *             the optional validation rule to use
     * @param val
     *             the value to validate
     * @return true if successfully validated otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean validate(String rule, Object val) throws UnifyException;

    /**
     * Gets a failure message for this validator based on supplied parameters.
     * 
     * @param rule
     *               the validation rule
     * @param params
     *               the message parameters
     * @return the failure message
     * @throws UnifyException
     *                        if an error occurs
     */
    String getFailureMessage(String rule, Object... params) throws UnifyException;
}
