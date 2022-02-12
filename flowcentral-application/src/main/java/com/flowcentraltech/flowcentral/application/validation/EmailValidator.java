/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.annotation.Component;

/**
 * Email validator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "fc-emailvalidator", description = "$m{application.validator.email}")
public class EmailValidator extends AbstractRegexValidator {

    public EmailValidator() {
        super("validator.email.regex", "$m{application.validator.email.failure}");
    }

}
