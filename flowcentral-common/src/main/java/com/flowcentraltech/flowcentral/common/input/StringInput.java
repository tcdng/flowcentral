/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * String input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StringInput extends AbstractInput<String> {

    public StringInput(String editor) {
        super(String.class, editor);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
