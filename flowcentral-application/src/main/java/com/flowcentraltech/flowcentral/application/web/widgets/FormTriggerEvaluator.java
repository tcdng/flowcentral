/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;

/**
 * Form trigger evaluator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FormTriggerEvaluator {

    String evaluateTrigger() throws UnifyException;
}
