/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.system.web.controllers;

import com.flowcentraltech.flowcentral.common.business.FileAttachmentProvider;
import com.flowcentraltech.flowcentral.common.data.Attachment;
import com.flowcentraltech.flowcentral.system.constants.SystemFileResourceConstants;
import com.flowcentraltech.flowcentral.system.constants.SystemModuleSysParamConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.constant.FileAttachmentType;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.annotation.ResultMapping;
import com.tcdng.unify.web.annotation.ResultMappings;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * User interface options controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/system/uioptions")
@UplBinding("web/system/upl/uioptionspage.upl")
@ResultMappings({ @ResultMapping(name = "refreshlogin",
        response = { "!refreshpanelresponse panels:$l{frmHeaderImgPanel frmBackImgPanel}" }) })
public class UIOptionsController extends AbstractSystemPageController<UIOptionsPageBean> {

    @Configurable
    private FileAttachmentProvider fileAttachmentProvider;

    public UIOptionsController() {
        super(UIOptionsPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public void setFileAttachmentProvider(FileAttachmentProvider fileAttachmentProvider) {
        this.fileAttachmentProvider = fileAttachmentProvider;
    }

    @Action
    public String saveUIOptions() throws UnifyException {
        UIOptionsPageBean pageBean = getPageBean();
        getSystemModuleService().setSysParameterValue(SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_TITLE,
                pageBean.getLoginPageTitle());
        getSystemModuleService().setSysParameterValue(SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_SUBTITLE,
                pageBean.getLoginPageSubtitle());
        saveFileResource(FileAttachmentType.IMAGE, SystemFileResourceConstants.LOGIN_HEADER_IMAGE_RESOURCE,
                pageBean.getLoginHeaderImage());
        saveFileResource(FileAttachmentType.IMAGE, SystemFileResourceConstants.LOGIN_BACK_IMAGE_RESOURCE,
                pageBean.getLoginBackImage());
        hintUser("$m{uioptionspage.hint.optionssaved}");
        return noResult();
    }

    @Action
    public String clearLoginImage() throws UnifyException {
        UIOptionsPageBean pageBean = getPageBean();
        String target = getRequestTarget(String.class);
        if ("loginHeaderImg".equals(target)) {
            pageBean.setLoginHeaderImage(null);
        } else if ("loginBackImg".equals(target)) {
            pageBean.setLoginBackImage(null);
        }

        return "refreshlogin";
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();
        loadUIOptions();
    }

    private void loadUIOptions() throws UnifyException {
        UIOptionsPageBean pageBean = getPageBean();
        pageBean.setLoginPageTitle(getSystemModuleService().getSysParameterValue(String.class,
                SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_TITLE));
        pageBean.setLoginPageSubtitle(getSystemModuleService().getSysParameterValue(String.class,
                SystemModuleSysParamConstants.SYSTEM_LOGINPAGE_SUBTITLE));
        pageBean.setLoginHeaderImage(loadFileResource(SystemFileResourceConstants.LOGIN_HEADER_IMAGE_RESOURCE));
        pageBean.setLoginBackImage(loadFileResource(SystemFileResourceConstants.LOGIN_BACK_IMAGE_RESOURCE));
    }

    private byte[] loadFileResource(String resourceName) throws UnifyException {
        Attachment attachment = fileAttachmentProvider.retrieveFileAttachment(
                SystemFileResourceConstants.FILERESOURCE_CATEGORY, SystemFileResourceConstants.FILERESOURCE_ENTITY_NAME,
                SystemFileResourceConstants.FILERESOURCE_ENTITY_INST_ID, resourceName);
        if (attachment != null) {
            return attachment.getData();
        }

        return null;
    }

    private void saveFileResource(FileAttachmentType type, String resourceName, byte[] resource) throws UnifyException {
        if (resource != null) {
            fileAttachmentProvider.saveFileAttachment(SystemFileResourceConstants.FILERESOURCE_CATEGORY,
                    SystemFileResourceConstants.FILERESOURCE_ENTITY_NAME,
                    SystemFileResourceConstants.FILERESOURCE_ENTITY_INST_ID,
                    Attachment.newBuilder(type).name(resourceName).title("").data(resource).build());
        } else {
            fileAttachmentProvider.deleteFileAttachment(SystemFileResourceConstants.FILERESOURCE_CATEGORY,
                    SystemFileResourceConstants.FILERESOURCE_ENTITY_NAME,
                    SystemFileResourceConstants.FILERESOURCE_ENTITY_INST_ID, resourceName);
        }
    }

}
