/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.chart.business;

import java.util.List;

import com.flowcentraltech.flowcentral.chart.data.ChartDef;
import com.flowcentraltech.flowcentral.chart.data.ChartSnapshotDef;
import com.flowcentraltech.flowcentral.chart.entities.Chart;
import com.flowcentraltech.flowcentral.chart.entities.ChartQuery;
import com.flowcentraltech.flowcentral.chart.entities.ChartSnapshot;
import com.flowcentraltech.flowcentral.chart.entities.ChartSnapshotQuery;
import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.tcdng.unify.core.UnifyException;

/**
 * Chart business service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ChartModuleService extends FlowCentralService {

    /**
     * Finds charts by criteria.
     * 
     * @param query
     *              the query object
     * @return list of charts
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Chart> findCharts(ChartQuery query) throws UnifyException;

    /**
     * Finds chart by ID.
     * 
     * @param chartId
     *                the chart ID
     * @return the chart
     * @throws UnifyException
     *                        if chart with ID is not found. If an error occurs
     */
    Chart findChart(Long chartId) throws UnifyException;

    /**
     * Finds chart ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application chart IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findChartIdList(String applicationName) throws UnifyException;
    
    /**
     * Finds snapshots by criteria.
     * 
     * @param query
     *              the query object
     * @return list of chart snapshots
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ChartSnapshot> findChartSnapshots(ChartSnapshotQuery query) throws UnifyException;

    /**
     * Gets a chart definition.
     * 
     * @param chartName
     *                  the chart long name
     * @return the chart definition
     * @throws UnifyException
     *                        if an error occurs
     */
    ChartDef getChartDef(String chartName) throws UnifyException;

    /**
     * Gets a chart snapshot definition.
     * 
     * @param snapshotName
     *                     the snapshot name
     * @return the chart snapshot
     * @throws UnifyException
     *                        if an error occurs
     */
    ChartSnapshotDef getChartSnapshotDef(String snapshotName) throws UnifyException;

    /**
     * Checks if chart snapshot exists.
     * 
     * @param snapshotName
     *                     the snapshot name
     * @return true if snapshot with name exists otherwise false
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isChartSnapshotExist(String snapshotName) throws UnifyException;

    /**
     * Saves a chart snapshot. Updates existing record or creates a new one if
     * necessary.
     * 
     * @param chartSnapshot
     *                      the snapshot to save
     * @throws UnifyException
     *                        if an error occurs
     */
    void saveChartSnapshot(ChartSnapshot chartSnapshot) throws UnifyException;
}
