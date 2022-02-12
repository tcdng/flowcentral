/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import com.flowcentraltech.flowcentral.configuration.xml.AppConfig;
import com.flowcentraltech.flowcentral.configuration.xml.BaseNameConfig;
import com.flowcentraltech.flowcentral.configuration.xml.ModuleConfig;
import com.flowcentraltech.flowcentral.configuration.xml.NotifTemplateConfig;
import com.flowcentraltech.flowcentral.configuration.xml.ReportConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfConfig;
import com.flowcentraltech.flowcentral.configuration.xml.WfWizardConfig;
import com.tcdng.unify.core.UnifyError;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.util.IOUtils;
import com.tcdng.unify.core.util.XmlConfigUtils;

/**
 * Configuration utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ConfigurationUtils {

    private ConfigurationUtils() {

    }

    public static <T> T readConfig(Class<T> configClass, String fileResource, String workingPath)
            throws UnifyException {
        InputStream inputStream = null;
        try {
            inputStream = IOUtils.openFileResourceInputStream(fileResource, workingPath);
            return XmlConfigUtils.readXmlConfig(configClass, inputStream);
        } finally {
            IOUtils.close(inputStream);
        }
    }

    public static void writeConfig(BaseNameConfig config, OutputStream outputStream) throws UnifyException {
        XmlConfigUtils.writeXmlConfig(config, outputStream);
    }

    public static void writeConfigNoEscape(BaseNameConfig config, OutputStream outputStream) throws UnifyException {
        XmlConfigUtils.writeXmlConfigNoEscape(config, outputStream);
    }
    
    public static List<String> readStringList(String fileResource, String workingPath)
            throws UnifyException {
        return IOUtils.readFileResourceLines(fileResource, workingPath);
    }
    
    public static List<UnifyError> validateModuleConfig(ModuleConfig moduleConfig) {
        // TODO
        return null;
    }

    public static List<UnifyError> validateApplicationConfig(AppConfig applicationConfig) {
        // TODO
        return null;
    }

    public static List<UnifyError> validateReportConfig(ReportConfig reportConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    public static List<UnifyError> validateNotifTemplateConfig(NotifTemplateConfig notifTemplateConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    public static List<UnifyError> validateWfConfig(WfConfig wfConfig) {
        // TODO Auto-generated method stub
        return null;
    }

    public static List<UnifyError> validateWfWizardConfig(WfWizardConfig wfWizardConfig) {
        // TODO Auto-generated method stub
        return null;
    }

}
