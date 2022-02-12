/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

/**
 * Character input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class CharacterInput extends AbstractInput<Character> {

    public CharacterInput(String editor) {
        super(Character.class, editor);
    }

    public void setValue(Character input) {
        this.value = input;
    }

    public Character getValue() {
        return value;
    }

}
