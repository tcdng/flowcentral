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
 * Columns configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class ReportColumnsConfig {

    private List<ReportColumnConfig> columnList;

    public List<ReportColumnConfig> getColumnList() {
        return columnList;
    }

    @XmlElement(name = "column")
    public void setColumnList(List<ReportColumnConfig> columnList) {
        this.columnList = columnList;
    }
}
