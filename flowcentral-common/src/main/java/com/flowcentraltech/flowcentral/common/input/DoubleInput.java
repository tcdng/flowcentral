/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Double input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class DoubleInput extends AbstractInput<Double> {

    public DoubleInput(String editor) {
        super(Double.class, editor);
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

}
