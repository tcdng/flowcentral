/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common;

import com.flowcentraltech.flowcentral.common.constants.CommonModuleNameConstants;
import com.tcdng.unify.core.AbstractUnifyComponentTest;
import com.tcdng.unify.core.ApplicationComponents;
import com.tcdng.unify.core.UnifyCorePropertyConstants;
import com.tcdng.unify.core.database.Database;
import com.tcdng.unify.core.database.DatabaseTransactionManager;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;
import com.tcdng.unify.core.system.entities.AbstractSequencedEntity;

/**
 * Convenient abstract base class for flowcentral tests.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralTest extends AbstractUnifyComponentTest {

    @Override
    protected void doAddSettingsAndDependencies() throws Exception {
        super.doAddSettingsAndDependencies();
        addContainerSetting(UnifyCorePropertyConstants.APPLICATION_NAME, "flowCentral");
        addContainerSetting(UnifyCorePropertyConstants.APPLICATION_BOOT,
                CommonModuleNameConstants.APPLICATION_BOOTSERVICE);
    }

    @SuppressWarnings("unchecked")
    protected void deleteAll(Class<? extends Entity>... entityClasses) throws Exception {
        Database db = (Database) getComponent(ApplicationComponents.APPLICATION_DATABASE);
        DatabaseTransactionManager tm = (DatabaseTransactionManager) getComponent(
                ApplicationComponents.APPLICATION_DATABASETRANSACTIONMANAGER);
        tm.beginTransaction();
        try {
            for (Class<? extends Entity> type : entityClasses) {
                if (AbstractSequencedEntity.class.isAssignableFrom(type)) {
                    db.deleteAll(Query.of(type).addGreaterThan("id", 0L));
                } else {
                    db.deleteAll(Query.of(type).ignoreEmptyCriteria(true));
                }
            }
        } finally {
            tm.endTransaction();
        }
    }

}
