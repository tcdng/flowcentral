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
import com.tcdng.unify.web.ui.widget.control.DynamicField;

/**
 * Parameter values widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-paramvalues")
public class ParamValuesWidget extends AbstractValueListWidget<ParamValueEntry> {

    private DynamicField paramCtrl;

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        paramCtrl = (DynamicField) addInternalChildWidget(
                "!ui-dynamic binding:paramInput.value descriptorBinding:paramInput.editor");
    }

    public DynamicField getParamCtrl() {
        return paramCtrl;
    }

    public ParamValueEntries getParamValueEntries() throws UnifyException {
        return getValue(ParamValueEntries.class);
    }

    @Override
    protected List<ParamValueEntry> getItemList() throws UnifyException {
        ParamValueEntries paramValueEntries = getParamValueEntries();
        if (paramValueEntries != null) {
            return paramValueEntries.getEntryList();
        }

        return Collections.emptyList();
    }

    @Override
    protected ValueStore newValue(ParamValueEntry paramValueEntry, int index) throws UnifyException {
        return createValueStore(paramValueEntry, index);
    }

}
