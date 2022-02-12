/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.List;

import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.AbstractListParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Previous steps parameters.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class PrevStepsParams extends AbstractListParam {

    private List<? extends Listable> prevStepList;

    public PrevStepsParams(List<? extends Listable> prevStepList) {
        this.prevStepList = prevStepList;
    }

    public List<? extends Listable> getPrevStepList() {
        return prevStepList;
    }

    @Override
    public boolean isPresent() {
        return !DataUtils.isBlank(prevStepList);
    }
}
