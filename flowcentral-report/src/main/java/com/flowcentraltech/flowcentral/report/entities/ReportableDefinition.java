/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.report.entities;

import java.util.List;

import com.flowcentraltech.flowcentral.application.entities.BaseApplicationEntity;
import com.tcdng.unify.core.annotation.ChildList;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.annotation.UniqueConstraint;

/**
 * Entity for storing reportable definition information.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_REPORTABLEDEF", uniqueConstraints = { @UniqueConstraint({ "name" }) })
public class ReportableDefinition extends BaseApplicationEntity {

    @Column(length = 96)
    private String title;

    @Column(length = 128)
    private String entity;

    @ChildList
    private List<ReportableField> fieldList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public List<ReportableField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<ReportableField> fieldList) {
        this.fieldList = fieldList;
    }

}
