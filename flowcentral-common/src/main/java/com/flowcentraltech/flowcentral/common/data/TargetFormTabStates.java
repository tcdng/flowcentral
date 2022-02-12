/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.tcdng.unify.core.constant.TriState;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Target form tab states.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormTabStates {

    private List<TargetFormState> targetStateList;

    public TargetFormTabStates() {
        this.targetStateList = new ArrayList<TargetFormState>();
    }

    public void setTabState(TriState required, TriState visible,
            TriState editable, TriState disabled, String... targets) {
        targetStateList.add(new TargetFormState(FormElementType.TAB, required, visible,
                editable, disabled, targets));
    }

    public List<TargetFormState> getTargetStateList() {
        return DataUtils.unmodifiableList(targetStateList);
    }

    public boolean isWithStateList() {
        return !DataUtils.isBlank(targetStateList);
    }

}
