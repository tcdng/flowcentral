/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.AbstractForm.EvaluationMode;
import com.flowcentraltech.flowcentral.configuration.constants.FormReviewType;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Form context evaluator component
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FormContextEvaluator extends UnifyComponent {

    /**
     * Evaluates a form context.
     * 
     * @param ctx
     *                       the form context
     * @param evaluationMode
     *                       the evaluation mode
     * @throws UnifyException
     *                        if an error occurs
     */
    void evaluateFormContext(FormContext ctx, EvaluationMode evaluationMode) throws UnifyException;

    /**
     * Evaluates a form context.
     * 
     * @param ctx
     *                   the form context
     * @param reviewType
     *                   the review type
     * @throws UnifyException
     *                        if an error occurs
     */
    void reviewFormContext(FormContext ctx, FormReviewType reviewType) throws UnifyException;
}
