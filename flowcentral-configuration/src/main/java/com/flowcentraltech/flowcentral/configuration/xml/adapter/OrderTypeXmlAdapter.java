/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.tcdng.unify.core.constant.OrderType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Order type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class OrderTypeXmlAdapter extends AbstractEnumConstXmlAdapter<OrderType> {

    public OrderTypeXmlAdapter() {
        super(OrderType.class);
    }
}
