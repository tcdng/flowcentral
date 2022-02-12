/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Double array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DoubleArrayInput extends AbstractArrayInput<Double[]> {

    public DoubleArrayInput(String editor) {
        super(Double[].class, editor);
    }

    public void setValue(Double[] val) {
        value = val;
    }

    public Double[] getValue() {
        return value;
    }

}
