/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

import com.flowcentraltech.flowcentral.configuration.constants.FormAnnotationType;

/**
 * Form annotation definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormAnnotationDef {

    private FormAnnotationType type;

    private String name;

    private String description;

    private String message;

    private boolean html;

    public FormAnnotationDef(FormAnnotationType type, String name, String description, String message, boolean html) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.message = message;
        this.html = html;
    }

    public FormAnnotationType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getMessage() {
        return message;
    }

    public boolean isHtml() {
        return html;
    }

    @Override
    public String toString() {
        return "FormAnnotationDef [type=" + type + ", name=" + name + ", description=" + description + ", message="
                + message + ", html=" + html + "]";
    }
}
