/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseAuditEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application suggestions.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_SUGGESTION")
public class AppSuggestion extends BaseAuditEntity {

    @ForeignKey(AppSuggestionType.class)
    private Long suggestionTypeId;
    
    @Column(length = 512)
    private String suggestion;

    @ListOnly(key = "suggestionTypeId", property = "applicationName")
    private String applicationName;

    @ListOnly(key = "suggestionTypeId", property = "applicationDesc")
    private String applicationDesc;

    @ListOnly(key = "suggestionTypeId", property = "name")
    private String suggestionTypeName;

    @ListOnly(key = "suggestionTypeId", property = "description")
    private String suggestionTypeDesc;
    
    @Override
    public String getDescription() {
        return suggestion;
    }

    public Long getSuggestionTypeId() {
        return suggestionTypeId;
    }

    public void setSuggestionTypeId(Long suggestionTypeId) {
        this.suggestionTypeId = suggestionTypeId;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationDesc() {
        return applicationDesc;
    }

    public void setApplicationDesc(String applicationDesc) {
        this.applicationDesc = applicationDesc;
    }

    public String getSuggestionTypeName() {
        return suggestionTypeName;
    }

    public void setSuggestionTypeName(String suggestionTypeName) {
        this.suggestionTypeName = suggestionTypeName;
    }

    public String getSuggestionTypeDesc() {
        return suggestionTypeDesc;
    }

    public void setSuggestionTypeDesc(String suggestionTypeDesc) {
        this.suggestionTypeDesc = suggestionTypeDesc;
    }

}
