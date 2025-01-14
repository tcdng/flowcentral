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

package com.flowcentraltech.flowcentral.application.business;

import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.criterion.IsNull;
import com.tcdng.unify.core.criterion.Restriction;

/**
 * Convenient abstract base class for entity based filter generator policies.
 * 
 * @author FlowCentral Technologies Limited
 * @since 1.0
 */
public abstract class AbstractEntityBasedFilterGenerator extends AbstractUnifyComponent
        implements EntityBasedFilterGenerator {

    private static final Restriction ID_NULL_RESTRICTION = new IsNull("id");
    
    @Configurable
    private ApplicationModuleService applicationModuleService;
    
    @Configurable
    private EnvironmentService environmentService;
    
    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

    protected EnvironmentService environment() {
        return environmentService;
    }

    protected Restriction noRestriction() {
        return null;
    }

    protected Restriction noRecordsRestriction() {
        return ID_NULL_RESTRICTION;
    }
}
