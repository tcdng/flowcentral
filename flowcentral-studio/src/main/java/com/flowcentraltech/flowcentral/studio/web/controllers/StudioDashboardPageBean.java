/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.web.panels.EntitySearch;
import com.flowcentraltech.flowcentral.studio.web.data.CreateAppForm;
import com.tcdng.unify.web.ui.AbstractPageBean;

/**
 * Studio dashboard page bean.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class StudioDashboardPageBean extends AbstractPageBean {

    private EntitySearch switchApplicationSearch;

    private CreateAppForm createAppForm;

    public EntitySearch getSwitchApplicationSearch() {
        return switchApplicationSearch;
    }

    public void setSwitchApplicationSearch(EntitySearch switchApplicationSearch) {
        this.switchApplicationSearch = switchApplicationSearch;
    }

    public CreateAppForm getCreateAppForm() {
        return createAppForm;
    }

    public void setCreateAppForm(CreateAppForm createAppForm) {
        this.createAppForm = createAppForm;
    }
}
