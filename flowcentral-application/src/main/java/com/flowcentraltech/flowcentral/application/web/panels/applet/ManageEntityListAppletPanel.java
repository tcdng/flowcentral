/*
 * Copyright 2021-2022 FlowCentral Technologies Limited.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
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
 * @author FlowCentral Technologies Limited
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
            case ENTRY_TABLE_PAGE:
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
