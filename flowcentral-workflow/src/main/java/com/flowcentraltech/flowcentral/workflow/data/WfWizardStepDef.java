/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.data;

/**
 * Workflow wizard step definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfWizardStepDef {

    private String name;

    private String description;

    private String label;

    private String form;

    private String reference;

    public WfWizardStepDef(String name, String description, String label, String form, String reference) {
        this.name = name;
        this.description = description;
        this.label = label;
        this.form = form;
        this.reference = reference;
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

    public String getForm() {
        return form;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        return "WfWizardStepDef [name=" + name + ", description=" + description + ", label=" + label + ", form=" + form
                + ", reference=" + reference + "]";
    }

}
