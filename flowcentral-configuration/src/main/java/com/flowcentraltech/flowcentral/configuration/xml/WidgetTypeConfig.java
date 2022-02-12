/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.InputType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.InputTypeXmlAdapter;
import com.tcdng.unify.core.constant.DataType;
import com.tcdng.unify.core.util.xml.adapter.DataTypeXmlAdapter;

/**
 * Widget type configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WidgetTypeConfig extends BaseNameConfig {

    private DataType dataType;

    private InputType inputType;

    private String editor;

    private String renderer;

    private boolean stretch;

    private boolean listOption;

    public WidgetTypeConfig() {
        stretch = true;
    }

    public DataType getDataType() {
        return dataType;
    }

    @XmlJavaTypeAdapter(DataTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public InputType getInputType() {
        return inputType;
    }

    @XmlJavaTypeAdapter(InputTypeXmlAdapter.class)
    @XmlAttribute
    public void setInputType(InputType inputType) {
        this.inputType = inputType;
    }

    public String getEditor() {
        return editor;
    }

    @XmlAttribute(required = true)
    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getRenderer() {
        return renderer;
    }

    @XmlAttribute(required = true)
    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public boolean isStretch() {
        return stretch;
    }

    @XmlAttribute
    public void setStretch(boolean stretch) {
        this.stretch = stretch;
    }

    public boolean isListOption() {
        return listOption;
    }

    @XmlAttribute
    public void setListOption(boolean listOption) {
        this.listOption = listOption;
    }

}
