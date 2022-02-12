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
 * Widget type configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WidgetTypesConfig {

    private List<WidgetTypeConfig> widgetTypeList;

    public List<WidgetTypeConfig> getWidgetTypeList() {
        return widgetTypeList;
    }

    @XmlElement(name = "widgetType", required = true)
    public void setWidgetTypeList(List<WidgetTypeConfig> widgetTypeList) {
        this.widgetTypeList = widgetTypeList;
    }

}
