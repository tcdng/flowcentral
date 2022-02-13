/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.studio.web.controllers;

import com.flowcentraltech.flowcentral.application.business.AppletUtilities;
import com.flowcentraltech.flowcentral.application.business.ApplicationModuleService;
import com.flowcentraltech.flowcentral.application.data.TableDef;
import com.flowcentraltech.flowcentral.application.entities.Application;
import com.flowcentraltech.flowcentral.application.web.data.AppletContext;
import com.flowcentraltech.flowcentral.application.web.data.FormContext;
import com.flowcentraltech.flowcentral.application.web.panels.EntitySearch;
import com.flowcentraltech.flowcentral.studio.constants.StudioApplicationConstants;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.flowcentraltech.flowcentral.studio.web.data.CreateAppForm;
import com.flowcentraltech.flowcentral.system.entities.Module;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.criterion.Equals;
import com.tcdng.unify.core.util.QueryUtils;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageController;

/**
 * Studio dashboard controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/applicationstudio/dashboard")
@UplBinding("web/studio/upl/studiodashboard.upl")
@ResultMappings({ @ResultMapping(name = "showswitchapplication",
        response = { "!switchpanelresponse panels:$l{switchApplicationPopup.searchBaseBodyPanel.entitySearchPanel}",
                "!showpopupresponse popup:$s{switchApplicationPopup}" }),
        @ResultMapping(name = "reloadapplicationstudio", response = { "!forwardresponse path:$s{/applicationstudio}" }),
        @ResultMapping(name = "cancelswitchapplication", response = { "!hidepopupresponse" }),
        @ResultMapping(name = "switchsearchapplication",
                response = {
                        "!switchpanelresponse panels:$l{switchApplicationPopup.searchBaseBodyPanel.entitySearchPanel}",
                        "!refreshpanelresponse panels:$l{switchApplicationPopup.entitySearchActionPanel}" }),
        @ResultMapping(name = "switchcreateapplication", response = {
                "!switchpanelresponse panels:$l{switchApplicationPopup.searchBaseBodyPanel.createApplicationBasePanel}",
                "!refreshpanelresponse panels:$l{switchApplicationPopup.entitySearchActionPanel}" }) })
public class StudioDashboardController extends AbstractPageController<StudioDashboardPageBean> {

    @Configurable
    private AppletUtilities appletUtils;

    @Configurable
    private ApplicationModuleService applicationModuleService;

    public StudioDashboardController() {
        super(StudioDashboardPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setAppletUtils(AppletUtilities appletUtils) {
        this.appletUtils = appletUtils;
    }

    public void setApplicationModuleService(ApplicationModuleService applicationModuleService) {
        this.applicationModuleService = applicationModuleService;
    }

    @Action
    public String showSwitchApplication() throws UnifyException {
        return "showswitchapplication";
    }

    @Action
    public String openApplication() throws UnifyException {
        String[] po = StringUtils.charSplit(getRequestTarget(String.class), ':');
        int mIndex = Integer.parseInt(po[1]);
        Application _inst = (Application) getPageBean().getSwitchApplicationSearch().getEntityTable().getDispItemList()
                .get(mIndex);
        setApplicationSessionAttributes(_inst);
        return "reloadapplicationstudio";
    }

    @Action
    public String createApplication() throws UnifyException {
        StudioDashboardPageBean pageBean = getPageBean();
        CreateAppForm createAppForm = pageBean.getCreateAppForm();

        Module module = null;
        if (createAppForm.isCreateModule()) {
            module = new Module();
            module.setName(createAppForm.getModuleName());
            module.setDescription(createAppForm.getModuleDesc());
            module.setLabel(createAppForm.getModuleLabel());
            module.setShortCode(createAppForm.getModuleShortCode());
        }

        Application application = new Application();
        application.setModuleId(createAppForm.getModuleId());
        application.setName(createAppForm.getApplicationName());
        application.setDescription(createAppForm.getApplicationDesc());
        application.setLabel(createAppForm.getApplicationLabel());
        application.setDevelopable(true);
        applicationModuleService.createApplication(application, module);
        setApplicationSessionAttributes(application);
        return "reloadapplicationstudio";
    }

    @Action
    public String prepareNewApplication() throws UnifyException {
        StudioDashboardPageBean pageBean = getPageBean();
        pageBean.setCreateAppForm(new CreateAppForm());
        return "switchcreateapplication";
    }

    @Action
    public String cancelSwitchApplication() throws UnifyException {
        if (isPageWidgetVisible("switchApplicationPopup.createAppBtn")) {
            return "switchsearchapplication";
        }

        return "cancelswitchapplication";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();

        StudioDashboardPageBean pageBean = getPageBean();
        if (pageBean.getSwitchApplicationSearch() == null) {
            TableDef _tableDef = appletUtils.getTableDef(StudioApplicationConstants.APPLICATION_SEARCH_TABLE);

            EntitySearch _switchApplicationSearch = new EntitySearch(new FormContext(new AppletContext(appletUtils)),
                    null, null, _tableDef, null, null, EntitySearch.ENABLE_ALL & ~(EntitySearch.SHOW_EDIT_BUTTON));
            _switchApplicationSearch
                    .setPaginationLabel(appletUtils.resolveSessionMessage("$m{entitysearch.display.label}"));
            _switchApplicationSearch.setEntitySubTitle("Application");
            _switchApplicationSearch.setBaseRestriction(new Equals("developable", Boolean.TRUE),
                    appletUtils.getSpecialParamProvider());
            _switchApplicationSearch.applyFilterToSearch();
            pageBean.setSwitchApplicationSearch(_switchApplicationSearch);
        }

        Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        if (!QueryUtils.isValidLongCriteria(applicationId)) {
            getPageRequestContextUtil().setRequestPopupName("switchApplicationPopup");
        }
    }

    private void setApplicationSessionAttributes(Application application) throws UnifyException {
        setSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID, application.getId());
        setSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME, application.getName());
        setSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_DESC, application.getDescription());
        setSessionAttribute(StudioSessionAttributeConstants.CLEAR_PAGES, Boolean.TRUE);
    }
}