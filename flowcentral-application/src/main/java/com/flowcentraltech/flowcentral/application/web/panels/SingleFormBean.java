/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;

/**
 * Single form bean for single for panels.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SingleFormBean {

    /**
     * Initialize the single form bean.
     * 
     * @param au handle to applet utilities component.
     * 
     * @throws UnifyException if an error occurs
     */
    void init(AppletUtilities au) throws UnifyException;
    
    /**
     * Loads single form bean using supplied entity instance properties.
     * 
     * @param inst
     *             the entity instance
     * @throws UnifyException
     *                        if an error occurs
     */
    void load(Entity inst) throws UnifyException;

    /**
     * Save single form bean to supplied entity instance properties.
     * 
     * @param inst
     *             the entity instance
     * @throws UnifyException
     *                        if an error occurs
     */
    void save(Entity inst) throws UnifyException;
}
