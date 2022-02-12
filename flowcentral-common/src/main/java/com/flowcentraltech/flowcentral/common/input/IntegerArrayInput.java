/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Integer array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class IntegerArrayInput extends AbstractArrayInput<Integer[]> {

    public IntegerArrayInput(String editor) {
        super(Integer[].class, editor);
    }

    public void setValue(Integer[] val) {
        value = val;
    }

    public Integer[] getValue() {
        return value;
    }

}
