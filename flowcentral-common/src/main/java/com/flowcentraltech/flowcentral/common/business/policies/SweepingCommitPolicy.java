/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.configuration.constants.RecordActionType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Database;

/**
 * Sweeping commit policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SweepingCommitPolicy {

    /**
     * Bumps versions of all parents in context.
     * 
     * @param db
     *             the database
     * @param type
     *             the record action type
     * @throws UnifyException
     *                        if an error occurs
     */
    void bumpAllParentVersions(Database db, RecordActionType type) throws UnifyException;
}
