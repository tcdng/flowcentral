/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.codegeneration.web.controllers;

import com.flowcentraltech.flowcentral.codegeneration.constants.CodeGenerationModuleSysParamConstants;
import com.flowcentraltech.flowcentral.codegeneration.constants.CodeGenerationTaskConstants;
import com.flowcentraltech.flowcentral.codegeneration.data.CodeGenerationItem;
import com.flowcentraltech.flowcentral.system.business.SystemModuleService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.annotation.UplBinding;
import com.tcdng.unify.core.constant.MimeType;
import com.tcdng.unify.core.data.DownloadFile;
import com.tcdng.unify.core.task.TaskSetup;
import com.tcdng.unify.core.util.StringUtils;
import com.tcdng.unify.web.annotation.Action;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;

/**
 * Extension module static files generation page controller.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("/codegeneration/extensionmodulestaticfilesgeneration")
@UplBinding("web/codegeneration/upl/extensionmodulestaticfilesgenerationpage.upl")
public class ExtensionModuleStaticFilesGenerationPageController
        extends AbstractCodeGenerationPageController<ExtensionModuleStaticFilesGenerationPageBean> {

    @Configurable
    private SystemModuleService systemModuleService;

    public ExtensionModuleStaticFilesGenerationPageController() {
        super(ExtensionModuleStaticFilesGenerationPageBean.class, Secured.TRUE, ReadOnly.FALSE, ResetOnWrite.FALSE);
    }

    public final void setSystemModuleService(SystemModuleService systemModuleService) {
        this.systemModuleService = systemModuleService;
    }

    @Action
    public String generateStaticFiles() throws UnifyException {
        ExtensionModuleStaticFilesGenerationPageBean pageBean = getPageBean();
        final String moduleName = systemModuleService.getModuleName(pageBean.getModuleId());
        pageBean.setCodeGenerationItem(new CodeGenerationItem(pageBean.getBasePackage(), moduleName));
        TaskSetup taskSetup = TaskSetup.newBuilder()
                .addTask(CodeGenerationTaskConstants.GENERATE_EXTENSION_MODULE_FILES_TASK_NAME)
                .setParam(CodeGenerationTaskConstants.CODEGENERATION_ITEM, pageBean.getCodeGenerationItem())
                .logMessages().build();
        return launchTaskWithMonitorBox(taskSetup, "Generate Static Application Files",
                "/codegeneration/extensionmodulestaticfilesgeneration/downloadGeneratedFile", null);
    }

    @Action
    public String downloadGeneratedFile() throws UnifyException {
        ExtensionModuleStaticFilesGenerationPageBean pageBean = getPageBean();
        CodeGenerationItem codeGenerationItem = pageBean.getCodeGenerationItem();
        DownloadFile downloadFile = new DownloadFile(MimeType.APPLICATION_OCTETSTREAM, codeGenerationItem.getFilename(),
                codeGenerationItem.getData());
        pageBean.setCodeGenerationItem(null);
        return fileDownloadResult(downloadFile, true);
    }

    @Override
    protected void onOpenPage() throws UnifyException {
        super.onOpenPage();
        ExtensionModuleStaticFilesGenerationPageBean pageBean = getPageBean();
        if (StringUtils.isBlank(pageBean.getBasePackage())) {
            String defaultBasePackage = systemModuleService.getSysParameterValue(String.class,
                    CodeGenerationModuleSysParamConstants.DEFAULT_CODEGEN_PACKAGE_BASE);
            pageBean.setBasePackage(defaultBasePackage);
        }

        pageBean.setCodeGenerationItem(null);
    }

}