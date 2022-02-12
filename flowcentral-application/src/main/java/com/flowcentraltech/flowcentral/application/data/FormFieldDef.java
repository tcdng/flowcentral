/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

/**
 * Form field definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormFieldDef {

    private EntityFieldDef entityFieldDef;

    private WidgetTypeDef widgetTypeDef;

    private RefDef inputRefDef;

    private String fieldLabel;

    private String renderer;

    private int column;

    private boolean switchOnChange;

    private boolean saveAs;

    private boolean required;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    public FormFieldDef(EntityFieldDef entityFieldDef, WidgetTypeDef widgetTypeDef, RefDef inputRefDef,
            String fieldLabel, String renderer, int column, boolean switchOnChange, boolean saveAs, boolean required,
            boolean visible, boolean editable, boolean disabled) {
        this.entityFieldDef = entityFieldDef;
        this.widgetTypeDef = widgetTypeDef;
        this.inputRefDef = inputRefDef;
        this.fieldLabel = fieldLabel;
        this.renderer = renderer;
        this.column = column;
        this.switchOnChange = switchOnChange;
        this.saveAs = saveAs;
        this.required = required;
        this.visible = visible;
        this.editable = editable;
        this.disabled = disabled;
    }

    public FormFieldDef(FormFieldDef srcFormFieldDef, int column) {
        this.column = column;
        this.entityFieldDef = srcFormFieldDef.entityFieldDef;
        this.widgetTypeDef = srcFormFieldDef.widgetTypeDef;
        this.inputRefDef = srcFormFieldDef.inputRefDef;
        this.fieldLabel = srcFormFieldDef.fieldLabel;
        this.renderer = srcFormFieldDef.renderer;
        this.switchOnChange = srcFormFieldDef.switchOnChange;
        this.saveAs = srcFormFieldDef.saveAs;
        this.required = srcFormFieldDef.required;
        this.visible = srcFormFieldDef.visible;
        this.editable = srcFormFieldDef.editable;
        this.disabled = srcFormFieldDef.disabled;
    }

    public String getFieldName() {
        return entityFieldDef.getFieldName();
    }

    public String getWidgetName() {
        return widgetTypeDef.getLongName();
    }

    public RefDef getInputRefDef() {
        return inputRefDef;
    }

    public boolean isWithInputRefDef() {
        return inputRefDef != null;
    }
    
    public String getFieldLabel() {
        return fieldLabel;
    }

    public String getRenderer() {
        return renderer;
    }

    public int getColumn() {
        return column;
    }

    public int getMinLen() {
        return entityFieldDef.getMinLen();
    }

    public int getMaxLen() {
        return entityFieldDef.getMaxLen();
    }

    public boolean isListOnly() {
        return entityFieldDef.isListOnly();
    }

    public boolean isSwitchOnChange() {
        return switchOnChange;
    }

    public boolean isSaveAs() {
        return saveAs;
    }

    public boolean isRequired() {
        return required;
    }

    public boolean isVisible() {
        return visible;
    }

    public boolean isEditable() {
        return editable && !entityFieldDef.isListOnly();
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public String toString() {
        return "FormFieldDef [fieldName=" + getFieldName() + ", fieldLabel=" + fieldLabel + ", renderer=" + renderer
                + ", column=" + column + ", minLen=" + getMinLen() + ", maxLen=" + getMaxLen() + ", switchOnChange="
                + switchOnChange + ", saveAs=" + saveAs + ", required=" + required + ", visible=" + visible
                + ", editable=" + editable + ", disabled=" + disabled + "]";
    }
}
