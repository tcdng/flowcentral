/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.entities.AppFormQuery;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;
import com.tcdng.unify.core.util.QueryUtils;

/**
 * Studio form list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformlist")
public class StudioFormListCommand extends AbstractApplicationListCommand<ZeroParams> {

    public StudioFormListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        final Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        if (QueryUtils.isValidLongCriteria(applicationId)) {
            return applicationService().findAppForms((AppFormQuery) new AppFormQuery()
                    .applicationId(applicationId).addSelect("id", "name", "description"));
        }

        return Collections.emptyList();
    }

}
