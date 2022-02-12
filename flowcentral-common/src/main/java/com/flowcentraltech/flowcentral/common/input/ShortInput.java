/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Short input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ShortInput extends AbstractInput<Short> {

    public ShortInput(String editor) {
        super(Short.class, editor);
    }

    public void setValue(Short value) {
        this.value = value;
    }

    public Short getValue() {
        return value;
    }

}
