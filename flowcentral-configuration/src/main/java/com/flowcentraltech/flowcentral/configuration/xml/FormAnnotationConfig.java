/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormAnnotationType;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.FormAnnotationTypeXmlAdapter;
import com.tcdng.unify.core.util.xml.adapter.CDataXmlAdapter;

/**
 * Form annotation configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormAnnotationConfig {

    private FormAnnotationType type;

    private String name;

    private String description;

    private String message;

    private boolean html;

    public FormAnnotationConfig() {
        type = FormAnnotationType.INFO;
    }

    public FormAnnotationType getType() {
        return type;
    }

    @XmlJavaTypeAdapter(FormAnnotationTypeXmlAdapter.class)
    @XmlAttribute
    public void setType(FormAnnotationType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(required = true)
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute(required = true)
    public void setDescription(String description) {
        this.description = description;
    }

    public String getMessage() {
        return message;
    }

    @XmlJavaTypeAdapter(CDataXmlAdapter.class)
    @XmlAttribute(required = true)
    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHtml() {
        return html;
    }

    @XmlAttribute
    public void setHtml(boolean html) {
        this.html = html;
    }

}
