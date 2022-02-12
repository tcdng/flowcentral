/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.Collections;
import java.util.List;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.control.DynamicField;

/**
 * Search widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-search")
public class SearchWidget extends AbstractValueListWidget<SearchEntry> {

    private DynamicField paramCtrl;

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        paramCtrl = (DynamicField) addInternalChildWidget(
                "!ui-dynamic binding:paramInput.value descriptorBinding:paramInput.editor");
    }

    @Action
    public void normalize() throws UnifyException {
        SearchEntries searchEntries = getSearchEntries();
        if (searchEntries != null) {
            searchEntries.normalize();
        }
    }

    public DynamicField getParamCtrl() {
        return paramCtrl;
    }

    public SearchEntries getSearchEntries() throws UnifyException {
        return getValue(SearchEntries.class);
    }

    @Override
    protected List<SearchEntry> getItemList() throws UnifyException {
        SearchEntries searchEntries = getSearchEntries();
        if (searchEntries != null) {
            return searchEntries.getEntryList();
        }

        return Collections.emptyList();
    }

    @Override
    protected ValueStore newValue(SearchEntry searchEntry, int index) throws UnifyException {
        return createValueStore(searchEntry, index);
    }

}
