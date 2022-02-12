/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Integer input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class IntegerInput extends AbstractInput<Integer> {

    public IntegerInput(String editor) {
        super(Integer.class, editor);
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

}
