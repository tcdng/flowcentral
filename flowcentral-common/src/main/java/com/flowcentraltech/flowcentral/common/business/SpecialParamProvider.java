/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Special parameter provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SpecialParamProvider extends UnifyComponent {

    /**
     * Resolves a special parameter.
     * 
     * @param param
     *              the parameter to resolve
     * @return the resolved parameter otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    Object resolveSpecialParameter(String param) throws UnifyException;
}
