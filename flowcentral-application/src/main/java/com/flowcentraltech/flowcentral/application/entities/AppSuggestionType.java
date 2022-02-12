/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;

/**
 * Application suggestion type entity;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_SUGGESTIONTYPE")
public class AppSuggestionType extends BaseApplicationEntity {

    @Column(length = 64, nullable = true)
    private String parent;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

}
