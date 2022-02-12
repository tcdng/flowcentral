/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.annotation.CategoryColumn;
import com.tcdng.unify.core.annotation.Child;
import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.FosterParentId;
import com.tcdng.unify.core.annotation.FosterParentType;
import com.tcdng.unify.core.annotation.Index;
import com.tcdng.unify.core.annotation.ListOnly;
import com.tcdng.unify.core.annotation.Table;
import com.tcdng.unify.core.constant.FileAttachmentType;

/**
 * Common file attachment entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FILEATTACHMENT", indexes = { @Index(value = { "entity" }), @Index(value = { "category" }) })
public class FileAttachment extends BaseAuditEntity {

    @ForeignKey(name = "ATTACHMENT_TY")
    private FileAttachmentType type;

    @FosterParentId
    private Long entityInstId;

    @FosterParentType(length = 128)
    private String entity;

    @CategoryColumn(name = "ATTACHMENT_CAT")
    private String category;

    @Column(length = 64)
    private String name;

    @Column(length = 96)
    private String title;

    @Column(name = "FILE_NM", length = 64, nullable = true)
    private String fileName;

    @ListOnly(key = "type", property = "description")
    private String typeDesc;

    @Child
    private FileAttachmentDoc file;

    @Override
    public String getDescription() {
        return title;
    }

    public FileAttachmentType getType() {
        return type;
    }

    public void setType(FileAttachmentType type) {
        this.type = type;
    }

    public Long getEntityInstId() {
        return entityInstId;
    }

    public void setEntityInstId(Long entityInstId) {
        this.entityInstId = entityInstId;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTypeDesc() {
        return typeDesc;
    }

    public void setTypeDesc(String typeDesc) {
        this.typeDesc = typeDesc;
    }

    public FileAttachmentDoc getFile() {
        return file;
    }

    public void setFile(FileAttachmentDoc file) {
        this.file = file;
    }

}
