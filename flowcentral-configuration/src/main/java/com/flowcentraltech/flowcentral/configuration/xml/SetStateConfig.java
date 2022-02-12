/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.FormElementTypeXmlAdapter;
import com.tcdng.unify.core.constant.TriState;
import com.tcdng.unify.core.util.xml.adapter.TriStateXmlAdapter;

/**
 * Set state configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetStateConfig {

    private FormElementType type;

    private String target;

    private TriState required;

    private TriState visible;

    private TriState editable;

    private TriState disabled;

    public SetStateConfig() {
        required = TriState.CONFORMING;
        visible = TriState.CONFORMING;
        editable = TriState.CONFORMING;
        disabled = TriState.CONFORMING;
    }

    public FormElementType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(FormElementTypeXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setType(FormElementType type) {
        this.type = type;
    }

    public String getTarget() {
        return target;
    }

    @XmlAttribute(name = "target", required = true)
    public void setTarget(String target) {
        this.target = target;
    }

    public TriState getRequired() {
        return required;
    }

    @XmlJavaTypeAdapter(TriStateXmlAdapter.class)
    @XmlAttribute
    public void setRequired(TriState required) {
        this.required = required;
    }

    public TriState getVisible() {
        return visible;
    }

    @XmlJavaTypeAdapter(TriStateXmlAdapter.class)
    @XmlAttribute
    public void setVisible(TriState visible) {
        this.visible = visible;
    }

    public TriState getEditable() {
        return editable;
    }

    @XmlJavaTypeAdapter(TriStateXmlAdapter.class)
    @XmlAttribute
    public void setEditable(TriState editable) {
        this.editable = editable;
    }

    public TriState getDisabled() {
        return disabled;
    }

    @XmlJavaTypeAdapter(TriStateXmlAdapter.class)
    @XmlAttribute
    public void setDisabled(TriState disabled) {
        this.disabled = disabled;
    }

}
