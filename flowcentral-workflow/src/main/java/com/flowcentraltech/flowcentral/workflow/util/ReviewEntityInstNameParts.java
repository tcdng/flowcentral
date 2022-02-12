/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.util;

import com.flowcentraltech.flowcentral.application.data.EntityInstNameParts;

/**
 * Review entity instance name parts.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ReviewEntityInstNameParts {

    private String reviewEntityInstName;

    private EntityInstNameParts reviewInstNameParts;

    private EntityInstNameParts instNameParts;

    public ReviewEntityInstNameParts(String reviewEntityInstName, EntityInstNameParts reviewInstNameParts,
            EntityInstNameParts instNameParts) {
        this.reviewEntityInstName = reviewEntityInstName;
        this.reviewInstNameParts = reviewInstNameParts;
        this.instNameParts = instNameParts;
    }

    public String getReviewEntityInstName() {
        return reviewEntityInstName;
    }

    public EntityInstNameParts getReviewInstNameParts() {
        return reviewInstNameParts;
    }

    public EntityInstNameParts getInstNameParts() {
        return instNameParts;
    }

}
