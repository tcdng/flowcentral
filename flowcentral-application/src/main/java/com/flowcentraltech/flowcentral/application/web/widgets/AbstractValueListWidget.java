/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.ui.DataTransferBlock;
import com.tcdng.unify.web.ui.widget.AbstractValueListMultiControl;
import com.tcdng.unify.web.ui.widget.Control;

/**
 * Convenient abstract base class for value list widgets.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractValueListWidget<T> extends AbstractValueListMultiControl<ValueStore, T> {

    @Override
    public void populate(DataTransferBlock transferBlock) throws UnifyException {
        if (transferBlock != null) {
            DataTransferBlock ctrlBlock = transferBlock.getChildBlock();
            Control control = (Control) getChildWidgetInfo(ctrlBlock.getId()).getWidget();
            if (ctrlBlock.getChildBlock() == null) {
                control.setValueStore(getValueList().get(ctrlBlock.getItemIndex()));
            } else {
                control.setValueStore(getValueList().get(ctrlBlock.getChildBlock().getItemIndex()));
            }

            control.populate(ctrlBlock);
        }
    }

    @Override
    protected void onCreateValueList(List<ValueStore> valueStoreList) throws UnifyException {

    }

}
