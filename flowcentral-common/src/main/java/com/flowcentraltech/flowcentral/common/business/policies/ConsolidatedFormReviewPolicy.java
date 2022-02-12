/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.TargetFormMessage;
import com.flowcentraltech.flowcentral.configuration.constants.FormReviewType;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Consolidated form review policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ConsolidatedFormReviewPolicy extends UnifyComponent {

    /**
     * Perform the review of a form's entity object.
     * 
     * @param instValueStore
     *                       the object value store
     * @param reviewType
     *                       the review type
     * @return the review result
     * @throws UnifyException
     *                        if an error occurs
     */
    List<TargetFormMessage> review(ValueStore instValueStore, FormReviewType reviewType) throws UnifyException;
}
