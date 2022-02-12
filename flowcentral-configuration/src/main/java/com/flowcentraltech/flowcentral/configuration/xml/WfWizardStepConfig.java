/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Workflow wizard step configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WfWizardStepConfig extends BaseNameConfig {

    private String form;

    private String reference;

    public String getForm() {
        return form;
    }

    @XmlAttribute(required = true)
    public void setForm(String form) {
        this.form = form;
    }

    public String getReference() {
        return reference;
    }

    @XmlAttribute
    public void setReference(String reference) {
        this.reference = reference;
    }

}
