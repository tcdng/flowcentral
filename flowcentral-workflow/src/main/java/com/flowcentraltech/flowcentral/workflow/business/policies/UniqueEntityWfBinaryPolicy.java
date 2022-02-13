/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.business.policies;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.data.UniqueConstraintDef;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.policies.AbstractWfBinaryPolicy;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.data.ValueStoreReader;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Unique entity workflow binary policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "uniqueentity-wfbinarypolicy", description = "$m{workflow.binarypolicy.uniqueentity}")
public class UniqueEntityWfBinaryPolicy extends AbstractWfBinaryPolicy {

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

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public boolean evaluate(ValueStoreReader wfItemReader, String entity, String rule) throws UnifyException {
        EntityDef entityDef = applicationModuleService.getEntityDef(entity);
        if (entityDef.isWithUniqueConstraints()) {
            EntityClassDef entityClassDef = applicationModuleService.getEntityClassDef(entity);
            Long id = wfItemReader.read(Long.class, "id");
            for (UniqueConstraintDef uniqueConstraintDef: entityDef.getUniqueConstraintList()) {
                Query query = Query.of((Class<? extends Entity>) entityClassDef.getEntityClass());
                if (id != null) {
                    query.addNotEquals("id", id);
                }

                for (String fieldName : uniqueConstraintDef.getFieldList()) {
                    query.addEquals(fieldName, wfItemReader.read(fieldName));
                }

                if (!query.isEmptyCriteria() && environmentService.countAll(query) > 0) {
                    return true;
                }
            }
        }
        
        return false;
    }

    @Override
    public List<? extends Listable> getRuleList(Locale locale) throws UnifyException {
        return Collections.emptyList();
    }

}