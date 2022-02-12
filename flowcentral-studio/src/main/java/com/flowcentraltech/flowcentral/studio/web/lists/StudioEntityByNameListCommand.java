/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.entities.AppEntity;
import com.flowcentraltech.flowcentral.application.entities.AppEntityQuery;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.QueryUtils;

/**
 * Studio entity by name list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentitybynamelist")
public class StudioEntityByNameListCommand extends AbstractApplicationListCommand<ZeroParams> {

    public StudioEntityByNameListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        final Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        if (QueryUtils.isValidLongCriteria(applicationId)) {
            List<AppEntity> appEntityList = applicationService()
                    .findAppEntities((AppEntityQuery) new AppEntityQuery().applicationId(applicationId)
                            .addSelect("name", "description").addOrder("description"));
            if (!DataUtils.isBlank(appEntityList)) {
                final String applicationName = (String) getSessionAttribute(
                        StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
                List<ListData> list = new ArrayList<ListData>();
                for (AppEntity appEntity : appEntityList) {
                    list.add(new ListData(
                            ApplicationNameUtils.getApplicationEntityLongName(applicationName, appEntity.getName()),
                            appEntity.getDescription()));
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
