/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.writers;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.web.ui.widget.ResponseWriter;

/**
 * Form listing generator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface FormListingGenerator extends UnifyComponent {

    /**
     * Generates form listing into writer.
     * 
     * @param formBeanValueStore
     *                           the form bean value store
     * @param writer
     *                           the response writer
     * @throws UnifyException
     *                        if an error occurs
     */
    void generate(ValueStore formBeanValueStore, ResponseWriter writer) throws UnifyException;
}
