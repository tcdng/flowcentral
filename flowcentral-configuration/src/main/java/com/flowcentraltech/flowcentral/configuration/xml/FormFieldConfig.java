/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.WidgetColor;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.WidgetColorXmlAdapter;

/**
 * Form field configuration.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class FormFieldConfig {

    private String name;

    private String label;

    private String inputWidget;

    private String reference;

    private WidgetColor color;
    
    private int column;

    private boolean switchOnChange;

    private boolean saveAs;

    private boolean required;

    private boolean visible;

    private boolean editable;

    private boolean disabled;

    public FormFieldConfig() {
        this.switchOnChange = false;
        this.required = false;
        this.visible = true;
        this.editable = true;
        this.disabled = false;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute
    public void setLabel(String label) {
        this.label = label;
    }

    public String getInputWidget() {
        return inputWidget;
    }

    @XmlAttribute(required = true)
    public void setInputWidget(String inputWidget) {
        this.inputWidget = inputWidget;
    }

    public String getReference() {
        return reference;
    }

    @XmlAttribute
    public void setReference(String reference) {
        this.reference = reference;
    }

    public WidgetColor getColor() {
        return color;
    }

    @XmlJavaTypeAdapter(WidgetColorXmlAdapter.class)
    @XmlAttribute
    public void setColor(WidgetColor color) {
        this.color = color;
    }

    public int getColumn() {
        return column;
    }

    @XmlAttribute(required = true)
    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isSwitchOnChange() {
        return switchOnChange;
    }

    @XmlAttribute
    public void setSwitchOnChange(boolean switchOnChange) {
        this.switchOnChange = switchOnChange;
    }

    public boolean isSaveAs() {
        return saveAs;
    }

    @XmlAttribute
    public void setSaveAs(boolean saveAs) {
        this.saveAs = saveAs;
    }

    public boolean isRequired() {
        return required;
    }

    @XmlAttribute
    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isVisible() {
        return visible;
    }

    @XmlAttribute
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isEditable() {
        return editable;
    }

    @XmlAttribute
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @XmlAttribute
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
