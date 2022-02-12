/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.constant.FileAttachmentType;

/**
 * File attachment query class;
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class FileAttachmentQuery extends BaseAuditEntityQuery<FileAttachment> {

    public FileAttachmentQuery() {
        super(FileAttachment.class);
    }

    public FileAttachmentQuery type(FileAttachmentType type) {
        return (FileAttachmentQuery) addEquals("type", type);
    }

    public FileAttachmentQuery entityInstId(Long entityInstId) {
        return (FileAttachmentQuery) addEquals("entityInstId", entityInstId);
    }

    public FileAttachmentQuery entity(String entity) {
        return (FileAttachmentQuery) addEquals("entity", entity);
    }

    public FileAttachmentQuery category(String category) {
        return (FileAttachmentQuery) addEquals("category", category);
    }

    public FileAttachmentQuery name(String name) {
        return (FileAttachmentQuery) addEquals("name", name);
    }

}
