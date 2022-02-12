/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.flowcentraltech.flowcentral.studio.constants.StudioAppComponentType;
import com.flowcentraltech.flowcentral.studio.util.StudioNameUtils.StudioAppletNameParts;

/**
 * Studio name utilities tests.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioNameUtilsTest {

    @Test
    public void testGetStudioAppletName() throws Exception {
        assertEquals("security.apl_45",
                StudioNameUtils.getStudioAppletName("security", StudioAppComponentType.APPLET, 45L));
    }

    @Test
    public void testGetStudioAppletNameParts() throws Exception {
        StudioAppletNameParts nameParts = StudioNameUtils.getStudioAppletNameParts("security.apl_45");
        assertNotNull(nameParts);
        assertEquals("security", nameParts.getApplicationName());
        assertEquals(StudioAppComponentType.APPLET, nameParts.getType());
        assertEquals(Long.valueOf(45L), nameParts.getInstId());
    }
}
