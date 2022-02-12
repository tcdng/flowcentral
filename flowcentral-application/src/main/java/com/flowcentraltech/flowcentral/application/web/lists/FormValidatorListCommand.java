/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.lists;

import com.flowcentraltech.flowcentral.application.validation.Validator;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.AbstractTypeListCommand;

/**
 * Form validator list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("formvalidatorlist")
public class FormValidatorListCommand extends AbstractTypeListCommand<Validator> {

    public FormValidatorListCommand() {
        super(Validator.class);
    }

}
