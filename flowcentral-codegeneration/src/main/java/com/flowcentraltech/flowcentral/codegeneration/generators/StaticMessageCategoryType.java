/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.generators;

/**
 * Static message category type.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public enum StaticMessageCategoryType {
    HEADER("Header"),
    APPLET("Applet"),
    CHART("Chart"),
    DASHBOARD("Dashboard"),
    NOTIFICATION("Notification"),
    REPORT("Report"),
    WORKFLOW("Workflow"),
    WIDGET("Widget"),
    SUGGESTION("Suggestion"),
    REF("Reference"),
    ENTITY("Entity"),
    TABLE("Table"),
    FORM("Form"),
    PROPERTY_LIST("Property List"),
    PROPERTY_RULE("Property Rule"),
    ASSIGNMENT_PAGE("Assignment Page");
    
    private final String comment;
    
    private StaticMessageCategoryType(String comment) {
        this.comment = comment;
    }

    public String comment() {
        return comment;
    }
       
}
