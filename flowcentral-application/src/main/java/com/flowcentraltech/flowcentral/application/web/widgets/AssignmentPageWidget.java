/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.widgets;

import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.AppletDef;
import com.flowcentraltech.flowcentral.application.data.AssignmentPageDef;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.web.ui.widget.AbstractMultiControl;
import com.tcdng.unify.web.ui.widget.Control;

/**
 * Assignment page widget.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-assignmentpage")
public class AssignmentPageWidget extends AbstractMultiControl {

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    private AssignmentPageDef oldAssignmentPageDef;

    private Control assignmentBoxCtrl;

    public Control getAssignmentBoxCtrl() throws UnifyException {
        AssignmentPageDef assignmentPageDef = getAssignmentPage().getAssignmentPageDef();
        if (oldAssignmentPageDef != assignmentPageDef) {
            StringBuilder dsb = new StringBuilder();
            dsb.append("!ui-assignmentbox binding:assignedIdList baseIdBinding:baseId");
            if (assignmentPageDef.isWithFilterCaption1()) {
                dsb.append(" filterCaption1:$s{").append(assignmentPageDef.getFilterCaption1()).append("}");
            }

            if (assignmentPageDef.isWithFilterCaption2()) {
                dsb.append(" filterCaption2:$s{").append(assignmentPageDef.getFilterCaption2()).append("}");
            }

            if (assignmentPageDef.isWithFilterList1()) {
                dsb.append(" filterList1:$s{").append(assignmentPageDef.getFilterList1()).append("}");
            }

            if (assignmentPageDef.isWithFilterList2()) {
                dsb.append(" filterList2:$s{").append(assignmentPageDef.getFilterList2()).append("}");
            }

            dsb.append(" assignCaption:$s{").append(assignmentPageDef.getAssignCaption()).append("}");
            dsb.append(" unassignCaption:$s{").append(assignmentPageDef.getUnassignCaption()).append("}");
            dsb.append(" assignList:$s{").append(assignmentPageDef.getAssignList()).append("}");
            dsb.append(" unassignList:$s{").append(assignmentPageDef.getUnassignList()).append("}");
            dsb.append(" listRule:$s{").append(assignmentPageDef.getEntity()).append(':')
                    .append(assignmentPageDef.getBaseField()).append(':').append(assignmentPageDef.getAssignField());
            String descFieldName = null;
            final int asnIndex = assignmentPageDef.getLongName().indexOf("_Asn");
            if (asnIndex > 0) {
                final String appletName = assignmentPageDef.getLongName().substring(0, asnIndex);
                AppletDef appletDef = applicationModuleService.getAppletDef(appletName);
                if (appletDef.isWithAssignDescField()) {
                    descFieldName = appletDef.getAssignDescField();
                }
            } else if (assignmentPageDef.isWithRuleDesc()) {
                descFieldName = assignmentPageDef.getRuleDescField();
            }

            if (descFieldName != null) {
                dsb.append(':').append(descFieldName);
            }
            
            dsb.append("}");

            if (descFieldName != null) {
                dsb.append(" assignListDesc:$s{").append(descFieldName).append("}");
                dsb.append(" unassignListDesc:$s{").append(descFieldName).append("}");
            }

            assignmentBoxCtrl = (Control) addInternalChildWidget(dsb.toString());
            oldAssignmentPageDef = assignmentPageDef;
        }

        assignmentBoxCtrl.setValueStore(getValueStore());
        return assignmentBoxCtrl;
    }

    @Override
    protected void doOnPageConstruct() throws UnifyException {

    }

    private AssignmentPage getAssignmentPage() throws UnifyException {
        return getValue(AssignmentPage.class);
    }
}