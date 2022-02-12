/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

/**
 * Default report column list.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DefaultReportColumn {

    private String fieldName;

    private String caption;

    public DefaultReportColumn(String fieldName, String caption) {
        this.fieldName = fieldName;
        this.caption = caption;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getCaption() {
        return caption;
    }
}
