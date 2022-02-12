/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.system.entities.CredentialQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Credential list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("credentiallist")
public class CredentialListCommand extends AbstractSystemListCommand<ZeroParams> {

    public CredentialListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams params) throws UnifyException {
        return getSystemModuleService().findCredentials(
                (CredentialQuery) new CredentialQuery().addSelect("name", "description").ignoreEmptyCriteria(true));
    }

}
