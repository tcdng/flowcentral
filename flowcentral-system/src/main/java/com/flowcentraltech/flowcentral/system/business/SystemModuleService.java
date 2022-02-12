/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.system.business;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.FlowCentralService;
import com.flowcentraltech.flowcentral.system.data.CredentialDef;
import com.flowcentraltech.flowcentral.system.data.LicenseDef;
import com.flowcentraltech.flowcentral.system.entities.Credential;
import com.flowcentraltech.flowcentral.system.entities.CredentialQuery;
import com.flowcentraltech.flowcentral.system.entities.DownloadLog;
import com.flowcentraltech.flowcentral.system.entities.Module;
import com.flowcentraltech.flowcentral.system.entities.ModuleQuery;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.data.Listable;
import com.tcdng.unify.core.task.TaskStatus;

/**
 * System module service.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public interface SystemModuleService extends FlowCentralService {

    /**
     * Gets instance licensing.
     * 
     * @return the instance licensing
     * @throws UnifyException
     *                        if an error occurs
     */
    LicenseDef getInstanceLicensing() throws UnifyException;
    
    /**
     * Creates a download log.
     * 
     * @param downloadLog
     *                    the log to create
     * @return the created download log ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long createDownloadLog(DownloadLog downloadLog) throws UnifyException;
    
    /**
     * Finds credentials based on supplied query.
     * 
     * @param query
     *              the credential query
     * @return the list of credential
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Credential> findCredentials(CredentialQuery query) throws UnifyException;

    /**
     * Gets an credential definition.
     * 
     * @param credName
     *                 the credential name
     * @return the credential definition
     * @throws UnifyException
     *                        if an error occurs
     */
    CredentialDef getCredentialDef(String credName) throws UnifyException;

    /**
     * Creates a new module.
     * 
     * @param module
     *               the module data
     * @return the created module ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long createModule(Module module) throws UnifyException;

    /**
     * Find modules by supplied query.
     * 
     * @param query
     *              the search query
     * @return the list of module
     * @throws UnifyException
     *                        if an error occurs
     */
    List<Module> findModules(ModuleQuery query) throws UnifyException;

    /**
     * Find module by supplied name.
     * 
     * @param moduleName
     *              the module name
     * @return the module
     * @throws UnifyException
     *                        if an error occurs
     */
    Module findModule(String moduleName) throws UnifyException;

    /**
     * Gets the unique ID of a module.
     * 
     * @param moduleName
     *                   the module name
     * @return the module ID
     * @throws UnifyException
     *                        if an error occurs
     */
    Long getModuleId(String moduleName) throws UnifyException;

    /**
     * Gets the module name for supplied ID.
     * 
     * @param moduleId
     *                   the module ID
     * @return the module name
     * @throws UnifyException
     *                        if an error occurs
     */
    String getModuleName(Long moduleId) throws UnifyException;

    /**
     * Gets system parameter value and converts to the specified type.
     * 
     * @param clazz
     *              the type to convert to
     * @param code
     *              the system parameter code
     * @return the resulting value
     * @throws UnifyException
     *                        if parameter with name is unknown. if a value data
     *                        conversion error occurs
     */
    <T> T getSysParameterValue(Class<T> clazz, String code) throws UnifyException;

    /**
     * Updates the value field of a system parameter.
     * 
     * @param code
     *              the system parameter code
     * @param value
     *              the value to set
     * @return the number of records updated
     * @throws UnifyException
     *                        if an error occurs
     */
    int setSysParameterValue(String code, Object value) throws UnifyException;

    /**
     * Release a scheduled task.
     * 
     * @param scheduledTaskId
     *                             the scheduled task ID
     * @param scheduledTaskHistId
     *                             the scheduled task history
     * @param completionTaskStatus
     *                             the task completion status
     * @param errorMsg
     *                             optional error messages
     * @throws UnifyException
     *                        if scheduled task history does not exist. if an error
     *                        occurs
     */
    void releaseScheduledTask(Long scheduledTaskId, Long scheduledTaskHistId, TaskStatus completionTaskStatus,
            String errorMsg) throws UnifyException;

    /**
     * Get names system parameters.
     * 
     * @return list of name system parameters
     * @throws UnifyException
     *                        if an error occurs
     */
    List<? extends Listable> getNamesSystemParameters() throws UnifyException;

    /**
     * Get contact system parameters.
     * 
     * @return list of contact system parameters
     * @throws UnifyException
     *                        if an error occurs
     */
    List<? extends Listable> getContactSystemParameters() throws UnifyException;
}
