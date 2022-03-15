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
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.LabelSuggestionDef;
import com.flowcentraltech.flowcentral.application.data.TableColumnDef;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.common.data.DefaultReportColumn;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Order;
import com.tcdng.unify.web.ui.widget.EventHandler;

/**
 * Convenient abstract base class for table object.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public abstract class AbstractTable<T, U> {

    private TableDef tableDef;

    private T sourceObject;

    private List<U> dispItemList;

    private Order order;

    private Order defaultOrder;

    private String[] refreshPanelIds;

    private int dispStartIndex;

    private int dispEndIndex;

    private int pageIndex;

    private int numberOfPages;

    private int totalItemCount;

    private boolean basicSearchMode;

    private boolean entryMode;
    
    protected final AppletUtilities au;
    
    private Set<Long> selected;
    
    private TableSelect<?> tableSelect;
    
    private EventHandler[] switchOnChangeHandlers;
    
    public AbstractTable(AppletUtilities au, TableDef tableDef, Order defaultOrder, boolean entryMode) {
        this.au = au;
        this.tableDef = tableDef;
        this.defaultOrder = defaultOrder;
        this.basicSearchMode = tableDef.isBasicSearch();
        this.entryMode = entryMode;
        this.selected = Collections.emptySet();
    }

    public void setTableSelect(TableSelect<?> tableSelect) {
        this.tableSelect = tableSelect;
    }

    public EventHandler[] getSwitchOnChangeHandlers() {
        return switchOnChangeHandlers;
    }

    public void setSwitchOnChangeHandlers(EventHandler[] switchOnChangeHandlers) {
        this.switchOnChangeHandlers = switchOnChangeHandlers;
    }

    public List<?> getSelectedItems() throws UnifyException {
        if (tableSelect != null) {
            return tableSelect.getSelectedItems();
        }
        
        return Collections.emptyList();
    }
    
    public final AppletUtilities getAu() {
        return au;
    }

    public EntityDef getEntityDef() {
        return tableDef.getEntityDef();
    }

    public LabelSuggestionDef getLabelSuggestionDef() {
        return tableDef.getLabelSuggestionDef();
    }

    public TableDef getTableDef() {
        return tableDef;
    }

    public List<TableColumnDef> getColumnDefList() {
        return tableDef.getColumnDefList();
    }

    public int getItemsPerPage() {
        return tableDef.getItemsPerPage();
    }

    public List<DefaultReportColumn> getDefaultReportColumnList() {
        return tableDef.getDefaultReportColumnList();
    }

    public void setSelected(Set<Long> selected) {
        this.selected = selected;
    }

    public boolean isSelected(Long id) {
        return id != null && selected.contains(id);
    }
    
    public boolean isSupportsBasicSearch() {
        return tableDef.isBasicSearch();
    }

    public void setBasicSearchMode(boolean basicSearchMode) {
        this.basicSearchMode = isSupportsBasicSearch() && basicSearchMode;
    }

    public boolean isBasicSearchMode() {
        return basicSearchMode;
    }
    
    public boolean isEntryMode() {
        return entryMode;
    }

    public void setSourceObject(T sourceObject) throws UnifyException {
        this.sourceObject = sourceObject;
        onLoadSourceObject(sourceObject, selected);
        reset();
    }

    public void fireOnChange() throws UnifyException {
        // TODO Recompute 'selected'
        onFireOnChange(sourceObject, selected);
    }

    public T getSourceObject() {
        return sourceObject;
    }

    public Order getOrder() {
        return order != null ? order: defaultOrder;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<U> getDispItemList() {
        return dispItemList;
    }

    public U getDisplayItem(int displayIndex) {
        return dispItemList.get(displayIndex);
    }
    
    public int getDispStartIndex() {
        return dispStartIndex;
    }

    public int getDispEndIndex() {
        return dispEndIndex;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public int getTotalItemCount() {
        return totalItemCount;
    }

    public String[] getRefreshPanelIds() {
        return refreshPanelIds;
    }

    public void setRefreshPanelIds(String[] refreshPanelIds) {
        this.refreshPanelIds = refreshPanelIds;
    }

    public boolean isWithRefreshPanels() {
        return refreshPanelIds != null;
    }

    public void reset() throws UnifyException {
        calcPageDimensions();
        getDispItems();
    }

    public boolean firstPage() throws UnifyException {
        if (tableDef.isPagination()) {
            pageIndex = 0;
            getDispItems();
            return true;
        }

        getDispItems();
        return false;
    }

    public boolean prevPage() throws UnifyException {
        if (tableDef.isPagination() && pageIndex > 0) {
            pageIndex--;
            getDispItems();
            return true;
        }

        return false;
    }

    public boolean nextPage() throws UnifyException {
        if (tableDef.isPagination() && pageIndex < (numberOfPages - 1)) {
            pageIndex++;
            getDispItems();
            return true;
        }

        return false;
    }

    public boolean lastPage() throws UnifyException {
        if (tableDef.isPagination()) {
            pageIndex = numberOfPages - 1;
            getDispItems();
            return true;
        }

        return false;
    }

    public boolean isAtFirstPage() {
        return numberOfPages == 0 || pageIndex == 0;
    }

    public boolean isAtLastPage() {
        return numberOfPages == 0 || pageIndex >= numberOfPages - 1;
    }

    protected abstract void onLoadSourceObject(T sourceObject, Set<Long> selected) throws UnifyException;

    protected abstract void onFireOnChange(T sourceObject, Set<Long> selected) throws UnifyException;

    protected abstract int getSourceObjectSize(T sourceObject) throws UnifyException;

    protected abstract List<U> getDisplayItems(T sourceObject, int dispStartIndex, int dispEndIndex)
            throws UnifyException;

    private void calcPageDimensions() throws UnifyException {
        pageIndex = 0;
        totalItemCount = getSourceObjectSize(sourceObject);
        if (totalItemCount <= 0) {
            totalItemCount = 0;
            numberOfPages = 0;
        } else {
            if (tableDef.isPagination()) {
                int itemsPerPage = tableDef.getItemsPerPage();
                numberOfPages = totalItemCount / itemsPerPage;
                if (totalItemCount % itemsPerPage > 0) {
                    numberOfPages++;
                }
            } else {
                numberOfPages = 1;
            }
        }
    }

    private void getDispItems() throws UnifyException {
        if (tableDef.isPagination()) {
            int itemsPerPage = tableDef.getItemsPerPage();
            dispStartIndex = pageIndex * itemsPerPage;
            dispEndIndex = dispStartIndex + itemsPerPage;
            if (dispEndIndex > totalItemCount) {
                dispEndIndex = totalItemCount;
            }
        } else {
            dispStartIndex = 0;
            dispEndIndex = totalItemCount;
        }

        dispItemList = getDisplayItems(sourceObject, dispStartIndex, dispEndIndex);
    }
}
