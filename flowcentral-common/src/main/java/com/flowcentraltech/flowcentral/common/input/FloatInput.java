/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Float input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FloatInput extends AbstractInput<Float> {

    public FloatInput(String editor) {
        super(Float.class, editor);
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Float getValue() {
        return value;
    }

}
