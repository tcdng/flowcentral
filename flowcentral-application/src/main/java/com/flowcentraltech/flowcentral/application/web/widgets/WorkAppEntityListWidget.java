/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.configuration.constants.EntityBaseType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.Or;
import com.tcdng.unify.core.criterion.Restriction;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Work application entity list widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-workappentitylist")
@UplAttributes({ @UplAttribute(name = "ref", type = String[].class, defaultVal = "application.appEntity"),
        @UplAttribute(name = "direct", type = boolean.class, defaultVal = "true") })
public class WorkAppEntityListWidget extends EntityListWidget {

    private static final Restriction WORK_ENTITY_RESTRICTION = new Or()
            .add(new Equals("type", EntityBaseType.BASE_WORK_ENTITY))
            .add(new Equals("type", EntityBaseType.BASE_STATUS_WORK_ENTITY));

    @Override
    protected void addMoreResultRestriction(Query<? extends Entity> query) throws UnifyException {
        super.addMoreResultRestriction(query);
        query.addRestriction(WORK_ENTITY_RESTRICTION);
    }

}
