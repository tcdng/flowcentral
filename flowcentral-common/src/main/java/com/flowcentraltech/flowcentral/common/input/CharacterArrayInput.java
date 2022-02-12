/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Character array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CharacterArrayInput extends AbstractArrayInput<Character[]> {

    public CharacterArrayInput(String editor) {
        super(Character[].class, editor);
    }

    public void setValue(Character[] val) {
        value = val;
    }

    public Character[] getValue() {
        return value;
    }

}
