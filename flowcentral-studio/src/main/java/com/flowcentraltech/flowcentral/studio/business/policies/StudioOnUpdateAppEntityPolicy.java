/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.AppEntity;
import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityBaseType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.database.Query;

/**
 * Studio on update application entity policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioonupdateappentity-policy")
public class StudioOnUpdateAppEntityPolicy extends StudioOnCreateComponentPolicy {

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        super.doExecutePreAction(ctx);
        AppEntity appEntity = (AppEntity) ctx.getInst();
        // Update base fields if necessary
        EntityBaseType currentBaseType = environment().value(EntityBaseType.class, "baseType",
                Query.of(AppEntity.class).addEquals("id", appEntity.getId()));
        if (!currentBaseType.equals(appEntity.getBaseType())) {
            // Delete old base fields
            final Long appEntityId = appEntity.getId();
            environment().deleteAll(Query.of(AppEntityField.class).addEquals("type", EntityFieldType.BASE)
                    .addEquals("appEntityId", appEntityId));

            // Add new base fields
            List<AppEntityField> newBaseFieldList = getAms().getEntityBaseTypeFieldList(appEntity.getBaseType(),
                    ConfigType.CUSTOM);
            for (AppEntityField appEntityField : newBaseFieldList) {
                appEntityField.setAppEntityId(appEntityId);
                environment().create(appEntityField);
            }
        }
    }

}
