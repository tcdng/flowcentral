/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import java.util.List;

import com.flowcentraltech.flowcentral.application.data.EntityClassDef;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.AbstractUnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.data.BeanValueListStore;
import com.tcdng.unify.core.data.BeanValueStore;
import com.tcdng.unify.core.data.ValueStore;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Convenient abstract base class for entity set value generators.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractEntitySetValuesGenerator extends AbstractUnifyComponent implements EntitySetValuesGenerator {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    @Configurable
    private EnvironmentService environmentService;

    public final void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
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

    /**
     * Gets the child value store.
     * 
     * @param parentEntityDef
     *                        the parent entity definition
     * @param valueStore
     *                        the parent value store
     * @param childFieldName
     *                        the child field name
     * @return the child record value store
     * @throws UnifyException
     *                        if an error occurs
     */
    @SuppressWarnings("unchecked")
    protected ValueStore getChildValueStore(EntityDef parentEntityDef, ValueStore valueStore, String childFieldName)
            throws UnifyException {
        EntityClassDef _childEntityClassDef = applicationModuleService.getEntityClassDef(applicationModuleService
                .getRefDef(parentEntityDef.getFieldDef(childFieldName).getReferences()).getEntity());
        Restriction _childRestriction = applicationModuleService.getChildRestriction(parentEntityDef, childFieldName,
                (Entity) valueStore.getValueObject());
        Entity childEntity = environment().listLean(Query
                .ofDefaultingToAnd((Class<? extends Entity>) _childEntityClassDef.getEntityClass(), _childRestriction));
        return new BeanValueStore(childEntity);
    }

    /**
     * Gets the child value store.
     * 
     * @param parentEntityDef
     *                        the parent entity definition
     * @param valueStore
     *                        the parent value store
     * @param childFieldName
     *                        the child field name
     * @return the child record value store
     * @throws UnifyException
     *                        if an error occurs
     */
    @SuppressWarnings("unchecked")
    protected ValueStore getChildListValueStore(EntityDef parentEntityDef, ValueStore valueStore, String childFieldName)
            throws UnifyException {
        EntityClassDef _childEntityClassDef = applicationModuleService.getEntityClassDef(applicationModuleService
                .getRefDef(parentEntityDef.getFieldDef(childFieldName).getReferences()).getEntity());
        Restriction _childRestriction = applicationModuleService.getChildRestriction(parentEntityDef, childFieldName,
                (Entity) valueStore.getValueObject());
        List<? extends Entity> childEntityList = environment().listAll(Query
                .ofDefaultingToAnd((Class<? extends Entity>) _childEntityClassDef.getEntityClass(), _childRestriction));
        return new BeanValueListStore(childEntityList);
    }
}
