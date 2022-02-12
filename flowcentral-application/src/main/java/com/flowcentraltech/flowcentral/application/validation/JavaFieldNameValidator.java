/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.annotation.Component;

/**
 * Java field name validator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "fc-javafieldnamevalidator", description = "$m{application.validator.javafieldname}")
public class JavaFieldNameValidator extends AbstractRegexValidator {

    public JavaFieldNameValidator() {
        super("validator.javafieldname.regex", "$m{application.validator.javafieldname.failure}");
    }

}
