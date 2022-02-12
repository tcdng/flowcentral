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

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;

/**
 * Studio form related applet list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioformrelatedappletlist")
public class StudioFormRelatedAppletListCommand extends AbstractApplicationListCommand<LongParam> {

    public StudioFormRelatedAppletListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParams) throws UnifyException {
        if (longParams.isPresent()) {
            return ApplicationNameUtils
                    .getListableList(applicationService().findFormRelatedAppApplets(longParams.getValue()));
        }

        return Collections.emptyList();
    }

}
