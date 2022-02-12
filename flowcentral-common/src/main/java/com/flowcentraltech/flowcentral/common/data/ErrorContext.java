/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.Collection;
import java.util.List;

/**
 * Error context.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ErrorContext {

    void addValidationError(String message);

    void addValidationError(FormMessage message);
    
    void addValidationError(String fieldName, String message);

    void clearValidationErrors();

    boolean isWithFormErrors();

    boolean isWithFieldErrors();

    boolean isWithFieldError(String fieldName);

    boolean isWithFieldError(Collection<String> fieldNames);

    String getFieldError(String fieldName);

    boolean isWithValidationErrors();

    List<FormMessage> getValidationErrors();

}
