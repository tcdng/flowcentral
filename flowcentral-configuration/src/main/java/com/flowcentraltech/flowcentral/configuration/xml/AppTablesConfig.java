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
 * Tables configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppTablesConfig {

    private List<AppTableConfig> tableList;

    public List<AppTableConfig> getTableList() {
        return tableList;
    }

    @XmlElement(name = "table")
    public void setTableList(List<AppTableConfig> tableList) {
        this.tableList = tableList;
    }

}
