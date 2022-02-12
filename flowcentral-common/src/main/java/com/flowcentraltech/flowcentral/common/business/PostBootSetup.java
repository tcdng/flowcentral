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
 * Post-boot setup component.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface PostBootSetup extends UnifyComponent {

    /**
     * Performs independent post-boot setup.
     * 
     * @throws UnifyException
     *                        if an error occurs
     */
    void performPostBootSetup() throws UnifyException;
}
