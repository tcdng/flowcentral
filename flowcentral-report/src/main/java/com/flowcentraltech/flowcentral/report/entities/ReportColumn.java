/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.HAlignType;
import com.tcdng.unify.core.constant.OrderType;

/**
 * Report column.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_REPORTCOLUMN")
public class ReportColumn extends BaseEntity {

    @ForeignKey(ReportConfiguration.class)
    private Long reportConfigurationId;

    @ForeignKey(nullable = true)
    private OrderType columnOrder;

    @ForeignKey(nullable = true)
    private HAlignType horizAlignType;

    @Column(name = "FIELD_NM")
    private String fieldName;

    @Column(name = "COLUMN_DESC", length = 48)
    private String description;

    @Column(name = "COLUMN_TY", length = 96, nullable = true)
    private String type;

    @Column(name = "FORMATTER", length = 64, nullable = true)
    private String formatter;

    @Column(name = "WIDTH_RATIO")
    private int width;

    @Column(name = "GROUP_FG")
    private boolean group;

    @Column(name = "GROUP_ON_NEW_PAGE_FG")
    private boolean groupOnNewPage;

    @Column(name = "SUM_FG")
    private boolean sum;

    @ListOnly(key = "columnOrder", property = "description")
    private String columnOrderDesc;

    @ListOnly(key = "horizAlignType", property = "description")
    private String horizAlignTypeDesc;

    public Long getReportConfigurationId() {
        return reportConfigurationId;
    }

    public void setReportConfigurationId(Long reportConfigurationId) {
        this.reportConfigurationId = reportConfigurationId;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormatter() {
        return formatter;
    }

    public void setFormatter(String formatter) {
        this.formatter = formatter;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public boolean isGroupOnNewPage() {
        return groupOnNewPage;
    }

    public void setGroupOnNewPage(boolean groupOnNewPage) {
        this.groupOnNewPage = groupOnNewPage;
    }

    public boolean isSum() {
        return sum;
    }

    public void setSum(boolean sum) {
        this.sum = sum;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public OrderType getColumnOrder() {
        return columnOrder;
    }

    public void setColumnOrder(OrderType columnOrder) {
        this.columnOrder = columnOrder;
    }

    public String getColumnOrderDesc() {
        return columnOrderDesc;
    }

    public void setColumnOrderDesc(String columnOrderDesc) {
        this.columnOrderDesc = columnOrderDesc;
    }

    public HAlignType getHorizAlignType() {
        return horizAlignType;
    }

    public void setHorizAlignType(HAlignType horizAlignType) {
        this.horizAlignType = horizAlignType;
    }

    public String getHorizAlignTypeDesc() {
        return horizAlignTypeDesc;
    }

    public void setHorizAlignTypeDesc(String horizAlignTypeDesc) {
        this.horizAlignTypeDesc = horizAlignTypeDesc;
    }
}
