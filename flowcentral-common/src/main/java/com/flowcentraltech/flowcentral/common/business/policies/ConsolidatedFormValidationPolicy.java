/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.common.data.TargetFormMessage;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Consolidated form validation policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ConsolidatedFormValidationPolicy extends UnifyComponent {

    /**
     * Perform the validation of a form's entity object.
     * 
     * @param instValueStore
     *                       the object value store
     * @return the validation result
     * @throws UnifyException
     *                        if an error occurs
     */
    List<TargetFormMessage> validate(ValueStore instValueStore) throws UnifyException;
}
