/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.annotation.Component;

/**
 * Domain validator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "fc-domainvalidator", description = "$m{application.validator.domain}")
public class DomainValidator extends AbstractRegexValidator {

    public DomainValidator() {
        super("validator.domain.regex", "$m{application.validator.domain.failure}");
    }

}
