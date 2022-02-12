/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Suggestion types configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SuggestionTypesConfig {

    private List<SuggestionTypeConfig> suggestionTypeList;

    public List<SuggestionTypeConfig> getSuggestionTypeList() {
        return suggestionTypeList;
    }

    @XmlElement(name = "suggestionType", required = true)
    public void setSuggestionTypeList(List<SuggestionTypeConfig> suggestionTypeList) {
        this.suggestionTypeList = suggestionTypeList;
    }

}
