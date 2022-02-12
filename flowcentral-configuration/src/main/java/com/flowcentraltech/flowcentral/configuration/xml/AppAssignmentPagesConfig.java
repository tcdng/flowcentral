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
 * Assignment pages configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppAssignmentPagesConfig {

    private List<AppAssignmentPageConfig> assignmentPageList;

    public List<AppAssignmentPageConfig> getAssignmentPageList() {
        return assignmentPageList;
    }

    @XmlElement(name = "assignmentPage")
    public void setAssignmentPageList(List<AppAssignmentPageConfig> assignmentPageList) {
        this.assignmentPageList = assignmentPageList;
    }

}
