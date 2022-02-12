/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Long input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class LongInput extends AbstractInput<Long> {

    public LongInput(String editor) {
        super(Long.class, editor);
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

}
