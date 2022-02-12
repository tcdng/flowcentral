/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.flowcentraltech.flowcentral.configuration.constants.FormColumnsType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Form columns type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FormColumnsTypeXmlAdapter extends AbstractEnumConstXmlAdapter<FormColumnsType> {

    public FormColumnsTypeXmlAdapter() {
        super(FormColumnsType.class);
    }
}
