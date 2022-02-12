/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.data;

/**
 * Property rule choice definition.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PropertyRuleChoiceDef {

    private PropertyListDef propertyListDef;

    private String choice;

    public PropertyRuleChoiceDef(PropertyListDef propertyListDef, String choice) {
        this.propertyListDef = propertyListDef;
        this.choice = choice;
    }

    public PropertyListDef getPropertyListDef() {
        return propertyListDef;
    }

    public String getChoice() {
        return choice;
    }
}
