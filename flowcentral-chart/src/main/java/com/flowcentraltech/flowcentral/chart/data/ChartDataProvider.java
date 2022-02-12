/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.chart.data;

import com.flowcentraltech.flowcentral.common.business.RuleListComponent;
import com.tcdng.unify.core.UnifyException;

/**
 * Chart data provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ChartDataProvider extends RuleListComponent {

    /**
     * Provides data.
     * 
     * @param rule
     *             optional rule
     * @return the chart data
     * @throws UnifyException
     *                        if an error occurs
     */
    ChartData provide(String rule) throws UnifyException;
}
