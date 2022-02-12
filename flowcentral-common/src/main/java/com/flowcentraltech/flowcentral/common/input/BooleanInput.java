/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Boolean input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BooleanInput extends AbstractInput<Boolean> {

    public BooleanInput(String editor) {
        super(Boolean.class, editor);
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

}
