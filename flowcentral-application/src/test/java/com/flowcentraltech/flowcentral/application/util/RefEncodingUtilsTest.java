/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests reference encoding utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class RefEncodingUtilsTest {

    @Test
    public void encodeRefValue() throws Exception {
        String encoded = RefEncodingUtils.encodeRefValue(0, "master.customer", "1001");
        assertEquals("0:master.customer:1001", encoded);
    }

    @Test
    public void decodeRefValue() throws Exception {
        RefDecodedValue value = RefEncodingUtils.decodeRefValue(null);
        assertNull(value);
        
        value = RefEncodingUtils.decodeRefValue("");
        assertNotNull(value);
        assertEquals(0, value.getIndex());
        assertNull(value.getRefLongName());
        assertEquals("", value.getValue());
        assertFalse(value.isLongNameRef());
       
        value = RefEncodingUtils.decodeRefValue("1:master.customer");
        assertNotNull(value);
        assertEquals(0, value.getIndex());
        assertNull(value.getRefLongName());
        assertEquals("1:master.customer", value.getValue());
        assertFalse(value.isLongNameRef());
        
        value = RefEncodingUtils.decodeRefValue("0:master.customer:1001");
        assertNotNull(value);
        assertEquals(0, value.getIndex());
        assertEquals("master.customer", value.getRefLongName());
        assertEquals("1001", value.getValue());
        assertTrue(value.isLongNameRef());
        
        value = RefEncodingUtils.decodeRefValue("4:account.ledger:2001");
        assertNotNull(value);
        assertEquals(4, value.getIndex());
        assertEquals("account.ledger", value.getRefLongName());
        assertEquals("2001", value.getValue());
        assertTrue(value.isLongNameRef());
    }
}
