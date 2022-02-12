/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.system.entities.ModuleQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Module list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("modulelist")
public class ModuleListCommand extends AbstractSystemListCommand<ZeroParams> {

    public ModuleListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams params) throws UnifyException {
        return getSystemModuleService().findModules((ModuleQuery) new ModuleQuery().ignoreEmptyCriteria(true));
    }

}
