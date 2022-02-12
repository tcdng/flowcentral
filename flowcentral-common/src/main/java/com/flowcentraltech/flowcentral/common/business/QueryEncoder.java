/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.criterion.Update;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Represents a query encoder
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface QueryEncoder extends UnifyComponent {

    /**
     * Encodes a query filter.
     * 
     * @param query
     *              the query to encode
     * @return the encoded filter
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeQueryFilter(Query<? extends Entity> query) throws UnifyException;

    /**
     * Encodes a query order.
     * 
     * @param query
     *              the query to encode
     * @return the encoded order
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeQueryOrder(Query<? extends Entity> query) throws UnifyException;

    /**
     * Encodes an update object.
     * 
     * @param update
     *               the update to encode
     * @return the encoded update
     * @throws UnifyException
     *                        if an error occurs
     */
    String encodeUpdate(Update update) throws UnifyException;
}
