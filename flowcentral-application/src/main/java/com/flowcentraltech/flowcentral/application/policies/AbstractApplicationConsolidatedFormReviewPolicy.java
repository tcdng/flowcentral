/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.policies.ConsolidatedFormReviewPolicy;
import com.flowcentraltech.flowcentral.common.data.TargetFormMessage;
import com.flowcentraltech.flowcentral.common.data.TargetFormMessages;
import com.flowcentraltech.flowcentral.configuration.constants.FormReviewType;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Convenient abstract base class for consolidated for review policies.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractApplicationConsolidatedFormReviewPolicy extends AbstractUnifyComponent
        implements ConsolidatedFormReviewPolicy {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private EnvironmentService environmentService;

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Override
    public final List<TargetFormMessage> review(ValueStore instValueStore, FormReviewType reviewType) throws UnifyException {
        TargetFormMessages messages = new TargetFormMessages();
        review(instValueStore, reviewType, messages);
        return messages.getMessages();
    }

    protected abstract void review(ValueStore instValueStore, FormReviewType reviewType, TargetFormMessages messages)
            throws UnifyException;

    protected EnvironmentService environment() {
        return environmentService;
    }

    protected ApplicationModuleService applicationService() {
        return applicationModuleService;
    }

    @SuppressWarnings("unchecked")
    protected void validateChildExists(TargetFormMessages messages, String fkFieldName, Long parentId,
            String entityLongName, String errMsgKey, String... targets) throws UnifyException {
        EntityClassDef entityClassDef = applicationService().getEntityClassDef(entityLongName);
        int count = environment().countAll(
                Query.of((Class<? extends Entity>) entityClassDef.getEntityClass()).addEquals(fkFieldName, parentId));
        if (count == 0) {
            messages.addError(errMsgKey, targets);
        }
    }

    @Override
    protected void onInitialize() throws UnifyException {

    }

    @Override
    protected void onTerminate() throws UnifyException {

    }

}
