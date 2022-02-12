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
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.control.DynamicField;

/**
 * Set values widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-setvalues")
public class SetValuesWidget extends AbstractValueListWidget<SetValueEntry> {

    private Control fieldSelectCtrl;

    private Control typeSelectCtrl;

    private DynamicField paramCtrl;

    private Control deleteCtrl;

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        fieldSelectCtrl = (Control) addInternalChildWidget(
                "!ui-select blankOption:$s{} list:entitysetvaluefielddeflist listParams:$l{entityDef} binding:fieldName");
        typeSelectCtrl = (Control) addInternalChildWidget(
                "!ui-select blankOption:$s{} list:entitysetvalueoptionlist listParams:$l{entityDef fieldName} binding:type");
        paramCtrl = (DynamicField) addInternalChildWidget(
                "!ui-dynamic binding:paramInput.value descriptorBinding:paramInput.editor");
        deleteCtrl = (Control) addInternalChildWidget(
                "!ui-button styleClass:$e{abutton} symbol:$s{cross} hint:$m{button.delete.hint} debounce:false");
    }

    @Action
    public void normalize() throws UnifyException {
        SetValueEntries setValueEntries = getSetValueEntries();
        if (setValueEntries != null) {
            setValueEntries.normalize();
        }
    }

    @Action
    public void delete() throws UnifyException {
        getSetValueEntries().removeEntry(getRequestTarget(int.class));
    }

    public Control getFieldSelectCtrl() {
        return fieldSelectCtrl;
    }

    public Control getTypeSelectCtrl() {
        return typeSelectCtrl;
    }

    public DynamicField getParamCtrl() {
        return paramCtrl;
    }

    public Control getDeleteCtrl() {
        return deleteCtrl;
    }

    public SetValueEntries getSetValueEntries() throws UnifyException {
        return getValue(SetValueEntries.class);
    }

    @Override
    protected List<SetValueEntry> getItemList() throws UnifyException {
        SetValueEntries setValueEntries = getSetValueEntries();
        if (setValueEntries != null) {
            return setValueEntries.getEntryList();
        }

        return Collections.emptyList();
    }

    @Override
    protected ValueStore newValue(SetValueEntry setValueEntry, int index) throws UnifyException {
        return createValueStore(setValueEntry, index);
    }

}
