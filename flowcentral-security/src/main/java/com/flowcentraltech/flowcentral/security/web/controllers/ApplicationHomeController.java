/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.security.web.controllers;

import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageController;

/**
 * Application home controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/application/home")
@UplBinding("web/security/upl/applicationhome.upl")
public class ApplicationHomeController extends AbstractPageController<ApplicationHomePageBean> {

    public ApplicationHomeController() {
        super(ApplicationHomePageBean.class, Secured.FALSE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

}
