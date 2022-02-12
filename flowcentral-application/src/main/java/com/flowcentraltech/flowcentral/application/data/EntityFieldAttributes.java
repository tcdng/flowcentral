/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Entity field attributes.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface EntityFieldAttributes {

    String getSuggestionType();
    
    int getMinLen();

    int getMaxLen();
    
    int getPrecision();
    
    int getScale();
}
