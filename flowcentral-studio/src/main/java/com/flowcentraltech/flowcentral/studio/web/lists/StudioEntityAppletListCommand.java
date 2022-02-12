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

import com.flowcentraltech.flowcentral.application.entities.AppAppletQuery;
import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Studio entity applet list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioentityappletlist")
public class StudioEntityAppletListCommand extends AbstractApplicationListCommand<StudioEntityFormParams> {

    public StudioEntityAppletListCommand() {
        super(StudioEntityFormParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, StudioEntityFormParams params) throws UnifyException {
        if (params.isPresent()) {
            return ApplicationNameUtils
                    .getListableList(applicationService().findAppApplets((AppAppletQuery) new AppAppletQuery()
                            .entity(params.getEntity()).addSelect("applicationName", "name", "description")));
        }

        return Collections.emptyList();
    }

}
