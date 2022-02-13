/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.tcdng.unify.core.criterion.RestrictionType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Restriction type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RestrictionTypeXmlAdapter extends AbstractEnumConstXmlAdapter<RestrictionType> {

    public RestrictionTypeXmlAdapter() {
        super(RestrictionType.class);
    }
}