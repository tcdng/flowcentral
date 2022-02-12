/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.List;

import com.tcdng.unify.core.UnifyException;

/**
 * Table select interface.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface TableSelect<T> {

    List<T> getSelectedItems() throws UnifyException;
}
