/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.business;

import java.io.OutputStream;
import java.util.List;

import com.flowcentraltech.flowcentral.common.data.DefaultReportColumn;
import com.flowcentraltech.flowcentral.common.data.ReportListing;
import com.flowcentraltech.flowcentral.common.data.ReportOptions;
import com.tcdng.unify.core.UnifyComponent;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.report.ReportColumn;

/**
 * Report provider component.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ReportProvider extends UnifyComponent {

    /**
     * Creates a new report option for dynamic reportable associated with supplied
     * entity name.
     * 
     * @param entityName
     *                                the entity name
     * @param defaultReportColumnList
     *                                the default report column list
     * @return the new report options
     * @throws UnifyException
     *                        if an error occurs
     */
    ReportOptions getDynamicReportOptions(String entityName, List<DefaultReportColumn> defaultReportColumnList)
            throws UnifyException;

    /**
     * Generates a dynamic report based on supplied report options.
     * 
     * @param reportOptions
     *                      the report options
     * @param outputStream
     *                      the output stream where generated report is written to
     * @throws UnifyException
     *                        if an error occurs
     */
    void generateDynamicReport(ReportOptions reportOptions, OutputStream outputStream) throws UnifyException;

    /**
     * Finds report columns of a reportable.
     * 
     * @param reportableName
     *                       the reportable code
     * @return the report columns
     * @throws UnifyException
     *                        if an error occurs
     */
    ReportColumn[] findReportableColumns(String reportableName) throws UnifyException;

    /**
     * Returns true if entity is reportable by this. provider.
     * 
     * @param entityName
     *                   the entity name
     * @throws UnifyException
     *                        if an error occurs
     */
    boolean isReportable(String entityName) throws UnifyException;

    /**
     * Gets configured report listing based on user role.
     * 
     * @param roleCode
     *                 the role code. Assumes super user if role is null.
     * @return the report listing
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ReportListing> getRoleReportListing(String roleCode) throws UnifyException;

    /**
     * Get report options for configured report.
     * 
     * @param reportConfigName
     *                         the report configuration long name
     * @return the report options object
     * @throws UnifyException
     *                        if an error occurs
     */
    ReportOptions getReportOptionsForConfiguration(String reportConfigName) throws UnifyException;

    /**
     * Populates extra report options data that depend on input parameters.
     * 
     * @param reportOptions
     *                      the report options to populate
     * @throws UnifyException
     *                        if an error occurs
     */
    void populateExtraConfigurationReportOptions(ReportOptions reportOptions) throws UnifyException;
}
