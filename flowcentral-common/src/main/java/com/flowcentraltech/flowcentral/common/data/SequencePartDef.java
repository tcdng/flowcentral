/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.data;

import com.flowcentraltech.flowcentral.common.constants.SequencePartType;

/**
 * Sequence part definition
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SequencePartDef {

    private final SequencePartType type;

    private final String text;

    private int numLen;

    public SequencePartDef(SequencePartType type) {
        this.type = type;
        this.text = null;
        this.numLen = 0;
    }

    public SequencePartDef(String text) {
        this.type = SequencePartType.TEXT;
        this.text = text;
        this.numLen = 0;
    }

    public SequencePartDef(SequencePartType type, int numLen) {
        this.type = type;
        this.text = null;
        this.numLen = numLen;
    }

    public SequencePartType getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public int getNumLen() {
        return numLen;
    }

    @Override
    public String toString() {
        return "SequencePartDef [type=" + type + ", text=" + text + ", numLen=" + numLen + "]";
    }
}
