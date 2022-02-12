/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.report.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.report.entities.ReportableField;
import com.flowcentraltech.flowcentral.report.entities.ReportableFieldQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Report configuration field list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("reportconfigfieldlist")
public class ReportConfigFieldListCommand extends AbstractReportListCommand<LongParam> {

    public ReportConfigFieldListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParams) throws UnifyException {
        if (longParams.isPresent()) {
            Long reportableDefinitionId = getReportModuleService()
                    .getReportConfigReportableDefinitionId(longParams.getValue());

            List<ReportableField> list = getReportModuleService()
                    .findReportableFields((ReportableFieldQuery) new ReportableFieldQuery()
                            .reportableId(reportableDefinitionId).addSelect("name", "description"));
            if (!DataUtils.isBlank(list)) {
                List<ListData> resultList = new ArrayList<ListData>();
                for (ReportableField reportableField : list) {
                    resultList.add(new ListData(reportableField.getName(), reportableField.getDescription()));
                }
                return resultList;
            }
        }

        return Collections.emptyList();
    }

}
