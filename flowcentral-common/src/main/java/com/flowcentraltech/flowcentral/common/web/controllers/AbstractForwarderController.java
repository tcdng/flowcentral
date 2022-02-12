/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.controllers;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Convenient abstract base class for page forwarders.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@ResultMappings({
        @ResultMapping(name = "forwardtopath", response = { "!forwardresponse pathBinding:$s{targetPath}" }) })
public abstract class AbstractForwarderController<T extends AbstractForwarderPageBean>
        extends AbstractFlowCentralPageController<T> {

    public AbstractForwarderController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    protected String forwardToPath(String targetPath) throws UnifyException {
        AbstractForwarderPageBean pageBean = getPageBean();
        pageBean.setTargetPath(targetPath);
        return "forwardtopath";
    }

}
