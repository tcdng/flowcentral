/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import com.flowcentraltech.flowcentral.common.data.TargetFormTabStates;
import com.flowcentraltech.flowcentral.common.data.TargetFormWidgetStates;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;

/**
 * Consolidated form state policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ConsolidatedFormStatePolicy extends UnifyComponent {

    /**
     * Perform the form tab states.
     * 
     * @param instValueStore
     *                       the object value store
     * @param trigger
     *                       optional form trigger
     * @return the form state result
     * @throws UnifyException
     *                        if an error occurs
     */
    TargetFormTabStates evaluateTabStates(ValueStore instValueStore, String trigger) throws UnifyException;

    /**
     * Perform the form widget states.
     * 
     * @param instValueStore
     *                       the object value store
     * @param trigger
     *                       optional form trigger
     * @return the form state result
     * @throws UnifyException
     *                        if an error occurs
     */
    TargetFormWidgetStates evaluateWidgetStates(ValueStore instValueStore, String trigger) throws UnifyException;
}
