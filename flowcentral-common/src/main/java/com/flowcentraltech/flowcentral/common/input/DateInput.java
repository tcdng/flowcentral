/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

import java.util.Date;

/**
 * Date input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DateInput extends AbstractInput<Date> {

    public DateInput(String editor) {
        super(Date.class, editor);
    }

    public void setValue(Date value) {
        this.value = value;
    }

    public Date getValue() {
        return value;
    }

}
