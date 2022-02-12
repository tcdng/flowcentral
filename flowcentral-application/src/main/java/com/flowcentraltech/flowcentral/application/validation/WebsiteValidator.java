/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.validation;

import com.tcdng.unify.core.annotation.Component;

/**
 * Website validator.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(name = "fc-websitevalidator", description = "$m{application.validator.website}")
public class WebsiteValidator extends AbstractRegexValidator {

    public WebsiteValidator() {
        super("validator.website.regex", "$m{application.validator.website.failure}");
    }

}
