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
 * Target form widget states.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class TargetFormWidgetStates {

    private List<TargetFormState> targetStateList;

    private List<TargetFormValue> targetValueList;

    public TargetFormWidgetStates() {
        this.targetStateList = new ArrayList<TargetFormState>();
        this.targetValueList = new ArrayList<TargetFormValue>();
    }

    public void setSectionState(TriState required, TriState visible,
            TriState editable, TriState disabled, String... targets) {
        targetStateList.add(new TargetFormState(FormElementType.SECTION, required, visible,
                editable, disabled, targets));
    }

    public void setFieldState(TriState required, TriState visible,
            TriState editable, TriState disabled, String... targets) {
        targetStateList.add(new TargetFormState(FormElementType.FIELD, required, visible,
                editable, disabled, targets));
    }

    public void setFieldValue(String fieldName, Object val) {
        targetValueList.add(new TargetFormValue(fieldName, val));
    }

    public List<TargetFormState> getTargetStateList() {
        return DataUtils.unmodifiableList(targetStateList);
    }
    
    public List<TargetFormValue> getTargetValueList() {
        return DataUtils.unmodifiableList(targetValueList);
    }

    public boolean isWithStateList() {
        return !DataUtils.isBlank(targetStateList);
    }

    public boolean isWithValueList() {
        return !DataUtils.isBlank(targetValueList);
    }
}
