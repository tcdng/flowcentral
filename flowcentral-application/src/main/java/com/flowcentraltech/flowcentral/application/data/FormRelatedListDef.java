/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

/**
 * Form related list definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormRelatedListDef {

    private String name;

    private String description;

    private String label;

    private String applet;

    private String editAction;

    public FormRelatedListDef(String name, String description, String label, String applet, String editAction) {
        this.description = description;
        this.name = name;
        this.label = label;
        this.applet = applet;
        this.editAction = editAction;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getApplet() {
        return applet;
    }

    public String getEditAction() {
        return editAction;
    }

    @Override
    public String toString() {
        return "FormRelatedListDef [name=" + name + ", description=" + description + ", label=" + label + ", applet="
                + applet + ", editAction=" + editAction + "]";
    }

}
