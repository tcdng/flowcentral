/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.util.StringUtils;

/**
 * Table column definition;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TableColumnDef {

    private String label;

    private String fieldName;

    private String headerStyle;

    private String cellRenderer;

    private String cellEditor;

    private boolean switchOnChange;

    private boolean disabled;

    private boolean editable;

    private boolean sortable;

    public TableColumnDef(String label, String fieldName, String headerStyle, String cellRenderer, String cellEditor,
            boolean switchOnChange, boolean disabled, boolean editable, boolean sortable) {
        this.label = label;
        this.fieldName = fieldName;
        this.headerStyle = headerStyle;
        this.cellRenderer = cellRenderer;
        this.cellEditor = cellEditor;
        this.switchOnChange = switchOnChange;
        this.disabled = disabled;
        this.editable = editable;
        this.sortable = sortable;
    }

    public String getLabel() {
        return label;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getHeaderStyle() {
        return headerStyle;
    }

    public String getCellRenderer() {
        return cellRenderer;
    }

    public String getCellEditor() {
        return cellEditor;
    }

    public boolean isWithCellEditor() {
        return cellEditor != null;
    }
    
    public boolean isWithLabel() {
        return !StringUtils.isBlank(label);
    }

    public boolean isSwitchOnChange() {
        return switchOnChange;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public boolean isEditable() {
        return editable;
    }

    public boolean isSortable() {
        return sortable;
    }

    @Override
    public String toString() {
        return "TableColumnDef [label=" + label + ", fieldName=" + fieldName + ", headerStyle=" + headerStyle
                + ", cellRenderer=" + cellRenderer + ", cellInput=" + cellEditor + ", sortable=" + sortable + "]";
    }
}
