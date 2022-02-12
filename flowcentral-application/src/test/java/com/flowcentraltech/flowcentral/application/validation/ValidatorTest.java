/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.flowcentraltech.flowcentral.common.AbstractFlowCentralTest;

/**
 * Validator component tests.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class ValidatorTest extends AbstractFlowCentralTest {

    @Test
    public void testEmailValidator() throws Exception {
        Validator validator = getValidator("fc-emailvalidator");
        assertFalse(validator.validate(null));
        assertFalse(validator.validate("abc"));
        assertFalse(validator.validate("abc.com"));
        assertTrue(validator.validate("info@tcdng.com"));
        assertTrue(validator.validate("lateef.ojulari@tcdng.com"));
    }

    @Test
    public void testMobileValidator() throws Exception {
        Validator validator = getValidator("fc-mobilevalidator");
        assertFalse(validator.validate(null));
        assertFalse(validator.validate(234));
        assertFalse(validator.validate("abc"));
        assertFalse(validator.validate("124"));
        assertTrue(validator.validate("08020948192"));
        assertTrue(validator.validate("720948192"));
        assertTrue(validator.validate("+2348020948192"));
    }

    @Test
    public void testWebsiteValidator() throws Exception {
        Validator validator = getValidator("fc-websitevalidator");
        assertFalse(validator.validate(null));
        assertFalse(validator.validate(234));
        assertFalse(validator.validate("abc"));
        assertFalse(validator.validate("http:/tcdng.com"));
        assertFalse(validator.validate("https:/tcdng.com"));
        assertTrue(validator.validate("tcdng.com"));
        assertTrue(validator.validate("www.tcdng.com"));
        assertTrue(validator.validate("http://tcdng.com"));
        assertTrue(validator.validate("https://tcdng.com"));
        assertTrue(validator.validate("http://www.tcdng.com"));
        assertTrue(validator.validate("https://www.tcdng.com"));
    }

    @Test
    public void testDomainValidator() throws Exception {
        Validator validator = getValidator("fc-domainvalidator");
        assertFalse(validator.validate(null));
        assertFalse(validator.validate(234));
        assertFalse(validator.validate("abc"));
        assertFalse(validator.validate("http:/tcdng.com"));
        assertFalse(validator.validate("https:/tcdng.com"));
        assertTrue(validator.validate("tcdng.com"));
        assertTrue(validator.validate("contact.tcdng.com"));
        assertFalse(validator.validate(".com"));
        assertFalse(validator.validate("http://tcdng.com"));
        assertFalse(validator.validate("https://tcdng.com"));
        assertFalse(validator.validate("http://www.tcdng.com"));
        assertFalse(validator.validate("https://www.tcdng.com"));
    }

    protected Validator getValidator(String name) throws Exception {
        return (Validator) getComponent(name);
    }

    @Override
    protected void onSetup() throws Exception {

    }

    @Override
    protected void onTearDown() throws Exception {

    }
}
