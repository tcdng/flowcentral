/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.application.entities;

import com.flowcentraltech.flowcentral.common.entities.BaseConfigNamedEntity;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.batch.ConstraintAction;

/**
 * Application entity upload configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_ENTITYUPLOAD")
public class AppEntityUpload extends BaseConfigNamedEntity {

    @ForeignKey(AppEntity.class)
    private Long appEntityId;

    @ForeignKey
    private ConstraintAction constraintAction;

    @ListOnly(key = "constraintAction", property = "description")
    private String constraintActionDesc;

    @ListOnly(key = "appEntityId", property = "applicationId")
    private Long applicationId;

    @ListOnly(key = "appEntityId", property = "applicationName")
    private String applicationName;

    @ListOnly(key = "appEntityId", property = "name")
    private String entityName;

    @Child(category = "entity-upload")
    private AppFieldSequence fieldSequence;

    public Long getAppEntityId() {
        return appEntityId;
    }

    public void setAppEntityId(Long appEntityId) {
        this.appEntityId = appEntityId;
    }

    public ConstraintAction getConstraintAction() {
        return constraintAction;
    }

    public void setConstraintAction(ConstraintAction constraintAction) {
        this.constraintAction = constraintAction;
    }

    public String getConstraintActionDesc() {
        return constraintActionDesc;
    }

    public void setConstraintActionDesc(String constraintActionDesc) {
        this.constraintActionDesc = constraintActionDesc;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public AppFieldSequence getFieldSequence() {
        return fieldSequence;
    }

    public void setFieldSequence(AppFieldSequence fieldSequence) {
        this.fieldSequence = fieldSequence;
    }

}
