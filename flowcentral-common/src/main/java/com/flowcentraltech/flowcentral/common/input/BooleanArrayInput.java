/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Boolean array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BooleanArrayInput extends AbstractArrayInput<Boolean[]> {

    public BooleanArrayInput(String editor) {
        super(Boolean[].class, editor);
    }

    public void setValue(Boolean[] val) {
        value = val;
    }

    public Boolean[] getValue() {
        return value;
    }

}
