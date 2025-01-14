/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.flowcentraltech.flowcentral.application.data;

import com.tcdng.unify.core.constant.OrderType;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Table column definition;
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public class TableColumnDef {

    private String label;

    private String fieldName;

    private String headerStyle;

    private String cellRenderer;

    private String cellEditor;

    private OrderType order;

    private int width;

    private boolean switchOnChange;

    private boolean disabled;

    private boolean editable;

    private boolean sortable;

    private boolean summary;

    public TableColumnDef(String label, String fieldName, String headerStyle, String cellRenderer, String cellEditor,
            OrderType order, int width, boolean switchOnChange, boolean disabled, boolean editable, boolean sortable,
            boolean summary) {
        this.label = label;
        this.fieldName = fieldName;
        this.headerStyle = headerStyle;
        this.cellRenderer = cellRenderer;
        this.cellEditor = cellEditor;
        this.order = order;
        this.width = width;
        this.switchOnChange = switchOnChange;
        this.disabled = disabled;
        this.editable = editable;
        this.sortable = sortable;
        this.summary = summary;
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

    public OrderType getOrder() {
        return order;
    }

    public int getWidth() {
        return width;
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

    public boolean isSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return "TableColumnDef [label=" + label + ", fieldName=" + fieldName + ", headerStyle=" + headerStyle
                + ", cellRenderer=" + cellRenderer + ", cellEditor=" + cellEditor + ", order=" + order + ", width="
                + width + ", switchOnChange=" + switchOnChange + ", disabled=" + disabled + ", editable=" + editable
                + ", sortable=" + sortable + ", summary=" + summary + "]";
    }
}
