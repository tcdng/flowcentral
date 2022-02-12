/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

import java.math.BigDecimal;

/**
 * Big decimal input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BigDecimalInput extends AbstractInput<BigDecimal> {

    public BigDecimalInput(String editor) {
        super(BigDecimal.class, editor);
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

}
