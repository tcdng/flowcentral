/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.web.ui.widget.panel.AbstractStandalonePanel;

/**
 * Convenient abstract base class for single form panels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractSingleFormPanel<T extends Entity, U extends AbstractSingleFormBean<T>>
        extends AbstractStandalonePanel implements SingleFormPanel {

    @Override
    public void addPageAliases() throws UnifyException {
        super.addPageAliases();
        getRequestContextUtil().addPageAlias(getId(), DataUtils.toArray(String.class, getAllWidgetIds())); // TODO Move
                                                                                                           // to super
                                                                                                           // class
    }

    @SuppressWarnings("unchecked")
    protected final U getFormBean() throws UnifyException {
        return (U) getValueStore().getValueObject();
    }
}
