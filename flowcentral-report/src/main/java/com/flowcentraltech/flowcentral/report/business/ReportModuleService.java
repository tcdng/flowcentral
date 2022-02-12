/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.common.business.ReportProvider;
import com.flowcentraltech.flowcentral.report.entities.ReportConfiguration;
import com.flowcentraltech.flowcentral.report.entities.ReportParameter;
import com.flowcentraltech.flowcentral.report.entities.ReportParameterQuery;
import com.flowcentraltech.flowcentral.report.entities.ReportableDefinition;
import com.flowcentraltech.flowcentral.report.entities.ReportableDefinitionQuery;
import com.flowcentraltech.flowcentral.report.entities.ReportableField;
import com.flowcentraltech.flowcentral.report.entities.ReportableFieldQuery;
import com.tcdng.unify.core.UnifyException;

/**
 * Report module service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface ReportModuleService extends FlowCentralService, ReportProvider {

    /**
     * Finds report configuration by ID.
     * 
     * @param reportConfigurationId
     *                the reportConfiguration ID
     * @return the report configuration
     * @throws UnifyException
     *                        if report configuration with ID is not found. If an error occurs
     */
    ReportConfiguration findReportConfiguration(Long reportConfigurationId) throws UnifyException;

    /**
     * Finds report configuration ID list for application.
     * 
     * @param applicationName
     *                        the application name
     * @return list of application report configuration IDs
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Long> findReportConfigurationIdList(String applicationName) throws UnifyException;

    /**
     * Creates a reportable definition.
     * 
     * @param reportableDefinition
     *                             the reportable definition
     * @return the created definition ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long createReportableDefinition(ReportableDefinition reportableDefinition) throws UnifyException;

    /**
     * Finds reportable definitions by criteria.
     * 
     * @param query
     *              the search query
     * @return list of reportable definitions
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ReportableDefinition> findReportDefinitions(ReportableDefinitionQuery query) throws UnifyException;

    /**
     * Gets the reportable definition ID for reportable.
     * 
     * @param reportableName
     *                       the reportable long name
     * @return the reportable definition ID if found otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    Long getReportableDefinitionId(String reportableName) throws UnifyException;

    /**
     * Gets the reportable definition ID for report configuration.
     * 
     * @param reportConfigurationId
     *                              the report configuration ID
     * @return the reportable definition ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long getReportConfigReportableDefinitionId(Long reportConfigurationId) throws UnifyException;

    /**
     * Create reportable field.
     * 
     * @param reportableField
     *                        the reportable field
     * @return the created record ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long createReportableField(ReportableField reportableField) throws UnifyException;

    /**
     * Finds reportable field by criteria.
     * 
     * @param query
     *              the search query
     * @return the reportable field if found otherwise null
     * @throws UnifyException
     *                        if an error occurs
     */
    ReportableField findReportableField(ReportableFieldQuery query) throws UnifyException;

    /**
     * Finds reportable fields by criteria.
     * 
     * @param query
     *              the search query
     * @return list of reportable fields
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ReportableField> findReportableFields(ReportableFieldQuery query) throws UnifyException;

    /**
     * Updates a reportable field.
     * 
     * @param reportableField
     *                        updates a reportable field
     * @return the number of records updated
     * @throws UnifyException
     *                        if an error occurs
     */
    int updateReportableField(ReportableField reportableField) throws UnifyException;

    /**
     * Deletes reportable field by criteria.
     * 
     * @param query
     *              the search query
     * @return the number of records updated
     * @throws UnifyException
     *                        if an error occurs
     */
    int deleteReportableField(ReportableFieldQuery query) throws UnifyException;

    /**
     * Finds report parameters by criteria.
     * 
     * @param query
     *              the search query
     * @return list of report parameters
     * @throws UnifyException
     *                        if an error occurs
     */
    List<ReportParameter> findReportParameters(ReportParameterQuery query) throws UnifyException;
}
