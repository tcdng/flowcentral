/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */
package com.flowcentraltech.flowcentral.common.entities;

import com.tcdng.unify.core.annotation.Column;
import com.tcdng.unify.core.annotation.ForeignKey;
import com.tcdng.unify.core.annotation.Table;

/**
 * File attachment document entity.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Table(name = "FC_FILEATTACHMENTDOC")
public class FileAttachmentDoc extends BaseEntity {

    @ForeignKey(FileAttachment.class)
    private Long fileAttachmentId;

    @Column(name = "ATTACHMENT_DOC")
    private byte[] data;

    public FileAttachmentDoc(byte[] data) {
        this.data = data;
    }

    public FileAttachmentDoc() {

    }

    @Override
    public String getDescription() {
        return null;
    }

    public Long getFileAttachmentId() {
        return fileAttachmentId;
    }

    public void setFileAttachmentId(Long fileAttachmentId) {
        this.fileAttachmentId = fileAttachmentId;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
