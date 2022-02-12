/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.report.util;

import java.util.ArrayList;
import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.AppEntityField;
import com.flowcentraltech.flowcentral.application.util.ApplicationEntityUtils;
import com.flowcentraltech.flowcentral.common.constants.ConfigType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityBaseType;
import com.flowcentraltech.flowcentral.configuration.constants.EntityFieldDataType;
import com.flowcentraltech.flowcentral.report.entities.ReportableField;
import com.tcdng.unify.convert.util.ConverterUtils;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.constant.HAlignType;
import com.tcdng.unify.core.message.MessageResolver;
import com.tcdng.unify.core.util.NameUtils;

/**
 * Report entity utilities.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public final class ReportEntityUtils {

    private ReportEntityUtils() {

    }

    public static List<ReportableField> getEntityBaseTypeReportableFieldList(MessageResolver msgResolver,
            EntityBaseType type) throws UnifyException {
        List<ReportableField> resultList = new ArrayList<ReportableField>();
        for (AppEntityField appEntityField : ApplicationEntityUtils.getEntityBaseTypeFieldList(msgResolver, type,
                ConfigType.STATIC_INSTALL)) {
            if (appEntityField.isReportable()) {
                ReportableField reportableField = new ReportableField();
                ReportEntityUtils.populateReportableField(reportableField, appEntityField);
                resultList.add(reportableField);
            }
        }

        return resultList;
    }

    public static void populateReportableField(ReportableField reportableField, AppEntityField appEntityField)
            throws UnifyException {
        String description = NameUtils.describeName(appEntityField.getName());
        EntityFieldDataType entityFieldDataType = appEntityField.getDataType();
        Class<?> dataClazz = null;
        if (entityFieldDataType.isListOnly()) {
            // TODO Get parent data type
            dataClazz = String.class;
        } else {
            dataClazz = entityFieldDataType.dataType().javaClass(); // TODO Enumerations?
            if (Number.class.isAssignableFrom(dataClazz)) {
                reportableField.setHorizontalAlign(HAlignType.RIGHT.name());
            }

            if (appEntityField.getDataType().isTimestamp()) {
                reportableField.setFormatter("!fixeddatetimeformat pattern:$s{yyyy-MM-dd HH:mm:ss}");
            } else if (appEntityField.getDataType().isDate()) {
                reportableField.setFormatter("!fixeddatetimeformat pattern:$s{yyyy-MM-dd}");
            }
        }

        reportableField.setWidth(-1);
        reportableField.setDescription(description);
        reportableField.setName(appEntityField.getName());
        reportableField.setParameterOnly(false);
        reportableField.setType(ConverterUtils.getWrapperClassName(dataClazz));
    }

}
