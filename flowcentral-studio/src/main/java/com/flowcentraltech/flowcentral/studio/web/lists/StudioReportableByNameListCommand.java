/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.studio.web.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import com.flowcentraltech.flowcentral.application.util.ApplicationNameUtils;
import com.flowcentraltech.flowcentral.application.web.lists.AbstractApplicationListCommand;
import com.flowcentraltech.flowcentral.report.business.ReportModuleService;
import com.flowcentraltech.flowcentral.report.entities.ReportableDefinition;
import com.flowcentraltech.flowcentral.report.entities.ReportableDefinitionQuery;
import com.flowcentraltech.flowcentral.studio.constants.StudioSessionAttributeConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.data.ListData;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.list.ZeroParams;
import com.tcdng.unify.core.util.DataUtils;
import com.tcdng.unify.core.util.QueryUtils;

/**
 * Studio reportable by name list command
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("studioreportablebynamelist")
public class StudioReportableByNameListCommand extends AbstractApplicationListCommand<ZeroParams> {

    @Configurable
    private ReportModuleService reportModuleService;

    public StudioReportableByNameListCommand() {
        super(ZeroParams.class);
    }

    public void setReportModuleService(ReportModuleService reportModuleService) {
        this.reportModuleService = reportModuleService;
    }

    @Override
    public List<? extends Listable> execute(Locale locale, ZeroParams zeroParams) throws UnifyException {
        final Long applicationId = (Long) getSessionAttribute(StudioSessionAttributeConstants.CURRENT_APPLICATION_ID);
        if (QueryUtils.isValidLongCriteria(applicationId)) {
            List<ReportableDefinition> reportableDefinitionList = reportModuleService
                    .findReportDefinitions((ReportableDefinitionQuery) new ReportableDefinitionQuery()
                            .applicationId(applicationId).addSelect("name", "description"));
            if (!DataUtils.isBlank(reportableDefinitionList)) {
                final String applicationName = (String) getSessionAttribute(
                        StudioSessionAttributeConstants.CURRENT_APPLICATION_NAME);
                List<ListData> list = new ArrayList<ListData>();
                for (ReportableDefinition reportableDefinition : reportableDefinitionList) {
                    list.add(new ListData(ApplicationNameUtils.getApplicationEntityLongName(applicationName,
                            reportableDefinition.getName()), reportableDefinition.getDescription()));
                }

                return list;
            }
        }

        return Collections.emptyList();
    }

}
