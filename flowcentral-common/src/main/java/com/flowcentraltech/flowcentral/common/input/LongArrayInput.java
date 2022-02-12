/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Long array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LongArrayInput extends AbstractArrayInput<Long[]> {

    public LongArrayInput(String editor) {
        super(Long[].class, editor);
    }

    public void setValue(Long[] val) {
        value = val;
    }

    public Long[] getValue() {
        return value;
    }

}
