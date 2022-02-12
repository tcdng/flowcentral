/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.FormColumnsType;

/**
 * Form section definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormSectionDef {

    private List<FormFieldDef> formFieldDefList;

    private String name;

    private String label;

    private FormColumnsType columns;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    public FormSectionDef(List<FormFieldDef> formFieldDefList, String name, String label, FormColumnsType columns, boolean visible,
            boolean editable, boolean disabled) {
        this.formFieldDefList = formFieldDefList;
        this.name = name;
        this.label = label;
        this.columns = columns;
        this.visible = visible;
        this.editable = editable;
        this.disabled = disabled;
    }

    public FormSectionDef(FormSectionDef srcFormSectionDef, List<FormFieldDef> formFieldDefList, FormColumnsType columns) {
        this.formFieldDefList = formFieldDefList;
        this.columns = columns;
        this.name = srcFormSectionDef.name;
        this.label = srcFormSectionDef.label;
        this.visible = srcFormSectionDef.visible;
        this.editable = srcFormSectionDef.editable;
        this.disabled = srcFormSectionDef.disabled;
    }

    public List<FormFieldDef> getFormFieldDefList() {
        return formFieldDefList;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public FormColumnsType getColumns() {
        return columns;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEditable() {
        return editable;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public String toString() {
        return "FormSectionDef [formFieldDefList=" + formFieldDefList + ", name=" + name + ", label=" + label
                + ", columns=" + columns + ", visible=" + visible + ", editable=" + editable + ", disabled=" + disabled
                + "]";
    }

}
