/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.flowcentraltech.flowcentral.configuration.constants.SetValueType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Set value type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class SetValueTypeXmlAdapter extends AbstractEnumConstXmlAdapter<SetValueType> {

    public SetValueTypeXmlAdapter() {
        super(SetValueType.class);
    }
}
