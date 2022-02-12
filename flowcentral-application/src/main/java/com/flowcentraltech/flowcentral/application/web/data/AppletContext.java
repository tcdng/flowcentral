/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.data;

import java.util.EnumMap;
import java.util.Map;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.data.EntityDef;
import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.flowcentraltech.flowcentral.common.business.SpecialParamProvider;
import com.flowcentraltech.flowcentral.common.data.AbstractContext;
import com.flowcentraltech.flowcentral.configuration.constants.EntityChildCategoryType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Applet context.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppletContext extends AbstractContext {

    private final AppletUtilities au;
    
    private Map<EntityChildCategoryType, String> entityReferences;

    private boolean readOnly;
    
    private boolean inWorkflow;
    
    private boolean review;
    
    public AppletContext(AppletUtilities au) {
        this.au = au;
        this.entityReferences = new EnumMap<EntityChildCategoryType, String>(EntityChildCategoryType.class);
        for (EntityChildCategoryType type : EntityChildCategoryType.values()) {
            this.entityReferences.put(type, null);
        }
    }

    public AppletUtilities getAu() {
        return au;
    }

    public EnvironmentService getEnvironment() {
        return au.getEnvironment();
    }

    public SpecialParamProvider getSpecialParamProvider() throws UnifyException {
        return au.getSpecialParamProvider();
    }

    public void extractReference(EntityDef entityDef, Object inst) throws UnifyException {
        if (inst instanceof Entity) {
            for (EntityChildCategoryType type : entityReferences.keySet()) {
                if (type.readField() != null && type.readEntity().equals(entityDef.getLongName())) {
                    String ref = DataUtils.getBeanProperty(String.class, inst, type.readField());
                    if (inst instanceof BaseApplicationEntity) {
                        String applicationName = ((BaseApplicationEntity) inst).getApplicationName();
                        ref = ApplicationNameUtils.ensureLongNameReference(applicationName, ref);
                    }

                    entityReferences.put(type, ref);
                }
            }
        }
    }

    public String getReference(EntityChildCategoryType type) {
        String ref = entityReferences.get(type);
        return ref != null ? ref : type.readEntity();
    }
    
    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }
    
    public boolean isReadOnly() {
        return readOnly;
    }
    
    public boolean isReview() {
        return review;
    }

    public void setReview(boolean review) {
        this.review = review;
    }

    public boolean isInWorkflow() {
        return inWorkflow;
    }

    public void setInWorkflow(boolean inWorkflow) {
        this.inWorkflow = inWorkflow;
    }

    public boolean isContextEditable() {
        return !readOnly && (review || !inWorkflow);
    }
}
