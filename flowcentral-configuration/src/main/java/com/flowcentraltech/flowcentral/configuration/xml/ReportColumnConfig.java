/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.flowcentraltech.flowcentral.configuration.xml.adapter.HAlignTypeXmlAdapter;
import com.flowcentraltech.flowcentral.configuration.xml.adapter.OrderTypeXmlAdapter;
import com.tcdng.unify.core.constant.HAlignType;
import com.tcdng.unify.core.constant.OrderType;

/**
 * Column configuration.
 * 
 * @author Lateef Ojulari
 * @version 1.0
 */
public class ReportColumnConfig {

    private String fieldName;

    private OrderType columnOrder;

    private HAlignType horizAlignType;

    private String description;

    private String type;

    private String formatter;

    private int width;

    private boolean group;

    private boolean groupOnNewPage;

    private boolean sum;

    public String getFieldName() {
        return fieldName;
    }

    @XmlAttribute(name = "field", required = true)
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
    }

    public OrderType getColumnOrder() {
        return columnOrder;
    }

    @XmlJavaTypeAdapter(OrderTypeXmlAdapter.class)
    @XmlAttribute(name = "order")
    public void setColumnOrder(OrderType columnOrder) {
        this.columnOrder = columnOrder;
    }

    public HAlignType getHorizAlignType() {
        return horizAlignType;
    }

    @XmlJavaTypeAdapter(HAlignTypeXmlAdapter.class)
    @XmlAttribute(name = "halign")
    public void setHorizAlignType(HAlignType horizAlignType) {
        this.horizAlignType = horizAlignType;
    }

    public String getFormatter() {
        return formatter;
    }

    @XmlAttribute
    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public String getDescription() {
        return description;
    }

    @XmlAttribute(required = true)
    public void setDescription(String description) {
        this.description = description;
    }

    public int getWidth() {
        return width;
    }

    @XmlAttribute
    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isGroup() {
        return group;
    }

    @XmlAttribute
    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isGroupOnNewPage() {
        return groupOnNewPage;
    }

    @XmlAttribute
    public void setGroupOnNewPage(boolean groupOnNewPage) {
        this.groupOnNewPage = groupOnNewPage;
    }

    public boolean isSum() {
        return sum;
    }

    @XmlAttribute
    public void setSum(boolean sum) {
        this.sum = sum;
    }

}
