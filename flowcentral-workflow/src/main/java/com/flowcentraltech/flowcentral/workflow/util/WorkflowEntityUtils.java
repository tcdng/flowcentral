/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.workflow.util;

import com.flowcentraltech.flowcentral.application.data.EntityInstNameParts;
import com.tcdng.unify.core.util.StringUtils;

/**
 * Workflow entity utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class WorkflowEntityUtils {

    private WorkflowEntityUtils() {

    }

    public static String getReviewEntityInstName(String reviewEntityName, Long reviewId, String entityName, Long id) {
        if (id == null) {
            id = 0L;
        }

        return StringUtils.concatenateUsingSeparator(':', reviewEntityName, reviewId, entityName, id);
    }

    public static ReviewEntityInstNameParts getReviewEntityInstNameParts(String reviewEntityInstName) {
        String[] po = StringUtils.charSplit(reviewEntityInstName, ':');
        return new ReviewEntityInstNameParts(reviewEntityInstName, new EntityInstNameParts(po[0], Long.valueOf(po[1])),
                new EntityInstNameParts(po[2], Long.valueOf(po[3])));
    }

}
