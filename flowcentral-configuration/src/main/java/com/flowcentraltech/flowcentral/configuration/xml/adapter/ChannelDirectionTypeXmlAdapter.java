/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.flowcentraltech.flowcentral.configuration.constants.ChannelDirectionType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Flow direction type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ChannelDirectionTypeXmlAdapter extends AbstractEnumConstXmlAdapter<ChannelDirectionType> {

    public ChannelDirectionTypeXmlAdapter() {
        super(ChannelDirectionType.class);
    }
}
