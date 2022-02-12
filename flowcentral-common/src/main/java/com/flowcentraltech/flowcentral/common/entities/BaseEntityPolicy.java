/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.system.entities.SequencedEntityPolicy;

/**
 * Base entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("base-entitypolicy")
public class BaseEntityPolicy extends SequencedEntityPolicy {

    public BaseEntityPolicy() {
        super(true); // Set now
    }

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        BaseEntity baseEntity = ((BaseEntity) record);
        baseEntity.setVersionNo(1L);
        Long id = baseEntity.getId();
        if (id == null || id >= 0) {
            return super.preCreate(record, now);
        }

        return id;
    }

    @Override
    public void preUpdate(Entity record, Date now) throws UnifyException {
        super.preUpdate(record, now);
        final BaseEntity baseEntity = ((BaseEntity) record);
        baseEntity.setVersionNo(baseEntity.getVersionNo() + 1L);
    }

    @Override
    public void onUpdateError(final Entity record) {
        final BaseEntity baseEntity = (BaseEntity) record;
        baseEntity.setVersionNo(baseEntity.getVersionNo() - 1L);
    }

}
