/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Code generation provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface CodeGenerationProvider extends UnifyComponent {

    /**
     * Gets code generation applets.
     * 
     * @return the code generation applets
     * @throws UnifyException
     *                        if an error occurs
     */
    List<String> getCodeGenerationApplets() throws UnifyException;

}
