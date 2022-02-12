/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import java.util.Set;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Bean table policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface BeanTablePolicy extends UnifyComponent {

    /**
     * Handles on data load.
     * 
     * @param valueStore
     *                   the data value store object
     * @param selected
     *                   selected item IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    void onLoad(ValueStore valueStore, Set<Long> selected) throws UnifyException;

    /**
     * Handles on data change.
     * 
     * @param valueStore
     *                   the data value store object
     * @param selected
     *                   selected item IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    void onChange(ValueStore valueStore, Set<Long> selected) throws UnifyException;
}
