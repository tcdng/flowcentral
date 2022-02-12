/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntity;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Application table column entity;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_TABLECOLUMN", uniqueConstraints = { @UniqueConstraint({ "appTableId", "field" }) })
public class AppTableColumn extends BaseConfigEntity {

    @ForeignKey(AppTable.class)
    private Long appTableId;

    @Column(length = 64)
    private String field;

    @Column(length = 128)
    private String renderWidget;

    @Column(length = 96, nullable = true)
    private String label;

    @Column(length = 64, nullable = true)
    private String linkAct;

    @Column
    private int widthRatio;

    @Column
    private boolean switchOnChange;

    @Column
    private boolean disabled;

    @Column
    private boolean editable;

    @Column
    private boolean sortable;

    @Override
    public String getDescription() {
        return field;
    }

    public Long getAppTableId() {
        return appTableId;
    }

    public void setAppTableId(Long appTableId) {
        this.appTableId = appTableId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getRenderWidget() {
        return renderWidget;
    }

    public void setRenderWidget(String renderWidget) {
        this.renderWidget = renderWidget;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLinkAct() {
        return linkAct;
    }

    public void setLinkAct(String linkAct) {
        this.linkAct = linkAct;
    }

    public int getWidthRatio() {
        return widthRatio;
    }

    public void setWidthRatio(int widthRatio) {
        this.widthRatio = widthRatio;
    }

    public final boolean isSwitchOnChange() {
        return switchOnChange;
    }

    public final void setSwitchOnChange(boolean switchOnChange) {
        this.switchOnChange = switchOnChange;
    }

    public final boolean isDisabled() {
        return disabled;
    }

    public final void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public final boolean isEditable() {
        return editable;
    }

    public final void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isSortable() {
        return sortable;
    }

    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

}
