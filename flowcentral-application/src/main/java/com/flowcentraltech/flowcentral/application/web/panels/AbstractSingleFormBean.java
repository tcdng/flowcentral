/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;

/**
 * Convenient abstract base class for single form beans.
 * 
 * @author FlowCentral Technologies Limited
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
