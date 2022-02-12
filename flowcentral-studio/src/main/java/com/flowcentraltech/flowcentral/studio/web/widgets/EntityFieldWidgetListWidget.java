/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.widgets;

import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityListWidget;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.flowcentraltech.flowcentral.studio.util.StudioQueryUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplAttribute;
import com.tcdng.unify.core.annotation.UplAttributes;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.database.Query;

/**
 * Entity field widget list widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-entityfieldwidgetlist")
@UplAttributes({ @UplAttribute(name = "typeField", type = String.class, mandatory = true),
        @UplAttribute(name = "listKey", type = String.class, defaultVal = "longName"),
        @UplAttribute(name = "ref", type = String[].class, defaultVal = "application.appWidgetTypeRef") })
public class EntityFieldWidgetListWidget extends EntityListWidget {

    @Override
    protected void addMoreResultRestriction(Query<? extends Entity> query) throws UnifyException {
        super.addMoreResultRestriction(query);
        EntityFieldDataType type = getValue(EntityFieldDataType.class, getUplAttribute(String.class, "typeField"));
        if (EntityFieldDataType.LIST_ONLY.equals(type)) {
            AppEntityField appEntityField = (AppEntityField) getValueStore().getValueObject();
            type = getApplicationService().resolveListOnlyEntityDataType(appEntityField);
        }

        StudioQueryUtils.addWidgetTypeCriteria(query, type);
    }

}
