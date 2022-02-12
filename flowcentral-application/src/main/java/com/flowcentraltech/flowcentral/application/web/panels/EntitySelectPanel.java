/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.ui.widget.AbstractPanel;

/**
 * Entity select panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityselectpanel")
@UplBinding("web/application/upl/entityselectpanel.upl")
public class EntitySelectPanel extends AbstractPanel {

    @Action
    public void search() throws UnifyException {
        EntitySelect entitySelect = getEntitySelect();
        entitySelect.applyFilterToSearch();
    }

    private EntitySelect getEntitySelect() throws UnifyException {
        return getValue(EntitySelect.class);
    }

}
