/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.HashSet;
import java.util.List;

import com.flowcentraltech.flowcentral.application.data.FormActionDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.ui.widget.AbstractValueListMultiControl;
import com.tcdng.unify.web.ui.widget.Control;
import com.tcdng.unify.web.ui.widget.WriteWork;

/**
 * Form action buttons.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-formactionbuttons")
public class FormActionButtons extends AbstractValueListMultiControl<ValueStore, FormActionDef> {

    public static final String WORK_SHOWACTIONSET = "showActionSet";

    private Control actionCtrl;

    @Override
    protected void doOnPageConstruct() throws UnifyException {
        actionCtrl = (Control) addInternalChildWidget(
                "!ui-button captionBinding:label symbolBinding:symbol styleClassBinding:styleClass binding:name");
        actionCtrl.setGroupId(getId());
    }

    @Override
    public void addPageAliases() throws UnifyException {
        addPageAlias(actionCtrl);
    }

    @Override
    public boolean isLayoutCaption() {
        return false;
    }

    @Override
    public void setAlternateMode(boolean alternateMode) {
        super.setAlternateMode(alternateMode);
        actionCtrl.setAlternateMode(alternateMode);
    }

    @Override
    public WriteWork getWriteWork() throws UnifyException {
        WriteWork work = super.getWriteWork();
        if (work.get(WORK_SHOWACTIONSET) == null) {
            work.set(WORK_SHOWACTIONSET, new HashSet<String>());
        }

        return work;
    }

    public Control getActionCtrl() {
        return actionCtrl;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected List<FormActionDef> getItemList() throws UnifyException {
        return (List<FormActionDef>) getValue();
    }

    @Override
    protected ValueStore newValue(FormActionDef item, int index) throws UnifyException {
        return createValueStore(item, index);
    }

    @Override
    protected void onCreateValueList(List<ValueStore> valueList) throws UnifyException {

    }
}
