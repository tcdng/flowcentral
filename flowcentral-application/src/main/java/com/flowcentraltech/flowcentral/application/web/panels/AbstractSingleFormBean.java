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
 * Convenient abstract base class for single form beans.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractSingleFormBean<T extends Entity> implements SingleFormBean {

    private AppletUtilities au;
    
    @Override
    public final void init(AppletUtilities au) throws UnifyException {
        this.au = au;
        doInit();
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void load(Entity inst) throws UnifyException {
        loadFromEntity((T) inst); 
    }

    @SuppressWarnings("unchecked")
    @Override
    public final void save(Entity inst) throws UnifyException {
        saveToEntity((T) inst); 
    }
    
    protected AppletUtilities getAu() {
        return au;
    }

    protected abstract void doInit() throws UnifyException;
    
    protected abstract void loadFromEntity(T entity) throws UnifyException;
    
    protected abstract void saveToEntity(T entity) throws UnifyException;
}
