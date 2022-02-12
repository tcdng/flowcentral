/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

import java.util.Date;

/**
 * Date array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DateArrayInput extends AbstractArrayInput<Date[]> {

    public DateArrayInput(String editor) {
        super(Date[].class, editor);
    }

    public void setValue(Date[] val) {
        value = val;
    }

    public Date[] getValue() {
        return value;
    }

}
