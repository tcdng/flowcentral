/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.workflow.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.flowcentraltech.flowcentral.workflow.util.WorkflowNameUtils.WfAppletNameParts;

/**
 * Workflow name utilities tests.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class WorkflowNameUtilsTest {

    @Test
    public void testGetWfAppletName() throws Exception {
        assertEquals("__wf_security.newUserFlow_approval",
                WorkflowNameUtils.getWfAppletName("security.newUserFlow", "approval"));
    }

    @Test
    public void testGetWfAppletNameParts() throws Exception {
        WfAppletNameParts nameParts = WorkflowNameUtils.getWfAppletNameParts("__wf_security.newUserFlow_approval");
        assertNotNull(nameParts);
        assertEquals("security.newUserFlow", nameParts.getWorkflow());
        assertEquals("approval", nameParts.getStepName());
    }
}
