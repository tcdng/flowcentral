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

import com.flowcentraltech.flowcentral.report.entities.ReportParameter;
import com.flowcentraltech.flowcentral.report.entities.ReportParameterQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.LongParam;
import com.tcdng.unify.core.util.DataUtils;

/**
 * Report parameter list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("reportparameterlist")
public class ReportParameterListCommand extends AbstractReportListCommand<LongParam> {

    public ReportParameterListCommand() {
        super(LongParam.class);
    }

    @Override
    public List<? extends Listable> execute(Locale locale, LongParam longParams) throws UnifyException {
        if (longParams.isPresent()) {
            List<ReportParameter> list = getReportModuleService()
                    .findReportParameters((ReportParameterQuery) new ReportParameterQuery()
                            .reportConfigurationId(longParams.getValue()).addSelect("name", "description"));
            if (!DataUtils.isBlank(list)) {
                List<ListData> resultList = new ArrayList<ListData>();
                for (ReportParameter reportParameter : list) {
                    resultList.add(new ListData(reportParameter.getName(), reportParameter.getDescription()));
                }
                return resultList;
            }
        }

        return Collections.emptyList();
    }

}
