/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.configuration.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Entity configuration.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class AppEntityConfig extends BaseNameConfig {

    private String type;

    private String delegate;
    
    private boolean auditable;

    private boolean reportable;

    private List<EntityFieldConfig> entityFieldList;

    private List<EntityAttachmentConfig> attachmentList;

    private List<EntityExpressionConfig> expressionList;
    
    private List<EntityUniqueConstraintConfig> uniqueConstraintList;

    private List<EntityIndexConfig> indexList;

    private List<EntityUploadConfig> uploadList;

    public String getType() {
        return type;
    }

    @XmlAttribute(required = true)
    public void setType(String type) {
        this.type = type;
    }

    public String getDelegate() {
        return delegate;
    }

    @XmlAttribute
    public void setDelegate(String delegate) {
        this.delegate = delegate;
    }

    public boolean isAuditable() {
        return auditable;
    }

    @XmlAttribute
    public void setAuditable(boolean auditable) {
        this.auditable = auditable;
    }

    public boolean isReportable() {
        return reportable;
    }

    @XmlAttribute
    public void setReportable(boolean reportable) {
        this.reportable = reportable;
    }

    public List<EntityFieldConfig> getEntityFieldList() {
        return entityFieldList;
    }

    @XmlElement(name = "field", required = true)
    public void setEntityFieldList(List<EntityFieldConfig> entityFieldList) {
        this.entityFieldList = entityFieldList;
    }

    public List<EntityAttachmentConfig> getAttachmentList() {
        return attachmentList;
    }

    @XmlElement(name = "attachment")
    public void setAttachmentList(List<EntityAttachmentConfig> attachmentList) {
        this.attachmentList = attachmentList;
    }

    public List<EntityExpressionConfig> getExpressionList() {
        return expressionList;
    }

    @XmlElement(name = "expression")
    public void setExpressionList(List<EntityExpressionConfig> expressionList) {
        this.expressionList = expressionList;
    }

    public List<EntityUniqueConstraintConfig> getUniqueConstraintList() {
        return uniqueConstraintList;
    }

    @XmlElement(name = "uniqueConstraint")
    public void setUniqueConstraintList(List<EntityUniqueConstraintConfig> uniqueConstraintList) {
        this.uniqueConstraintList = uniqueConstraintList;
    }

    public List<EntityIndexConfig> getIndexList() {
        return indexList;
    }

    @XmlElement(name = "index")
    public void setIndexList(List<EntityIndexConfig> indexList) {
        this.indexList = indexList;
    }

    public List<EntityUploadConfig> getUploadList() {
        return uploadList;
    }

    @XmlElement(name = "upload")
    public void setUploadList(List<EntityUploadConfig> uploadList) {
        this.uploadList = uploadList;
    }

}
