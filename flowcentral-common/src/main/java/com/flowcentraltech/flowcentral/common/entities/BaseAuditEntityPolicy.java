/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import java.util.Date;

import com.flowcentraltech.flowcentral.configuration.constants.DefaultApplicationConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.UserToken;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Entity;

/**
 * Base audit entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("baseaudit-entitypolicy")
public class BaseAuditEntityPolicy extends BaseEntityPolicy {

    @Override
    public Object preCreate(final Entity record, Date now) throws UnifyException {
        final BaseAuditEntity baseAuditEntity = ((BaseAuditEntity) record);
        baseAuditEntity.setCreateDt(now);
        baseAuditEntity.setUpdateDt(now);

        final String loginId = getUserLoginId();
        if (baseAuditEntity.getCreatedBy() == null) {
            baseAuditEntity.setCreatedBy(loginId);
        }
        
        if (baseAuditEntity.getUpdatedBy() == null) {
            baseAuditEntity.setUpdatedBy(loginId);
        }

        return super.preCreate(baseAuditEntity, now);
    }

    @Override
    public void preUpdate(final Entity record, Date now) throws UnifyException {
        super.preUpdate(record, now);
        final BaseAuditEntity baseAuditEntity = ((BaseAuditEntity) record);
        baseAuditEntity.setUpdateDt(now);

        final String loginId = getUserLoginId();
        baseAuditEntity.setUpdatedBy(loginId);
    }

    private String getUserLoginId() throws UnifyException {
        UserToken userToken = getUserToken();
        if (userToken != null) {
            return userToken.getUserLoginId();
        }

        return DefaultApplicationConstants.SYSTEM_LOGINID;
    }
}
