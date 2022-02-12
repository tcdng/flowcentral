/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Form tab definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormTabDef {

    private TabContentType contentType;

    private String name;

    private String label;

    private String applet;

    private String reference;

    private String editAction;

    private List<FormSectionDef> formSectionDefList;

    private List<FormFieldDef> condRefDefFormFieldDefList;

    private List<String> fieldNameList;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    private int listOnlyCheck;
    
    public FormTabDef(TabContentType contentType, String name, String label, String applet, String reference,
            String editAction, List<FormSectionDef> formSectionDefList, boolean visible, boolean editable,
            boolean disabled) {
        this.contentType = contentType;
        this.name = name;
        this.label = label;
        this.applet = applet;
        this.reference = reference;
        this.editAction = editAction;
        this.formSectionDefList = formSectionDefList;
        this.visible = visible;
        this.editable = editable;
        this.disabled = disabled;
        this.listOnlyCheck = -1;
    }

    public FormTabDef(FormTabDef srcFormTabDef, List<FormSectionDef> formSectionDefList) {
        this.formSectionDefList = formSectionDefList;
        this.contentType = srcFormTabDef.contentType;
        this.name = srcFormTabDef.name;
        this.label = srcFormTabDef.label;
        this.applet = srcFormTabDef.applet;
        this.reference = srcFormTabDef.reference;
        this.editAction = srcFormTabDef.editAction;
        this.visible = srcFormTabDef.visible;
        this.editable = srcFormTabDef.editable;
        this.disabled = srcFormTabDef.disabled;
        this.listOnlyCheck = srcFormTabDef.listOnlyCheck;
    }

    public TabContentType getContentType() {
        return contentType;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getApplet() {
        return applet;
    }

    public String getReference() {
        return reference;
    }

    public String getEditAction() {
        return editAction;
    }

    public boolean isChildOrChildList() {
        return contentType.isChildOrChildList();
    }

    public boolean isWithListOnlyFields() {
        if (listOnlyCheck < 0) {
            listOnlyCheck = 0;
            for (FormSectionDef formSectionDef : formSectionDefList) {
                for (FormFieldDef formFieldDef : formSectionDef.getFormFieldDefList()) {
                    if (formFieldDef.isListOnly()) {
                        listOnlyCheck = 1;
                        return true;
                    }
                }
            }
        }

        return listOnlyCheck > 0;
    }
    
    public List<FormSectionDef> getFormSectionDefList() {
        return formSectionDefList;
    }

    public List<FormFieldDef> getCondRefDefFormFieldDefList() {
        if (condRefDefFormFieldDefList == null) {
            synchronized(this) {
                if (condRefDefFormFieldDefList == null) {
                    condRefDefFormFieldDefList = new ArrayList<FormFieldDef>();
                    for (FormSectionDef formSectionDef: formSectionDefList) {
                        for (FormFieldDef formFieldDef: formSectionDef.getFormFieldDefList()) {
                            if (formFieldDef.isWithInputRefDef() && formFieldDef.getInputRefDef().isWithCondition()) {
                                condRefDefFormFieldDefList.add(formFieldDef);
                            }
                        }
                    }

                    condRefDefFormFieldDefList = DataUtils.unmodifiableList(condRefDefFormFieldDefList);
                }
            }
        }

        return condRefDefFormFieldDefList;
    }

    public boolean isWithCondRefDefFormFields() {
        return !getCondRefDefFormFieldDefList().isEmpty();
    }
    
    public List<String> getFieldNameList() {
        if (fieldNameList == null) {
            fieldNameList = new ArrayList<String>();
            for (FormSectionDef formSectionDef : formSectionDefList) {
                for (FormFieldDef formFieldDef : formSectionDef.getFormFieldDefList()) {
                    fieldNameList.add(formFieldDef.getFieldName());
                }
            }

            fieldNameList = DataUtils.unmodifiableList(fieldNameList);
        }

        return fieldNameList;
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
        return "FormTabDef [contentType=" + contentType + ", name=" + name + ", label=" + label + ", applet=" + applet
                + ", reference=" + reference + ", editAction=" + editAction + ", formSectionDefList="
                + formSectionDefList + ", fieldNameList=" + fieldNameList + ", visible=" + visible + ", editable="
                + editable + ", disabled=" + disabled + "]";
    }

}
