/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.annotation.Component;

/**
 * Mobile validator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "fc-mobilevalidator", description = "$m{application.validator.mobileno}")
public class MobileValidator extends AbstractRegexValidator {

    public MobileValidator() {
        super("validator.mobile.regex", "$m{application.validator.mobile.failure}");
    }

}
