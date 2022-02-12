/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.adapter;

import com.flowcentraltech.flowcentral.configuration.constants.WorkflowAlertType;
import com.tcdng.unify.core.util.xml.AbstractEnumConstXmlAdapter;

/**
 * Workflow alert type XML adapter.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowAlertTypeXmlAdapter extends AbstractEnumConstXmlAdapter<WorkflowAlertType> {

    public WorkflowAlertTypeXmlAdapter() {
        super(WorkflowAlertType.class);
    }
}
