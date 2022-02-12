/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.tcdng.unify.core.constant.HAlignType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Horizontal alignment type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class HAlignTypeXmlAdapter extends AbstractEnumConstXmlAdapter<HAlignType> {

    public HAlignTypeXmlAdapter() {
        super(HAlignType.class);
    }
}
