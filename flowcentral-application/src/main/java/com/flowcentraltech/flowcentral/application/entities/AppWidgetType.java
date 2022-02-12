/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.configuration.constants.InputType;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.DataType;

/**
 * Application widget type entity;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_WIDGETTYPE")
public class AppWidgetType extends BaseApplicationEntity {

    @ForeignKey
    private DataType dataType;

    @ForeignKey(nullable = true)
    private InputType inputType;

    @Column(length = 512)
    private String editor;

    @Column(length = 512)
    private String renderer;

    @Column
    private boolean stretch;

    @Column
    private boolean listOption;

    @ListOnly(key = "dataType", property = "description")
    private String dataTypeDesc;

    @ListOnly(key = "inputType", property = "description")
    private String inputTypeDesc;

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public InputType getInputType() {
        return inputType;
    }

    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getRenderer() {
        return renderer;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public boolean isStretch() {
        return stretch;
    }

    public void setStretch(boolean stretch) {
        this.stretch = stretch;
    }

    public boolean isListOption() {
        return listOption;
    }

    public void setListOption(boolean listOption) {
        this.listOption = listOption;
    }

    public String getDataTypeDesc() {
        return dataTypeDesc;
    }

    public void setDataTypeDesc(String dataTypeDesc) {
        this.dataTypeDesc = dataTypeDesc;
    }

    public String getInputTypeDesc() {
        return inputTypeDesc;
    }

    public void setInputTypeDesc(String inputTypeDesc) {
        this.inputTypeDesc = inputTypeDesc;
    }

}
