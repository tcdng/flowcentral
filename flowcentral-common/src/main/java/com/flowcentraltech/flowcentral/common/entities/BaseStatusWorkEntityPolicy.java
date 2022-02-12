/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.constants.RecordStatus;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Base status work entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("basestatuswork-entitypolicy")
public class BaseStatusWorkEntityPolicy extends BaseWorkEntityPolicy {

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        BaseStatusWorkEntity baseStatusWorkEntity = (BaseStatusWorkEntity) record;
        if (baseStatusWorkEntity.getStatus() == null) {
            baseStatusWorkEntity.setStatus(RecordStatus.ACTIVE);
        }

        return super.preCreate(record, now);
    }

}
