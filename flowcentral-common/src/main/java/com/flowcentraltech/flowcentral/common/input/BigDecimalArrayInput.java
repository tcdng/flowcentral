/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.common.input;

import java.math.BigDecimal;

/**
 * Big decimal array input.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class BigDecimalArrayInput extends AbstractArrayInput<BigDecimal[]> {

    public BigDecimalArrayInput(String editor) {
        super(BigDecimal[].class, editor);
    }

    public void setValue(BigDecimal[] val) {
        value = val;
    }

    public BigDecimal[] getValue() {
        return value;
    }

}
