/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.dashboard.business;

import java.util.List;

import com.flowcentraltech.flowcentral.dashboard.entities.Dashboard;
import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.dashboard.data.DashboardDef;
import com.tcdng.unify.core.UnifyException;

/**
 * Dashboard business service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface DashboardModuleService extends FlowCentralService {

    /**
     * Finds dashboard by ID.
     * 
     * @param dashboardId
     *                the dashboard ID
     * @return the dashboard
     * @throws UnifyException
     *                        if dashboard with ID is not found. If an error occurs
     */
    Dashboard findDashboard(Long dashboardId) throws UnifyException;

    /**
     * Finds dashboard ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application dashboard IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findDashboardIdList(String applicationName) throws UnifyException;

    /**
     * Gets application dashboard definition.
     * 
     * @param dashboardName
     *                      the dashboard long name
     * @return the dashboard definition
     * @throws UnifyException
     *                        if an error occurs
     */
    DashboardDef getDashboardDef(String dashboardName) throws UnifyException;

}
