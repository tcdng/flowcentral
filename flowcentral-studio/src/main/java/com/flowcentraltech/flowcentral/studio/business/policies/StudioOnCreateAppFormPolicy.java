/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.business.policies;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.AppForm;
import com.flowcentraltech.flowcentral.application.entities.AppFormElement;
import com.flowcentraltech.flowcentral.common.business.policies.EntityActionContext;
import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.flowcentraltech.flowcentral.configuration.constants.FormColumnsType;
import com.flowcentraltech.flowcentral.configuration.constants.FormElementType;
import com.flowcentraltech.flowcentral.configuration.constants.TabContentType;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Studio on create application form policy.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studiooncreateappform-policy")
public class StudioOnCreateAppFormPolicy extends StudioOnCreateComponentPolicy {

    @Override
    protected void doExecutePreAction(EntityActionContext ctx) throws UnifyException {
        super.doExecutePreAction(ctx);
        final AppForm appForm = (AppForm) ctx.getInst();
        if (DataUtils.isBlank(appForm.getElementList())) {
            List<AppFormElement> elementList = new ArrayList<AppFormElement>();
            // Add basic tab with empty section
            AppFormElement appFormElement = new AppFormElement();
            appFormElement.setType(FormElementType.TAB);
            appFormElement.setElementName("basicDetails");
            appFormElement.setTabContentType(TabContentType.MINIFORM);
            appFormElement.setLabel(resolveApplicationMessage("$m{studio.apptable.form.basicdetails}"));
            appFormElement.setVisible(true);
            appFormElement.setEditable(true);
            appFormElement.setDisabled(false);
            appFormElement.setConfigType(ConfigType.CUSTOM);
            elementList.add(appFormElement);

            appFormElement = new AppFormElement();
            appFormElement.setType(FormElementType.SECTION);
            appFormElement.setElementName("basicDetails");
            appFormElement.setSectionColumns(FormColumnsType.TYPE_2);
            appFormElement.setLabel(null);
            appFormElement.setVisible(true);
            appFormElement.setEditable(true);
            appFormElement.setDisabled(false);
            appFormElement.setConfigType(ConfigType.CUSTOM);
            elementList.add(appFormElement);

            appForm.setElementList(elementList);
        }
    }

}
