/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import java.util.Map;

/**
 * Label suggestions defintion.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LabelSuggestionDef {

    private Map<String, String> labelByFieldNames;

    public LabelSuggestionDef(Map<String, String> labelByFieldNames) {
        this.labelByFieldNames = labelByFieldNames;
    }
    
    public String getSuggestedLabel(String fieldName) {
        return labelByFieldNames.get(fieldName);
    }
}
