/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;

import com.tcdng.unify.core.annotation.Component;

/**
 * Bean table widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-beantable")
public class BeanTableWidget extends AbstractTableWidget<BeanTable, Object, List<?>> {

    public BeanTableWidget() {
        super(BeanTable.class, Object.class);
    }

}
