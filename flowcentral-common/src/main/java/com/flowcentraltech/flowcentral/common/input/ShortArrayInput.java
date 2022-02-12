/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Short array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ShortArrayInput extends AbstractArrayInput<Short[]> {

    public ShortArrayInput(String editor) {
        super(Short[].class, editor);
    }

    public void setValue(Short[] val) {
        value = val;
    }

    public Short[] getValue() {
        return value;
    }

}
