/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import com.flowcentraltech.flowcentral.application.web.writers.FormListingGenerator;
import com.flowcentraltech.flowcentral.common.web.lists.AbstractEntityTypeListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.StringParam;

/**
 * Studio form listing generator list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiolistinggeneratorlist")
public class StudioFormListingGeneratorListCommand
        extends AbstractEntityTypeListCommand<FormListingGenerator, StringParam> {

    public StudioFormListingGeneratorListCommand() {
        super(FormListingGenerator.class, StringParam.class);
    }

    @Override
    protected String getEntityName(StringParam param) throws UnifyException {
        if (param.isPresent()) {
            return param.getValue();
        }

        return null;
    }

}
