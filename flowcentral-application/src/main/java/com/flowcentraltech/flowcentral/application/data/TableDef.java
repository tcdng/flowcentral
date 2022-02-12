/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flowcentraltech.flowcentral.application.util.ApplicationEntityNameParts;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.common.data.DefaultReportColumn;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Select;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Table definition;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TableDef extends BaseApplicationEntityDef {

    private EntityDef entityDef;

    private List<TableColumnDef> columnDefList;

    private List<DefaultReportColumn> defaultReportColumnList;

    private LabelSuggestionDef labelSuggestionDef;

    private Select select;

    private String label;

    private int sortHistory;

    private int itemsPerPage;

    private boolean serialNo;

    private boolean sortable;

    private boolean headerToUpperCase;

    private boolean headerCenterAlign;

    private boolean limitSelectToColumns;

    private boolean basicSearch;

    private TableDef(EntityDef entityDef, List<TableColumnDef> columnDefList, String label, int sortHistory,
            int itemsPerPage, boolean serialNo, boolean sortable, boolean headerToUpperCase, boolean headerCenterAlign,
            boolean basicSearch, boolean limitSelectToColumns, ApplicationEntityNameParts nameParts, String description,
            Long id, long version) {
        super(nameParts, description, id, version);
        this.entityDef = entityDef;
        this.columnDefList = columnDefList;
        this.label = label;
        this.sortHistory = sortHistory;
        this.itemsPerPage = itemsPerPage;
        this.serialNo = serialNo;
        this.sortable = sortable;
        this.headerToUpperCase = headerToUpperCase;
        this.headerCenterAlign = headerCenterAlign;
        this.basicSearch = basicSearch;
        this.limitSelectToColumns = limitSelectToColumns;
        if (this.limitSelectToColumns) {
            this.select = new Select().add("id").add("versionNo");
        }

        this.defaultReportColumnList = new ArrayList<DefaultReportColumn>();
        final int len = columnDefList.size();
        for (int i = 0; i < len; i++) {
            TableColumnDef tableColumnDef = columnDefList.get(i);
            this.defaultReportColumnList.add(new DefaultReportColumn(tableColumnDef.getFieldName(), getFieldLabel(i)));
            if (this.limitSelectToColumns) {
                this.select.add(tableColumnDef.getFieldName());
            }
        }

        this.defaultReportColumnList = DataUtils.unmodifiableList(this.defaultReportColumnList);
    }

    public EntityDef getEntityDef() {
        return entityDef;
    }

    public String getFieldLabel(int index) {
        TableColumnDef columnDef = getColumnDef(index);
        if (columnDef.isWithLabel()) {
            return columnDef.getLabel();
        }

        return entityDef.getFieldDef(columnDef.getFieldName()).getFieldLabel();
    }

    public List<TableColumnDef> getColumnDefList() {
        return columnDefList;
    }

    public LabelSuggestionDef getLabelSuggestionDef() {
        if (labelSuggestionDef == null) {
            final int len = columnDefList.size();
            Map<String, String> labelByFieldNames = new HashMap<String, String>();
            for (int i = 0; i < len; i++) {
                labelByFieldNames.put(columnDefList.get(i).getFieldName(), getFieldLabel(i));
            }

            labelSuggestionDef = new LabelSuggestionDef(labelByFieldNames);
        }

        return labelSuggestionDef;
    }

    public List<DefaultReportColumn> getDefaultReportColumnList() {
        return defaultReportColumnList;
    }

    public Select getSelect() {
        return select;
    }

    public String getLabel() {
        return label;
    }

    public int getSortHistory() {
        return sortHistory;
    }

    public int getItemsPerPage() {
        return itemsPerPage;
    }

    public int getColumnCount() {
        return columnDefList.size();
    }

    public boolean isSerialNo() {
        return serialNo;
    }

    public boolean isSortable() {
        return sortable;
    }

    public boolean isHeaderToUpperCase() {
        return headerToUpperCase;
    }

    public boolean isHeaderCenterAlign() {
        return headerCenterAlign;
    }

    public boolean isBasicSearch() {
        return basicSearch;
    }

    public boolean isLimitSelectToColumns() {
        return limitSelectToColumns;
    }

    public boolean isUseSortHistory() {
        return sortHistory > 0;
    }

    public boolean isPagination() {
        return itemsPerPage > 0;
    }

    public TableColumnDef getColumnDef(int index) {
        return columnDefList.get(index);
    }

    public static Builder newBuilder(EntityDef entityDef, String label, boolean serialNo, boolean sortable,
            String longName, String description, Long id, long version) {
        return new Builder(entityDef, label, serialNo, sortable, longName, description, id, version);
    }

    public static class Builder {

        private EntityDef entityDef;

        private List<TempColumnDef> columnDefList;

        private String label;

        private int totalWidth;

        private int sortHistory;

        private int itemsPerPage;

        private boolean serialNo;

        private boolean sortable;

        private boolean headerToUpperCase;

        private boolean headerCenterAlign;

        private boolean basicSearch;

        private boolean limitSelectToColumns;

        private String longName;

        private String description;

        private Long id;

        private long version;

        public Builder(EntityDef entityDef, String label, boolean serialNo, boolean sortable, String longName,
                String description, Long id, long version) {
            this.entityDef = entityDef;
            this.label = label;
            this.serialNo = serialNo;
            this.sortable = sortable;
            this.longName = longName;
            this.id = id;
            this.description = description;
            this.version = version;
            columnDefList = new ArrayList<TempColumnDef>();
        }

        public Builder sortHistory(int sortHistory) {
            this.sortHistory = sortHistory;
            return this;
        }

        public Builder itemsPerPage(int itemsPerPage) {
            this.itemsPerPage = itemsPerPage;
            return this;
        }

        public Builder headerToUpperCase(boolean headerToUpperCase) {
            this.headerToUpperCase = headerToUpperCase;
            return this;
        }

        public Builder headerCenterAlign(boolean headerCenterAlign) {
            this.headerCenterAlign = headerCenterAlign;
            return this;
        }

        public Builder basicSearch(boolean basicSearch) {
            this.basicSearch = basicSearch;
            return this;
        }

        public Builder limitSelectToColumns(boolean limitSelectToColumns) {
            this.limitSelectToColumns = limitSelectToColumns;
            return this;
        }

        public Builder addColumnDef(String fieldName, String renderer, int widthRatio, boolean switchOnChange,
                boolean disabled, boolean editable, boolean sortable) {
            return addColumnDef(null, fieldName, renderer, null, widthRatio, switchOnChange, disabled, editable,
                    sortable);
        }

        public Builder addColumnDef(String label, String fieldName, String renderer, String editor, int widthRatio,
                boolean switchOnChange, boolean disabled, boolean editable, boolean sortable) {
            return addColumnDef(label, fieldName, renderer, editor, null, widthRatio, switchOnChange, disabled,
                    editable, sortable);
        }

        public Builder addColumnDef(String label, String fieldName, String renderer, String editor, String linkAct,
                int widthRatio, boolean switchOnChange, boolean disabled, boolean editable, boolean sortable) {
            if (widthRatio <= 0) {
                widthRatio = 1;
            }

            totalWidth += widthRatio;
            columnDefList.add(new TempColumnDef(label, fieldName, renderer, editor, linkAct, widthRatio, switchOnChange,
                    disabled, editable, sortable));
            return this;
        }

        public TableDef build() throws UnifyException {
            List<TableColumnDef> _columnDefList = new ArrayList<TableColumnDef>();
            int usedPercent = 0;
            int len = columnDefList.size();
            for (int i = 0; i < len; i++) {
                TempColumnDef tempDef = columnDefList.get(i);
                TableColumnDef tableColumnDef = null;
                String fieldName = tempDef.getFieldName();
                String renderer = tempDef.getRenderer();
                String editor = !StringUtils.isBlank(tempDef.getEditor())
                        ? tempDef.getEditor() + " binding:" + fieldName
                        : null;
                String linkAct = tempDef.getLinkAct();
                if (!StringUtils.isBlank(linkAct)) {
                    String formatter = "";
                    int fromIndex = renderer.indexOf("formatter");
                    if (fromIndex > 0) {
                        int toIndex = renderer.indexOf('}', fromIndex);
                        if (toIndex > 0) {
                            formatter = renderer.substring(fromIndex - 1, toIndex + 1);
                        }
                    }

                    renderer = "!ui-link debounce:true preferredCaptionBinding:" + fieldName + formatter + " binding:"
                            + fieldName + " alwaysValueIndex:true eventHandler:$d{!ui-event event:onclick action:$c{"
                            + linkAct + "}}";
                } else {
                    renderer = renderer + " binding:" + fieldName;
                }

                if (i == (len - 1)) {
                    tableColumnDef = new TableColumnDef(tempDef.getLabel(), fieldName,
                            "width:" + (100 - usedPercent) + "%;", renderer, editor,
                            tempDef.isSwitchOnChange(), tempDef.isDisabled(), tempDef.isEditable(),
                            tempDef.isSortable());
                } else {
                    int width = (tempDef.getWidthRatio() * 100) / totalWidth;
                    tableColumnDef = new TableColumnDef(tempDef.getLabel(), fieldName,
                            "width:" + width + "%;", renderer, editor, tempDef.isSwitchOnChange(),
                            tempDef.isDisabled(), tempDef.isEditable(), tempDef.isSortable());
                    usedPercent += width;
                }

                _columnDefList.add(tableColumnDef);
            }

            ApplicationEntityNameParts nameParts = ApplicationNameUtils.getApplicationEntityNameParts(longName);
            return new TableDef(entityDef, DataUtils.unmodifiableList(_columnDefList), label, sortHistory, itemsPerPage,
                    serialNo, sortable, headerToUpperCase, headerCenterAlign, basicSearch, limitSelectToColumns,
                    nameParts, description, id, version);
        }

        private class TempColumnDef {

            private String label;

            private String fieldName;

            private String renderer;

            private String editor;

            private String linkAct;

            private int widthRatio;

            private boolean switchOnChange;

            private boolean disabled;

            private boolean editable;

            private boolean sortable;

            public TempColumnDef(String label, String fieldName, String renderer, String editor, String linkAct,
                    int widthRatio, boolean switchOnChange, boolean disabled, boolean editable, boolean sortable) {
                this.label = label;
                this.fieldName = fieldName;
                this.renderer = renderer;
                this.editor = editor;
                this.linkAct = linkAct;
                this.widthRatio = widthRatio;
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

            public String getRenderer() {
                return renderer;
            }

            public String getEditor() {
                return editor;
            }

            public String getLinkAct() {
                return linkAct;
            }

            public int getWidthRatio() {
                return widthRatio;
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

        }
    }

}
