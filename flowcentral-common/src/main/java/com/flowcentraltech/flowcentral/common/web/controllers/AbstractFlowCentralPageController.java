/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.web.controllers;

import java.util.List;

import com.flowcentraltech.flowcentral.common.business.EnvironmentService;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.database.Entity;
import com.tcdng.unify.core.logging.EventType;
import com.tcdng.unify.core.logging.FieldAudit;
import com.tcdng.unify.web.constant.ReadOnly;
import com.tcdng.unify.web.constant.ResetOnWrite;
import com.tcdng.unify.web.constant.Secured;
import com.tcdng.unify.web.ui.AbstractPageBean;
import com.tcdng.unify.web.ui.AbstractPageController;

/**
 * Convenient abstract base class for flowcentral page controllers.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public abstract class AbstractFlowCentralPageController<T extends AbstractPageBean> extends AbstractPageController<T> {

    @Configurable
    private EnvironmentService environmentService;

    public AbstractFlowCentralPageController(Class<T> pageBeanClass, Secured secured, ReadOnly readOnly,
            ResetOnWrite resetOnWrite) {
        super(pageBeanClass, secured, readOnly, resetOnWrite);
    }

    public final void setEnvironmentService(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    protected EnvironmentService environment() {
        return environmentService;
    }

    protected void logUserEvent(String eventName, String... details) throws UnifyException {
        getEventLogger().logUserEvent(eventName, details);
    }

    protected void logUserEvent(String eventName, List<String> details) throws UnifyException {
        getEventLogger().logUserEvent(eventName, details);
    }

    protected void logUserEvent(EventType eventType, Class<? extends Entity> entityClass) throws UnifyException {
        getEventLogger().logUserEvent(eventType, entityClass);
    }

    protected void logUserEvent(EventType eventType, Entity record, boolean isNewRecord) throws UnifyException {
        getEventLogger().logUserEvent(eventType, record, isNewRecord);
    }

    protected <U extends Entity> void logUserEvent(EventType eventType, U oldRecord, U newRecord)
            throws UnifyException {
        getEventLogger().logUserEvent(eventType, oldRecord, newRecord);
    }

    protected void logUserEvent(EventType eventType, Class<? extends Entity> entityClass, Long recordId,
            List<FieldAudit> fieldAuditList) throws UnifyException {
        getEventLogger().logUserEvent(eventType, entityClass, recordId, fieldAuditList);
    }

}
