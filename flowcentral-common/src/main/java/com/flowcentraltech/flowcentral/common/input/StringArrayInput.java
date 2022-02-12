/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * String array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StringArrayInput extends AbstractArrayInput<String[]> {

    public StringArrayInput(String editor) {
        super(String[].class, editor);
    }

    public void setValue(String[] val) {
        value = val;
    }

    public String[] getValue() {
        return value;
    }

}
