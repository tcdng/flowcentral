/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.util;

import java.util.Arrays;

import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.tcdng.unify.core.constant.DataType;
import com.tcdng.unify.core.criterion.Amongst;
import com.tcdng.unify.core.criterion.And;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.criterion.IsNull;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Studio query utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class StudioQueryUtils {

    private StudioQueryUtils() {

    }

    public static void addWidgetTypeCriteria(Query<? extends Entity> query, EntityFieldDataType entityFieldDataType) {
        if (entityFieldDataType == null) {
            query.addRestriction(new IsNull("dataType"));
        } else {
            if (entityFieldDataType.isEntityRef()) {
                if (entityFieldDataType.isRefFileUpload()) {
                    query.addRestriction(new And().add(new Equals("applicationName", "application"))
                            .add(new Equals("name", "fileupload")));
                } else {
                    query.addRestriction(new And().add(new Equals("applicationName", "application"))
                            .add(new Amongst("name", Arrays.asList("entitylist", "entitysearch", "entityselect"))));
                }
            } else if (entityFieldDataType.isEnumDataType()) {
                query.addRestriction(new And().add(new Equals("applicationName", "application"))
                        .add(new Equals("name", "enumlist")));
            } else {
                DataType dataType = entityFieldDataType.dataType();
                if (dataType == null) {
                    query.addRestriction(new IsNull("dataType"));
                } else {
                    query.addRestriction(new And().add(new Amongst("dataType", dataType.convertibleFromTypes()))
                            .add(new Equals("listOption", true)));
                }
            }
        }
    }
}
