/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.web.panels;

import com.tcdng.unify.web.ui.widget.data.FileAttachmentsInfo;

/**
 * Entity file attachments
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
public class EntityFileAttachments {

    private FileAttachmentsInfo fileAttachmentsInfo;

    private boolean disabled;
    
    public void setFileAttachmentsInfo(FileAttachmentsInfo fileAttachmentsInfo) {
        this.fileAttachmentsInfo = fileAttachmentsInfo;
    }

    public FileAttachmentsInfo getFileAttachmentsInfo() {
        if (fileAttachmentsInfo != null) {
            fileAttachmentsInfo.setDisabled(disabled);
        }

        return fileAttachmentsInfo;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

}
