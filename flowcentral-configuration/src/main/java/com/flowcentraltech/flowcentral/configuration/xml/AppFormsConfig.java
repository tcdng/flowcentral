/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

/**
 * Forms configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppFormsConfig {

    private List<AppFormConfig> formList;

    public List<AppFormConfig> getFormList() {
        return formList;
    }

    @XmlElement(name = "form")
    public void setFormList(List<AppFormConfig> formList) {
        this.formList = formList;
    }

}
