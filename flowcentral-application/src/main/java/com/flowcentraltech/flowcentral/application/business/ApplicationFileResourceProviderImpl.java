/*
 * Copyright (c) 2019, 2021, FlowCentral Technologies.
 * All rights reserved.
 * 
 * PROPRIETARY AND CONFIDENTIAL. USE IS SUBJECT TO LICENSE TERMS.
 */

package com.flowcentraltech.flowcentral.application.business;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.flowcentraltech.flowcentral.application.constants.ApplicationModuleNameConstants;
import com.flowcentraltech.flowcentral.common.business.FileAttachmentProvider;
import com.flowcentraltech.flowcentral.common.data.Attachment;
import com.flowcentraltech.flowcentral.system.constants.SystemFileResourceConstants;
import com.tcdng.unify.core.UnifyException;
import com.tcdng.unify.core.annotation.Component;
import com.tcdng.unify.core.annotation.Configurable;
import com.tcdng.unify.core.file.AbstractFileResourceProvider;

/**
 * Application file resource provider.
 * 
 * @author Lateef Ojulari
 * @since 1.0
 */
@Component(ApplicationModuleNameConstants.APPLICATION_FILE_RESOURCE_PROVIDER)
public class ApplicationFileResourceProviderImpl extends AbstractFileResourceProvider {

    @Configurable
    private FileAttachmentProvider fileAttachmentProvider;

    public void setFileAttachmentProvider(FileAttachmentProvider fileAttachmentProvider) {
        this.fileAttachmentProvider = fileAttachmentProvider;
    }

    @Override
    public InputStream openFileResourceInputStream(String category, String resourceName) throws UnifyException {
        byte[] resource = readFileResource(category, resourceName);
        return resource != null ? new ByteArrayInputStream(resource) : null;
    }

    @Override
    public byte[] readFileResource(String category, String resourceName) throws UnifyException {
        Attachment attachment = fileAttachmentProvider.retrieveFileAttachment(category,
                SystemFileResourceConstants.FILERESOURCE_ENTITY_NAME,
                SystemFileResourceConstants.FILERESOURCE_ENTITY_INST_ID, resourceName);
        return attachment != null ? attachment.getData() : null;
    }

}
