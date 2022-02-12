/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import com.tcdng.unify.core.util.StringUtils;

/**
 * Reference decoded value
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefDecodedValue {

    private int index;

    private String refLongName;

    private Object value;

    public RefDecodedValue(int index, String refLongName, Object value) {
        this.index = index;
        this.refLongName = refLongName;
        this.value = value;
    }

    public RefDecodedValue(Object value) {
        this.index = 0;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public String getRefLongName() {
        return refLongName;
    }

    public Object getValue() {
        return value;
    }
    
    public boolean isLongNameRef() {
        return !StringUtils.isBlank(refLongName);
    }
    
    public boolean isNullValue() {
        return value == null;
    }

    @Override
    public String toString() {
        return "RefDecodedValue [index=" + index + ", refLongName=" + refLongName + ", value=" + value + "]";
    }
}
