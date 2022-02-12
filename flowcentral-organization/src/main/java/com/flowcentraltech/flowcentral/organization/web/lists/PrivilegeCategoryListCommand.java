/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.organization.web.lists;

import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.organization.entities.PrivilegeCategoryQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;

/**
 * Privilege category list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("privilegecategorylist")
public class PrivilegeCategoryListCommand extends AbstractOrganizationListCommand<ZeroParams> {

    public PrivilegeCategoryListCommand() {
        super(ZeroParams.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams params) throws UnifyException {
        return getOrganizationModuleService().findPrivilegeCategories(
                (PrivilegeCategoryQuery) new PrivilegeCategoryQuery().ignoreEmptyCriteria(true));
    }

}
