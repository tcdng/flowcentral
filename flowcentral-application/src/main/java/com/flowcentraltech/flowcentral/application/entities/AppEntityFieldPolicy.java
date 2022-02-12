/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigEntityPolicy;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Application entity field policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("appentityfield-entitypolicy")
public class AppEntityFieldPolicy extends BaseConfigEntityPolicy {

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        AppEntityField appEntityField = ((AppEntityField) record);
        if (appEntityField.getType() == null) {
            appEntityField.setType(EntityFieldType.CUSTOM);
        }

        return super.preCreate(record, now);
    }
}
