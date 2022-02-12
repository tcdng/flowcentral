/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Float array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FloatArrayInput extends AbstractArrayInput<Float[]> {

    public FloatArrayInput(String editor) {
        super(Float[].class, editor);
    }

    public void setValue(Float[] val) {
        value = val;
    }

    public Float[] getValue() {
        return value;
    }

}
