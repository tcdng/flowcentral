/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Entity table widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entitytable")
public class EntityTableWidget extends AbstractTableWidget<EntityTable, Entity, Restriction> {

    public EntityTableWidget() {
        super(EntityTable.class, Entity.class);
    }

    public Long[] getSelectedItemIds() throws UnifyException {
        Integer[] selected = getSelected();
        if (selected != null && selected.length > 0) {
            Long[] ids = new Long[selected.length];
            for (int i = 0; i < selected.length; i++) {
                ids[i] = (Long) getItem(selected[i]).getId();
            }

            return ids;
        }

        return DataUtils.ZEROLEN_LONG_ARRAY;
    }

}
