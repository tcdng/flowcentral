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

import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;

/**
 * Workflow editor previous step list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("wfeditprevsteplist")
public class WfEditPrevStepListCommand extends AbstractApplicationListCommand<PrevStepsParams> {

    public WfEditPrevStepListCommand() {
        super(PrevStepsParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, PrevStepsParams params) throws UnifyException {
        if (params.isPresent()) {
            return params.getPrevStepList();
        }

        return Collections.emptyList();
    }

}
