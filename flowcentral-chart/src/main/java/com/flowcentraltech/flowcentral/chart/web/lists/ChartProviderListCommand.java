/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.web.lists;

import com.flowcentraltech.flowcentral.chart.data.ChartDataProvider;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.list.AbstractTypeListCommand;

/**
 * Chart provider list command.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component("chartproviderlist")
public class ChartProviderListCommand extends AbstractTypeListCommand<ChartDataProvider> {

    public ChartProviderListCommand() {
        super(ChartDataProvider.class);
    }

}
