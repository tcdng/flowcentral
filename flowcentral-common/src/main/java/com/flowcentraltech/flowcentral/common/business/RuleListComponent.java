/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business;

import java.util.List;
import java.util.Locale;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.Listable;

/**
 * Rule list component.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface RuleListComponent extends UnifyComponent {

    /**
     * Gets rule list.
     * 
     * @param locale
     *               the locale.
     * @return the rule list
     * @throws UnifyException
     *                        if an error occurs
     */
    List<? extends Listable> getRuleList(Locale locale) throws UnifyException;
}
