/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.panels;

import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.UplBinding;

/**
 * Workflow step routings CRUD panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-wfsteproutingscrudpanel")
@UplBinding("web/studio/upl/wfsteproutingscrudpanel.upl")
public class WfStepRoutingsCrudPanel extends AbstractStudioDialogCrudPanel {

    @Override
    public void onPageConstruct() throws UnifyException {
        super.onPageConstruct();
        setDisabled("frmNextStepName", true);
    }

}
