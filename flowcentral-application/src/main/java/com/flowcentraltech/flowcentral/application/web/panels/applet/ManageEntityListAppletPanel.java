/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.web.panels.applet;

import com.flowcentraltech.flowcentral.application.constants.AppletPropertyConstants;
import com.flowcentraltech.flowcentral.application.web.widgets.EntityTable;
import com.flowcentraltech.flowcentral.common.business.ReportProvider;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.web.annotation.Action;

/**
 * Manage entity list applet panel.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("fc-manageentitylistappletpanel")
@UplBinding("web/application/upl/manageentitylistappletpanel.upl")
public class ManageEntityListAppletPanel extends AbstractEntityFormAppletPanel {

    @Configurable
    private ReportProvider reportProvider;

    public ReportProvider getReportProvider() {
        return reportProvider;
    }

    public void setReportProvider(ReportProvider reportProvider) {
        this.reportProvider = reportProvider;
    }

    @Override
    public void switchState() throws UnifyException {
        super.switchState();

        ManageEntityListApplet applet = getManageEntityListApplet();
        applet.ensureCurrentAppletStruct();
        if (isWidgetVisible("entitySearchPanel.newBtn")) {
            setVisible("entitySearchPanel.newBtn", !applet.isWithBaseFilter());
        }

        final AbstractEntityFormApplet.ViewMode viewMode = applet.getMode();
        final String roleCode = getUserToken().getRoleCode();

        switch (viewMode) {
            case ASSIGNMENT_PAGE:
            case PROPERTYLIST_PAGE:
            case LISTING_FORM:
            case MAINTAIN_FORM_SCROLL:
            case MAINTAIN_PRIMARY_FORM_NO_SCROLL:
            case MAINTAIN_CHILDLIST_FORM_NO_SCROLL:
            case MAINTAIN_RELATEDLIST_FORM_NO_SCROLL:
            case MAINTAIN_HEADLESSLIST_FORM_NO_SCROLL:
            case MAINTAIN_FORM:
            case MAINTAIN_CHILDLIST_FORM:
            case MAINTAIN_RELATEDLIST_FORM:
            case MAINTAIN_HEADLESSLIST_FORM:
            case NEW_FORM:
            case NEW_PRIMARY_FORM:
            case NEW_CHILD_FORM:
            case NEW_CHILDLIST_FORM:
            case NEW_RELATEDLIST_FORM:
            case NEW_HEADLESSLIST_FORM:
            case HEADLESS_TAB:
                break;
            case SEARCH:
                switchContent("entitySearchPanel");
                final EntityTable _entityTable = applet.getEntitySearch().getEntityTable();
                final boolean reportBtnVisible = _entityTable.getTotalItemCount() > 0
                        && applet.getRootAppletDef().getPropValue(boolean.class,
                                AppletPropertyConstants.SEARCH_TABLE_REPORT, false)
                        && reportProvider.isReportable(_entityTable.getEntityDef().getLongName())
                        && applicationPrivilegeManager.isRoleWithPrivilege(roleCode,
                                _entityTable.getEntityDef().getReportPrivilege());
                setVisible("entitySearchPanel.reportBtn", reportBtnVisible);
            default:
                break;
        }
    }

    @Action
    public void prepareGenerateReport() throws UnifyException {
        EntityTable entityTable = getManageEntityListApplet().getEntitySearch().getEntityTable();
        ReportOptions reportOptions = reportProvider.getDynamicReportOptions(entityTable.getEntityDef().getLongName(),
                entityTable.getDefaultReportColumnList());
        reportOptions.setReportResourcePath("/common/resource/report");
        reportOptions.setRestriction(entityTable.getSourceObject());
        reportOptions.setReportEntityList(true);
        showReportOptionsBox(reportOptions);
    }

    protected ManageEntityListApplet getManageEntityListApplet() throws UnifyException {
        return getValue(ManageEntityListApplet.class);
    }
}
