/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.common.util.ConfigUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Base configuration named entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("baseconfignamed-entitypolicy")
public class BaseConfigNamedEntityPolicy extends BaseAuditEntityPolicy {

    @Override
    public Object preCreate(Entity record, Date now) throws UnifyException {
        ConfigUtils.preCreate((BaseConfigNamedEntity) record);
        return super.preCreate(record, now);
    }

    @Override
    public void preUpdate(Entity record, Date now) throws UnifyException {
        ConfigUtils.preUpdate((BaseConfigNamedEntity) record);
        super.preUpdate(record, now);
    }
}
