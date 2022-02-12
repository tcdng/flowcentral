/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Table column configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TableColumnConfig {

    private String field;

    private String label;

    private String renderWidget;

    private String linkAct;

    private int widthRatio;

    private boolean switchOnChange;

    private boolean disabled;

    private boolean editable;

    private boolean sortable;

    public TableColumnConfig() {
        this.sortable = true;
    }

    public String getField() {
        return field;
    }

    @XmlAttribute(required = true)
    public void setField(String field) {
        this.field = field;
    }

    public String getLabel() {
        return label;
    }

    @XmlAttribute
    public void setLabel(String label) {
        this.label = label;
    }

    public String getRenderWidget() {
        return renderWidget;
    }

    @XmlAttribute(required = true)
    public void setRenderWidget(String renderWidget) {
        this.renderWidget = renderWidget;
    }

    public String getLinkAct() {
        return linkAct;
    }

    @XmlAttribute
    public void setLinkAct(String linkAct) {
        this.linkAct = linkAct;
    }

    public int getWidthRatio() {
        return widthRatio;
    }

    @XmlAttribute
    public void setWidthRatio(int widthRatio) {
        this.widthRatio = widthRatio;
    }

    public boolean isSwitchOnChange() {
        return switchOnChange;
    }

    @XmlAttribute
    public void setSwitchOnChange(boolean switchOnChange) {
        this.switchOnChange = switchOnChange;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @XmlAttribute
    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isEditable() {
        return editable;
    }

    @XmlAttribute
    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isSortable() {
        return sortable;
    }

    @XmlAttribute
    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

}
