/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.business.policies;

import java.util.List;

import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.ParamConfig;
import com.tcdng.unify.core.database.Entity;

/**
 * Parameter configuration list provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ParamConfigListProvider extends UnifyComponent {

    /**
     * Gets the parameter configuration list category based on supplied entity
     * instance.
     * 
     * @param entityInst
     *                   the entity instance
     * @return the category
     * @throws UnifyException
     *                        if an error occurs
     */
    String getCategory(Entity entityInst) throws UnifyException;

    /**
     * Get parameter configuration list based on supplied entity instance.
     * 
     * @param entityInst
     *                   the entity instance
     * @return list of parameter configurations
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ParamConfig> getParamConfigList(Entity entityInst) throws UnifyException;
}
