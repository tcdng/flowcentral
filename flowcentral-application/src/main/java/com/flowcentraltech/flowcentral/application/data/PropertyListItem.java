/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Property item class.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyListItem {

    private String name;

    private String description;

    private String value;

    private String displayValue;

    private String editor;

    public PropertyListItem(String name, String description, String value, String displayValue, String editor) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.displayValue = displayValue;
        this.editor = editor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getValue() {
        return value;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getEditor() {
        return editor;
    }
}
